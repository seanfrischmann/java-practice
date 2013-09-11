package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;

import model.Board;
import model.Piece;
import model.Player;
import model.Position;

import org.junit.Test;

import ui.Driver;

public class BoardTest {

	@Test
	public void Boardtest() throws AWTException {
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		int expectedNumberOfPlayers = Driver.getArgs().length - 1;
		int actualNumberOfPlayers = board.getNumberOfPlayers();
		assertTrue("The expected value was " + expectedNumberOfPlayers + ".  The actual value was " + actualNumberOfPlayers + ".", expectedNumberOfPlayers == actualNumberOfPlayers);
	}
	
	@Test 
	public void addPlayersTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		int expected = 4;
		board.addPlayers(args.length - 1);
		int actual = args.length -1;
		assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);
	}
	
	@Test
	public void canMoveForwardTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		Position po = new Position(0, 0, board);
		Player pl1 = board.getCurrentPlayersTurn();
		Piece p = new Piece("Piece1", pl1, po);
		boolean expected = true;
		boolean actual = board.canMoveForward(p);
		assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);
	}
	
	@Test
	public void boardArrayTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		int expected = 32;
		int actual = board.boardArray().size();
		assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);
	}
	
	@Test 
	public void getBoardTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		for (int i = 0; i < board.getBoard().size(); i++){
			String expected = board.boardArray().get(i).toString();
			String actual = board.getBoard().get(i);
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void getStartPositionArray() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		for (int i = 0; i < board.getStartPositionArraySize(); i++){
		int expected = board.getBoard().get(i).length();
		int actual = board.getStartPositionArray(i).length;
		assertEquals(expected, actual);
		}
	}
	
	@Test
	public void getStartPostionArraySize() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		for (int i = 0; i < board.getStartPositionArraySize(); i++){
		int expected = board.getStartPositionArray(i).length + 1;
		int actual = board.getStartPositionArraySize();
		assertEquals(expected, actual);
		}
	}
	
	@Test
	public void getStartPositionTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		int expected = 3;
		int actual = board.getStartPosition(3, 2).getStack().size();
		assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);
		
	}
	
	@Test
	public void getLeftTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		for (int i = 0; i < board.leftTrack().length; i++){
			String expected = "[]";
			String actual = board.getLeft(i).toString();
			assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);
		}
	}
	
	@Test 
	public void getRightTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		for (int i = 0; i < board.rightTrack().length; i++){
			String expected = "[]";
			String actual = board.getRight(i).toString();
			assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);
		}
	}
	
	@Test 
	public void getCenterTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		for (int i = 0; i < board.centerTrack().length; i++){
			String expected = "[]";
			String actual = board.getCenter(i).toString();
			assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);
		}
	}
	
	@Test 
	public void getCommonTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		for (int i = 0; i < board.centerTrack().length; i++){
			String expected = "[]";
			String actual = board.getCommon(i).toString();
			assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);
		}
	}
	
	@Test
	public void leftTrackTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		int expected = 14;
		int actual = board.leftTrack().length;
		assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);		
	}
	
	@Test 
	public void rightTrackTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		int expected = 14;
		int actual = board.rightTrack().length;
		assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);		
	}
	
	@Test
	public void centerTrackTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		int expected = 14;
		int actual = board.centerTrack().length;
		assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);
		
	}
	
	@Test
	public void getNumberOfPlayersTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		int expected = 4;
		int actual = board.getNumberOfPlayers();
		assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);	
	}
	
	@Test
	public void getPlayerArrayTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		String expected1 = new String("Matthew");
		String expected2 = new String("Sean");
		String expected3 = new String("Anna");
		String expected4 = new String("Audrey");
		String actual1 = board.getPlayerArray().get(0).getName();
		String actual2 = board.getPlayerArray().get(1).getName();
		String actual3 = board.getPlayerArray().get(2).getName();
		String actual4 = board.getPlayerArray().get(3).getName();
		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertEquals(expected3, actual3);
		assertEquals(expected4, actual4);
	}
	
	@Test
	public void getCurrentPlayersTurnTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		int expected = 4;
		int actual = board.getPlayerArray().size();
		assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);	
	}
	
	@Test
	public void setNextPlayerTurnTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		String expected = "Sean";
		board.setNextPlayersTurn();
		String actual = board.getCurrentPlayersTurn().getName();
		assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);	
	}
	
	@Test 
	public void getWinnerTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		String expected = "Matthew";
		board.getPlayerArray().get(0).setScore(6);
		String actual = board.getPlayerArray().get(0).getName();
		assertTrue("The expected value was " + expected +".  The actual value was " + actual + ".", expected == actual);	
	}
}