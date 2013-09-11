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
public class MoveSpecialSquareTest {

	@Test
	public void test() {
		Lotus lotus = new Lotus();
		
		Stack<Piece> TwoStackPlayer1 = lotus.getBoard().getStartArea().getTwoStackPlayer1();
		Stack<Piece> TwoStackPlayer2 = lotus.getBoard().getStartArea().getTwoStackPlayer2();
		Square special1 = lotus.getBoard().getSpecialSquare1();
		Square special2 = lotus.getBoard().getSpecialSquare2();
		Piece piece1 = TwoStackPlayer1.pop();
		Piece piece2 = TwoStackPlayer2.pop();
		special1.addPiece(piece1);
		special2.addPiece(piece2);
		Square nextSquare1 = special1.getNextSquare();		
		Square nextSquare2 = special2.getNextSquare().getNextSquare();
		lotus.squareMove(special1, nextSquare1);
		lotus.squareMove(special2, nextSquare2);
		
		int expected = 2;
		int actual1 = nextSquare1.getStackSize();
		int actual2 = nextSquare2.getStackSize();
		
		assertTrue("The expected stack size is: "+expected+" and the actual size was player1's move "+actual1+" plus player2's move "+actual2, (actual1+actual2) == expected);
	}

}
