package cse115.graphics;

import java.awt.Shape;
import javax.swing.JComponent;

/**
 * 
 * TODO: Fill in comments for CompoundGraphic
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 28, 2006 TODO: dimensions should be set first, adjusting
 * shapes may not be as expected
 * 
 * CompoundGraphic.java
 */
public class CompoundGraphic extends AbstractGraphic implements IContainer {

	/** The List of Graphics that this compound contains* */
	private java.util.ArrayList<Graphic> _graphicsList;

	/**
	 * Creates a new instance of an empty CompoundGraphic with a dimension of
	 * (1,1) at point (0,0)
	 */
	public CompoundGraphic() {
		_graphicsList = new java.util.ArrayList<Graphic>();
		this.setDimension(new java.awt.Dimension(1, 1));
	}

	/**
	 * Adds a graphic to the compound
	 * 
	 * @see cse115.graphics.IContainer#add(cse115.graphics.Graphic)
	 * @param g
	 *            The Graphic to add
	 */
	@Override
	public void add(Graphic g) {
		_graphicsList.add(g);
		g.setContainer(this);
		if (this.getContainer() != null) {
			this.getContainer().repaint();
			System.out.println("added " + g + ", now repainting");
		}

		// TODO: paint with bounds
	}

	/**
	 * Removes a Graphic from the Compound
	 * 
	 * @see cse115.graphics.IContainer#remove(cse115.graphics.Graphic)
	 * @param g
	 *            The Graphic to remove
	 */
	@Override
	public void remove(Graphic g) {
		_graphicsList.remove(g);
		if (this.getContainer() != null)
			this.getContainer().repaint();
		// TODO: paint with bounds
	}

	/**
	 * Move this Graphic by a certain vector
	 * 
	 * @see cse115.graphics.Locatable#move(cse115.utilities.Vector)
	 * @param vector
	 *            The vector representing how much to move
	 */
	@Override
	public void move(cse115.utilities.Vector vector) {
		for (Graphic g : _graphicsList) {
			g.move(vector);
		}
	}

	/**
	 * Tests to see whether a given point is in one of the graphics in the
	 * compound. Overridden to test for all the graphics this contains.
	 * 
	 * @see cse115.graphics.Graphic#contains(java.awt.Point)
	 * @param pointToCheck
	 *            the point for which to test containment
	 * @return true if the point is in one of the graphics in the compound,
	 *         false otherwise
	 */
	@Override
	public boolean contains(java.awt.Point pointToCheck) {
		java.awt.Point newPoint = new java.awt.Point(pointToCheck.x - this.getLocation().x,
				pointToCheck.y - this.getLocation().y);
		for (Graphic g : _graphicsList)
			if (g.contains(newPoint))
				return true;

		return false;
	}

	/**
	 * Uses the Graphics2D object to Paint the CompoundGraphic at a specified
	 * location and with a specified dimension
	 * 
	 * @see cse115.graphics.Graphic#actualPaint(java.awt.Graphics2D,
	 *      java.awt.Point, java.awt.Dimension)
	 * @param gs
	 *            The Graphics2D object that will do the painting
	 * @param location
	 *            The Location at which to paint the Compound
	 * @param dimension
	 *            The Dimension of the Compound (not used)
	 */
	@Override
	public void actualPaint(java.awt.Graphics2D gs, java.awt.Point location,
			java.awt.Dimension dimension) {
		for (Graphic g : _graphicsList) {
			// paint each thing with an offset of location
			g.paint(gs, location);
		}
	}

	/**
	 * Forces a repaint of all the Graphics in the same container as the
	 * Compound
	 * 
	 * @see cse115.graphics.IContainer#repaint()
	 */
	// TODO: paint with bounds
	@Override
	public void repaint() {
		if (this.getContainer() != null) {
			this.getContainer().repaint();
		} else {
			// System.out.println("can't repaint "+this);
		}
	}

	/**
	 * @param img
	 * @param infoflags
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return I don't know
	 * @see JComponent#imageUpdate(java.awt.Image, int, int, int, int, int)
	 */
	@Override
	public boolean imageUpdate(java.awt.Image img, int infoflags, int x, int y, int width,
			int height) {
		// forward request on to this compound's container
		return this.getContainer().imageUpdate(img, infoflags, x, y, width, height);
	}

	/**
	 * Sets the dimension of this compound, thus causing all the Graphics in the
	 * compound to be altered. Use with caution. It is much easier if the
	 * Dimensions of CompoundGraphics are set before any Graphics are inserted
	 * into it.
	 * 
	 * @see cse115.graphics.Sizeable#setDimension(java.awt.Dimension)
	 * @param newDimension
	 *            The Dimension to set this CompoundGraphic to be
	 */
	@Override
	public void setDimension(java.awt.Dimension newDimension) {
		java.awt.Dimension oldDimension = this.getDimension();
		for (Graphic g : _graphicsList) {
			this.adjustShape(this, g, oldDimension, newDimension);
		}

		super.setDimension(newDimension);
		// this.setBounds(this.getLocation().x, this.getLocation().y,
		// newDimension.width,
		// newDimension.height);
	}

	/**
	 * Adjusts the specified graphic's size and location based on the
	 * newDimension and it's position relative to the staticShape
	 * 
	 * @param staticShape The shape to base the calculations on
	 * @param shapeToAdjust The Shape that will be moved/resized
	 * @param oldDimension The old dimension of the Compound
	 * @param newDimension The dimension that the Compound is to become
	 */
	private void adjustShape(Graphic staticShape, Graphic shapeToAdjust,
			java.awt.Dimension oldDimension, java.awt.Dimension newDimension) {
		// System.out.println("staticShape: " + staticShape.getLocation() + ", "
		// + staticShape.getDimension());
		// System.out.println("shapeToMove: " + shapeToMove.getLocation() + ", "
		// + shapeToMove.getDimension());
		// System.out.println("oldDimension: " + oldDimension);
		// System.out.println("newDimension: " + newDimension);

		// move the shape so that it's location stays with the same relative
		// location as before
		double ratioX = (shapeToAdjust.getLocation().x) / (double) oldDimension.width;
		double ratioY = shapeToAdjust.getLocation().y / (double) oldDimension.height;
		// System.out.println("ratioX: " + ratioX + ", ratioY: " + ratioY);

		java.awt.Point newPoint = new java.awt.Point((int) (newDimension.width * ratioX),
				(int) (newDimension.height * ratioY));
		// System.out.println("setting the location of " + shapeToMove + " to be
		// " + newPoint);
		shapeToAdjust.setLocation(newPoint);

		double xOffset = (double) shapeToAdjust.getDimension().width
				/ (double) staticShape.getDimension().width;
		double yOffset = (double) shapeToAdjust.getDimension().height
				/ (double) staticShape.getDimension().height;

		// System.out.println("xoffset: " + xOffset + ", yoffset: " + yOffset);
		shapeToAdjust.setDimension(new java.awt.Dimension(
				(int) (newDimension.width * xOffset),
				(int) (newDimension.height * yOffset)));

		// System.out.println();
	}

	/**
	 * Not implemented because there is no java.awt.Shape which represents a compound graphic
	 * @see cse115.graphics.Graphic#getShape()
	 * @return an empty java.awt.Rectangle
	 */
	@Override
	public Shape getShape() {
		return new java.awt.Rectangle();
	}

}
