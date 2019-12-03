
public class ChildrensPrice extends Price{

	int getPriceCode() {
		return Movie.CHILDRENS;
	}
	public double getChager(int daysRented) {
		//double result=0;
		double result=1.5;
		if(daysRented > 3)
  			 result += (daysRented - 3) * 1.5;
		return result;
	}
}
