package pl.edu.pjatk.tau;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.edu.pjatk.tau.labone.domain.Invoice;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class AppTest extends TestCase {
    @Test
    public void invoiceIsImplementedTest() {
        assertNotNull(new Invoice(1,1,"10001/FVT/19",81.30, 23, "Tylko przegląd"));
    }

    // mock creation
    List mockedList = mock(List.class);

    @Test
    public void firstMockTest(){
        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

}
