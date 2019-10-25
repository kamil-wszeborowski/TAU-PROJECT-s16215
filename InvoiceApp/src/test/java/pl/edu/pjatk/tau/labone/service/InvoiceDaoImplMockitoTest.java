
package pl.edu.pjatk.tau.labone.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.pjatk.tau.labone.domain.Invoice;


@RunWith(MockitoJUnitRunner.class)
public class InvoiceDaoImplMockitoTest extends TestCase {

    @Test
    public void invoiceIsImplementedTest() {
        assertNotNull(new Invoice(1,1,"10001/FVT/19",81.30, 23, "Tylko przegląd"));
    }


/*
    @Mock
    Invoice invoice; // = Mockito.mock(Invoice.class);
    InvoiceDaoImpl invoiceDao; // = Mockito.mock(InvoiceDaoImpl.class);
    InvoiceDaoManager invoiceDaoManager; // = Mockito.mock(InvoiceDaoManager.class);
    private Date testDate = new Date();

    @Before
    public void setUp(){
        //invoice.setLastReadDate(testDate);
        invoiceDao.create(invoice);
        invoiceDaoManager = invoiceDao;
    }

    @Test
    public void invoiceIsMockedAndIsNotNull(){
        assertThat(invoice, is(notNullValue()));
        assertThat(invoiceDao, is(notNullValue()));
    }


    @Test
    public void invoiceDaoImplGetMethodShouldNotBeNullModyficationDateTest(){


        //invoiceDao.get(0).getLastReadDate();
        //Date testDate = new Date();
        //invoiceDao.get(0).getLastReadDate();
        //when(invoiceDao.get(0).getLastReadDate()).thenReturn(null);
        //Invoice invoice = new Invoice(5, 5, "10005/FVT/19", 81.30, 23,  "Bez zaliczki");
        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
        Invoice invoiceOne = new Invoice(0, 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        Invoice invoiceTwo = new Invoice(1, 1, "10001/FVT/19", 81.30, 23,  "Bez zaliczki");
        invoiceDao.create(invoiceOne);
        invoiceDao.create(invoiceTwo);

        System.out.println("TestDate: "+this.testDate);
        System.out.println("GetLastRead: "+invoiceDao.get(0).getLastReadDate());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("GetLastRead: "+invoiceDao.get(0).getLastReadDate());

        //assertEquals(this.testDate,this.testDate);



    }
*/



}
