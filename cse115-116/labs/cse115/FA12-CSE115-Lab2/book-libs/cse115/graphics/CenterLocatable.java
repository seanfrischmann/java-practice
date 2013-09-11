package cse115.graphics;

/**
 * 
 * TODO: Fill in comments for CenterLocatable
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 28, 2006
 * 
 * 
 * CenterLocatable.java
 */
public interface CenterLocatable extends Locatable {

	/**
	 * Finds the center location of this Object
	 * 
	 * @return The point at the center of this Object
	 */
	public java.awt.Point getCenterLocation();

	/**
	 * Sets the location of this graphic by putting the center of the Object at the specified point
	 * @param p the Point to set the center of this object to be
	 */
	public void setCenterLocation(java.awt.Point p);
}
