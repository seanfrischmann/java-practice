package finch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import edu.cmu.ri.createlab.terk.robot.finch.FinchInterface;

import java.awt.Robot;
import javax.swing.Timer;

import game.Lotus;
import game.Square;

/**
 * The FinchController Class acts as the Main Class
 * It begins the chain of instantiation of the multiple components of the Lotus Game as whole
 * The class also acts as the basis for the Finch's controls
 * <p>  
 * @author Matthew & Sean
 */
public class FinchController{
	
	private Robot _robot;
	private Lotus _lotus = new Lotus();
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
	 */
	public FinchController(FinchInterface finch){
		_finch = finch;		
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
			_x = _x-1;
			_robot.mouseMove(_x, _y);
		}
		else if (_finch.isRightWingDown()){
			_x = _x+1;
			_robot.mouseMove(_x+1, _y);
		}
		else if (_finch.isBeakDown()){
			_y = _y-1;
			_robot.mouseMove(_x, _y-1);
		}
		else if (_finch.isBeakUp()){
			_y = _y+1;
			_robot.mouseMove(_x, _y+1); 
		}
		else if (_finch.isShaken()){
			_robot.mousePress(InputEvent.BUTTON1_MASK);
		}
		_finch.setLED(_lotus.getCurrentPlayersTurn().getColor());
	}
	
}
