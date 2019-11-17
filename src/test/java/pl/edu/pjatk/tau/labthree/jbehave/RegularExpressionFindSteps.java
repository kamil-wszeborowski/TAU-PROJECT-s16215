package pl.edu.pjatk.tau.labthree.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pl.edu.pjatk.tau.labone.domain.Invoice;
import pl.edu.pjatk.tau.labone.service.InvoiceDaoImpl;

import static org.junit.Assert.assertEquals;

public class RegularExpressionFindSteps {

    private InvoiceDaoImpl invoiceDao;

    @Given("List of invoices")
    public void invoiceFindSetup(){
        this.invoiceDao = new InvoiceDaoImpl();
        Invoice invoiceOne = new Invoice( 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        Invoice invoiceTwo = new Invoice( 1, "10001/FVT/19", 81.30, 23,  "Wymiana oleju");
        this.invoiceDao.create(invoiceOne);
        this.invoiceDao.create(invoiceTwo);
    }

    @When("set the invoice number to $number as the searched phrase")
    public void seInvoiceNumber(String number){
        invoiceDao.number = number;
    }

    @Then("find method should return $searchedNumber")
    public void shouldGetInvoiceId(String searchedNumber){
        String numberFound = invoiceDao.findByRegularExpresion();
        assertEquals(searchedNumber, numberFound);
    }


}
