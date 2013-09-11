package cse115.graphics;

/**
 * 
 * TODO: Fill in comments for Colorable
 *
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 *
 * Created on: Jul 28, 2006
 *
 *
 * Colorable.java
 */
public interface Colorable {

	/**
	 * Gets the Color of this Object
	 * @return the <code>java.awt.Color</code> of this Object
	 */
	public java.awt.Color getColor();
	
	/**
	 * Sets the Color of this Object
	 * @param c the <code>java.awt.Color</code> to set the Object to become
	 */
	public void setColor(java.awt.Color c);
}
