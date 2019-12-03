
public class NewRegularPrice extends Price{

	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	public double getChager(int daysRented) {
		//return dayRented;
	    return daysRented * 3;
	}
	public int getFrequentRentalPoint(int daysRented) {
  		 return (daysRented>1) ? 2 : 1;
   }
}
