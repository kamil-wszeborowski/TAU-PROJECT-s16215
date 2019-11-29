package pl.edu.pjatk.tau.labfour.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.tau.labfour.domain.Invoice;
import pl.edu.pjatk.tau.labfour.service.InvoiceDaoImpl;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@RestController
public class InvoiceApi {

    private InvoiceDaoImpl invoiceDaoImpl;

    @Autowired
    public InvoiceApi(InvoiceDaoImpl invoiceDaoImpl) {
        this.invoiceDaoImpl = invoiceDaoImpl;
    }

    //@Autowired
    //InvoiceDaoManager invoiceDaoManager;

    @RequestMapping("/")
    public String index() {
        return "This is non rest, just checking if everything works.";
    }

    @RequestMapping(value = "/invoice",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Invoice create(@RequestBody Invoice i) {
        if (invoiceDaoImpl.create(i) < 1) return null;
        return i;
    }

    @RequestMapping(value = "/invoice/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Invoice get(@PathVariable("id") int id) throws SQLException {
        return invoiceDaoImpl.get(id);
    }

    // Update
    @PutMapping (value = "/invoice/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateFramework(@PathVariable("id") Integer id,@RequestBody Invoice i ) throws SQLException {
        return invoiceDaoImpl.update(id,i);
    }

    @RequestMapping(value = "/invoices", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Invoice> getAll(@RequestParam(value = "filter", required = false) String f) throws SQLException {
        List<Invoice> invoices = new LinkedList<Invoice>();
        for (Invoice i : invoiceDaoImpl.getAll()) {
            if (f == null) {
                invoices.add(i);
            } else if (i.getInvoiceNumber().contains(f)) {
                invoices.add(i);
            }
        }
        return invoices;
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable("id") Integer id) throws SQLException {
        return new Integer(invoiceDaoImpl.delete(invoiceDaoImpl.get(id)));
    }
}
