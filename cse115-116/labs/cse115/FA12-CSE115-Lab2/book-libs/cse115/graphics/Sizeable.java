package cse115.graphics;

/**
 * 
 * TODO: Add comments to Sizeable
 *
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 *
 * Created on: Jul 29, 2006
 * Sizeable.java
 */
public interface Sizeable {

	/**
	 * Sets the Dimension of this Object
	 * @param d The dimension to set the Object to be
	 */
	public void setDimension(java.awt.Dimension d);
	
	/**
	 * Gets the Dimension of this Object
	 * @return the Object's Dimension
	 */
	public java.awt.Dimension getDimension();
}
