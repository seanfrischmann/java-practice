package cse115.containers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;
/**
 * Panel.java
 *
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 *
 * Created on: Jun 5, 2006
 *
 */

public class Panel extends JPanel {

	/**
	 * Creates a new instance of Panel
	 * @param arg0
	 * @param arg1
	 */
	public Panel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
	}

	/**
	 * Creates a new instance of Panel
	 * @param arg0
	 */
	public Panel(LayoutManager arg0) {
		super(arg0);
	}

	/**
	 * Creates a new instance of Panel
	 * @param arg0
	 */
	public Panel(boolean arg0) {
		super(arg0);
	}

	/**
	 * Creates a new instance of Panel
	 */
	public Panel() {
		super();
	}
	
	public void setColor(Color c){
		this.setBackground(c);
	}
	/**
	 * @return
	 */
	public Color getColor() {
		return this.getBackground();
	}
	
	public void setDimension(Dimension d){
		this.setPreferredSize(d);
		this.setSize(d);
		this.setMaximumSize(d);
		this.setMinimumSize(d);
	}

	public java.awt.Dimension getDimension() {
		return this.getSize();
	}
}
