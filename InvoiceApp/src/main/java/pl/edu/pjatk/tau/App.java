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

        Invoice invoiceOne = new Invoice(0, 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        invoiceDao.create(invoiceOne);
        for(Invoice item : (List<Invoice>)invoiceDao.getAll()){
            System.out.println(item.getInvoiceNumber()+" "+ item.getBrutto()+" "+item.getNetto()+" "+ item.getVat()+" "+ item.getDescription());
        }

        Invoice invoiceTwo = new Invoice(1, 1, "10001/FVT/19", 813.01, 23,  "Przeglad");
        invoiceDao.update(invoiceTwo,0);
        for(Invoice item : (List<Invoice>)invoiceDao.getAll()){
            System.out.println(item.getInvoiceNumber()+" "+ item.getBrutto()+" "+item.getNetto()+" "+ item.getVat()+" "+ item.getDescription());
        }


    }
}
