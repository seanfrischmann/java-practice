package Gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import finch.FinchController;

/**
 * Class extends JFrame
 * This class serves as he main assembler of the GUI
 * Also as the class that instantiates the other components of the GUI
 * <p>
 * @author Matthew
 */
public class BasicBoard extends JFrame{
	/**
	 * The constructor for the Basic Board
	 * extends JFrame and sets the Opacity of the JFrame
	 * <p>
	 * @author Matthew
	 */
	public BasicBoard(){
		this.setOpacity(0);
	}
	
	//Main method used to create the JFrame and to test
	
		public static void main(String [] args){
			/*
			 * Remove comment below to try the BETA-finchController
			 */
			//new FinchController(new Finch());
			
			Dimension d;
			
			//JFrame creation and addition of elements to the frame
			JBackgroundPanel bgp = new JBackgroundPanel();
			Overlay o = new Overlay();
			JFrame frame = new JFrame("Lotus Board Game");
			/*Sets the JFrame to a specific dimension
			 * and does not allow the JFrame to be resized
			 */
			d = new Dimension(700,700);
			frame.setMaximumSize(d);
			frame.setMinimumSize(d);
			frame.setPreferredSize(d);
			frame.setSize(d);
			frame.setResizable(false);
			frame.add(o);
			frame.add(bgp);
			frame.setLocation(0,0);
			/*Layers the JPanels in the correct order
			  Smaller Numbers are painted last 	
			*/
			frame.setComponentZOrder(bgp, 1);
			frame.setComponentZOrder(o, 0);
			JOptionPane.showMessageDialog(frame, "Lotus Manual\n\nThe object of the game Lotus is to move one's pieces off the board before the other player.\n Player one is given ten red game pieces while the Player two gets ten blue game pieces.\n\n The pieces are stacked in the middle of the board as one stack of 4 pieces, one stack of 3 pieces, one stack of 2 pieces, and one stack of 1 piece.\n Each player takes turns moving their pieces in an attempt to get to the exit space on the game board.\n A player can only move a piece that is on top of a stack or that is the only piece left in a stack.\n The height of the stack determines how far you can move your piece.\n Therefore; a piece in a stack of 1 can only move 1 space forward.\n\n A player may decide which of the two starting positions to move their piece to, both positions lead to one exit position.\n After the game start there is no limit to how many pieces can be in a stack.\n\n The board consists of 14 regular squares, two special squares, and one backwards square. The regular squares have a starting height of 0.\n This meaning that the regular rules will be in affect when on those squares.\n\n One of the two special squares has a beginning height of 1, and the other has a beginning height of 2.\n These beginning heights are added to the stack size of the pieces on top of the square.\n\n The backwards square makes the player move his pieces backwards instead of forwards.\n Unless the piece came from a square directly next to the backwards square, in which case the backwards square acts as a regular square.");
			JOptionPane.showMessageDialog(frame, "Brief How-to-Play\n\n  1.) The box to the bottom left displays current players turn.\n\n  2.) When Moving from the starting area, select which stack you\n    want to move from.\n\n  3.) Next select your starting square, either to the left or right.\n\n  4.) After you select your starting square, select the square\n     you want to move to.\n\n  5.) If you are moving from a square, select the square you want to\n    move from followed by the square you want to move to.\n\nPlease see User.txt located in Gui package to see more details\n\nThanks for playing!");
			bgp.setAlignmentX(0);
			bgp.setAlignmentY(0);
			o.setAlignmentX(0);
			o.setAlignmentY(100);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}