import java.util.Enumeration;
import java.util.Vector;

class Customer {
      private String _name;
      private Vector _rental = new Vector();
      
      public Customer(String name){
    	  _name=name;
      }
      public void addRental(Rental arg) {
    	  _rental.add(arg);
      }
      public String getName() {
		return _name;
      }
      
      private double amountFor(Rental aRental) {
		return aRental.getChager();  
      }
      
      private int frequentRenterPointss(Rental aRental) {
    	  return aRental.getFrequentRentalPoint();
      }
      
      
      public String statemant() {
    	  double totalAmount=0;
    	  int frequentRenterPoints=0;
    	  Enumeration rental=_rental.elements();
    	  String result="Rental Record for "+getName()+"\n";
    	  while(rental.hasMoreElements()) {
    		  double thisAmount=0;
    		  Rental each=(Rental) rental.nextElement();
    		  
    		  thisAmount=amountFor(each);
    		  //thisAmount=each.getChager();
    		  //frequentRenterPoints +=each.getFrequentRentalPoint();
    		  frequentRenterPoints += frequentRenterPointss(each);
    		  
     		 //show figures for this rental
     		 result+="\t"+each.getMovie().getTital()+"\t"+String.valueOf(each.getChager())+"\n";
     		 totalAmount+=each.getChager();
    	  }
    	 //add footer lines
     	 result += "Amount owed is"+String.valueOf(totalAmount)+"\n";
     	 result += "You earned"+String.valueOf(frequentRenterPoints)+"frequent renter points";
     	 return result;
      }
}
