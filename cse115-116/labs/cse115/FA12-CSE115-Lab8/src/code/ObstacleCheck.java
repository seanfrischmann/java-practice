package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.cmu.ri.createlab.terk.robot.finch.FinchInterface;

public class ObstacleCheck implements ActionListener {

	private FinchController _c;
	public ObstacleCheck(FinchController c){
		_c = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		_c.obstacle();
			
		// TODO Auto-generated method stub

	}

}
