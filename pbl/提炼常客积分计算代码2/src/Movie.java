
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
}
