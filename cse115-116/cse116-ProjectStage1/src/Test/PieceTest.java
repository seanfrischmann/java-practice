package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import game.Lotus;
import game.Piece;
import game.Player;
import game.Square;

import java.awt.Color;

import org.junit.Test;
/** 
 * Tests the functionality of the Piece's methods
 * <p>
 * @author Matthew
 *
 */
public class PieceTest {
	/** 
	 * Tests the setting of the location of the _startingSquare to the current Square the Piece occupies
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void setStartingSquaretest() {
		Player p1 = new Player(Color.RED);
		Piece pi1 = new Piece(p1);
		Square square = new Square();
		Square _startingSquare = square;
		pi1.setStartingSquare(_startingSquare);
		Square expected = _startingSquare;
		Square actual = pi1.getStartingSquare();
		assertTrue("The expected value was " + expected + "." + "The actual value was " + actual + ".", expected == actual);
	}
	/**
	 * Test to see if the method returns the location of the _startingSquare of a particular Piece
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void getStartingSquareTest() {
		Player p1 = new Player(Color.RED);
		Piece pi1 = new Piece(p1);
		Square square = new Square();
		Square _startingSquare = square;
		pi1.setStartingSquare(_startingSquare);
		Square expected = _startingSquare;
		Square actual = pi1.getStartingSquare();
		assertTrue("The expected value was " + expected + "." + "The actual value was " + actual + ".", expected == actual);
	
	}
}
