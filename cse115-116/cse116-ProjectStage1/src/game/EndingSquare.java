package game;

import java.util.HashMap;

/**
 * Added a way to keep track of the winner by using a HashMap. 
 * Instead of adding a piece to a stack when you move a piece "off" 
 * of the last game square, it stores the player and increments every 
 * time a players piece is moved "off" the board.
 * <p>
 * @author Sean
 */
public class EndingSquare extends Square {
	
	/**
	 * The constructor creates a new HashMap used to store the Pieces that have reached the End Space
	 * <p>
	 * @author Sean
	 */
	private HashMap<Player, Integer> _endMap;
	
	public EndingSquare(){
		_endMap = new HashMap<Player, Integer>();
	}
	/**
	 * This method overrides the addPiece method from Square
	 * In place of adding a Piece to a Stack
	 * A Piece is added to a HashMap
	 * <p>
	 * @param Piece
	 * <p>
	 * @author Sean
	 */
	@Override
	public void addPiece(Piece piece){
		if(_endMap.containsKey(piece.getPlayer())){
			Integer value = _endMap.get(piece.getPlayer());
			_endMap.put(piece.getPlayer(), ++value);			
		}
		else{
			_endMap.put(piece.getPlayer(), 1);
		}
	}
	/**
	 * Method checks of a Player has a Piece in the HashMap and the amount of Pieces if any are stored
	 * <p>
	 * @param player
	 * <p>
	 * @return Amount of Pieces a Player has stored
	 * @return 0
	 * <p> 
	 * @author Sean
	 */
	public int getPlayersEndStack(Player player){
		if (_endMap.containsKey(player)) {
			return _endMap.get(player);
		}
		
		return 0;
	}

}
