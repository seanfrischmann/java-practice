package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class walkingTheWalk implements ActionListener {
	
	private FinchController _c;
	public walkingTheWalk(FinchController c){
		_c = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_c.walkingDead();

	}

}
