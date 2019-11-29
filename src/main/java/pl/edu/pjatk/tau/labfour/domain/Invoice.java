package pl.edu.pjatk.tau.labfour.domain;

import java.time.Clock;
import java.time.LocalDateTime;

public class Invoice {
    private int id;
    private int idKht;
    private String invoiceNumber;
    private double netto;
    private double brutto;
    private double vat;
    private int vatMark;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime modyficationDate=null;
    private LocalDateTime lastReadDate=null;
    private boolean actCreateDate = true;
    private boolean actModyficationDate = true;
    private boolean actLastReadDate = true;
    private Clock clock = Clock.systemDefaultZone();

    public Invoice(){

    }

    public Invoice(int idKht, String invoiceNumber, double netto, int vatMark, String description){
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate() {
        if(actCreateDate==true) {
            this.createDate = LocalDateTime.now(clock);
        }
    }

    public LocalDateTime getModyficationDate() {
        return modyficationDate;
    }

    public void setModyficationDate() {
        if(actLastReadDate==true){
            this.modyficationDate = LocalDateTime.now(clock);
        }
    }

    public LocalDateTime getLastReadDate() {
        return lastReadDate;
    }

    public void setLastReadDate() {
        if(actLastReadDate==true){
            this.lastReadDate = LocalDateTime.now(clock);
        }

    }

    public boolean isActCreateDate() {
        return actCreateDate;
    }

    public void setActCreateDate(boolean actCreateDate) {
        this.actCreateDate = actCreateDate;
    }

    public boolean isActModyficationDate() {
        return actModyficationDate;
    }

    public void setActModyficationDate(boolean actModyficationDate) {
        this.actModyficationDate = actModyficationDate;
    }

    public boolean isActLastReadDate() {
        return actLastReadDate;
    }

    public void setActLastReadDate(boolean actLastReadDate) {
        this.actLastReadDate = actLastReadDate;
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }


}

