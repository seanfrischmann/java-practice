package Tests;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Color;

import model.BackwardsPosition;
import model.Board;
import model.Piece;
import model.Player;
import model.Position;

import org.junit.Test;

import ui.Driver;

public class BackwardsPositionTest {

	@Test
	public void backwardsPositionTest() throws AWTException {
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();		
		BackwardsPosition bp = new BackwardsPosition(0, 0, board);
		boolean expected = false;
		boolean actual = bp.isForwardPosition();
		assertTrue("The expected value was " + expected + ".  The actual value was " + actual + ".", expected == actual);		
	}

	@Test
	public void moveTopTest() throws AWTException{
		String[] args = new String[]{"mouse", "Matthew", "Sean", "Anna", "Audrey"};
		Driver.main(args);
		Board board = new Board();
		Player pl1 = new Player(Color.RED, "PLayer1");
		Position[] track = new Position[32];
		BackwardsPosition bp = new BackwardsPosition(0, 15, board);
		Piece p1 = new Piece("Piece1", pl1, bp);
		Piece p2 = new Piece("Piece2", pl1, bp);
		int expected = 2;
		p1.setTrack(track);
		p2.setTrack(track);
		bp.putOn(p1);
		bp.putOn(p2);
		bp.moveTop();
		int actual = bp.height();
		assertTrue("The expected value was " + expected + ".  The actual value was " + actual + ".", expected == actual);		
	}
}
