package cse115.containers;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Row.java
 *
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 *
 * Created on: Jun 5, 2006
 *
 */

public class Row extends cse115.containers.Panel {

	/**
	 * Creates a new instance of Row
	 */
	public Row() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}

//	@Override
//	public Component add(Component c){
//		JPanel p = new JPanel();
//		p.setBackground(cse115.utilities.Random.randomColor());
//		p.add(c);
//		return super.add(p);
//	}
}
