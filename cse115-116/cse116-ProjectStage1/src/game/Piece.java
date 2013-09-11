package game;

import java.util.Stack;

/**
 * The Piece class serves to act as the pieces of the game board
 * The pieces can be pushed and popped onto Stacks
 * The pieces also are colored to reflect which player they belong to
 * <p>
 * @author Sean
 */
public class Piece {
	
		private Player _player;
		private Square _startingSquare;
		private Stack<Piece> _startingStack;
		private Square _lastSquare;
	
	/**
	 * The constructor of Piece creates a piece
	 * Also sets the player of the piece
	 * regulating who can move a piece 
	 * <p>
	 * @param player
	 * <p>
	 * @author Sean
	 */
	public Piece(Player player){		
		_player = player;
	}
	/**
	 * Method sets the Starting square of the Piece to the current Square
	 * <p>
	 * @author Sean
	 */
	public void setStartingSquare(Square square){
		_startingSquare = square;
	}
	/**
	 * Method gets the location of the StartingSquare
	 * <p>
	 * @return location of the StartingSquare
	 * <p>
	 * @author Sean
	 */
	public Square getStartingSquare(){
		return _startingSquare;
	}
	/**
	 * Method gets the player that has control of a piece
	 * <p>
	 * @return Player that has been assigned to Piece
	 * <p>
	 * @author Sean
	 */
	public Player getPlayer(){
		return _player;
	}
	/**
	 * Method gets the Starting Stack
	 * <p>
	 * @return Starting Stack
	 * <p>
	 * @author Sean 
	 */
	public Stack<Piece> getStartingStack() {
		return _startingStack;
	}
	/**
	 * Method sets the StartingStack to the Stack that is parameterized
	 * <p>
	 * @param startingStack
	 * <p>
	 * @author Sean
	 */
	public void setStartingStack(Stack<Piece> startingStack) {
		_startingStack = startingStack;
	}
	/**
	 * Method gets the location of the LastSquare
	 * <p>
	 * @return location of the LastSquare
	 * <p>
	 * @author Sean
	 */
	public Square getLastSquare() {
		return _lastSquare;
	}
	/** 
	 * Method sets the LastSquare to the Stack that is parameterized
	 * <p>
	 * @param lastSquare
	 * <p>
	 * @author Sean
	 */
	public void setLastSquare(Square lastSquare) {
		_lastSquare = lastSquare;
	}
	
	

}
