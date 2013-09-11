package Tests;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Color;
import java.util.Stack;

import model.Board;
import model.Piece;
import model.Player;
import model.Position;

import org.junit.Test;

import ui.Driver;

public class PositionTest {

	@Test
	public void PostionTest() {
		Position po = new Position(0, 0, null);
		int expectedOffset = 0;
		int expectedIndex = 0;
		String expectedStack = new Stack<Piece>().toString();
		Board expectedBoard = null;
		int actualOffset = po.getOffset();
		int actualIndex = po.getIndex();
		String actualStack = po.getStack().toString();
		Board actualBoard = po.getBoard();
		assertTrue("The expected offset was " + expectedOffset + ".  The actual offset was " + actualOffset + ".", expectedOffset == actualOffset);
		assertTrue("The expected index was " + expectedIndex + ".  The actual index was " + actualIndex + ".", expectedIndex == actualIndex);
		assertTrue("The expected stack was "+ expectedStack + ".  The actual stack was " + actualStack + ".", expectedStack == actualStack);
		assertTrue("The expected board was " + expectedBoard + ".  The actual board was " + actualBoard + ".", expectedBoard == actualBoard);
	}

	@Test
	public void heightTest(){
		Position po = new Position(0, 0, null);
		int expected = 0;
		int actual = po.height();
		assertTrue("The expected value was " + expected + ".  The actual value was " + actual + ".", expected == actual);	
	}
	
	@Test
	public void putOnTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		Position po = new Position(0, 0, board);
		Player pl1 = new Player(Color.RED, "Player1");
		Player pl2 = new Player(Color.RED, "Player2");
		Piece p1 = new Piece("Piece1", pl1, po);
		Piece p2= new Piece("Piece2", pl2, po);
		po.putOn(p1);
		po.putOn(p2);
		String expected = p2.toString();
		String actual = po.getStack().pop().toString();
		assertTrue("The expected value was " + expected + ".  The actual value was " + actual +".", expected == actual);		
	}
}
