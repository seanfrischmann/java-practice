package cse115.graphics;

import java.awt.geom.Ellipse2D;

/**
 * 
 * TODO: Fill in comments for AbstractGraphic
 *
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 *
 * Created on: Jul 28, 2006
 *
 *
 * AbstractGraphic.java
 */
public abstract class AbstractGraphic implements Graphic {

	/** The Dimension of this graphic * */
	private java.awt.Dimension _dimension;

	/** The location of this graphic * */
	private java.awt.Point _location;

	/**
	 * The container of this graphic, will be defined when it is added to a
	 * container *
	 */
	private IContainer _canvas;

	/** The degree of rotation of this graphic * */
	private Integer _rotation;

	/** The MouseListeners that this graphic has * */
	private java.util.ArrayList<java.awt.event.MouseListener> _mouseListeners;

	/** The MouseMotionListeners that this graphic has * */
	private java.util.ArrayList<java.awt.event.MouseMotionListener> _mouseMotionListeners;

	/**
	 * Creates a new instance of AbstractGraphic with a default size (0,0);
	 * location (0,0); and rotation (0)
	 */
	public AbstractGraphic() {
		_dimension = new java.awt.Dimension();
		_location = new java.awt.Point();
		_rotation = 0;
		_mouseListeners = new java.util.ArrayList<java.awt.event.MouseListener>();
		_mouseMotionListeners = new java.util.ArrayList<java.awt.event.MouseMotionListener>();
	}

	/**
	 * Gets the Container of this graphic
	 * 
	 * @return the IContainer that this graphic is contained in. Returns null if
	 *         this does not have an IContainer
	 * @see #setContainer(IContainer container)
	 */
	public IContainer getContainer() {
		return _canvas;
	}

	/**
	 * Sets the Container of this Graphic. Should be automatically called inside
	 * the addGraphic method of the IContainer that contains this graphic
	 * 
	 * @param container
	 */
	public void setContainer(IContainer container) {
		// System.out.println("setting the container of "+this);
		// if we already have a container, remove this from the container
		if (_canvas != null) {
			_canvas.remove(this);
			_canvas.repaint();
		}

		// set _canvas to be what was passed in
		_canvas = container;
		_canvas.repaint();
	}

	/**
	 * This gets the concrete subclasses ready to do the actual painting - it
	 * figures out an offset, and a rotation, then delegates the drawing to the
	 * specific subclass
	 * 
	 * @see cse115.graphics.Graphic#paint(java.awt.Graphics2D, java.awt.Point)
	 * @param gs
	 *            The Graphics2D object that draws the shapes on the IContainer
	 * @param offset
	 *            Can be used to paint the graphic relative to a certain
	 *            location in the IContainer without redefining it's internal
	 *            representation of the location
	 */
	public void paint(java.awt.Graphics2D gs, java.awt.Point offset) {
		java.awt.Point newLocation = new java.awt.Point(this.getLocation().x + offset.x, this
				.getLocation().y
				+ offset.y);

		this.rotateForward(gs, offset);

		// actualPaint should be defined in the subclasses, it will paint the
		// appropriate shape
		this.actualPaint(gs, newLocation, this.getDimension());

		this.rotateBackward(gs, offset);
	}

	/**
	 * This gets the concrete subclasses ready to do the actual painting - it
	 * figures out a rotation, then delegates the drawing to the specific
	 * subclass
	 * 
	 * @see cse115.graphics.Graphic#paint(java.awt.Graphics2D)
	 * @param gs
	 *            The Graphics2D object that draws the shapes on the IContainer
	 */
	public void paint(java.awt.Graphics2D gs) {
		// paint with an offset of 0
		this.paint(gs, new java.awt.Point());
	}

	/**
	 * Changes the Dimension of this Graphic
	 * 
	 * @see cse115.graphics.Sizeable#setDimension(java.awt.Dimension)
	 * @see #getDimension
	 * @param d
	 *            the new Dimension
	 */
	public void setDimension(java.awt.Dimension d) {
		_dimension = d;
		if (_canvas != null)
			_canvas.repaint();
		// TODO: repaint with bounds
	}

	/**
	 * Gets the dimension of this graphic
	 * 
	 * @see cse115.graphics.Sizeable#getDimension()
	 * @see #setDimension
	 * @return the Dimension of this graphic
	 */
	public java.awt.Dimension getDimension() {
		return _dimension;
	}

	/**
	 * Changes the location of this graphic
	 * 
	 * @see cse115.graphics.Locatable#setLocation(java.awt.Point)
	 * @param point
	 *            The new location to put the graphic
	 */
	public void setLocation(java.awt.Point point) {
		_location = point;
		if (_canvas != null)
			_canvas.repaint();
		else {
			// System.out.println("can't set location of "+this);
		}
		// TODO: repaint with bounds
	}

	/**
	 * Gets the location of this graphic
	 * 
	 * @see cse115.graphics.Locatable#getLocation()
	 * @return The current location
	 */
	public java.awt.Point getLocation() {
		return _location;
	}

	/**
	 * Changes the center location of this graphic
	 * 
	 * @see cse115.graphics.CenterLocatable#setCenterLocation(java.awt.Point)
	 * @param point
	 *            the location to place the center of this graphic at
	 */
	public void setCenterLocation(java.awt.Point point) {
		this.setLocation(new java.awt.Point(point.x - this.getDimension().width / 2,
				point.y - this.getDimension().height / 2));
	}

	/**
	 * Gets the Center location of this graphic
	 * 
	 * @see cse115.graphics.CenterLocatable#getCenterLocation()
	 * @return a Point representing the location at the center of this graphic
	 */
	public java.awt.Point getCenterLocation() {
		return new java.awt.Point(
				this.getLocation().x + (this.getDimension().width / 2), this
						.getLocation().y
						+ (this.getDimension().height / 2));
	}

	/**
	 * Moves the Graphic by a certain vector
	 * 
	 * @see cse115.graphics.Graphic#move(cse115.utilities.Vector)
	 * @param v
	 *            The vector containing the amount to move
	 */
	public void move(cse115.utilities.Vector v) {
		this.setLocation(new java.awt.Point(this.getLocation().x + v.getDx(), this
				.getLocation().y
				+ v.getDy()));
	}

	/**
	 * Changes the rotation of this graphic. Should rotate about its center
	 * 
	 * @see cse115.graphics.Rotatable#setRotation(java.lang.Integer)
	 * @param degree
	 *            The number of degrees to set the rotation at
	 */
	public void setRotation(Integer degree) {
		degree %= 360;
		_rotation = degree;
		if (_canvas != null) {
			_canvas.repaint();
		} else {
			// System.out.println("setting rotation, not repainting "+this);
		}
		// TODO: repaint with bounds
	}

	/**
	 * Gets the current rotation of this graphic
	 * 
	 * @see cse115.graphics.Rotatable#getRotation()
	 * @return an Integer (0 through 359) representing the rotation of this
	 *         graphic
	 */
	public Integer getRotation() {
		return _rotation;
	}

	/**
	 * Rotates the graphic by a specific number of degrees
	 * 
	 * @see cse115.graphics.Rotatable#rotate(java.lang.Integer)
	 * @param degreesToRotate
	 *            The number of degrees to rotate this graphic
	 */
	public void rotate(Integer degreesToRotate) {
		this.setRotation(this.getRotation() + degreesToRotate);
	}

	/**
	 * This method is used to rotate the Graphics2D back to the start angle of
	 * rotation after drawing the shape (The drawing of the shape is done by
	 * calling actualPaint).
	 * 
	 * @param gs
	 *            The Graphics2D object to rotate
	 * @param offset
	 *            The point about which to rotate
	 */
	private void rotateBackward(java.awt.Graphics2D gs, java.awt.Point offset) {
		gs.rotate((this.getRotation() * (Math.PI / 180)) * -1, this
				.getCenterLocation().x
				+ offset.x, this.getCenterLocation().y + offset.y);
	}

	/**
	 * This method is used to rotate the Graphics2D around to the appropriate
	 * angle of rotation before drawing the shape (The drawing of the shape is
	 * done by calling actualPaint).
	 * 
	 * @param gs
	 *            The Graphics2D object to rotate
	 * @param offset
	 *            The point about which to rotate
	 */
	private void rotateForward(java.awt.Graphics2D gs, java.awt.Point offset) {
		gs.rotate((this.getRotation() * (Math.PI / 180)), this
				.getCenterLocation().x
				+ offset.x, this.getCenterLocation().y + offset.y);
	}

	/**
	 * Adds a <code>java.awt.event.MouseListener</code> to this graphic
	 * 
	 * @see cse115.graphics.Graphic#addMouseListener(java.awt.event.MouseListener)
	 * @param ml
	 */
	public void addMouseListener(java.awt.event.MouseListener ml) {
		_mouseListeners.add(ml);
	}

	/**
	 * Gets all the <code>java.awt.event.MouseListeners</code> of this graphic
	 * 
	 * @see cse115.graphics.Graphic#getMouseListeners()
	 * @return a Collection of MouseListeners
	 */
	public java.util.Collection<java.awt.event.MouseListener> getMouseListeners() {
		return _mouseListeners;
	}

	/**
	 * Adds a <code>java.awt.event.MouseMotionListener</code> to this graphic
	 * 
	 * @see cse115.graphics.Graphic#addMouseMotionListener(java.awt.event.MouseMotionListener)
	 * @param mml The <code>java.awt.event.MouseMotionListener</code> to add to the 
	 */
	public void addMouseMotionListener(java.awt.event.MouseMotionListener mml) {
		_mouseMotionListeners.add(mml);
	}

	/**
	 * Gets all the <code>java.awt.event.MouseMotionListeners</code> of this graphic
	 * @see cse115.graphics.Graphic#getMouseMotionListeners()
	 * @return A collection of all the MouseMotionListeners of this graphic
	 */
	public java.util.Collection<java.awt.event.MouseMotionListener> getMouseMotionListeners() {
		return _mouseMotionListeners;
	}

	/**
	 * TODO: union rotation bounds, call "get paintable area"?
	 * 
	 * Returns the BoundingBox of this graphic?
	 * @see cse115.graphics.Graphic#getBounds()
	 * @return A java.awt.Rectangle representing the bounding box of this graphic
	 */
	public java.awt.Rectangle getBounds() {
		return new java.awt.Rectangle(this.getLocation().x,
				this.getLocation().y, this.getDimension().width, this
						.getDimension().height);
	}
	
	/**
	 * Tests to see if the given point is contained within this shape
	 * 
	 * @see cse115.graphics.Graphic#contains(java.awt.Point)
	 * @param p
	 *            The point to test for containment
	 * @return true if the point is contained in the ellipse, false otherwise
	 */
	public boolean contains(java.awt.Point p) {
		// create an ellipse of the same bounds and ask that if it contains p
		java.awt.Shape shape = this.getShape();
				
		if (this.getRotation()!=0) {
			java.awt.Rectangle r = this.getBounds();
			double x = r.getCenterX();
			double y = r.getCenterY();
			java.awt.geom.AffineTransform trans = 
				java.awt.geom.AffineTransform.getRotateInstance(Math.toRadians(this.getRotation()), x, y);
			java.awt.Shape newShape = trans.createTransformedShape(shape);
			return newShape.contains(p);
		}
		
		return shape.contains(p);
	}
}
