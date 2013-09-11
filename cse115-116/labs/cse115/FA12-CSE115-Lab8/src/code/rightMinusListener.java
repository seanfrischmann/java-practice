package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rightMinusListener implements ActionListener {

	private FinchController _c;
	public rightMinusListener(FinchController c){
		_c = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		_c.decrementRight();

	}

}
