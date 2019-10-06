package pl.edu.pjatk.tau;

public class Invoice {
    private int id;
    private int idKht;
    private String invoiceNumber;
    private float netto;
    private float brutto;
    private float vat;
    private String vatStr;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKht() {
        return idKht;
    }

    public void setIdKht(int idKht) {
        this.idKht = idKht;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public float getNetto() {
        return netto;
    }

    public void setNetto(float netto) {
        this.netto = netto;
    }

    public float getBrutto() {
        return brutto;
    }

    public void setBrutto(float brutto) {
        this.brutto = brutto;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public String getVatStr() {
        return vatStr;
    }

    public void setVatStr(String vatStr) {
        this.vatStr = vatStr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

