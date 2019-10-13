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

    @Test (expected = IndexOutOfBoundsException.class)
    public void invoiceDaoImplUpdateMethodShouldThrowExceptionIfTheObjectWasNotFoundTest(){
        InvoiceDaoImpl invoices = new InvoiceDaoImpl();
        Invoice invoiceOne = new Invoice(0, 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");

        invoices.update(invoiceOne,0);
    }

    @Test
    public void invoiceDaoImplUpdateMethodShouldUpdateValueOfObjectInCollection(){
        InvoiceDaoImpl invoices = new InvoiceDaoImpl();
        Invoice invoiceOne = new Invoice(0, 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        Invoice invoiceTwo = new Invoice(1, 1, "10001/FVT/19", 81.30, 23,  "Bez zaliczki");
        invoices.create(invoiceOne);
        invoices.update(invoiceTwo,0);

        assertEquals("The method did not update the record ID in the collection!",invoiceTwo.getId(),invoices.get(0).getId());
        assertEquals("The method did not update the record IdKht in the collection!",invoiceTwo.getIdKht(),invoices.get(0).getIdKht());
        assertEquals("The method did not update the record InvoiceNumber in the collection!",invoiceTwo.getInvoiceNumber(),invoices.get(0).getInvoiceNumber());
        assertEquals(invoiceTwo.getNetto(),invoices.get(0).getNetto(),0.01);
        assertEquals(invoiceTwo.getBrutto(),invoices.get(0).getBrutto(),0.01);
        assertEquals(invoiceTwo.getVat(),invoices.get(0).getVat(),0.01);
        assertEquals("The method did not update the record VatMark in the collection!",invoiceTwo.getVatMark(),invoices.get(0).getVatMark());
        assertEquals("The method did not update the record Description in the collection!",invoiceTwo.getDescription(),invoices.get(0).getDescription());
    }

}
