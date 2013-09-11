package Tests;

import static org.junit.Assert.assertTrue;

import java.awt.Color;

import model.Piece;
import model.Player;
import model.Position;

import org.junit.Test;

public class PieceTest {

	@Test
	public void Piecetest() {
		Player p = new Player(Color.RED, "Player");
		Position po = new Position(0, 0, null);
		Piece pi = new Piece("Piece", p, po);
		String expectedString = "Piece";
		Player expectedPlayer = p;
		Position expectedPostion = po;
		String actualString = pi.toString();
		Player actualPlayer = pi.getPlayer();
		Position actualPosition = pi.getStartingPostion();
		assertTrue("The expected string was " + expectedString + "." + "The actual string was " + actualString + ".", expectedString == actualString);
		assertTrue("The expected player was " + expectedPlayer + "." + "The actual player was " + actualPlayer + ".", expectedPlayer == actualPlayer);
		assertTrue("The expected position was " + expectedPostion + "." + "The actual position was " + actualPosition + ".", expectedPostion == actualPosition);
	}
	
	@Test
	public void setTrack(){
		Position[] track = new Position[10];
		Player p = new Player(Color.RED, "Player");
		Position po = new Position(0, 0, null);
		Piece pi = new Piece("Piece", p, po);
		Position[] expected = track;
		pi.setTrack(track);
		Position[] actual = pi.getTrack();
		assertTrue("The expected value was " + expected + ".  The actual value was " + actual + ".", expected == actual);
	}
	
	@Test 
	public void toStringTest(){
		Player p = new Player(Color.RED, "Player");
		Position po = new Position(0, 0, null);
		Piece pi = new Piece("Piece", p, po);
		String expected = "Piece";
		String actual = pi.toString();
		assertTrue("The expected value was " + expected + ".  The actual value was " + actual + ".", expected == actual);
	}
	
	@Test
	public void getTrackTest(){
		Position[] track = new Position[10];
		Player p = new Player(Color.RED, "Player");
		Position po = new Position(1, 1, null);
		Piece pi = new Piece("Piece", p, po);
		Position[] expected = track;
		pi.setTrack(track);
		Position[] actual = pi.getTrack();
		assertTrue("The expected value was " + expected + ".  The actual value was " + actual + ".", expected == actual);
	}
	
	@Test
	public void getPlayerTest(){
		Player p = new Player(Color.RED, "Player");
		Position po = new Position(0, 0, null);
		Piece pi = new Piece("Piece", p, po);
		Player expected = p;
		Player actual = pi.getPlayer();
		assertTrue("The expected value was " + expected + ".  The actual value was " + actual + ".", expected == actual);
	}
	
	@Test
	public void getStartingPostionTest(){
		Player p = new Player(Color.RED, "Player");
		Position po = new Position(0, 0, null);
		Piece pi = new Piece("Piece", p, po);
		Position expected = po;
		Position actual = pi.getStartingPostion();
		assertTrue("The expected value was " + expected + ".  The actual value was " + actual + ".", expected == actual);
	}
}
