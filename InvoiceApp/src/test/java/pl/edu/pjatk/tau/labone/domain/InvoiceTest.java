package pl.edu.pjatk.tau.labone.domain;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class InvoiceTest extends TestCase {

    @Test
    public void invoiceIsImplementedTest() {
        assertNotNull(new Invoice(1,1,"10001/FVT/19",81.30, 23, "Tylko przegląd"));
    }

}

