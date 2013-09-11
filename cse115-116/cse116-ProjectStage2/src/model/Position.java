package model;

import java.util.Stack;

public class Position {
	private int _offset;
	protected int _index;
	protected Stack<Piece> _stack;
	protected Board _board;
	private boolean _forwardPosition = true;
	
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
		if(_stack.isEmpty()){			
			return null;
			
		}
		return _stack.peek();
	}
	/**
	 * Method moves top piece off of position and moves it the distance based
	 * on height of stack on position.
	 */
	public void moveTop() {
		int distanceToMove = height();
		Piece p = _stack.pop();
		if((p.getTrack()[_index].getIndex() + distanceToMove) > 13){
			p.getPlayer().setScore(p.getPlayer().getScore()+1);
			System.out.println(p.getPlayer().getScore()+" "+p.getPlayer().getName());
		}
		else{
			p.getTrack()[_index + distanceToMove].putOn(p);
		}		
	}
	public int getIndex(){
		return _index;
	}
	public Stack<Piece> getStack(){
		return _stack;
	}
	
	@Override public String toString() {
		return _stack.toString();
	}
	
	public int getOffset(){
		return _offset;
	}
	
	public Board getBoard(){
		return _board;
	}

	public boolean isForwardPosition() {
		return _forwardPosition;
	}

	public void setForwardPosition(boolean forwardPosition) {
		_forwardPosition = forwardPosition;
	}
}
