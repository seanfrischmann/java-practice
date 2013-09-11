package model;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board {
	
	private ActionListener _listener;
	
	private Position[] _left;
	private Position[] _right;
	private StartPosition[] _redStart;
	private StartPosition[] _blueStart;
	
	public void setActionListener(ActionListener al) {
		_listener = al;
	}
	
	public void notifyOfChange() {
		if (_listener != null) {
			_listener.actionPerformed(null);
		}
	}
	
	public Board() {
		_left = new Position[13];
		_right = new Position[13];
		for (int i=0; i<3; i++) {
			_left[i] = (new Position(0,i,this));
			_right[i] = (new Position(0,i,this));
		}
		for (int i=3; i<13; i++) {
			_left[i] = (new Position(0,i,this));
			_right[i] = _left[i];
		}
		_redStart = new StartPosition[4];
		_blueStart = new StartPosition[4];
		for (int i=0; i<4; i++) {
			_redStart[i] = (new StartPosition(0,i,this));
			populate(_redStart[i], "R", i+1);
			_blueStart[i] = (new StartPosition(0,i,this));
			populate(_blueStart[i], "B", i+1);
		}
	}

	private void populate(Position pos, String s, int howMany) {
		for (int i=0; i<howMany; i++) {
			pos.putOn(new Piece(s));
		}
	}

	public ArrayList<String> getBoard() {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i=0; i<4; i++) {
			temp.add(_redStart[i].toString());
			temp.add(_blueStart[i].toString());
		}
		for (int i=0; i<3; i++) {
			temp.add(_left[i].toString());
			temp.add(_right[i].toString());
		}
		for (int i=3; i<13; i++) {
			temp.add(_right[i].toString());
		}
		return temp;
	}

	public StartPosition getRedStart(int i) { return _redStart[i]; }
	public StartPosition getBlueStart(int i) { return _blueStart[i]; }
	public Position getLeft(int i) { return _left[i]; }
	public Position getRight(int i) { return _right[i]; }
	public Position getCommon(int i) { return _right[i]; }

	public Position[] leftTrack() {
		return _left;
	}

	public Position[] rightTrack() {
		return _right;
	}
}
