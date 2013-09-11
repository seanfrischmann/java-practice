package code;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Driver implements Runnable {
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Driver());
	}
	@Override public void run() {
		new FinchController(new MockFinch());
//		new FinchController(new Finch());
//		new Finch();
	}
}
