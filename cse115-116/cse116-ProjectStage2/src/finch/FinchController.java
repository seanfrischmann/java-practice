package finch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.Timer;

import edu.cmu.ri.createlab.terk.robot.finch.FinchInterface;

/**
 * The FinchController Class acts as the Main Class
 * It begins the chain of instantiation of the multiple components of the Lotus Game as whole
 * The class also acts as the basis for the Finch's controls
 * <p>  
 * @author Matthew & Sean
 */
public class FinchController{
	
	 
	private Robot _robot;
	private FinchInterface _finch;
	private int _x;
	private int _y;
	
	/**
	 * The Constructor Method for the FinchController
	 * Using the java.awt.Robot class we have used the Finch to simulate a mouse
	 * Shaking the Finch will act as a mouse click
	 * Pivoting the Finch about the x or y axis will move the mouse
	 * <p>
	 * @param Finch
	 * <p>
	 * @author Matthew & Sean  
	 * @throws AWTException 
	 */
	public FinchController(FinchInterface finch) throws AWTException{
		_finch = finch;		
		_robot = new Robot();
		_robot.mouseMove(_x, _y);		
		ActionListener check = new PositionCheck(this);
		Timer timer = new Timer(100, check);
		timer.start();
	}
	/**
	 * Method accounts for all different actions of the Finch
	 * Rotation along x and y axis and shaken
	 * These methods change the value of the x and y coordinate of the mouse
	 * <p>
	 * @author Matthew & Sean
	 */
	public void positionOfFinch(){
		if (_finch.isLeftWingDown()){
			_x = _x-15;
			_robot.mouseMove(_x, _y);
		}
		else if (_finch.isRightWingDown()){
			_x = _x+15;
			_robot.mouseMove(_x, _y);
		}
		else if (_finch.isBeakDown()){
			_y = _y+15;
			_robot.mouseMove(_x, _y);
		}
		else if (_finch.isBeakUp()){
			_y = _y-15;
			_robot.mouseMove(_x, _y); 
		}
		else if (_finch.isTapped()){
			_robot.mousePress(InputEvent.BUTTON1_MASK);
			_robot.mouseRelease(InputEvent.BUTTON1_MASK);
		}
		
	}
	
}
