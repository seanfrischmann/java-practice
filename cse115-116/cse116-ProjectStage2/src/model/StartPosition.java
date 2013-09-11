package model;


public class StartPosition extends Position {
	
	public StartPosition(int offset, int index, Board b) {
		super(offset, index, b);
	}
	
	@Override public void moveTop() {
		throw new UnsupportedOperationException();
	}

	public void moveTopTrack() {
		int distanceToMove = height();
		Piece p = _stack.pop();
		p.setTrack(_board.leftTrack());
		p.getTrack()[distanceToMove-1].putOn(p);
	}
	
	public void moveCenterTrack(){
		int distanceToMove = height();
		Piece p = _stack.pop();
		p.setTrack(_board.centerTrack());
		p.getTrack()[distanceToMove-1].putOn(p);
	}

	public void moveBottomTrack() {
		int distanceToMove = height();
		Piece p = _stack.pop();
		p.setTrack(_board.rightTrack());
		p.getTrack()[distanceToMove-1].putOn(p);
	}
	

	@Override public String toString() {
		return _stack.toString();
	}
}
