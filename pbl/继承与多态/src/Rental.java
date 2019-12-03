
class Rental {
	
     private Movie _movie;
     private int _daysRented;
     
     public Rental(Movie movie,int daysRented) {
    	 _movie=movie;
    	 _daysRented=daysRented;
     }
     /*
     public int getDaysRented() {
		return _daysRented;
     }
     */
     public Movie getMovie() {
		return _movie;
     }
     
     public double getChager() {
		return _movie.getChager( _daysRented); 
     }
     
     public int getFrequentRentalPoint() {
    	 return _movie.getFrequentRentalPoint(_daysRented);
     }
}
