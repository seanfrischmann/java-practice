package cse115.graphics;

/**
 * 
 * TODO: Fill in comments for AbstractColorableGraphic
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 28, 2006
 * 
 * 
 * AbstractColorableGraphic.java
 */
public abstract class AbstractColorableGraphic extends AbstractGraphic
		implements ColorableGraphic {

	/** The Color of this * */
	private java.awt.Color _color;

	/**
	 * Creates a new instance of AbstractColorableGraphic
	 */
	public AbstractColorableGraphic() {
		_color = java.awt.Color.GRAY;
	}

	/**
	 * Gets the Color of this Graphic
	 * 
	 * @see cse115.graphics.Colorable#getColor()
	 * @return a java.awt.Color representing the color of this graphic
	 */
	public java.awt.Color getColor() {
		return _color;
	}

	/**
	 * Sets the Color of this Graphic
	 * 
	 * @see cse115.graphics.Colorable#setColor(java.awt.Color)
	 * @param c
	 *            The Color to set the graphic to be
	 */
	public void setColor(java.awt.Color c) {
		_color = c;
		if(this.getContainer()!=null)
			this.getContainer().repaint();
	}

	/**
	 * The Paint method partially overrides the superclass method to set the
	 * color of the Graphics2D object
	 * 
	 * @see cse115.graphics.Graphic#paint(java.awt.Graphics2D)
	 * @param gs
	 *            The Graphics2D object which will paint this graphic
	 */
	@Override
	public void paint(java.awt.Graphics2D gs) {
		this.paint(gs, new java.awt.Point());
	}

	/**
	 * The Paint method partially overrides the superclass method to set the
	 * color of the Graphics2D object at the specified offset
	 * 
	 * @see cse115.graphics.Graphic#paint(java.awt.Graphics2D, java.awt.Point)
	 * @param gs
	 *            The Graphics2D object which will paint this graphic
	 * @param offset
	 *            The offset at which to paint this object
	 */
	@Override
	public void paint(java.awt.Graphics2D gs, java.awt.Point offset) {
		gs.setColor(this.getColor());
		super.paint(gs, offset);
	}

}
