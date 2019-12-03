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
      
      private double getTotalCharge() {
    	  double result=0;
    	  Enumeration rental=_rental.elements();
    	  while(rental.hasMoreElements()) {
    		  Rental each=(Rental)rental.nextElement();
    		  result += each.getChager();
    	  }
    	  return result;
      }
      
      private int getTotalFrequentRenterPoints() {
    	  int result=0;
    	  Enumeration rental=_rental.elements();
          while(rental.hasMoreElements()) {
    		  Rental each=(Rental) rental.nextElement();
    		  result += frequentRenterPointss(each);
          }
          return result;
      }
      
      public String statemant() {
    	  Enumeration rental=_rental.elements();
    	  String result="Rental Record for "+getName()+"\n";
    	  while(rental.hasMoreElements()) {
    		  
    		  Rental each=(Rental) rental.nextElement();
    		  
     		 //show figures for this rental
     		 result+="\t"+each.getMovie().getTital()+"\t"+String.valueOf(each.getChager())+"\n";
    	  }
    	 //add footer lines
     	 result += "Amount owed is"+String.valueOf(getTotalCharge())+"\n";
     	 result += "You earned"+String.valueOf(getTotalFrequentRenterPoints())+"frequent renter points";
     	 return result;
      }
}
