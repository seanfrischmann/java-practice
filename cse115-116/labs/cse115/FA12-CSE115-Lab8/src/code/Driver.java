package code;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Driver implements Runnable {
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Driver());
	}
	@Override public void run() {
		/*
		 * Uncomment just one of these lines to run your program:
		 * 
		 *     Uncomment the MockFinch line if you do not have a
		 *     real Finch attached to your computer.
		 * 
		 *     Uncomment the Finch line only if you have a real 
		 *     Finch attached to your computer.
		 */
		new FinchController(new MockFinch());
		//new FinchController(new Finch());
	}
}
