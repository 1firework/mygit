
public class Main {
     public static void main(String[] args) {
    	 Customer customer=new Customer("ÀîÀ×");
    	 customer.addRental(new Rental(new Movie("¡¶Ï²ÑóÑóÓë»ÒÌ«ÀÇ¡·",2),5));
    	 customer.addRental(new Rental(new Movie("¡¶Ê®ÃæÂñ·ü¡·",0),4));
    	 customer.addRental(new Rental(new Movie("¡¶¸´³ğÕßÁªÃË¡·",1),3));
    	 System.out.println("¶©ÔÄºÅ£º"+"\n"+customer.statemant());
     }
}
