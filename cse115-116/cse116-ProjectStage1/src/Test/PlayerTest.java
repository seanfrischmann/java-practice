package Test;

import static org.junit.Assert.assertTrue;
import game.Player;

import java.awt.Color;

import org.junit.Test;
/**
 * Tests the functionality of the Player class
 * <p>
 * @author Matthew
 *
 */
public class PlayerTest {
	/** 
	 * Tests if the method returns the Color of the selected player
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void getColorTest() {
		Player p1 = new Player(Color.RED);
		Color expected = Color.RED;
		Color actual = p1.getColor();
		assertTrue("The expected value was " + expected+"." + "The actual value was " + actual+ ".", expected == actual);
	}

}
