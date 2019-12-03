
public class Movie{
	
     public static final int CHILDRENS=2;
     public static final int REGULAR=0;
     public static final int NEW_RELEASE=1;
     
     private String _tital;
     private int _priceCode;
     
     public Movie(String tital,int priceCode) {
    	 _tital=tital;
    	 _priceCode=priceCode;
     }
     
     public int getPriceCode() {
		return _priceCode;
     }
     
     public void setPriceCode(int arg) {
		_priceCode=arg;
     }
     
     public String getTital() {
		return _tital;
     }
     public double getChager(int daysRented) {
    	 double result = 0;
    	 switch(getPriceCode()) {
    	 case Movie.REGULAR:
    		 result += 2;
    		 if(daysRented > 2) 
    			 result += (daysRented - 2) * 1.5;
    		 break;
    	 case Movie.NEW_RELEASE:
    		 result += daysRented;
    		 break;
    	 case Movie.CHILDRENS:
    		 if(daysRented > 3)
    			 result += (daysRented - 3) * 1.5;
    		 break;
    	 }
		return result; 
     }
     
     public int getFrequentRentalPoint(int daysRented) {
    	 if((getPriceCode() == Movie.NEW_RELEASE)&&daysRented > 1)
    		 return 2;
    	 else
    		 return 1;
     }
}
