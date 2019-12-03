
public class Movie{
	
     public static final int CHILDRENS=2;
     public static final int REGULAR=0;
     public static final int NEW_RELEASE=1;
     
     private String _tital;
     private Price _price;
     
     public Movie(String tital,int priceCode) {
    	 _tital=tital;
    	 setPriceCode(priceCode);
     }
     
     public int getPriceCode() {
		return _price.getPriceCode();
     }
     
     public void setPriceCode(int arg) {
		switch(arg) {
		case REGULAR:
			_price=new RegularPrice();
			break;
		case CHILDRENS:
			_price=new ChildrensPrice();
			break;
		case NEW_RELEASE:
			_price=new NewRegularPrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
     }
     
     public String getTital() {
		return _tital;
     }
     public double getChager(int daysRented) {
		return _price.getChager(daysRented); 
     }
     
     public int getFrequentRentalPoint(int daysRented) {
    	 return _price.getFrequentRentalPoint(daysRented);
     }
}
