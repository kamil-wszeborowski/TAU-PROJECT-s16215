package pl.edu.pjatk.tau.labone.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.edu.pjatk.tau.labone.domain.Invoice;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class InvoiceDaoImplTest {

    private InvoiceDaoImpl invoiceDao;
    private Invoice invoiceOne;
    private Invoice invoiceTwo;
    private Invoice invoiceThree;

    @Before
    public void setUp() {
        invoiceDao = new InvoiceDaoImpl();
        invoiceOne = new Invoice( 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        invoiceTwo = new Invoice( 1, "10001/FVT/19", 81.30, 23,  "Bez zaliczki");
        invoiceThree = new Invoice( 10, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
    }

    @After
    public void deleteAll(){
        invoiceDao.deleteAll();
    }

    @Test
    public void invoiceDaoImplInvoicesListIsImplementedTest() {
        assertNotNull(invoiceDao);
        //assertNotNull(new InvoiceDaoImpl());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void invoiceDaoImplGetMethodShouldThrowExeptionOnEmptyCollectionTest(){
        invoiceDao.get(0);
        //new InvoiceDaoImpl().get(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invoicesShouldHaveUniqueIdIfNotThenExceptionWillByThrowTest(){
        int idOnList;

        idOnList = invoiceDao.create(invoiceOne);
        invoiceDao.get(idOnList).setId(1);

        invoiceDao.create(invoiceTwo);
    }


    @Test
    public void invoiceDaoImplCreateMethodShouldAddInvoiceToCollectionTest(){
        int idOfAddedInvoice;
        int shouldByAtSize;

        idOfAddedInvoice = invoiceDao.create(invoiceOne);
        shouldByAtSize = invoiceDao.getAll().size()-1;

        assertEquals("Invoice object is not created properly in Collection!"+idOfAddedInvoice,shouldByAtSize,idOfAddedInvoice);
    }

    @Test
    public void invoiceDaoImplGetAllMethodShouldReturnAllRecordFromInvoicesListTest(){
         invoiceDao.create(invoiceOne);
         invoiceDao.create(invoiceTwo);

         assertEquals("GetAll() method return wrong number of records!",2,invoiceDao.getAll().size());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void invoiceDaoImplDeleteMethodShouldThrowExceptionIfTheObjectWasNotFoundTest(){
         invoiceDao.delete(invoiceThree);
    }

    @Test
    public void invoiceDaoImplDeleteMethodShouldRemoveObjectFromCollectionTest(){
        int sizeBeforeDelete;
        int sizeAfterDelete;
        invoiceDao.create(invoiceOne);
        invoiceDao.create(invoiceTwo);

        sizeBeforeDelete = invoiceDao.getAll().size();
        invoiceDao.delete(invoiceOne);
        sizeAfterDelete = invoiceDao.getAll().size();

        assertNotEquals("The method did not remove the record from the collection!",sizeBeforeDelete,sizeAfterDelete);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void invoiceDaoImplUpdateMethodShouldThrowExceptionIfTheObjectWasNotFoundTest(){
        invoiceDao.update(invoiceOne,0);
    }

    @Test
    public void invoiceDaoImplUpdateMethodShouldUpdateValueOfObjectInCollection(){
        int idOnList;

        idOnList= invoiceDao.create(invoiceOne);
        invoiceDao.update(invoiceTwo,idOnList);

        assertEquals("The method did not update the record ID in the collection!",invoiceTwo.getId(),invoiceDao.get(idOnList).getId());
        assertEquals("The method did not update the record IdKht in the collection!",invoiceTwo.getIdKht(),invoiceDao.get(idOnList).getIdKht());
        assertEquals("The method did not update the record InvoiceNumber in the collection!",invoiceTwo.getInvoiceNumber(),invoiceDao.get(idOnList).getInvoiceNumber());
        assertEquals(invoiceTwo.getNetto(),invoiceDao.get(idOnList).getNetto(),0.01);
        assertEquals(invoiceTwo.getBrutto(),invoiceDao.get(idOnList).getBrutto(),0.01);
        assertEquals(invoiceTwo.getVat(),invoiceDao.get(idOnList).getVat(),0.01);
        assertEquals("The method did not update the record VatMark in the collection!",invoiceTwo.getVatMark(),invoiceDao.get(idOnList).getVatMark());
        assertEquals("The method did not update the record Description in the collection!",invoiceTwo.getDescription(),invoiceDao.get(idOnList).getDescription());
    }

}
