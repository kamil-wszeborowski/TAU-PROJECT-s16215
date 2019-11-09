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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mockito.Mockito.doReturn;

public class InvoiceDaoImpl implements InvoiceDaoManager<Invoice> {

    private static List<Invoice> invoices = new ArrayList<>();

    private static Integer idCounter = 0;
    public static String number;

    private final static LocalDate LOCAL_DATE = LocalDate.of(2016, 6, 16);

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
        List<Invoice> invoiceList = invoices;
        invoiceList.forEach(Invoice::setLastReadDate);
        return invoices;
    };

    @Override
    public Integer create(Invoice invoice){
        int id = generateId();
        invoice.setId(id);
        if(findWithID(invoice.getId()).isPresent()){
            throw new IllegalArgumentException("Something go wrong! In the database already exists record with id:"+invoice.getId());
        }
        invoice.setCreateDate();
        invoices.add(invoice);
        return invoice.getId();

    };

    @Override
    public Integer update(Invoice invoice, int idList){
        if(!invoices.get(idList).equals(null)) {
            //invoices.get(idList).setId(invoice.getId());
            invoices.get(idList).setIdKht(invoice.getIdKht());
            invoices.get(idList).setInvoiceNumber(invoice.getInvoiceNumber());
            invoices.get(idList).setNetto(invoice.getNetto());
            invoices.get(idList).setBrutto(invoice.getBrutto());
            invoices.get(idList).setVat(invoice.getVat());
            invoices.get(idList).setVatMark(invoice.getVatMark());
            invoices.get(idList).setDescription(invoice.getDescription());
            invoices.get(idList).setModyficationDate();
            return invoices.get(idList).getId();
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

    private Integer generateId(){
        return idCounter++;
    }

    private Optional<Invoice> findWithID(Integer id){
        return invoices.stream().filter(i -> i.getId()==(id)).findFirst();
    }

    public void deleteAll(){
        invoices.clear();
        idCounter = 0;
    }

    public String findByRegularExpresion(){
        String numberFound="No invoice with this number found";
        Pattern compliedPattern = Pattern.compile(number);

        for (Invoice invoice: invoices) {
            Matcher matcher = compliedPattern.matcher(invoice.getInvoiceNumber());
            if(matcher.matches()==true){
                numberFound = invoice.getInvoiceNumber();
            }
        }

        return numberFound;
    }
}
