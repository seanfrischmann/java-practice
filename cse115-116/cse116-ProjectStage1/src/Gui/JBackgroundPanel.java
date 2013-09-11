package Gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * This class take in an image, 5x5Grid.gif, and paints it to a JPanel
 * <p>
 * @author Matthew
 *
 */

public class JBackgroundPanel extends JPanel {
	
	/**
	 * The constructor of this class extend JPanel
	 * The dimensions of the class are set and the image is take from its location 
	 * The image is then stored as a variable
	 * <p>
	 * @author Matthew
	 */
	private Image image;
	private Dimension d;
 
  public JBackgroundPanel() {
	d = new Dimension(700,700);
	this.setMaximumSize(d);
	this.setMinimumSize(d);
	this.setPreferredSize(d);
	this.setSize(d);
    // loads the background image
	  try
	    {
	      image = ImageIO.read(new URL(getClass().getResource("5x5Grid.gif"), "5x5Grid.gif"));
	    }
	    catch (Exception e) { /*handled in paintComponent()*/ }
	  }
 
  /**
   * Method overrides the standard paintComponent method of a JPanel
   * This method does the virtual painting of the image onto the JBackgroundPanel
   * <p>
   * @param Graphics g
   * <p>
   * @author Matthew
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // paint the background image and scale it to fill the entire space
    if (image != null)
    g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
  }
}