package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class feelingTheHeat implements ActionListener {
	
	private FinchController _c;
	
	public feelingTheHeat(FinchController c){
		_c=c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_c.whereIsTheSun();

	}

}
