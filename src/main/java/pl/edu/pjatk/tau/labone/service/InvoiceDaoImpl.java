package pl.edu.pjatk.tau.labone.service;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.edu.pjatk.tau.labone.domain.Invoice;

import java.sql.*;
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

    private Connection connection;
    private static List<Invoice> invoices = new ArrayList<>();

    private static Integer idCounter = 0;
    public static String number;
    public static String listOfNumber;

    private PreparedStatement addInvoiceStmt;

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
/*
    public InvoiceDaoImpl(Connection connection)  {
        this.connection = connection;
        if (!isDatabaseReady()) {
            try {
                createTables();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            setConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public InvoiceDaoImpl() {
        try {
            this.connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!isDatabaseReady()) {
            try {
                createTables();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            this.setConnection(this.connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTables() throws SQLException {
        connection.createStatement()
                .executeUpdate("CREATE TABLE "
                        +"Invoice(id bigint GENERATED BY DEFAULT AS IDENTITY, "
                        +"idKht bigint NOT NULL, "
                        +"invoiceNumber varchar(20) NOT NULL, "
                        +"netto numeric(12,2), "
                        +"brutto numeric(12,2), "
                        +"vat numeric(12,2), "
                        +"vatMark integer, "
                        +"description varchar(100))");
    }

    public boolean isDatabaseReady() {
        try {
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            boolean tableExists = false;
            while (rs.next()) {
                if ("Invoice".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }
            return tableExists;
        } catch (SQLException e) {
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;

        addInvoiceStmt = connection.prepareStatement(
                "INSERT INTO Invoice (idKht, invoiceNumber, netto, brutto, vat, vatMark, description) VALUES (?, ?, ?, ?, ?, ?, ?,)",
                Statement.RETURN_GENERATED_KEYS);

       // deletePersonStmt = connection.prepareStatement("DELETE FROM Person where id = ?");
      //  deleteAllPersonsStmt = connection.prepareStatement("DELETE FROM Person");
      //  getAllPersonsStmt = connection.prepareStatement("SELECT id, name, yob FROM Person ORDER BY id");
      //  getPersonStmt = connection.prepareStatement("SELECT id, name, yob FROM Person WHERE id = ?");
       // updatePersonStmt = connection.prepareStatement("UPDATE Person SET name=?,yob=? WHERE id = ?");


    }
*/
    @Override
    public Invoice get(int idList) {
        try{
            Optional<Invoice> invoice = findWithID(idList);
            invoice.ifPresent(Invoice::setLastReadDate);
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

    public Integer findIdOfInvoiceNumber(String searchedNumber){
        int idFound = -1;
        Pattern compliedPattern = Pattern.compile(searchedNumber);

        for (Invoice invoice: invoices) {
            Matcher matcher = compliedPattern.matcher(invoice.getInvoiceNumber());
            if(matcher.matches()==true){
                idFound = invoice.getId();
            }
        }
        return idFound;
    }

    public String deleteListOfInvoices(){
        String deletedInvoicesNumber = "";
        String numberFromInvoice ;
        int idOfInvoice;

        List<Invoice> listToDelete = new ArrayList<>();

        String[] parts = listOfNumber.split(",");

        for(int i=0;i<parts.length;i++){
            numberFromInvoice = parts[i];
            idOfInvoice = findIdOfInvoiceNumber(numberFromInvoice);
            if(idOfInvoice != -1){
                deletedInvoicesNumber += numberFromInvoice+",";
                listToDelete.add(get(idOfInvoice));
            }
        }

        for(int i=0;i<listToDelete.size();i++){
            delete(listToDelete.get(i));
        }

        if(deletedInvoicesNumber == ""){
            deletedInvoicesNumber = "No invoice number was found";
        }

        return deletedInvoicesNumber;
    }
}
