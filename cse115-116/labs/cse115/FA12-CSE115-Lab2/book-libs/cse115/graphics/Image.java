package cse115.graphics;

import java.awt.Shape;

/**
 * 
 * TODO: Add comments to Image, file not found, types of pictures
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 29, 2006 Image.java
 */
public class Image extends AbstractGraphic {

	/** The underlying java.awt.Image which will be painted * */
	private java.awt.Image _image;

	/**
	 * Creates an Image graphic using the picture located at a given location
	 * 
	 * @param fileName
	 *            The absolute or relative path to the file containing the image
	 */
	public Image(String fileName) {
		_image = java.awt.Toolkit.getDefaultToolkit().createImage(fileName);
	}

	/**
	 * This method uses the Graphics2D object to paint an Image onto the
	 * container at a specified point with a specified dimension
	 * 
	 * @see cse115.graphics.Graphic#actualPaint(java.awt.Graphics2D,
	 *      java.awt.Point, java.awt.Dimension)
	 * @param gs
	 *            The Graphics2D object to do the painting
	 * @param location
	 *            The point at which to paint the Image
	 * @param dimension
	 *            The dimension of the Image to paint
	 */
	@Override
	public void actualPaint(java.awt.Graphics2D gs, java.awt.Point location,
			java.awt.Dimension dimension) {
		gs.drawImage(_image, location.x, location.y, dimension.width, dimension.height, this
				.getContainer());
	}

	/**
	 * @see cse115.graphics.Graphic#getShape()
	 * @return a java.awt.Rectangle
	 */
	@Override
	public Shape getShape() {
		return this.getBounds();
	}
}
