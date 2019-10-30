package pl.edu.pjatk.tau.labone.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.pjatk.tau.labone.domain.Invoice;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceDaoImplMockitoDateTest {

    @InjectMocks
    private Invoice firstTestInvoice;

    @InjectMocks
    private Invoice secondTestInvoice;
    private InvoiceDaoManager invoiceDao = new InvoiceDaoImpl();

    @Mock
    private Clock clock;

    private final static LocalDateTime STATIC_TIME_CREATE =
            LocalDateTime.of(2016,6,16, 16, 16, 16, 0);
    private final static LocalDateTime STATIC_TIME_LAST_READ =
            LocalDateTime.of(2019,9,19, 19, 19, 19, 0);
    private final static LocalDateTime STATIC_TIME_MODYFICATION =
            LocalDateTime.of(2016,6,16, 16, 16, 16, 0);

    private void mockTime(LocalDateTime staticTime) {
        Clock fixedClock = Clock.fixed(staticTime.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());

        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        Invoice firstTestInvoice= new Invoice( 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        Invoice secondTestInvoice = new Invoice( 1, "10001/FVT/19", 81.30, 23,  "Bez zaliczki");
    }

    @After
    public void deleteAll(){

        invoiceDao.deleteAll();
    }

    @Test
    public void setLastReadDateTest() {
        mockTime(STATIC_TIME_LAST_READ);

        Integer idOnList = invoiceDao.create(firstTestInvoice);
        Invoice getInvoice = invoiceDao.get(idOnList);

        assertEquals(STATIC_TIME_LAST_READ,getInvoice.getLastReadDate());

    }

    @Test
    public void setLastReadDateWhenActIsFalseTest() {
        mockTime(STATIC_TIME_LAST_READ);

        firstTestInvoice.setActLastReadDate(false);
        Integer idOnList = invoiceDao.create(firstTestInvoice);
        Invoice getInvoice = invoiceDao.get(idOnList);

        assertEquals(null,getInvoice.getLastReadDate());
    }

    @Test
    public void setLastReadDateWhenAllRecordWasGetTest(){
        mockTime(STATIC_TIME_LAST_READ);


        Integer idFirst = invoiceDao.create(firstTestInvoice);
        Integer idSecond = invoiceDao.create(secondTestInvoice);

        List<Invoice> testList = invoiceDao.getAll();

        assertEquals(STATIC_TIME_LAST_READ,testList.get(idFirst).getLastReadDate());
        assertEquals(STATIC_TIME_LAST_READ,testList.get(idSecond).getLastReadDate());
    }

    @Test
    public void setLastReadDateWhenAllRecordWasGetAndActIsFalseTest(){
        mockTime(STATIC_TIME_LAST_READ);

        firstTestInvoice.setActLastReadDate(false);
        secondTestInvoice.setActLastReadDate(false);
        Integer idFirst = invoiceDao.create(firstTestInvoice);
        Integer idSecond = invoiceDao.create(secondTestInvoice);

        List<Invoice> testList = invoiceDao.getAll();

        assertEquals(null,testList.get(idFirst).getLastReadDate());
        assertEquals(null,testList.get(idSecond).getLastReadDate());

    }

    @Test
    public void setCreateDateTest(){
        mockTime(STATIC_TIME_CREATE);

        Integer idOnList = invoiceDao.create(firstTestInvoice);
        Invoice getInvoice = invoiceDao.get(idOnList);

        assertEquals(STATIC_TIME_CREATE,getInvoice.getCreateDate());
    }

    @Test
    public void setCreateDateWhenActWasFalseTest(){
        mockTime(STATIC_TIME_CREATE);

        firstTestInvoice.setActLastReadDate(false);
        Integer idOnList = invoiceDao.create(firstTestInvoice);
        Invoice getInvoice = invoiceDao.get(idOnList);

        assertEquals(STATIC_TIME_CREATE,getInvoice.getCreateDate());
    }

    @Test
    public void setModyficationDateTest(){
        mockTime(STATIC_TIME_MODYFICATION);

        Integer idFirst = invoiceDao.create(firstTestInvoice);
        Integer idOnList = invoiceDao.update(secondTestInvoice,idFirst);
        Invoice getInvoice = invoiceDao.get(idOnList);

        assertEquals(STATIC_TIME_MODYFICATION,getInvoice.getModyficationDate());
    }

    @Test
    public void setModyficationDateWhenActWasFalseTest(){
        mockTime(STATIC_TIME_MODYFICATION);

        firstTestInvoice.setActModyficationDate(false);
        Integer idFirst = invoiceDao.create(firstTestInvoice);
        Integer idOnList = invoiceDao.update(secondTestInvoice,idFirst);
        Invoice getInvoice = invoiceDao.get(idOnList);

        assertEquals(STATIC_TIME_MODYFICATION,getInvoice.getModyficationDate());
    }

    @Test
    public void setAllDateValueWhenAllActIsTrueTest(){
        mockTime(STATIC_TIME_CREATE);
        mockTime(STATIC_TIME_MODYFICATION);

        firstTestInvoice.setActCreateDate(true);
        firstTestInvoice.setActModyficationDate(true);
        firstTestInvoice.setActLastReadDate(true);

        Integer idFirst = invoiceDao.create(firstTestInvoice);
        Integer idOnList = invoiceDao.update(secondTestInvoice,idFirst);
        Invoice getInvoice = invoiceDao.get(idOnList);

        assertEquals(STATIC_TIME_CREATE,getInvoice.getCreateDate());
        assertEquals(STATIC_TIME_MODYFICATION,getInvoice.getModyficationDate());


        mockTime(STATIC_TIME_LAST_READ);

        Integer idSecond = invoiceDao.create(secondTestInvoice);
        Invoice getSecondInvoice = invoiceDao.get(idSecond);

        assertEquals(STATIC_TIME_LAST_READ,getSecondInvoice.getLastReadDate());
    }

}
