package Test;

import static org.junit.Assert.assertTrue;
import game.Lotus;
import game.Piece;
import game.Player;
import game.Square;

import java.awt.Color;

import org.junit.Test;
/**
 * Test the functionality of the Square class's methods
 * <p>
 * @author Matthew
 *
 */
public class SquareTest {
	/**
	 * Tests the functionality of the addPiece method of the Square class
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void addPieceTest() {
		Square squ = new Square();
		Player p1 = new Player(Color.RED);
		Piece pi1 = new Piece(p1);
		squ.addPiece(pi1);
		int expected = 1;
		int actual = squ.getHeight();
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
	}
	/**
	 * Test the functionality of the removePiece method
	 * <p>
	 * @author Matthew
 	*/
	@Test
	public void removePieceTest() {
		Square squ = new Square();
		Player p1 = new Player(Color.RED);
		Piece pi1 = new Piece(p1);
		squ.addPiece(pi1);
		squ.removePiece();
		int expected = 0;
		int actual = squ.getHeight();
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
	}	
	/**
	 * Tests the functionality of the getPiece method of a nonempty Square
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void getPieceTestNonEmpty() {
		Square squ = new Square();
		Player p1 = new Player(Color.RED);
		Piece pi1 = new Piece(p1);
		Player p2 = new Player(Color.RED);
		Piece pi2 = new Piece(p2);
		squ.addPiece(pi1);
		squ.addPiece(pi2);
		Piece expected = pi2; 
		Piece actual = squ.getPiece();
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
		
	}
	/**
	 * Tests the functionality of the getPiece method of an empty Square
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void getPieceTestEmpty(){ 
		Square squ = new Square();
		Piece expected = null;
		Piece actual = squ.getPiece();
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
	}
	/**
	 * Tests the functionality of the getHeight method on a Square
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void getHeightTest() {
		Square squ = new Square();
		Player p1 = new Player(Color.RED);
		Piece pi1 = new Piece(p1);
		Player p2 = new Player(Color.RED);
		Piece pi2 = new Piece(p2);
		squ.addPiece(pi1);
		squ.addPiece(pi2);
		int expected = 2;
		int actual = squ.getHeight();
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
	}
	/**
	 * Tests the functionality of the setNextSquare method on a Square
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void setNextSquareTest() {
		Square squ = new Square();
		Square _nextSquare = new Square();
		squ.setNextSquare(_nextSquare);
		Square expected = _nextSquare;
		Square actual = squ.getNextSquare();
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
	}
	/**
	 * Tests the functionality of the getNextSquare method on a Square
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void getNextSquareTest() {
		Square squ = new Square();
		Square _nextSquare = new Square();
		squ.setNextSquare(_nextSquare);
		Square expected = _nextSquare;
		Square actual = squ.getNextSquare();
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
	}
	/**
	 * Tests the functionality of the addPreviousSquare method on a Square
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void addPreviousSquareTest(){
		Lotus lotus = new Lotus();
		Square[] squareArray = lotus.getBoard().getSquareArray();
		Square expected = squareArray[0];
		Square actual = squareArray[1].getPreviousSquares().get(0);
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
	}
	/**
	 * Tests the functionality of the getPreviousSquares method on a Square
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void getPreviousSquaresTest(){
		Lotus lotus = new Lotus();
		Square[] squareArray = lotus.getBoard().getSquareArray();
		Square expected = squareArray[0];
		Square actual = squareArray[1].getPreviousSquares().get(0);
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
	}
	/**
	 * Tests the functionality of the isForwardSquare method on a Square
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void isForwardSquareTest(){
		Square squ = new Square();
		boolean expected = true;
		boolean actual = squ.isForwardSquare();
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
	}
	/**
	 * Tests the getStackSize method on a Square
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void getStackSizeTest(){
		Square squ = new Square();
		Player p1 = new Player(Color.RED);
		Player p2 = new Player(Color.RED);
		Piece pi1 = new Piece(p1);
		Piece pi2 = new Piece(p2);
		squ.addPiece(pi1);
		squ.addPiece(pi2);
		int expected = 2;
		int actual = squ.getStackSize();
		assertTrue("The expected value was " + expected + "." + "The actual result was " + actual + ".", expected == actual);
	}
}
