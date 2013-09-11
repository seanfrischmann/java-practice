package cse115.graphics;

/**
 * 
 * TODO: Fill in comments for Graphic
 * 
 * TODO: this.redraw(), every graphic should be able to repaint just itself
 * [move if(container==null) here]
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 27, 2006
 * 
 * 
 * Graphic.java
 */
public interface Graphic extends Sizeable, CenterLocatable, Rotatable {

	/**
	 * This sets the container of this graphic
	 * 
	 * @param container
	 *            the container which will contain this graphic
	 */
	public void setContainer(IContainer container);

	/**
	 * Returns the bounding box of this graphic
	 * 
	 * @return a java.awt.Rectangle representing the bounds
	 */
	public java.awt.Rectangle getBounds();

	/**
	 * Checks whether a given point is contained within this graphic
	 * 
	 * @param p
	 *            The point to check
	 * @return true if this graphic contains <code>p</code> false if not
	 */
	public boolean contains(java.awt.Point p);
	
	/**
	 * Should return a java.awt.Shape representation of this graphic.  Used for the contains method
	 * @return a java.awt.Shape
	 */
	public java.awt.Shape getShape();

	/**
	 * This method uses the Graphics2D object to paint itself onto its container
	 * 
	 * @param gs
	 *            The Graphics2D object used to do the painting
	 */
	public void paint(java.awt.Graphics2D gs);

	/**
	 * This method uses the Graphics2D object to paint itself onto its container
	 * using <code>location</code> as an offset.
	 * 
	 * This sets up the Graphics2D object to paint correctly, but the actual
	 * shape that gets painted is defined in the subclass - in a method called
	 * <code>actualPaint</code>
	 * 
	 * @param gs
	 *            The Graphics2D object used to do the painting
	 * @param location
	 *            The offset at which to paint this graphic
	 */
	public void paint(java.awt.Graphics2D gs, java.awt.Point location);

	/**
	 * This method uses the Graphics2D object to paint the actual shape onto the
	 * Container.
	 * 
	 * @param gs
	 *            The Graphics2D object used to do the painting
	 * @param location
	 *            The offset at which to paint this graphic
	 * @param dimension
	 *            The dimension this graphic
	 */
	public void actualPaint(java.awt.Graphics2D gs, java.awt.Point location,
			java.awt.Dimension dimension);

	/**
	 * Adds a <code>java.awt.event.MouseListener</code> onto this graphic
	 * TODO: remove mouse listener?
	 * 
	 * @param ml
	 *            The <code>java.awt.event.MouseListener</code> to listen on
	 *            this graphic
	 */
	public void addMouseListener(java.awt.event.MouseListener ml);

	/**
	 * Returns all the <code>java.awt.event.MouseListener</code>s of this
	 * graphic
	 * 
	 * @return Returns a collection containing all the
	 *         <code>java.awt.event.MouseListener</code>s of this graphic
	 */
	public java.util.Collection<java.awt.event.MouseListener> getMouseListeners();

	/**
	 * Adds a <code>java.awt.event.MouseMotionListener</code> onto this
	 * graphic TODO: remove listener?
	 * 
	 * @param mml
	 *            The <code>java.awt.event.MouseMotionListener</code> to
	 *            listen on this graphic
	 */
	public void addMouseMotionListener(java.awt.event.MouseMotionListener mml);

	/**
	 * Returns all the <code>java.awt.event.MouseMotionListener</code>s of
	 * this graphic
	 * 
	 * @return Returns a collection containing all the
	 *         <code>java.awt.event.MouseMotionListener</code>s of this
	 *         graphic
	 */
	public java.util.Collection<java.awt.event.MouseMotionListener> getMouseMotionListeners();
}
