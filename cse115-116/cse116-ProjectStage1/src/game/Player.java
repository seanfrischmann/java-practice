package game;

import java.awt.Color;

/**
 * This class establishes the players and sets their distinct colors
 * <p>
 * @author Sean
 *
 */
public class Player {
	/**
	 * The constructor creates a private color object
	 * This color is then assigned to the player
	 * <p>
	 * @author Sean
	 */
	private Color _color;
	
	public Player(Color color){
		_color = color;
	}
	/**
	 * Method gets the Color of the Player
	 * <p>
	 * @return Color of selected Player
	 * <p>
	 * @author Sean
	 */
	public Color getColor(){
		return _color;
	}
	
}
