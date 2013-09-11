package cse115.graphics;

import java.awt.Shape;

/**
 * 
 * TODO: Add comments to Polygon, should need to add at least three points in
 * order to correctly make a polygon. Draws connecting points in the order that
 * they are added. Then connects the last point back to the first.
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 29, 2006 Polygon.java
 */
public class Polygon extends AbstractColorableGraphic {

	/** The underlying java.awt.Polygon * */
	private java.awt.Polygon _poly;

	/**
	 * Creates a new instance of Polygon with no vertices
	 */
	public Polygon() {
		_poly = new java.awt.Polygon();
	}

	/**
	 * Add a point to the polygon
	 * 
	 * @param p
	 *            the point to add
	 */
	public void addPoint(java.awt.Point p) {
		_poly.addPoint(p.x, p.y);
		if (this.getContainer() != null)
			this.getContainer().repaint();
	}

	/**
	 * removes the first occurrence of point p from the polygon
	 * 
	 * @param p
	 *            The Point to remove
	 */
	public void removePoint(java.awt.Point p) {
		// build arraylist
		java.util.ArrayList<java.awt.Point> vertices = new java.util.ArrayList<java.awt.Point>();
		for (int i = 0; i < _poly.npoints; i++) {
			vertices
					.add(new java.awt.Point(_poly.xpoints[i], _poly.ypoints[i]));
		}

		// remove p from arraylist
		vertices.remove(p);

		// build polygon from updated arraylist
		_poly.reset();
		for (java.awt.Point point : vertices) {
			_poly.addPoint(point.x, point.y);
		}

		this.getContainer().repaint();
	}

	/**
	 * This method uses the Graphics2D object to paint the Polygon onto the
	 * container at a specified point with a specified dimension
	 * 
	 * @see cse115.graphics.Graphic#actualPaint(java.awt.Graphics2D,
	 *      java.awt.Point, java.awt.Dimension)
	 * @param gs
	 *            The Graphics2D object to do the painting
	 * @param location
	 *            The point at which to paint the Polygon
	 * @param dimension
	 *            The dimension of the Polygon to paint
	 */
	@Override
	public void actualPaint(java.awt.Graphics2D gs, java.awt.Point location,
			java.awt.Dimension dimension) {
		// move the polygon to location, except it already is positioned
		// somewhere, so remove that amount from location
		_poly.translate(location.x - this.getLocation().x, location.y
				- this.getLocation().y);
		gs.fillPolygon(_poly);
		_poly.translate(-(location.x - this.getLocation().x),
				-(location.y - this.getLocation().y));
	}

	/**
	 * Sets the location of the polygon. TODO: does this do the upper left hand
	 * corner of the bounding box?
	 * 
	 * @see cse115.graphics.Locatable#setLocation(java.awt.Point)
	 * @param point
	 *            A java.awt.Point representing the new location of the Polygon
	 */
	@Override
	public void setLocation(java.awt.Point point) {
		// find the offset of how much we need to move this
		int xOffset = point.x - this.getLocation().x;
		int yOffset = point.y - this.getLocation().y;

		// update the internal refrence of the location
		super.setLocation(point);
		_poly.translate(xOffset, yOffset);

		if (this.getContainer() != null)
			this.getContainer().repaint();
	}

	/**
	 * Moves the Polygon by some amount, specified by a vector
	 * 
	 * @see cse115.graphics.Graphic#move(cse115.utilities.Vector)
	 * @param v
	 *            The vector representing the amount to move the Polygon
	 */
	@Override
	public void move(cse115.utilities.Vector v) {
		// for each point, move it by the offsets
		_poly.translate(v.getDx(), v.getDy());

		if (this.getContainer() != null)
			this.getContainer().repaint();
	}

	/**
	 * Resizes the Polygon to a specific dimension. Warning: still in beta
	 * testing and will probably not function as expected. 
	 * 
	 * @see cse115.graphics.Sizeable#setDimension(java.awt.Dimension)
	 * @param d
	 *            The dimension which the polygon should have
	 */
	//TODO: does this lose precision?
	@Override
	public void setDimension(java.awt.Dimension d) {
		super.setDimension(d);
		// when resizing the dimension, we assume at origin, so save the current
		// location to reset it later
		java.awt.Point location = this.getLocation();

		// set it to be at the origin
		this.setLocation(new java.awt.Point());

		// the arraylist that will hold the new, update points of the polygon
		java.util.ArrayList<java.awt.Point> vertices = new java.util.ArrayList<java.awt.Point>();

		// the width of the new Dimension/current width = ratioX. Every x
		// location is multiplied by ratio
		double ratioX = (double) d.width / (double) _poly.getBounds().width;

		// the height of the new Dimension/current length = ratioY. Every y
		// location is multiplied by ratio
		double ratioY = (double) d.height / (double) _poly.getBounds().height;

		// resize the polygon, assuming it is at the origin, will move back
		// later
		for (int i = 0; i < _poly.npoints; i++) {

			// the new point is the x-coordinate * ratioX and y-coordinate *
			// ratioY
			java.awt.Point newPoint = new java.awt.Point(
					(int) (_poly.xpoints[i] * ratioX),
					(int) (_poly.ypoints[i] * ratioY));

			vertices.add(newPoint);
		}

		// rebuild the polygon from our updated vertices list
		_poly.reset();
		for (java.awt.Point p : vertices) {
			_poly.addPoint(p.x, p.y);
		}

		// reset the location
		this.setLocation(location);

		if (this.getContainer() != null)
			this.getContainer().repaint();
	}

	/**
	 * @see cse115.graphics.Graphic#getShape()
	 * @return
	 */
	@Override
	public Shape getShape() {
		return _poly;
	}

}