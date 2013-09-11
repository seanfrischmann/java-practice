package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Color;
import java.util.Stack;

import model.Board;
import model.Piece;
import model.Player;
import model.StartPosition;

import org.junit.Test;

import ui.Driver;

public class StartPositionTest {

	@Test
	public void startPositionTest() throws AWTException {
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		StartPosition sp = new StartPosition(0, 0, board);
		int expectedOffset = 0;
		int expectedIndex = 0;
		String expectedStack = new Stack<Piece>().toString();
		Board expectedBoard = board;
		int actualOffset = sp.getOffset();
		int actualIndex = sp.getIndex();
		String actualStack = sp.getStack().toString();
		Board actualBoard = sp.getBoard();
		assertTrue("The expected offset was " + expectedOffset + ".  The actual offset was " + actualOffset + ".", expectedOffset == actualOffset);
		assertTrue("The expected index was " + expectedIndex + ".  The actual index was " + actualIndex + ".", expectedIndex == actualIndex);
		assertTrue("The expected stack was "+ expectedStack + ".  The actual stack was " + actualStack + ".", expectedStack == actualStack);
		assertTrue("The expected board was " + expectedBoard + ".  The actual board was " + actualBoard + ".", expectedBoard == actualBoard);
	}
	
	@Test
	public void moveTopTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		StartPosition sp = new StartPosition(0, 0, board);
		boolean expected = true;
		boolean actual = false;
		try{
			sp.moveTop();
		}
		catch (UnsupportedOperationException e){
			actual = true;
		}
		assertTrue(expected == actual);
	}
	
	@Test
	public void moveTopTrackTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		StartPosition sp = new StartPosition(0, 0, board);
		Player pl1 = new Player(Color.RED, "PLayer1");
		Piece p1 = new Piece("Piece1", pl1, sp);
		sp.putOn(p1);
		sp.moveTopTrack();
		String expected = board.leftTrack().toString();
		String actual = p1.getTrack().toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moveCenterTrackTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		StartPosition sp = new StartPosition(0, 0, board);
		Player pl1 = new Player(Color.RED, "PLayer1");
		Piece p1 = new Piece("Piece1", pl1, sp);
		sp.putOn(p1);
		sp.moveCenterTrack();
		String expected = board.centerTrack().toString();
		String actual = p1.getTrack().toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moveBottomTrackTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		StartPosition sp = new StartPosition(0, 0, board);
		Player pl1 = new Player(Color.RED, "PLayer1");
		Piece p1 = new Piece("Piece1", pl1, sp);
		sp.putOn(p1);
		sp.moveBottomTrack();
		String expected = board.rightTrack().toString();
		String actual = p1.getTrack().toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void toStringTest() throws AWTException {
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		StartPosition sp = new StartPosition(0, 0, board);
		String expected = new Stack<Integer>().toString();
		String actual = sp.toString();
		assertEquals(expected, actual);
	}
}