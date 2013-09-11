package finch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import finch.FinchController;

/**
 * Class is the ActionListener that listens for changes in the orientation of the Finch
 * If an action is heard the mouse will either move or click on-screen
 * <p>
 * @author Sean
 */
public class PositionCheck implements ActionListener {
	
	
	private FinchController _c;
	public PositionCheck(FinchController c){
		_c = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_c.positionOfFinch();

	}

}
