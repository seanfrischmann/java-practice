package Test;

import static org.junit.Assert.*;
import game.BackwardsSquare;
import game.Lotus;
import game.Square;

import org.junit.Test;
/**
 * Test the functionality of the BackwardsSquare class
 * <p>
 * @author Matthew
 *
 */
public class BackwardsSquareTest {
	/**
	 * Constructor runs a test on the BackwardsSquare class to test if the boolean value of the square 
	 * was successfully changed to false.
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void backwardsSquareTest() {
		Lotus lotus = new Lotus();
		Square backSquare = lotus.getBoard().getBackwardsSquare();
		boolean actual = false;
		boolean expected = backSquare.isForwardSquare();
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
	}

}
