package cse115.graphics;

import java.awt.Shape;

/**
 * 
 * TODO: Fill in comments for Ellipse
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 28, 2006
 * 
 * 
 * Ellipse.java
 */
public class Ellipse extends AbstractColorableGraphic {

	/**
	 * Creates a new instance of Ellipse with a Dimension of 0,0 and Location of
	 * 0,0
	 */
	public Ellipse() {
	}

	/**
	 * This method uses the Graphics2D object to paint an ellipse onto the
	 * container at a specified point with a specified dimension
	 * 
	 * @see cse115.graphics.Graphic#actualPaint(java.awt.Graphics2D,
	 *      java.awt.Point, java.awt.Dimension)
	 * @param gs
	 *            The Graphics2D object to do the painting
	 * @param location
	 *            The point at which to paint the Ellipse
	 * @param dimension
	 *            The dimension of the Ellipse to paint
	 */
	@Override
	public void actualPaint(java.awt.Graphics2D gs, java.awt.Point location,
			java.awt.Dimension dimension) {
		gs.fillOval(location.x, location.y, dimension.width, dimension.height);
	}

	/**
	 * @see cse115.graphics.Graphic#getShape()
	 * @return a java.awt.geom.Ellipse2D.Double
	 */
	@Override
	public Shape getShape() {
		return new java.awt.geom.Ellipse2D.Double(this.getLocation().x, this
				.getLocation().y, this.getDimension().getWidth(), this
				.getDimension().getHeight());
	}
}
