package pl.edu.pjatk.tau.labone.domain;

public class Invoice {
    private int id;
    private int idKht;
    private String invoiceNumber;
    private double netto;
    private double brutto;
    private double vat;
    private int vatMark;
    private String description;

    public Invoice(int id,int idKht, String invoiceNumber,double netto, int vatMark, String description){
        this.id = id;
        this.idKht = idKht;
        this.invoiceNumber = invoiceNumber;
        this.netto = netto;
        switch(vatMark) {
            case 23 :
                this.brutto = Math.round((netto * 1.23)* 100.0) / 100.0;
                this.vat = Math.round((netto * 0.23)* 100.0) / 100.0;
                break;
            case 8 :
                this.brutto = Math.round((netto * 1.08)* 100.0) / 100.0;
                this.vat = Math.round((netto * 0.8)* 100.0) / 100.0;
                break;
            case 5 :
                this.brutto = Math.round((netto * 1.05)* 100.0) / 100.0;
                this.vat = Math.round((netto * 0.5)* 100.0) / 100.0;
                break;
            case 0 :
                this.brutto = netto;
                this.vat = 0;
                break;
        }
        this.description = description;
    }

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
    public double getNetto() {
        return netto;
    }
    public void setNetto(double netto) {
        this.netto = netto;
    }
    public double getBrutto() {
        return brutto;
    }
    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }
    public double getVat() {
        return vat;
    }
    public void setVat(double vat) {
        this.vat = vat;
    }
    public int getVatMark() {
        return vatMark;
    }
    public void setVatMark(int vatMark) {
        this.vatMark = vatMark;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}

