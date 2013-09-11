package code;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.cmu.ri.createlab.terk.robot.finch.FinchInterface;

public class FinchController {
		
	private int _leftVelocity;
	private int _rightVelocity;
	private FinchInterface _finch;
	private JLabel _leftlabel;
	private JLabel _rightlabel;
	private int _maxVelocity;
	private int _minVelocity;
	
		
	public FinchController(FinchInterface finch){
		_finch = finch;
		
		_minVelocity = -255;
		_maxVelocity = 255;
		
		JFrame frame = new JFrame();
		
		Container pane = frame.getContentPane();
		
		BoxLayout box = new BoxLayout(pane, BoxLayout.X_AXIS);
		pane.setLayout(box);
		
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		pane.add(left);
		pane.add(right);
		
		BoxLayout box2 = new BoxLayout(left, BoxLayout.Y_AXIS);
		BoxLayout box3 = new BoxLayout(right, BoxLayout.Y_AXIS);
		left.setLayout(box2);
		right.setLayout(box3);
		
		JButton button1 = new JButton("+");
		ActionListener b1 = new leftPlusListener(this);
		button1.addActionListener(b1);
		left.add(button1);

		
		_leftlabel = new JLabel("L:"+ 0);
		left.add(_leftlabel);
				
		JButton button2 = new JButton("-");
		ActionListener b2 = new leftMinusListener(this);
		button2.addActionListener(b2);
		left.add(button2);		
			
		JButton button3 = new JButton("+");
		ActionListener b3 = new rightPlusListener(this);
		button3.addActionListener(b3);
		right.add(button3);
		
		_rightlabel = new JLabel("R:"+ 0);
		right.add(_rightlabel);
		
		JButton button4 = new JButton("-");
		ActionListener b4 = new rightMinusListener(this);
		button4.addActionListener(b4);
		right.add(button4);
		
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		
	}
	public void incrementLeft(){
		if (_leftVelocity < _maxVelocity){
			_leftVelocity++;
			_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
			_leftlabel.setText("L:"+ _leftVelocity);
		}		
	}
	public void decrementLeft(){
		if (_leftVelocity > _minVelocity){
			_leftVelocity--;
			_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
			_leftlabel.setText("L:"+ _leftVelocity);
		}		
	}
	public void incrementRight(){
		if (_rightVelocity < _maxVelocity){
			_rightVelocity++;
			_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
			_rightlabel.setText("R:"+ _rightVelocity);
		}		
	}
	public void decrementRight(){
		if (_rightVelocity > _minVelocity){
			_rightVelocity--;
			_finch.setWheelVelocities(_leftVelocity, _rightVelocity);
			_rightlabel.setText("R:"+ _rightVelocity);
		}		
	}
}
