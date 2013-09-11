package example1;

import cse115.graphics.Graphic;
import cse115.utilities.Vector;

public interface Organism extends Graphic {
	public void setLocation(java.awt.Point p);
	public java.awt.Point getLocation();
	public Vector getVelocity();
	public void flipHorizontal();
	public void flipVertical();
	public void setVelocity(Vector v);
	public boolean isMoving();
}
