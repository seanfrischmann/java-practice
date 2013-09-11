package model;

import java.util.Stack;

public class StartPosition extends Position {
	
	public StartPosition(int offset, int index, Board b) {
		super(offset, index, b);
	}
	
	@Override public void moveTop() {
		throw new UnsupportedOperationException();
	}

	public void moveTopLeft() {
		int distanceToMove = height();
		Piece p = _stack.pop();
		p.setTrack(_board.leftTrack());
		p.getTrack()[distanceToMove].putOn(p);
	}

	public void moveTopRight() {
		int distanceToMove = height();
		Piece p = _stack.pop();
		p.setTrack(_board.rightTrack());
		p.getTrack()[distanceToMove].putOn(p);
	}
	

	@Override public String toString() {
		return _stack.toString();
	}
}
