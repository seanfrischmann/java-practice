package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class seeingTheLights implements ActionListener {
	
			private FinchController _c;
			
			public seeingTheLights(FinchController c){
				_c=c;
			}

	@Override
	public void actionPerformed(ActionEvent e) {
		_c.whoTurnedOutTheLights();

	}

}
