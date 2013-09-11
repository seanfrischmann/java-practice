package Test;

import static org.junit.Assert.*;
import game.SpecialSquare;
import game.Square;

import org.junit.Test;
/**
 * Tests the functionality of the methods of the SpecialSquare class
 * <p>
 * @author Matthew
 *
 */
public class SpecialSquareTest {
	/**
	 * Tests the getHeight method of the SpecialSquare with a starting height of 1 
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void getHeightTest1() {
		Square specSquare1 = new SpecialSquare(1);
		int expected1 = 1;
		int actual1 = specSquare1.getHeight();
		assertTrue ("The expected value was "+ expected1 + "." + "The actual value was"+ actual1 + ".", expected1 == actual1);
		
	}
	/**
	 * Tests the getHeight method of the SpecialSquare with a starting height of 2
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void getHeightTest2(){
		Square specSquare2 = new SpecialSquare(2);
		int expected2 = 2;
		int actual2 = specSquare2.getHeight();
		assertTrue ("The expected value was "+ expected2 + "." + "The actual value was"+ actual2 + ".", expected2 == actual2);
		
	}
	
}
