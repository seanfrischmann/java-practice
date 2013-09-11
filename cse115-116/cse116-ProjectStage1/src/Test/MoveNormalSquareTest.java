package Test;

import static org.junit.Assert.*;


import java.util.Stack;


import game.Lotus;
import game.Piece;

import game.Square;

import org.junit.Test;

	/**
	 * The purpose of this JUnit Test is to see if moving a piece from a normal
	 * square works correctly by checking the size of the square's stack that
	 * the piece was being moved to after the move method is called. 
	 * @author Sean
	 *
	 */
public class MoveNormalSquareTest {
	
	
	@Test
	public void test() {
		
		Lotus lotus = new Lotus();
		Square[] squareArray = lotus.getBoard().getSquareArray();
		Stack<Piece> oneStackPlayer1 = lotus.getBoard().getStartArea().getOneStackPlayer1();
		Piece temp = oneStackPlayer1.pop();
		squareArray[0].addPiece(temp);
		lotus.squareMove(squareArray[0], squareArray[1]);
		
		int expected = 1;
		int actual = squareArray[1].getStackSize();
		
		assertTrue("The expected stack size is:"+expected+" and the actual size was;"+actual, actual == expected);
	}

}
