package pl.edu.pjatk.tau;

//private static InvoiceDaoImpl;
public class App 
{
    public static void main( String[] args )
    {
/*
        String string = "10000/FVT/19,10001/FVT/19,10002/FVT/19,10003/FVT/19";
        String[] parts = string.split(",");
        String part1 = parts[0]; // 004
        String part2 = parts[1]; // 034556
        String part3 = parts[2]; // 034556

        for(int i=0;i<parts.length;i++){
            System.out.println(parts[i]);
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



        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
        Invoice invoiceOne = new   Invoice( 0, "10000/FVT/19", 81.30, 23,  "Bez zaliczki");
        Invoice invoiceTwo = new   Invoice( 1, "10001/FVT/19", 81.30, 23,  "Wymiana oleju");
        Invoice invoiceThree = new Invoice( 2, "10002/FVT/19", 81.30, 23,  "Wymiana oleju");
        Invoice invoiceFour = new  Invoice( 3, "10003/FVT/19", 81.30, 23,  "Wymiana oleju");
        invoiceDao.create(invoiceOne);
        invoiceDao.create(invoiceTwo);
        invoiceDao.create(invoiceThree);
        invoiceDao.create(invoiceFour);


        String listOfNumber = "10000/FVT/19,10001/FVT/19,10002/FVT/19";
        String invoicesThatShouldBeRemoved = "10000/FVT/19,10001/FVT/19,10002/FVT/19,";
        invoiceDao.listOfNumber = listOfNumber;

        String deletedInvoicesNumber = invoiceDao.deleteListOfInvoices();

        System.out.println("Powinny zostać usunięte: "+invoicesThatShouldBeRemoved);
        System.out.println("Usuniete: "+deletedInvoicesNumber);
       */

    }


}
