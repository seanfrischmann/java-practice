package cse115.graphics;

/**
 * 
 * TODO: Add comments to Locatable
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 29, 2006 Locatable.java
 */
public interface Locatable {

	/**
	 * Sets the Location of this Object to be the specified point
	 * 
	 * @param p
	 *            the point at which to locate this Object
	 */
	public void setLocation(java.awt.Point p);

	/**
	 * Gets the location of this Object
	 * 
	 * @return a java.awt.Point representing the current location of the Object
	 */
	public java.awt.Point getLocation();

	/**
	 * Moves the Object from one location to another by a specific vector
	 * 
	 * @param v
	 *            The vector representing where this should move
	 */
	public void move(cse115.utilities.Vector v);
}
