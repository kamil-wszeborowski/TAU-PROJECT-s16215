package pl.edu.pjatk.tau.labone.service;

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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceDaoImplMockitoDateTest {

    @InjectMocks
    private Invoice firstTestInvoice;
    private Invoice secondTestInvoice;
    private InvoiceDaoManager invoiceDao = new InvoiceDaoImpl();

    @Mock
    private Clock clock;

    private final static LocalDateTime STATIC_TIME_CREATE =
            LocalDateTime.of(2012,12,21, 21, 21, 21, 0);
    private final static LocalDateTime STATIC_TIME_READ =
            LocalDateTime.of(2019,01,12, 21, 0, 0, 0);
    private final static LocalDateTime STATIC_TIME_UPDATE =
            LocalDateTime.of(2012,12,21, 21, 21, 21, 0);

    private void mockTime(LocalDateTime staticTime) {
        Clock fixedClock = Clock.fixed(staticTime.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        Invoice firstTestInvoice= new Invoice(0, 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        Invoice secondTestInvoice = new Invoice(1, 1, "10001/FVT/19", 81.30, 23,  "Bez zaliczki");
    }


    @Test
    public void setLastReadDateTest() {
        mockTime(STATIC_TIME_READ);

        Integer idOnList = invoiceDao.create(firstTestInvoice);
        Invoice getInvoice = invoiceDao.get(idOnList);

        assertEquals(STATIC_TIME_READ,getInvoice.getLastReadDate());

    }

    @Test
    public void setLastReadDateWhenActIsFalse() {
        mockTime(STATIC_TIME_READ);

        firstTestInvoice.setActLastReadDate(false);
        Integer idOnList = invoiceDao.create(firstTestInvoice);
        Invoice getInvoice = invoiceDao.get(idOnList);

        assertEquals(null,getInvoice.getLastReadDate());
    }

}
