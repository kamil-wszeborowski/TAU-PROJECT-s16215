package pl.edu.pjatk.tau.labone.service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.edu.pjatk.tau.labone.domain.Invoice;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class InvoiceDaoImplTest {

    @Test
    public void invoiceDaoImplInvoicesListIsImplementedTest() {
        assertNotNull(new InvoiceDaoImpl());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void invoiceDaoImplGetMethodShouldThrowExeptionOnEmptyCollectionTest(){
        new InvoiceDaoImpl().get(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invoicesShouldHaveUniqueIdIfNotThenExceptionWillByThrowTest(){
        Invoice invoiceOne = new Invoice(5, 5, "10005/FVT/19", 81.30, 23,  "Bez zaliczki");
        Invoice invoiceTwo = new Invoice(5, 5, "10005/FVT/19", 81.30, 23,  "Bez zaliczki");
        InvoiceDaoManager invoiceDao = new InvoiceDaoImpl();

        invoiceDao.create(invoiceOne);
        invoiceDao.create(invoiceTwo);
    }

    @Test
    public void invoiceDaoImplCreateMethodShouldAddInvoiceToCollectionTest(){
        int idOfAddedInvoice;
        Invoice invoiceOne = new Invoice(0, 0, "10006/FVT/19", 81.30, 23,  "Bez zaliczki");
        InvoiceDaoManager invoiceDao = new InvoiceDaoImpl();
        invoiceDao.create(invoiceOne);

        idOfAddedInvoice = invoiceDao.get(0).getId();
        assertEquals("Invoice object is not created properly in Collection!"+idOfAddedInvoice,0,idOfAddedInvoice);
    }

    @Test
    public void invoiceDaoImplGetAllMethodShouldReturnAllRecordFromInvoicesListTest(){
        InvoiceDaoImpl invoices = new InvoiceDaoImpl();
        Invoice invoiceOne = new Invoice(0, 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        Invoice invoiceTwo = new Invoice(1, 1, "10001/FVT/19", 81.30, 23,  "Bez zaliczki");
        invoices.create(invoiceOne);
        invoices.create(invoiceTwo);

        assertEquals("GetAll() method return wrong number of records!",2,invoices.getAll().size());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void invoiceDaoImplDeleteMethodShouldThrowExceptionIfTheObjectWasNotFoundTest(){
        InvoiceDaoImpl invoices = new InvoiceDaoImpl();
        Invoice invoiceOne = new Invoice(10, 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");

        invoices.delete(invoiceOne);
    }

    @Test
    public void invoiceDaoImplDeleteMethodShouldRemoveObjectFromCollectionTest(){
        int sizeBeforeDelete;
        int sizeAfterDelete;
        InvoiceDaoImpl invoices = new InvoiceDaoImpl();
        Invoice invoiceOne = new Invoice(0, 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        Invoice invoiceTwo = new Invoice(1, 1, "10001/FVT/19", 81.30, 23,  "Bez zaliczki");
        invoices.create(invoiceOne);
        invoices.create(invoiceTwo);

        sizeBeforeDelete = invoices.getAll().size();
        invoices.delete(invoiceOne);
        sizeAfterDelete = invoices.getAll().size();

        assertNotEquals("The method did not remove the record from the collection!",sizeBeforeDelete,sizeAfterDelete);
    }



}
