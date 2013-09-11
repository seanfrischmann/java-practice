package game;

import java.util.ArrayList;
import java.util.Stack;

/** 
 * The purpose of the Square class is to simulate the squares on a game board
 * Each square represents a location on the game board
 * <p>
 * @author Sean
 */
public class Square{
	
	
	private Stack<Piece> _square;
	private Square _nextSquare;
	private ArrayList<Square> _previousSquares = new ArrayList<Square>();
	protected boolean _forwardSquare = true;
	
	/**
	 * Create a new stack of type Piece which is the representation
	 * of a square on the board.
	 * <p>
	 * @author Sean
	 */
	public Square(){
		_square = new Stack<Piece>();
	}
	/**
	 * Method adds a Player's Piece, passed in, to the top of
	 * the square's stack
	 * <p>
	 * @param piece
	 * <p>
	 * @author Sean
	 */
	public void addPiece(Piece piece){
		_square.push(piece);
	}
	/**
	 * Method removes the top Piece of the squares stack
	 * <p>
	 * @return Piece
	 * <p>
	 * @author Sean
	 */
	public Piece removePiece(){
		return _square.pop();
	}
	/**
	 * Method returns the piece on top of the squares stack
	 * <p>
	 * @return the Piece on top of the current stack if stack is nonempty
	 * @return null if Square is empty
	 * <p>
	 * @author Sean
	 */
	public Piece getPiece(){
		if(_square.isEmpty()){
			return null;
		}
		return _square.peek();	
	}
	/**
	 * Method returns, as an integer, the size of the square's stack
	 * <p>
	 * @return height of the Square as an Int
	 * <p>
	 * @author Sean
	 */
	public int getHeight(){
		return _square.size();
	}
	/**
	 * Method is used to set what the next square on the board is.
	 * <p>
	 * @return sets the next Square on the Board to be the current Square
	 * <p>
	 * @author Sean
	 */
	public void setNextSquare(Square square){
		_nextSquare = square;
	}
	/**
	 * Method returns what the next square on the board is.
	 * <p>
	 * @return the next Square on the Board
	 * <p>
	 * @author Sean
	 */
	public Square getNextSquare(){
		return _nextSquare;
	}
	/**
	 * Method is used to set what the previous square was.
	 * <p>
	 * @author Sean
	 */
	public void addPreviousSquare(Square square){
		_previousSquares.add(square);
	}	
	/**
	 * Method returns what the previous Square on the board is
	 * <p>
	 * @return gets the Array of the PreviousSquare on the Board
	 * <p>
	 * @author Sean
	 */
	public ArrayList<Square> getPreviousSquares(){
		return _previousSquares;
	}
	/**
	 * Method test if Square is a ForwardSquare
	 * <p>
	 * @return true if Square is a ForwardSquare
	 * @return false if Square is not a ForwardSquare
	 * <p>
	 * @author Sean
	 */
	public boolean isForwardSquare(){
		return _forwardSquare;
	}
	/**
	 * Method returns the current size of the stack at the Square
	 * <p>
	 * @return the size of the Stack at the Square as an Int
	 * <p>
	 * @author Sean
	 */
	public int getStackSize() {
		return _square.size();
	}
}
