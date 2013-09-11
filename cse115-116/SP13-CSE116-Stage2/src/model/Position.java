package model;

import java.util.Stack;

public class Position {
	private int _offset;
	private int _index;
	protected Stack<Piece> _stack;
	protected Board _board;
	
	public Position(int offset, int index, Board b) {
		_offset = offset;
		_stack = new Stack<Piece>();
		_index = index;
		_board = b;
	}
	
	public int height() {
		return _stack.size() + _offset;
	}
	
	public void putOn(Piece p) {
		_stack.push(p);
		_board.notifyOfChange();
	}
	
	public Piece peekTop() {
		return _stack.peek();
	}

	public void moveTop() {
		int distanceToMove = height();
		Piece p = _stack.pop();
		p.getTrack()[_index + distanceToMove].putOn(p);
	}
	
	@Override public String toString() {
		return _stack.toString();
	}
}
