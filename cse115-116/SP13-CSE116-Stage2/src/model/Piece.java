package model;

import java.awt.Color;

public class Piece {
	
	private String _string;
	private Position[] _track;

	public Piece(String s) {
		_string = s;
	}
	
	public void setTrack(Position[] track) {
		_track = track;
	}
	
	@Override public String toString() {
		return _string;
	}

	public Position[] getTrack() {
		return _track;
	}

}
