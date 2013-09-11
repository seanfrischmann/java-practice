package Test;

import static org.junit.Assert.*;
import game.Lotus;
import game.Piece;
import game.Square;

import java.util.Stack;

import org.junit.Test;

public class StackMoveTest {

	@Test
	public void test() {
		Lotus lotus = new Lotus();
		
		Stack<Piece> TwoStackPlayer1 = lotus.getBoard().getStartArea().getTwoStackPlayer1();
		Square[] squareArray = lotus.getBoard().getSquareArray();
		lotus.stackMove(squareArray[0], TwoStackPlayer1, squareArray[1]);
		
		int expected = 1;
		int actual = squareArray[1].getStackSize();
		
		assertTrue(expected == actual);
	}

}
