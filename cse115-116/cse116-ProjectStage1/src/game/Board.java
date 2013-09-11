package game;


import java.util.ArrayList;
import java.util.Random;

/**
 * The point of the Board class is to act as a container for the 
 * "game board". It generates squares needed for the board as well as
 * generating the starting area and ending area.
 * <p>
 * @author Sean
 */

public class Board {
	
		
	
	private ArrayList<Integer> _used = new ArrayList<Integer>();
	private Square[] _board;
	private EndingSquare _end;
	private StartingArea _start;
	
	/**
	 * Constructor generates 3 random numbers to create special squares
	 * A new Starting area is created for both players
	 * A new array is created to hold the location of the pieces
	 * A new ending square is created to place pieces that have reached the end
	 * <p>
	 * @param player1
	 * @param player2
	 * <p> 
	 * @author Sean
	 */
	public Board(Player player1, Player player2){
		
		randomNumber(3);
		
		_start = new StartingArea(player1, player2);
		
		_board = new Square[17];
		for(int i = 0; i < _board.length; i++){
			_board[i] = createSquare(i);
		}
		_end = new EndingSquare();
		_board[0].setNextSquare(_board[1]);
		_board[1].setNextSquare(_board[2]);
		_board[2].setNextSquare(_board[3]);
		_board[4].setNextSquare(_board[5]);
		_board[5].setNextSquare(_board[6]);
		_board[6].setNextSquare(_board[3]);
		_board[3].setNextSquare(_board[7]);
		for(int i = 7; i < (_board.length - 1); i++){
			_board[i].setNextSquare(_board[i+1]);
		}
		_board[16].setNextSquare(_end);
		_board[2].addPreviousSquare(_board[1]);
		_board[1].addPreviousSquare(_board[0]);
		_board[6].addPreviousSquare(_board[5]);
		_board[5].addPreviousSquare(_board[4]);
		_board[3].addPreviousSquare(_board[2]);
		_board[3].addPreviousSquare(_board[6]);
		_board[7].addPreviousSquare(_board[3]);
		for(int i = 8; i < _board.length - 1; i++){
			_board[i].addPreviousSquare(_board[i-1]);
		}
		
	}
	/**
	 * Method generates a random number and stores it in 
	 * an ArrayList after checking if it already exists
	 * <p>
	 * @param int
	 * <p>
	 * @author Sean
	 */
	public void randomNumber(int numbers){
		Random _rand = new Random();
		for(int i = 0; i < numbers; i++){
			boolean failTest = true;
			while(failTest){
				int test = _rand.nextInt(16);
				if(!_used.contains(test)){
					_used.add(test);				
					failTest = false;
				}
			}
		}						
	}
	/**
	 * This method generates new squares for the board.
	 * It first checks to see if the passed in integer matches
	 * the random number stored in the _used ArrayList, depending
	 * on which position in the array, assigns one of the special
	 * squares. If it is not one of the random numbers, it creates
	 * a normal square.
	 * @param integer
	 * @return square
	 */
	public Square createSquare(int i){
		
		if(_used.get(0) == i){
			return new SpecialSquare(1);
		}
		else if(_used.get(1) == i){
			return new SpecialSquare(2);
		}
		else if(_used.get(2) == i){
			return new BackwardsSquare();
		}
		else{
			return new Square();
		}
	}
	
	/** 
	 * Method gets the location of SpecialSquare1
	 * @return Array location of SpecialSquare1
	 * @author Sean
	 */
	public Square getSpecialSquare1(){
		return _board[_used.get(0)];
	}
	
	/**
	 * Method gets the location of SpecialSquare2  
	 * @return Array location of SpecialSquare2
	 * @author Sean
	 */
	public Square getSpecialSquare2(){
		return _board[_used.get(1)];
	}
	
	/**
	 * Method gets location of BackwardsSquare
	 * @return Array location of SpecialSquare
	 * @author Sean
	 */
	public Square getBackwardsSquare(){
		return _board[_used.get(2)];
	}
	
	/**
	 * Method gets the SquareArray 
	 * @return SquareArray object
	 * @author Sean
	 */
	public Square[] getSquareArray(){
		return _board;
	}
	/** 
	 * Method gets the starting Square of the left fork 
	 * @return Array position 0
	 * @author Sean 
	 */
	public Square getStartSquareLeft(){
		return _board[0];
	}
	/**
	 * Method gets the starting Square of the right fork 
	 * @return Array position 4
	 * @author Sean
	 */
	public Square getStartSquareRight(){
		return _board[4];
	}
	/**
	 * Method gets the Square where the left and right fork combine 
	 * @return Array position 3
	 * @author Sean
	 */
	public Square getVSquare(){
		return _board[3];
	}
	
	/** 
	 * Method gets the location of the ending Square 
	 * @return Array position 17
	 * @author Sean
	 */
	public EndingSquare getEndSquare(){
		return _end;
	}
	
	/** 
	 * Method gets the location of the starting Square
	 * @return StartingArea
	 * @author Sean
	 */
	public StartingArea getStartArea(){
		return _start;
	}
}
