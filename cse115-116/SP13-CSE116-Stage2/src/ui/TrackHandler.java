package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Position;

public class TrackHandler implements ActionListener {

	private Position _pos;

	public TrackHandler(Position pos) {
		_pos = pos;
	}

	@Override public void actionPerformed(ActionEvent e) {
		_pos.moveTop();
	}

}
