package cse115.utilities;

/**
 * 
 * TODO: Fill in comments for Timer Should this be abstract?
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 28, 2006
 * 
 * 
 * Timer.java
 */
public class Timer extends javax.swing.Timer {

	/**
	 * Creates a new instance of Timer with the given delay (in milliseconds)
	 * 
	 * @param delay
	 *            the time to elapse in between activations of the timer. Timer
	 *            is initialized in the stopped position (must be started).
	 */
	public Timer(Integer delay) {
		super(delay, null);
		this.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				Timer.this.activate();
			}

		});
	}

	/**
	 * When the timer is started, this method gets called repeatedly with the
	 * delay specified in the constructor.  Must be overriden to do something useful.
	 */
	public void activate() {
	}

}
