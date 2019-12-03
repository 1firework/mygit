
public class Main {
     public static void main(String[] args) {
    	 Customer customer=new Customer("李雷");
    	 customer.addRental(new Rental(new Movie("《熊出没》",2),5));
    	 customer.addRental(new Rental(new Movie("《十面埋伏》",0),6));
    	 customer.addRental(new Rental(new Movie("《复仇者联盟4》",1),7));
    	 System.out.println("租用："+"\n"+customer.statemant());
     }
}
