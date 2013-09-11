package cse115.graphics;

/**
 * 
 * TODO: Add comments to IContainer
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 29, 2006 IContainer.java
 */
public interface IContainer extends java.awt.image.ImageObserver {

	/**
	 * Adds a Graphic onto the Container
	 * 
	 * @param g
	 *            The Graphic to put on/in the container
	 */
	public void add(Graphic g);

	/**
	 * Removes a Graphic from the container
	 * 
	 * @param g
	 *            The Graphic to remove from the container
	 */
	public void remove(Graphic g);

	/**
	 * Forces a repaint of all the Graphics on the container
	 */
	public void repaint();
}
