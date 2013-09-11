package Test;

import static org.junit.Assert.*;

import game.Piece;
import game.Player;
import game.StartingArea;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;
/**
 * Testing if the player starts off with the right amount of stacks 
 * and that the stacks have the right amount of pieces in them. 
 * Each Player should have one stack of 4, 3, 2, and 1 pieces.
 * @author Zach
 */
public class StartingAreaTest {
	
	private game.StartingArea _sa;

	@Before
	public void setUp() {
		_sa = new game.StartingArea(null, null);
	}
	
	

	@Test
	//See if player 1 fourstack starts with 4 pieces.
	public void test1() {
		assertTrue("", _sa.getFourStackPlayer1().size() == 4);
	}
	@Test
	//See if player 1 threestack starts with 3 pieces.
	public void test2() {
		assertTrue("", _sa.getThreeStackPlayer1().size() == 3);
	}
	@Test
	//See if player 1 twostack starts with 2 pieces.
	public void test3() {
		assertTrue("", _sa.getTwoStackPlayer1().size() == 2);
	}
	@Test
	//See if player 1 onestack starts with 1 piece.
	public void test4() {
		assertTrue("", _sa.getOneStackPlayer1().size() == 1);
	}
	@Test
	//See if player 2 fourstack starts with 4 pieces.
	public void test5() {
		assertTrue("", _sa.getFourStackPlayer2().size() == 4);
	}
	@Test
	//See if player 2 threestack starts with 3 pieces.
	public void test6() {
		assertTrue("", _sa.getThreeStackPlayer2().size() == 3);
	}
	@Test
	//See if player 2 twostack starts with 2 pieces.
	public void test7() {
		assertTrue("", _sa.getTwoStackPlayer2().size() == 2);
	}
	@Test
	//See if player 2 onestack starts with 1 piece.
	public void test8() {
		assertTrue("", _sa.getOneStackPlayer2().size() == 1);
	}
}
	
	/*public void test1() {
		assertTrue("", _sa._fourStackPlayer1.size() == 4);
	}

	public void test2() {
		assertTrue("", _sa._threeStackPlayer1.size() == 3);
	}
	public void test3() {
		assertTrue("", _sa._twoStackPlayer1.size() == 2);
	}
	public void test4() {
		assertTrue("",_sa._oneStackPlayer1.size() == 1);
	}
	
	public void test5() {
		assertTrue("", _sa._fourStackPlayer2.size() == 4);
	}

	public void test6() {
		assertTrue("", _sa._threeStackPlayer2.size() == 3);
	}
	public void test7() {
		assertTrue("", _sa._twoStackPlayer2.size() == 2);
	}
	public void test8() {
		assertTrue("",_sa._oneStackPlayer2.size() == 1);
	}
}
*/
		
		/*Stack<Piece> fourStackPlayer1 = new Stack<Piece>();
		Stack<Piece> threeStackPlayer1 = new Stack<Piece>();
		Stack<Piece> twoStackPlayer1 = new Stack<Piece>();
		Stack<Piece> oneStackPlayer1 = new Stack<Piece>();
		
		Stack<Piece> fourStackPlayer2 = new Stack<Piece>();
		Stack<Piece> threeStackPlayer2 = new Stack<Piece>();
		Stack<Piece> twoStackPlayer2 = new Stack<Piece>();
		Stack<Piece> oneStackPlayer2 = new Stack<Piece>();
		
		
		Piece p1 = new Piece(null);
		Piece p2 = new Piece(null);
		Piece p3 = new Piece(null);
		Piece p4 = new Piece(null);
		fourStackPlayer1.add(p1);
		fourStackPlayer1.add(p2);
		fourStackPlayer1.add(p3);
		fourStackPlayer1.add(p4);
		assertEquals(fourStackPlayer1.size(), 4);
		
		Piece p5 = new Piece(null);
		Piece p6 = new Piece(null);
		Piece p7 = new Piece(null);
		threeStackPlayer1.add(p5);
		threeStackPlayer1.add(p6);
		threeStackPlayer1.add(p7);
		assertEquals(threeStackPlayer1.size(), 3);
		
		Piece p8 = new Piece(null);
		Piece p9 = new Piece(null);
		twoStackPlayer1.add(p8);
		twoStackPlayer1.add(p9);
		assertEquals(twoStackPlayer1.size(), 2);
		
		Piece p10 = new Piece(null);
		oneStackPlayer1.add(p10);
		assertEquals(oneStackPlayer1.size(), 1);
		
		Piece p21 = new Piece(null);
		Piece p22 = new Piece(null);
		Piece p23 = new Piece(null);
		Piece p24 = new Piece(null);
		fourStackPlayer2.add(p21);
		fourStackPlayer2.add(p22);
		fourStackPlayer2.add(p23);
		fourStackPlayer2.add(p24);
		assertEquals(fourStackPlayer2.size(), 4);
		
		Piece p25 = new Piece(null);
		Piece p26 = new Piece(null);
		Piece p27 = new Piece(null);
		threeStackPlayer2.add(p25);
		threeStackPlayer2.add(p26);
		threeStackPlayer2.add(p27);
		assertEquals(threeStackPlayer2.size(), 3);
		
		Piece p28 = new Piece(null);
		Piece p29 = new Piece(null);
		twoStackPlayer2.add(p28);
		twoStackPlayer2.add(p29);
		assertEquals(twoStackPlayer2.size(), 2);
		
		Piece p210 = new Piece(null);
		oneStackPlayer2.add(p210);
		assertEquals(oneStackPlayer2.size(), 1);
	
	}

}
*/