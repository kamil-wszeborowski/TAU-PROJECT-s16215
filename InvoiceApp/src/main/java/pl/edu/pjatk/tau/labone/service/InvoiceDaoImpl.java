package pl.edu.pjatk.tau.labone.service;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.edu.pjatk.tau.labone.domain.Invoice;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

public class InvoiceDaoImpl implements InvoiceDaoManager<Invoice> {

    private static List<Invoice> invoices = new ArrayList<>();

    private final static LocalDate LOCAL_DATE = LocalDate.of(2012, 12, 21);

    @InjectMocks
    private Invoice invoice;

    @Mock
    private Clock clock;

    private Clock fixedClock;

    @Before
    public void initMocks() {
        fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
    }


 /*
    public InvoiceDaoImpl(){

        invoices.add(new Invoice(0, 0, "10000/FVT/19", 81.30, 23, "Tylko przegląd"));
        invoices.add(new Invoice(1, 1, "10001/FVT/19", 81.30, 8,"Zaliczka wliczona w cene"));
        invoices.add(new Invoice(2, 3, "10002/FVT/19", 81.30, 5,"Bez zaliczki"));

    }
*/
    @Override
    public Invoice get(int idList) {
        try{
            Optional<Invoice> invoice = findWithID(idList);
            invoice.ifPresent(Invoice::setLastReadDate);
            //invoices.get(idList).setLastReadDate(new Date());
            return invoices.get(idList);
        }
        catch (Exception e) {
            throw new IndexOutOfBoundsException("Something go wrong! In the database not found record with id:" + idList);
        }

    }

    @Override
    public List<Invoice> getAll(){
        return invoices;
    };

    @Override
    public Integer create(Invoice invoice){
        boolean checkID = true;
        for(Invoice item : invoices){
            if(item.getId() == invoice.getId()){
                checkID = false;
                throw new IllegalArgumentException("Something go wrong! In the database already exists record with id:"+invoice.getId());
            }
        }
        if(checkID = true){
            invoices.add(invoice);
            return invoice.getId();
        }
        return null;
    };

    @Override
    public void update(Invoice invoice, int idList){
        if(!invoices.get(idList).equals(null)) {
            invoices.get(idList).setId(invoice.getId());
            invoices.get(idList).setIdKht(invoice.getIdKht());
            invoices.get(idList).setInvoiceNumber(invoice.getInvoiceNumber());
            invoices.get(idList).setNetto(invoice.getNetto());
            invoices.get(idList).setBrutto(invoice.getBrutto());
            invoices.get(idList).setVat(invoice.getVat());
            invoices.get(idList).setVatMark(invoice.getVatMark());
            invoices.get(idList).setDescription(invoice.getDescription());
        }else {
            throw new IndexOutOfBoundsException("Something go wrong! In the database not found record with id:" + idList);
        }
    };

    @Override
    public void delete(Invoice invoice){
        boolean remove = false;
        remove = invoices.remove(invoice);

        if(remove == false){
            throw new IndexOutOfBoundsException("Something go wrong! In the database not found record with id:" + invoice.getId());
        }

    };

    private Optional<Invoice> findWithID(Integer id){
        return invoices.stream()
                .filter(i -> i.getId()==(id))
                .findFirst();
    }

    private boolean movieExists(Invoice invoice) {

        return findWithID(invoice.getId()).isPresent();
    }

}
