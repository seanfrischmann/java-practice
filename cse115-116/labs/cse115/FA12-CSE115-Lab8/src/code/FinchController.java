package code;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import edu.cmu.ri.createlab.terk.robot.finch.FinchInterface;

public class FinchController {
		
	private int _leftVelocity;
	private int _rightVelocity;
	private FinchInterface _finch;
	private JLabel _leftlabel;
	private JLabel _rightlabel;
	private int _maxVelocity;
	private int _minVelocity;
	private boolean _canMoveForward = true; // Disables Incremental button when there is an obstacle
	private boolean _isDisabled = false;	//Disables Buttons when walking,light, and heat are being tested
	private int _turn = 0;	//Counts the number of corners the Finch hits while walking
	
	
		
	public FinchController(FinchInterface finch){
		_finch = finch;
		
		_minVelocity = -255;
		_maxVelocity = 255;
		
		_leftVelocity = 0;
		_rightVelocity = 0;
		
		JFrame frame = new JFrame();
		
		Container pane = frame.getContentPane();
		
		BoxLayout box = new BoxLayout(pane, BoxLayout.X_AXIS);
		pane.setLayout(box);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		
		BoxLayout box2 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
		BoxLayout box3 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
		BoxLayout box4 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
		panel1.setLayout(box2);
		panel2.setLayout(box3);
		panel3.setLayout(box4);
		
		panel1.setMaximumSize(new Dimension(100,100));
		panel2.setMaximumSize(new Dimension(100,100));
		panel3.setMaximumSize(new Dimension(150,100));
		
		
		JButton button1 = new JButton("+");
		ActionListener b1 = new leftPlusListener(this);
		button1.addActionListener(b1);
		panel1.add(button1);

		
		_leftlabel = new JLabel("L:"+ _leftVelocity);
		panel1.add(_leftlabel);
				
		JButton button2 = new JButton("-");
		ActionListener b2 = new leftMinusListener(this);
		button2.addActionListener(b2);
		panel1.add(button2);		
			
		JButton button3 = new JButton("+");
		ActionListener b3 = new rightPlusListener(this);
		button3.addActionListener(b3);
		panel2.add(button3);
		
		_rightlabel = new JLabel("R:"+ _rightVelocity);
		panel2.add(_rightlabel);
		
		JButton button4 = new JButton("-");
		ActionListener b4 = new rightMinusListener(this);
		button4.addActionListener(b4);
		panel2.add(button4);
		
		JButton button5 = new JButton("Walking the walk");
		ActionListener b5 = new walkingTheWalk(this);
		button5.addActionListener(b5);
		panel3.add(button5);
		
		JButton button6 = new JButton("Seeing the lights");
		ActionListener b6 = new seeingTheLights(this);
		button6.addActionListener(b6);
		panel3.add(button6);
		
		JButton button7 = new JButton("Feeling the heat");
		ActionListener b7 = new feelingTheHeat(this);
		button7.addActionListener(b7);
		panel3.add(button7);
		
		
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		ActionListener check = new ObstacleCheck(this);
		Timer timer = new Timer(100, check);
		timer.start();
	}
	public void incrementLeft(){
		if(!_isDisabled){
			if (_canMoveForward &&_leftVelocity < _maxVelocity){
				_leftVelocity = _leftVelocity + 5;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
				_leftlabel.setText("L:"+ _leftVelocity);
			}	
		}
			
	}
	public void decrementLeft(){
		if(!_isDisabled){
			if (_leftVelocity > _minVelocity){
				_leftVelocity= _leftVelocity - 5;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
				_leftlabel.setText("L:"+ _leftVelocity);
			}	
		}
			
	}
	public void incrementRight(){
		if(!_isDisabled){
			if (_canMoveForward && _rightVelocity < _maxVelocity){
				_rightVelocity = _rightVelocity + 5;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);	
			}
		}
		
			
	}
	public void decrementRight(){
		if(!_isDisabled){
			if (_rightVelocity > _minVelocity){
				_rightVelocity = _rightVelocity -5;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
			}
		}
				
	}
	public void obstacle(){
			if(_finch.isObstacleLeftSide() || _finch.isObstacleRightSide()){
				if(!_isDisabled){
					_canMoveForward = false;
					if(_leftVelocity > 0 || _rightVelocity > 0){
						_leftVelocity=0;
						_rightVelocity=0;
						_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
						_leftlabel.setText("L:"+ _leftVelocity);
						_rightlabel.setText("R:"+ _rightVelocity);
					}
				}
				
				if(_finch.isObstacleLeftSide() && _finch.isObstacleRightSide()){
					_finch.setLED(Color.MAGENTA);
				}
				else if(_finch.isObstacleLeftSide()){
					_finch.setLED(Color.RED);
				}
				else if(_finch.isObstacleRightSide()){
					_finch.setLED(Color.BLUE);
				}
			}
			
			else{
				_canMoveForward = true;
				_finch.setLED(Color.GREEN);
			}
		
	}
	public void walkingDead(){
		_isDisabled = true;
		_turn = 0;
		int a = 0;
		int c = 0;
		while(_isDisabled){
			if(_turn==0){
				a++;
			}
			if(_turn==2){
				c++;
			}
			if(!_finch.isObstacleLeftSide() && !_finch.isObstacleRightSide()){
				_leftVelocity=100;
				_rightVelocity=100;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity, 100);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.GREEN);
			}
					
			else if(_finch.isObstacleLeftSide() && _finch.isObstacleRightSide()){
				_leftVelocity=-250;
				_rightVelocity=150;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity, 100);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.MAGENTA);
				_turn++;
			}
			else if(_finch.isObstacleRightSide()){		// Compensation for when Finch hits wall but not a corner
				_leftVelocity=-250;
				_rightVelocity=150;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity, 100);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.BLUE);
			}
			if(_turn == 4){
				_finch.setWheelVelocities(100, 100, (c-a)*100);
				_isDisabled = false;
			}
		}
	}
	public void whoTurnedOutTheLights(){
		_isDisabled = true;
		int lightLimit = 230;	//Light limit varies on Finch and environment, general range 225-235
		
		while(_isDisabled){
			if(_finch.isRightLightSensor(lightLimit) && _finch.isLeftLightSensor(lightLimit)){
				_leftVelocity=0;
				_rightVelocity=0;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.YELLOW);
				_isDisabled = false;
			}
			else if(_finch.isObstacleLeftSide() && _finch.isObstacleRightSide()){
				_leftVelocity=-250;
				_rightVelocity=150;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity, 300);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.MAGENTA);
			}
			else if(_finch.isObstacleLeftSide()){
				_leftVelocity=150;
				_rightVelocity=-250;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity, 300);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.RED);				
			}
			else if(_finch.isObstacleRightSide()){
				_leftVelocity=-250;
				_rightVelocity=150;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity, 300);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.BLUE);
			}
			else{
				_leftVelocity=100;
				_rightVelocity=110;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.GREEN);
			}
		}
		
	}
	public void whereIsTheSun(){
		_isDisabled = true;
		int heatLimit = 26;	// The heat limit varies depending on Finch and environment, general range 26-34
		int lightLimit = 190; //The light limit also varies base on Finch and environment, general range 170-200
		
		while(_isDisabled){
			if(_finch.isTemperature(heatLimit) && _finch.isRightLightSensor(lightLimit) && _finch.isLeftLightSensor(lightLimit)){
				_leftVelocity=0;
				_rightVelocity=0;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.ORANGE);
				_isDisabled = false;				
			}
			else if(_finch.isObstacleLeftSide() && _finch.isObstacleRightSide()){
				_leftVelocity=-250;
				_rightVelocity=150;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity, 300);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.MAGENTA);
			}
			else if(_finch.isObstacleLeftSide()){
				_leftVelocity=150;
				_rightVelocity=-250;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity, 300);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.RED);				
			}
			else if(_finch.isObstacleRightSide()){
				_leftVelocity=-250;
				_rightVelocity=150;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.BLUE);
			}
			else{
				_leftVelocity=70;
				_rightVelocity=65;
				_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
				_leftlabel.setText("L:"+ _leftVelocity);
				_rightlabel.setText("R:"+ _rightVelocity);
				_finch.setLED(Color.GREEN);
			}
		}
	}
	// light intensity 190 and 230
	// heat temp 26
}
