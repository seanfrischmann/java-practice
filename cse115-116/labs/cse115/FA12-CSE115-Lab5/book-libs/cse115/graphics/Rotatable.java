package cse115.graphics;

/**
 * 
 * TODO: Add comments to Rotatable, Should start with rotation of 0 = normal.
 *
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 *
 * Created on: Jul 29, 2006
 * Rotatable.java
 */
public interface Rotatable {
	/**
	 * Rotates clockwise the Object by the specified number of degrees
	 * @param degreesToRotate rotates the Object by this many degrees
	 */
	public void rotate(Integer degreesToRotate);
	
	/**
	 * Sets the Rotation of the Object to be a certain degree.
	 * @param degree the number of degrees at which to have the Object rotated
	 */
	//TODO: that comment sucks
	public void setRotation(Integer degree);
	
	/**
	 * Gets the current rotation of this Object in degrees.
	 * @return An Integer (between 0 and 359) representing the current angle of rotation
	 */
	public Integer getRotation();
}
