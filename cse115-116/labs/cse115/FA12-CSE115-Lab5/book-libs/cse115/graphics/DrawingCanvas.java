package cse115.graphics;

/**
 * 
 * TODO: Fill in comments for DrawingCanvas
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Aug 1, 2006
 * 
 * 
 * DrawingCanvas.java
 */
public class DrawingCanvas extends javax.swing.JPanel implements
		java.awt.event.MouseListener, java.awt.event.MouseMotionListener,
		IContainer {

	/** The Collection that will hold all of the Graphics on this Container * */
	private java.util.ArrayList<Graphic> _graphicsList;

	/**
	 * The Point that the mouse was last at, used for events (to see if the
	 * mouse just entered the graphic or not, etc)
	 */
	private java.awt.Point _lastMousePoint;

	/** The Currently selected graphic, used for dragging * */
	private Graphic _current;

	/**
	 * Creates a new instance of DrawingCanvas with no Graphics on it. The
	 * default size is (100,100)
	 */
	public DrawingCanvas() {
		this.setLayout(null);
		_graphicsList = new java.util.ArrayList<Graphic>();
		this.setPreferredSize(new java.awt.Dimension(100, 100));

		super.addMouseListener(this);
		super.addMouseMotionListener(this);
	}

	/**
	 * Called when the mouse is clicked on the DrawingCanvas, delegates to the
	 * appropriate Graphic
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 * @param e
	 *            The MouseEvent that did the clicking
	 */
	public void mouseClicked(java.awt.event.MouseEvent e) {
		for (int i = _graphicsList.size()-1; i>=0; i--) {
			Graphic g = _graphicsList.get(i);
			if (g.contains(e.getPoint())) {
				for (java.awt.event.MouseListener ml : g.getMouseListeners()) {
					ml.mouseClicked(e);
				}
				break;
			}
		}
	}

	/**
	 * Called when the mouse is pressed on the DrawingCanvas, delegates to the
	 * appropriate Graphic
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 * @param e
	 *            The MouseEvent that did the pressing
	 */
	public void mousePressed(java.awt.event.MouseEvent e) {
		for (int i = _graphicsList.size()-1; i>=0; i--) {
			Graphic g = _graphicsList.get(i);
			if (g.contains(e.getPoint())) {
				for (java.awt.event.MouseListener ml : g.getMouseListeners()) {
					//redefine the mouse click position
					e = new java.awt.event.MouseEvent(this, e.getID(), e
							.getWhen(), e.getModifiers(), e.getX()
							- g.getLocation().x, e.getY() - g.getLocation().y,
							e.getClickCount(), e.isPopupTrigger());
					ml.mousePressed(e);
				}
				//System.out.println("setting current graphic to " + g);
				_current = g;
				break;
			}
		}
	}

	/**
	 * Called when the mouse is released on the DrawingCanvas, delegates to the
	 * appropriate Graphic
	 * 
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 * @param e
	 *            The MouseEvent that did the releasing
	 */
	public void mouseReleased(java.awt.event.MouseEvent e) {
		for (int i = _graphicsList.size()-1; i>=0; i--) {
			Graphic g = _graphicsList.get(i);
			if (g.contains(e.getPoint())) {
				for (java.awt.event.MouseListener ml : g.getMouseListeners()) {
					e = new java.awt.event.MouseEvent(this, e.getID(), e
							.getWhen(), e.getModifiers(), e.getX()
							- g.getLocation().x, e.getY() - g.getLocation().y,
							e.getClickCount(), e.isPopupTrigger());
					ml.mouseReleased(e);
				}
				_current = null;
				break;
			}
		}
	}

	/**
	 * Called when the mouse is entered onto the DrawingCanvas, does nothing
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 * @param e
	 *            The MouseEvent that did the entering
	 */
	public void mouseEntered(java.awt.event.MouseEvent e) {
	}

	/**
	 * Called when the mouse exits the DrawingCanvas, does nothing
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 * @param e
	 *            The MouseEvent that did the exiting
	 */
	public void mouseExited(java.awt.event.MouseEvent e) {
	}

	/**
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 * @param e
	 */
	public void mouseDragged(java.awt.event.MouseEvent e) {

		// as long as some graphic is the current one,
		if (_current != null) {

			// tell all the MouseMotionListeners of that graphic that it was
			// dragged
			for (java.awt.event.MouseMotionListener mml : _current
					.getMouseMotionListeners()) {
				mml.mouseDragged(e);
			}
		}

		_lastMousePoint = e.getPoint();
	}

	/**
	 * Called when the mouse was moved on the DrawingCanvas, calls entered,
	 * exited, moved on appropriate graphics
	 * 
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 * @param e
	 *            The MouseEvent that did the moving
	 */
	public void mouseMoved(java.awt.event.MouseEvent e) {
		if (_lastMousePoint == null) {
			_lastMousePoint = DrawingCanvas.this.getMousePosition();
		}
		for (int i = _graphicsList.size()-1; i>=0; i--) {
			Graphic g = _graphicsList.get(i);
			// if it contains this point but not the last one, then it just
			// entered the graphic
			if (g.contains(e.getPoint()) && !g.contains(_lastMousePoint)) {
				for (java.awt.event.MouseListener ml : g.getMouseListeners()) {
					ml.mouseEntered(e);
				}
			}
			// if it contains the last point but not this one, then it just left
			// the graphic
			else if (g.contains(_lastMousePoint) && !g.contains(e.getPoint())) {
				for (java.awt.event.MouseListener ml : g.getMouseListeners()) {
					ml.mouseExited(e);
				}
			}
			// if it contains the last point and this one, then it moved on the
			// graphic
			else if (g.contains(_lastMousePoint) && g.contains(e.getPoint())) {
				for (java.awt.event.MouseMotionListener mml : g
						.getMouseMotionListeners()) {
					mml.mouseMoved(e);
				}
			}
		}
		_lastMousePoint = e.getPoint();
	}

	/**
	 * Sets the Dimension of this DrawingCanvas
	 * 
	 * @param dimension
	 */
	public void setDimension(java.awt.Dimension dimension) {
		this.setPreferredSize(dimension);
		this.setMaximumSize(dimension);
		this.setMinimumSize(dimension);
		this.setSize(dimension);
	}

	/**
	 * Gets the Dimension of this DrawingCanvas
	 * 
	 * @return a java.awt.Dimension representing the current Dimension
	 */
	public java.awt.Dimension getDimension() {
		return this.getSize();
	}

	/**
	 * Sets the Location of this DrawingCanvas to a specified point. Probably
	 * won't work nicely with Layouts
	 * 
	 * @see java.awt.Component#setLocation(java.awt.Point)
	 * @param p
	 *            The Point at which to place this DrawingCanvas
	 */
	@Override
	public void setLocation(java.awt.Point p) {
		this.setBounds(p.x, p.y, this.getDimension().width,
				this.getDimension().height);
	}

	/**
	 * Sets the Color of this DrawingCanvas
	 * 
	 * @param color
	 */
	public void setColor(java.awt.Color color) {
		this.setBackground(color);
	}

	/**
	 * Gets the Color of this DrawingCanvas
	 * 
	 * @return A java.awt.Color representing the Color of this DrawingCanvas
	 */
	public java.awt.Color getColor() {
		return this.getBackground();
	}

	/**
	 * Adds a Graphic onto the DrawingCanvas. Graphics are added so that the
	 * most recently added one will be on top of any others
	 * 
	 * @see cse115.graphics.IContainer#add(cse115.graphics.Graphic)
	 * @param g
	 *            The Graphic to add to this DrawingCanvas
	 */
	public void add(Graphic g) {
		g.setContainer(this);
		_graphicsList.add(g);
	}

	/**
	 * Removes a Graphic from the DrawingCanvas.
	 * 
	 * @see cse115.graphics.IContainer#remove(cse115.graphics.Graphic)
	 * @param g
	 *            The Graphic to remove
	 */
	public void remove(Graphic g) {
		_graphicsList.remove(g);
		// TODO: repaint?
	}

	/**
	 * Gets a Collection of all the Graphics on this DrawingCanvas
	 * 
	 * @return a java.util.Collection of Graphics
	 */
	public java.util.Collection<Graphic> getAllGraphics() {
		return (java.util.Collection<Graphic>) _graphicsList.clone();
	}

	/**
	 * Partially overrides the paint method to paint all of it's graphics as
	 * well as itself
	 * 
	 * @see java.awt.Component#paint(java.awt.Graphics)
	 * @param gs
	 *            The java.awt.Graphics object that will paint the Graphics
	 */
	@Override
	public void paint(java.awt.Graphics gs) {
		// repaint the panel
		super.paint(gs);

		// paint all the graphics on the panel, casting the Graphics to a
		// Graphics2D
		// because that class has some functionality that we will need
		for (Graphic graphic : getAllGraphics()) {
			graphic.paint((java.awt.Graphics2D) gs);
		}
	}

	/**
	 * Find a random point on this DrawingCanvas
	 * 
	 * @return a java.awt.Point that represents a random location on this
	 *         DrawingCanvas
	 */
	public java.awt.Point randomPoint() {
		int x = cse115.utilities.Random.randomInteger(0,
				this.getDimension().width);
		int y = cse115.utilities.Random.randomInteger(0,
				this.getDimension().height);

		return new java.awt.Point(x, y);
	}
}
