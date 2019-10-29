package pl.edu.pjatk.tau;

//private static InvoiceDaoImpl;
public class App 
{
    public static void main( String[] args )
    {
        /*
        InvoiceDaoManager invoiceDao = new InvoiceDaoImpl();
        Invoice invoiceOne = new Invoice( 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        Invoice invoiceTwo = new Invoice( 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        invoiceDao.create(invoiceOne);
        invoiceDao.create(invoiceTwo);
        for(Invoice item : (List<Invoice>)invoiceDao.getAll()){
            System.out.println(item.getId()+" "+item.getInvoiceNumber()+" "+ item.getBrutto()+" "+item.getNetto()+" "+ item.getVat()+" "+ item.getDescription()+" "+ item.getCreateDate()+" "+ item.getLastReadDate());
        }

        System.out.println( "Poniżej lista dokumentów sprzedaży:" );
        InvoiceDaoManager invoiceDao = new InvoiceDaoImpl();

        Invoice invoiceOne = new Invoice( 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        invoiceDao.create(invoiceOne);
        for(Invoice item : (List<Invoice>)invoiceDao.getAll()){
            System.out.println(item.getInvoiceNumber()+" "+ item.getBrutto()+" "+item.getNetto()+" "+ item.getVat()+" "+ item.getDescription()+" "+ item.getCreateDate()+" "+ item.getLastReadDate());
        }

        Invoice invoiceTwo = new Invoice( 1, "10001/FVT/19", 813.01, 23,  "Przeglad");
        invoiceDao.update(invoiceTwo,0);
        for(Invoice item : (List<Invoice>)invoiceDao.getAll()){
            System.out.println(item.getInvoiceNumber()+" "+ item.getBrutto()+" "+item.getNetto()+" "+ item.getVat()+" "+ item.getDescription()+" "+ item.getCreateDate()+" "+ item.getLastReadDate());
        }

        System.out.println("###################################\n");
        System.out.println("First read: "+invoiceDao.get(0).getLastReadDate());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Second read: "+invoiceDao.get(0).getLastReadDate());

        System.out.println("###################################\n");
        for(Invoice item : (List<Invoice>)invoiceDao.getAll()){
            System.out.println(item.getInvoiceNumber()+" "+ item.getBrutto()+" "+item.getNetto()+" "+ item.getVat()+" "+ item.getDescription());
            System.out.println("Creation date: "+invoiceDao.get(0).getCreateDate());
            System.out.println("Modyfication date: "+invoiceDao.get(0).getModyficationDate());
            System.out.println("Last read date: "+invoiceDao.get(0).getLastReadDate());
        }

         */
    }


}
