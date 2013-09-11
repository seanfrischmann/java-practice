package game;

import java.awt.Color;
import java.util.Stack;

/**
 * The purpose of this class is to create the starting area
 * for both Players, which involves four stacks per player.
 * Each player has a stack consisting of four, three, two, 
 * and one piece(s). The class also creates the pieces as
 * well as assigns the stack which it originated from.
 */
public class StartingArea {
		
	private Stack<Piece> _fourStackPlayer1;
	private Stack<Piece> _threeStackPlayer1;
	private Stack<Piece> _twoStackPlayer1;
	private Stack<Piece> _oneStackPlayer1;
	
	private Stack<Piece> _fourStackPlayer2;
	private Stack<Piece> _threeStackPlayer2;
	private Stack<Piece> _twoStackPlayer2;
	private Stack<Piece> _oneStackPlayer2;
	
	/**
	 * Method creates players starting stack and game pieces.
	 * @param player1
	 * @param player2
	 */
	public StartingArea(Player player1, Player player2){
		/*
		 * Player 1
		 */
		_fourStackPlayer1 = new Stack<Piece>();
		_threeStackPlayer1 = new Stack<Piece>();
		_twoStackPlayer1 = new Stack<Piece>();
		_oneStackPlayer1 = new Stack<Piece>();
		/*
		 * Four Stack
		 */		
		Piece piece1 = new Piece(player1);
		piece1.setStartingStack(_fourStackPlayer1);
		_fourStackPlayer1.add(piece1);
		Piece piece2 = new Piece(player1);
		piece2.setStartingStack(_fourStackPlayer1);
		_fourStackPlayer1.add(piece2);
		Piece piece3 = new Piece(player1);
		piece3.setStartingStack(_fourStackPlayer1);
		_fourStackPlayer1.add(piece3);
		Piece piece4 = new Piece(player1);
		_fourStackPlayer1.add(piece4);
		/*
		 * Three Stack		
		 */
		Piece piece5 = new Piece(player1);
		piece5.setStartingStack(_threeStackPlayer1);
		_threeStackPlayer1.add(piece5);
		Piece piece6 = new Piece(player1);
		piece6.setStartingStack(_threeStackPlayer1);
		_threeStackPlayer1.add(piece6);
		Piece piece7 = new Piece(player1);
		piece7.setStartingStack(_threeStackPlayer1);
		_threeStackPlayer1.add(piece7);
		/*
		 * Two Stack
		 */
		Piece piece8 = new Piece(player1);
		piece8.setStartingStack(_twoStackPlayer1);
		_twoStackPlayer1.add(piece8);
		Piece piece9 = new Piece(player1);
		piece9.setStartingStack(_twoStackPlayer1);
		_twoStackPlayer1.add(piece9);
		/*
		 * One Stack
		 */
		Piece piece10 = new Piece(player1);
		piece10.setStartingStack(_oneStackPlayer1);
		_oneStackPlayer1.add(piece10);
		/*
		 * Player 2
		 */
		_fourStackPlayer2 = new Stack<Piece>();
		_threeStackPlayer2 = new Stack<Piece>();
		_twoStackPlayer2 = new Stack<Piece>();
		_oneStackPlayer2 = new Stack<Piece>();
		/*
		 * Four Stack
		 */		
		Piece piece11 = new Piece(player2);
		piece11.setStartingStack(_fourStackPlayer2);
		_fourStackPlayer2.add(piece11);
		Piece piece12 = new Piece(player2);
		piece12.setStartingStack(_fourStackPlayer2);
		_fourStackPlayer2.add(piece12);
		Piece piece13 = new Piece(player2);
		piece13.setStartingStack(_fourStackPlayer2);
		_fourStackPlayer2.add(piece13);
		Piece piece14 = new Piece(player2);
		piece14.setStartingStack(_fourStackPlayer2);
		_fourStackPlayer2.add(piece14);
		/*
		 * Three Stack
		 */
		Piece piece15 = new Piece(player2);
		piece15.setStartingStack(_threeStackPlayer2);
		_threeStackPlayer2.add(piece15);
		Piece piece16 = new Piece(player2);
		piece16.setStartingStack(_threeStackPlayer2);
		_threeStackPlayer2.add(piece16);
		Piece piece17 = new Piece(player2);
		piece17.setStartingStack(_threeStackPlayer2);
		_threeStackPlayer2.add(piece17);
		/*
		 * Two Stack
		 */
		Piece piece18 = new Piece(player2);
		piece18.setStartingStack(_twoStackPlayer2);
		_twoStackPlayer2.add(piece18);
		Piece piece19 = new Piece(player2);
		piece19.setStartingStack(_twoStackPlayer2);
		_twoStackPlayer2.add(piece19);
		/*
		 * One Stack
		 */
		Piece piece20 = new Piece(player2);
		piece20.setStartingStack(_oneStackPlayer2);
		_oneStackPlayer2.add(piece20);		
	}
	public boolean hasPiece(Player player){
		if(player.getColor() == Color.red){
			return !(_fourStackPlayer1.isEmpty()&& _threeStackPlayer1.isEmpty()&&_twoStackPlayer1.isEmpty()&&_oneStackPlayer1.isEmpty());			
		}
		else{
			return !(_fourStackPlayer2.isEmpty()&&_threeStackPlayer2.isEmpty()&&_twoStackPlayer2.isEmpty()&&_oneStackPlayer2.isEmpty());			
		}
	}
	public Stack<Piece> getFourStackPlayer1() {
		return _fourStackPlayer1;
	}
	public Stack<Piece> getThreeStackPlayer1() {
		return _threeStackPlayer1;
	}
	public Stack<Piece> getTwoStackPlayer1() {
		return _twoStackPlayer1;
	}
	public Stack<Piece> getOneStackPlayer1() {
		return _oneStackPlayer1;
	}
	public Stack<Piece> getFourStackPlayer2() {
		return _fourStackPlayer2;
	}
	public Stack<Piece> getThreeStackPlayer2() {
		return _threeStackPlayer2;
	}
	public Stack<Piece> getTwoStackPlayer2() {
		return _twoStackPlayer2;
	}
	public Stack<Piece> getOneStackPlayer2() {
		return _oneStackPlayer2;
	}
}

