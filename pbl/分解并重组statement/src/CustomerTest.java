import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	@Test
	public void test() {
		Customer customer=new Customer("LiLei");
		customer.addRental(new Rental(new Movie("Jack",2),6));
		Assert.assertEquals(customer.statement(), "Hello");
		//fail("Not yet implemented");
	}
	
}
