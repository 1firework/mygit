
abstract class Price {
    abstract int getPriceCode();
    abstract double getChager(int daysRented) ;
    
    public int getFrequentRentalPoint(int daysRented) {
   		 return 1;
    }
}
