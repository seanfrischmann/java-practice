package Tests;

import static org.junit.Assert.assertTrue;

import java.awt.Color;

import model.Player;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void playerTest() {
		Player p = new Player(Color.RED, "Player");
		Color expectedColor = Color.RED;
		int expectedScore = 0;
		String expectedString = "Player";
		Color actualColor = p.getColor();
		int actualScore = p.getScore();
		String actualString = p.getName();
		assertTrue("The expected color was " + expectedColor + "." + "The actual color was " + actualColor + ".", expectedColor == actualColor);
		assertTrue("The expected score was " + expectedScore + "." + "The actual score was " + actualScore + ".", expectedScore == actualScore);
		assertTrue("The expected string was " + expectedString + "." + "The actual string was " + actualString + ".", expectedString == actualString);
	}
	
	@Test
	public void getColorTest(){
		Player p = new Player(Color.RED, "Player");
		Color expected = Color.RED;
		Color actual = p.getColor();
		assertTrue("The expected value was " + expected + "." + "The actual value was " + actual + ".", expected == actual);
	}
	
	@Test
	public void getNameTest(){
		Player p = new Player(Color.RED, "Player");
		String expected = "Player";
		String actual = p.getName();
		assertTrue("The expected value was " + expected + "." + "The actual value was " + actual + ".", expected == actual);
	}
	
	@Test
	public void getScoreTest(){
		Player p = new Player(Color.RED, "Player");
		int expected = 0;
		int actual = p.getScore();
		assertTrue("The expected value was "+ expected + "." + "The actual value was " + actual + ".", expected == actual);
	}
	
	@Test 
	public void setScoreTest(){
		Player p = new Player(Color.RED, "Player");
		p.setScore(4);
		int expected = 4;
		int actual = p.getScore();
		assertTrue("The expected value was " + expected + "." + "The actual value was " + actual + ".", expected == actual);
	}
}
