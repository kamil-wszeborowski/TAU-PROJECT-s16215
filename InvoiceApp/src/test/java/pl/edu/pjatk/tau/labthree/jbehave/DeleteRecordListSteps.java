package pl.edu.pjatk.tau.labthree.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pl.edu.pjatk.tau.labone.domain.Invoice;
import pl.edu.pjatk.tau.labone.service.InvoiceDaoImpl;

import static org.junit.Assert.assertEquals;

public class DeleteRecordListSteps {
    private InvoiceDaoImpl invoiceDao;

    @Given("Database with invoices")
    public void createDatabaseSetup(){
        this.invoiceDao = new InvoiceDaoImpl();
        Invoice invoiceOne = new Invoice( 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        Invoice invoiceTwo = new Invoice( 1, "10001/FVT/19", 81.30, 23,  "Wymiana oleju");
        Invoice invoiceThree = new Invoice( 2, "10002/FVT/19", 81.30, 23,  "Wymiana oleju");
        Invoice invoiceFour = new Invoice( 3, "10003/FVT/19", 81.30, 23,  "Wymiana oleju");
        this.invoiceDao.create(invoiceOne);
        this.invoiceDao.create(invoiceTwo);
        this.invoiceDao.create(invoiceThree);
        this.invoiceDao.create(invoiceFour);
    }

    @When("set arguments to $listOfNumber of record to delete")
    public void setInvoiceDeleteRecordList(String listOfNumber){
        invoiceDao.listOfNumber = listOfNumber;
    }

    @Then("delete list method should return list of invoice $invoicesThatShouldBeRemoved that was deleted")
    public void shouldGetListOfDeletedInvoice(String invoicesThatShouldBeRemoved){
        String deletedInvoicesNumber = invoiceDao.deleteListOfInvoices();
        assertEquals(invoicesThatShouldBeRemoved, deletedInvoicesNumber);
    }

}
