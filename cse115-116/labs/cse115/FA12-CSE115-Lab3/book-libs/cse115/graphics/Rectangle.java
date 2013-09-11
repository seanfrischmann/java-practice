package cse115.graphics;

import java.awt.Shape;

/**
 * TODO: Add comments to Rectangle
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 29, 2006 Rectangle.java
 */
public class Rectangle extends AbstractColorableGraphic {

	/**
	 * Creates a new instance of the Rectangle Graphic with dimension (0,0) and
	 * location(0,0)
	 */
	// TODO: all graphics should be noted what their start values are
	public Rectangle() {
	}

	/**
	 * This method uses the Graphics2D object to paint a rectangle onto the
	 * container at a specified point with a specified dimension
	 * 
	 * @see cse115.graphics.Graphic#actualPaint(java.awt.Graphics2D,
	 *      java.awt.Point, java.awt.Dimension)
	 * @param gs
	 *            The Graphics2D object to do the painting
	 * @param location
	 *            The point at which to paint the rectangle
	 * @param dimension
	 *            The dimension of the rectangle to paint
	 */
	public void actualPaint(java.awt.Graphics2D gs, java.awt.Point location,
			java.awt.Dimension dimension) {
		gs.fillRect(location.x, location.y, dimension.width, dimension.height);
	}

	/**
	 * @see cse115.graphics.Graphic#getShape()
	 * @return a java.awt.Rectangle
	 */
	public Shape getShape() {
		return this.getBounds();
	}


}
