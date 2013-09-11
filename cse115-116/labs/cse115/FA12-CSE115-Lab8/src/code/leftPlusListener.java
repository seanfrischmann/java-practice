package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class leftPlusListener implements ActionListener {
	private FinchController _c;
	public leftPlusListener(FinchController c){
		_c = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_c.incrementLeft();

	}

}
