package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class leftMinusListener implements ActionListener {
	
	private FinchController _c;
	public leftMinusListener(FinchController c){
		_c = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		_c.decrementLeft();
	}

}
