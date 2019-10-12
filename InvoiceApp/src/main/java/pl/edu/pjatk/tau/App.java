package pl.edu.pjatk.tau;

import pl.edu.pjatk.tau.labone.domain.Invoice;
import pl.edu.pjatk.tau.labone.service.InvoiceDaoImpl;
import pl.edu.pjatk.tau.labone.service.InvoiceDaoManager;

import java.util.List;

//private static InvoiceDaoImpl;
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Poniżej lista dokumentów sprzedaży:" );
        InvoiceDaoManager invoiceDao = new InvoiceDaoImpl();

        //Invoice v1 = invoiceDao.get(1);
        //System.out.println(v1.getInvoiceNumber());

        /*
        Invoice createdInvoice = new Invoice(3, 3, "10003/FVT/19", 81.30, 23,  "Bez zaliczki");

        invoiceDao.create(createdInvoice);
        invoiceDao.update(createdInvoice,2);
        */
        for(Invoice item : (List<Invoice>)invoiceDao.getAll()){
            System.out.println(item.getInvoiceNumber()+" "+ item.getBrutto()+" "+item.getNetto()+" "+ item.getVat());
        }






    }
}
