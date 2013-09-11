package Test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.HashMap;

import game.EndingSquare;
import game.Lotus;
import game.Piece;
import game.Player;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the functionality of the EndingSquare class
 * <p>
 * @author Matthew
 *
 */
public class EndingSquareTest {
	
	@Test
	public void addPieceTest() {
		Player p1 = new Player(Color.RED);
		Piece pi1 = new Piece(p1);
		Piece pi2 = new Piece(p1);
		Piece pi3= new Piece(p1);
		EndingSquare endSquare = new EndingSquare();
		endSquare.addPiece(pi1);
		endSquare.addPiece(pi2);
		endSquare.addPiece(pi3);
		int expected = 3;
		int actual = endSquare.getPlayersEndStack(p1);
		assertTrue("The expected value was " + expected+"." + "The actual value was " + actual+ ".", expected == actual);
	}
	/**
	 * Tests the functionality of the getPlayersEndStack method
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void getPlayersEndStackTest() {
		Player p1 = new Player(Color.RED);
		Piece pi1 = new Piece(p1);
		Piece pi2 = new Piece(p1);
		Piece pi3= new Piece(p1);
		EndingSquare endSquare = new EndingSquare();
		endSquare.addPiece(pi1);
		endSquare.addPiece(pi2);
		endSquare.addPiece(pi3);
		int expected = 3;
		int actual = endSquare.getPlayersEndStack(p1);
		assertTrue("The expected value was " + expected+"." + "The actual value was " + actual+ ".", expected == actual);
	}
	}

