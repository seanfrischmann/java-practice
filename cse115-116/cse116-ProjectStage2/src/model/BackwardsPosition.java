package model;

/**
 * This class modifies the Position class changing the setForwardPositon boolean to false.
 * It requires the same input the Position class, but changes the way a Piece moves in the game,
 * forcing a Piece of a height greater than 1 to move backwards. 
 * If the Piece has a height equal to 1 then the Piece continues forward.
 * <p>
 * @author Sean & Anna
 */
public class BackwardsPosition extends Position {
	
	/**
	 * The constructor of the BackwardsPosition class.  Takes the same parameters as its super class,
	 * but modifies the setForwardPositon boolean to false.
	 * <p>
	 * @param offset
	 * @param index
	 * @param b
	 * <p>
	 * @author Sean & Anna
	 */
	public BackwardsPosition(int offset, int index, Board b) {
		super(offset, index, b);
		setForwardPosition(false);		
	}
	
	/**
	 * The moveTop method is the method that actually moves the Piece on top of the stack 
	 * located on the BackwardsPosition's location.
	 * It checks the height of the stack.
	 * To move a Piece it is popped off a stack then put on a Position some distance away.
	 * If the stack height equals 1 then the piece moves forward 1 Position.
	 * If it is anything else besides 1 or 0 the Piece moves backwards the height of its stack.
	 * <p>
	 * @author Sean & Anna
	 */
	@Override
	public void moveTop() {
		int distanceToMove = height();
		Piece p = _stack.pop();
		if(distanceToMove == 1){
			p.getTrack()[_index + distanceToMove].putOn(p);
		}
		else if((p.getTrack()[_index].getIndex()-distanceToMove) < 0){
			p.getStartingPostion().putOn(p);
		}
		else{
			p.getTrack()[_index - distanceToMove].putOn(p);
		}
	}
}
