package example1;

import static example1.ITerrariumConstants.SOIL_LOCATION;
import static example1.ITerrariumConstants.SOIL_SIZE;
import cse115.utilities.Random;
import cse115.utilities.Vector;

/**
 * @author alphonce
 * 
 * A behavior for walking left/right, but not up/down.
 *
 */
public class Walk implements IBehavior {

	@Override
	public void perform(Organism org) {
		// randomly flip orientation (horizontal/vertical) and direction
		int r1 = Random.randomInteger(0, 999);
		if (r1 < 15) {
			switch (Random.randomInteger(0, 2)) {
			  case 0:	org.setVelocity(new Vector(org.getVelocity().getDx(), 0));
			    break;
			  case 1:	org.setVelocity(new Vector(-org.getVelocity().getDx(), 0));
	  			break;
			}
		}
		java.awt.Point location = org.getLocation();
		Vector velocity = org.getVelocity();
		int newX = location.x + velocity.getDx();

		// bounds checking
		if (newX + org.getDimension().width > SOIL_LOCATION.x + SOIL_SIZE.width) {
			newX = location.x;	// reset x location
			org.flipHorizontal();
		}
		if (newX < SOIL_LOCATION.x) {
			newX = location.x;	// reset x location
			org.flipHorizontal();
		}
				
		// updating
		org.setLocation(new java.awt.Point(newX, location.y));
	}
}
