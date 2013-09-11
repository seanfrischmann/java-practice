package ui;

import java.awt.AWTException;

import javax.swing.SwingUtilities;

public class Driver {
	private static String[] savedArgs;

	public static String[] getArgs() {
		return savedArgs;
	}
	
	public static void main(String[] args) throws AWTException {
		savedArgs = args;
		SwingUtilities.invokeLater(new Game());
	}
}
