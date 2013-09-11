package Test;

import static org.junit.Assert.*;
import game.Lotus;
import game.Piece;
import game.Square;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;
/**
 * The purpose of this JUnit Test is to see if moving a piece from a special
 * square works correctly by checking the size of the square's stack that
 * the piece was being moved to after the move method is called.
 * @author Sean
 *
 */
public class MoveBackwardsSquareTest {

	@Test
	public void test() {
Lotus lotus = new Lotus();
		
		Stack<Piece> TwoStackPlayer1 = lotus.getBoard().getStartArea().getTwoStackPlayer1();
		Stack<Piece> TwoStackPlayer2 = lotus.getBoard().getStartArea().getTwoStackPlayer2();
		Square backwards = lotus.getBoard().getBackwardsSquare();
		Square previous1 = backwards.getPreviousSquares().get(0);
		Square previous2 = previous1.getPreviousSquares().get(0);
		Piece piece1 = TwoStackPlayer1.pop();
		Piece piece2 = TwoStackPlayer2.pop();
		backwards.addPiece(piece2);
		backwards.addPiece(piece1);
		
		lotus.squareMove(backwards, previous2);
		
		
		int expected1 = 0;
		int expected2 = 1;
		int actual1 = previous1.getStackSize();
		int actual2 = previous2.getStackSize();
		
		assertTrue("The expected 1 stack size should be: "+expected1+" and the expected 2 stack size should be: "+expected2+ 
					" the actual 1 stack size was: "+actual1+" and the actual 2 stack size was: "+actual2, (actual1 + actual2) == (expected1 + expected2));

	}

}
