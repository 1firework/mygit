import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//Customer customer=new Customer("LiLei");
		double a=new Customer("LiLei").amountFor(new Rental(new Movie("Jack",2),6));
		//fail("Not yet implemented");
	}

}
