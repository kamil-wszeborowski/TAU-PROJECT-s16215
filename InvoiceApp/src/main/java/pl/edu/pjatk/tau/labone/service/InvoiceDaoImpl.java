package pl.edu.pjatk.tau.labone.service;

import pl.edu.pjatk.tau.labone.domain.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDaoManager<Invoice> {

    private List<Invoice> invoices = new ArrayList<>();

    public InvoiceDaoImpl(){
     /*
        invoices.add(new Invoice(0, 0, "10000/FVT/19", 81.30, 23, "Tylko przegląd"));
        invoices.add(new Invoice(1, 1, "10001/FVT/19", 81.30, 8,"Zaliczka wliczona w cene"));
        invoices.add(new Invoice(2, 3, "10002/FVT/19", 81.30, 5,"Bez zaliczki"));
      */
    }

    @Override
    public Invoice get(int idList) {
        try{
            return invoices.get(idList) ;
        }
        catch (Exception e) {
            throw new IndexOutOfBoundsException("Something go wrong! In the database not found record with id:" + idList);
        }

    }

    @Override
    public List<Invoice> getAll(){
        return invoices;
    };

    @Override
    public void create(Invoice invoice){
        boolean checkID = true;
        for(Invoice item : invoices){
            if(item.getId() == invoice.getId()){
                checkID = false;
                throw new IllegalArgumentException("Something go wrong! In the database already exists record with id:"+invoice.getId());
            }
        }
        if(checkID = true){
            invoices.add(invoice);
        }
    };

    @Override
    public void update(Invoice invoice, int id){

    };

    @Override
    public void delete(Invoice invoice){
        boolean remove = false;
        remove = invoices.remove(invoice);

        if(remove == false){
            throw new IndexOutOfBoundsException("Something go wrong! In the database not found record with id:" + invoice.getId());
        }

    };

}
