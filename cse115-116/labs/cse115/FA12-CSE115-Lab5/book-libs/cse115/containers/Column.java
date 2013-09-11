package cse115.containers;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
/**
 * Column.java
 *
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 *
 * Created on: Jun 5, 2006
 *
 */

public class Column extends cse115.containers.Panel {

	/**
	 * Creates a new instance of Column
	 */
	public Column() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
//	@Override
//	public Component add(Component c){
//		JPanel p = new JPanel();
//		p.setBackground(this.getColor());
//		p.add(c);
//		return super.add(p);
//	}

}
