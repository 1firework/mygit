package company;
import rate.*;
public class DianxinCompany implements Company{

	public Rate producerate() {
		// TODO Auto-generated method stub
		return new DianxinRate();
	}
   
}
