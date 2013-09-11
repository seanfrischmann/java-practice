package example1;

import static example1.ITerrariumConstants.SOIL_LOCATION;
import static example1.ITerrariumConstants.SOIL_SIZE;
import cse115.utilities.Random;
import cse115.utilities.Vector;

/**
 * @author alphonce
 * 
 * A behavior for walking left/right and up/down.
 *
 */
public class Tunnel implements IBehavior {

	@Override
	public void perform(Organism org) {
		// randomly flip orientation (horizontal/vertical) and direction
		int r1 = Random.randomInteger(0, 999);
		if (r1 < 15) {
			switch (Random.randomInteger(0, 3)) {
			  case 0:	org.setVelocity(new Vector(org.getVelocity().getDx(), org.getVelocity().getDy()));
			    break;
			  case 1:	org.setVelocity(new Vector(-org.getVelocity().getDx(), -org.getVelocity().getDy()));
	  			break;
			  case 2:	org.setVelocity(new Vector(org.getVelocity().getDy(), org.getVelocity().getDx()));
	  			break;
			  case 3:	org.setVelocity(new Vector(-org.getVelocity().getDy(), -org.getVelocity().getDx()));
	  			break;
			}
		}
		java.awt.Point location = org.getLocation();
		Vector velocity = org.getVelocity();
		int newX = location.x + velocity.getDx();
		int newY = location.y + velocity.getDy();

		// bounds checking
		if (newX + org.getDimension().width > SOIL_LOCATION.x + SOIL_SIZE.width) {
			newX = location.x;	// reset x location
			org.flipHorizontal();
		}
		if (newX < SOIL_LOCATION.x) {
			newX = location.x;	// reset x location
			org.flipHorizontal();
		}
		// We DO want width, not height, because ant changes direction of travel
		if (newY + org.getDimension().width > SOIL_LOCATION.y + SOIL_SIZE.height) {
			newY = location.y;	// reset y location
			org.flipVertical();
		}
		if (newY < SOIL_LOCATION.y) {
			newY = location.y;	// reset y location
			org.flipVertical();
		}
				
		// updating
		org.setLocation(new java.awt.Point(newX, newY));
	}
}
