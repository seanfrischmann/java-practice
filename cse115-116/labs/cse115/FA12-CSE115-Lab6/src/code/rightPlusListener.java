package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rightPlusListener implements ActionListener {

	private FinchController _c;
	public rightPlusListener(FinchController c){
		_c = c;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		_c.incrementRight();

	}

}
