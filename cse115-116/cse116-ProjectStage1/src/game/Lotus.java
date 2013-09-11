package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;


/**
 * The purpose of the lotus class is to contain all the logic for 
 * the actual game. It starts the game by adding both players and sets
 * the current players turn. It also creates the game board.
 *<p>
 *  @author Sean
 */

public class Lotus {
	
		
	private Player _player1;
	private Player _player2;
	private Player _currentPlayersTurn;
	private Board _gameBoard;
	private Player _winner;
	/**
	 * Constructor calls startGame() method in order to
	 * initiate the game.
	 * @author Sean
	 */
	public Lotus(){
		startGame();
	}
	/**
	 * Method creates two players.
	 * <p>
	 * Player 1 as color Red
	 * <p>
	 * Player 2 as color Blue
	 * @author Sean
	 */
	public void addPlayers(){
		_player1 = new Player(Color.red);
		_player2 = new Player(Color.blue);		
	}
	/**
	 * Method adds players, sets who goes first, and 
	 * creates the game board.
	 * @author Sean
	 */
	public void startGame(){
		addPlayers();
		setCurrentPlayersTurn(_player1);
		_gameBoard = new Board(_player1, _player2);		
	}
	/**
	 * Method check to see if player has all of a players pieces
	 * are off the board.
	 * <p>
	 * If so, sets the winner to that player.
	 * @author Sean
	 */
	public void endGame(){
		int allOfPlayersPieces = 10;
		if(_gameBoard.getEndSquare().getPlayersEndStack(_player1) == allOfPlayersPieces){
			setWinner(_player1);				
		}
		else if(_gameBoard.getEndSquare().getPlayersEndStack(_player2) == allOfPlayersPieces){
			setWinner(_player2);			
		}		
	}
	/**
	 * Method checks to see whether the piece is a valid move, if it is not
	 * then the method checks to see if the player has an available move.
	 * @param piece at the top of the square player is trying to move from
	 * @return true if piece belongs to player
	 * <p>
	 * true if player does not have a piece on the board
	 * <p>
	 * false if player has a has a piece on the board and piece does not belong to them.
	 * @author Sean
	 */
	public boolean canMovePiece(Piece piece){
		if(piece.getPlayer() == _currentPlayersTurn){
			return true;
		}
		Square[] squaresOnBoard = _gameBoard.getSquareArray();
		boolean hasPiece = false;
		for(int i = 0; i < squaresOnBoard.length; i++){
			Piece topPiece = squaresOnBoard[i].getPiece();
			if(topPiece != null && topPiece.getPlayer() == _currentPlayersTurn){
				hasPiece = true;
			}			
		}
		if(_gameBoard.getStartArea().hasPiece(_currentPlayersTurn)){
			hasPiece = true;
		}
		return !hasPiece;			
	}
	/**
	 * Method moves piece from its origin to chosen square as long as it is either 
	 * a valid move or player has no other move.
	 * @param startSquare
	 * @param nextSquare
	 * @return true if move was valid
	 * <p>
	 * false if move was not valid
	 * @author Sean
	 */
	
	public boolean squareMove(Square startSquare, Square endSquare){		
		if(canMovePiece(startSquare.getPiece())){
			Square temp = startSquare;
			boolean found = false;
			boolean backToTheBeginning = false;
			for(int i = 0; i <= startSquare.getHeight(); i++){
				if(temp == endSquare){
					found = true;
					break;
				}
				if(startSquare.isForwardSquare()){
					temp = temp.getNextSquare();
				}
				else{
					Square lastSquare = startSquare.getPiece().getLastSquare();
					/* This is the standard spot a square will hold its previous*/
					ArrayList<Square> previousSquares = startSquare.getPreviousSquares();
										
					/* This is square three on the board, where both starts come together*/
					Square vSquare = _gameBoard.getVSquare();
					if(previousSquares.contains(lastSquare) || previousSquares.isEmpty()){
						temp = temp.getNextSquare();
					}
					else if(temp == vSquare){
						if(startSquare.getPiece().getStartingSquare() == _gameBoard.getStartSquareLeft()){							
							temp = temp.getPreviousSquares().get(0);
						}
						else{
							temp = temp.getPreviousSquares().get(1);
						}
					}
					else if(temp == _gameBoard.getStartSquareLeft() || temp == _gameBoard.getStartSquareRight()){
						backToTheBeginning = true;						
					}
					else{
						temp = temp.getPreviousSquares().get(0);
					}
				}							
			}
			if(found){
				Piece piece = startSquare.removePiece();
				piece.setLastSquare(startSquare);
				endSquare.addPiece(piece);
			}
			else if(backToTheBeginning){
				Piece piece = startSquare.removePiece();
				piece.getStartingStack().add(piece);
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}	
		endGame();
		if(getWinner() == null){
			if(getCurrentPlayersTurn() == _player1){
				setCurrentPlayersTurn(_player2);
			}
			else{
				setCurrentPlayersTurn(_player1);
			}	
		}
		return true;
	}
	/**
	 * Method is used to move pieces from the starting area onto
	 * the board. It takes three parameters:
	 * <p>
	 * startingSide- which side you are starting from: Square[0] or Square[4]
	 * <p>
	 * startStack- which stack your moving from: FourStack, ThreeStack etc.
	 * <p>
	 * endSquare- Destination
	 * @param startingSide
	 * @param startStack
	 * @param endSquare
	 * @return true if move is valid
	 * <p>
	 * false if move is not valid
	 * @author Sean
	 */
	public boolean stackMove(Square startingSide, Stack<Piece> startStack, Square endSquare){
		if(startStack.peek().getPlayer() == _currentPlayersTurn){
			Square temp = startingSide;			
			boolean found = false;
			for(int i = 0; i < startStack.size(); i++){
				if(temp == endSquare){
					found = true;
					break;
				}
				else{
					temp = temp.getNextSquare();
				}
			}
			if(found){
				Piece piece = startStack.pop();
				piece.setStartingSquare(startingSide);
				endSquare.addPiece(piece);
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		endGame();
		if(getWinner() == null){
			if(getCurrentPlayersTurn() == _player1){
				setCurrentPlayersTurn(_player2);
			}
			else{
				setCurrentPlayersTurn(_player1);
			}	
		}
		return true;
	}
	/**
	 * Method gets the current players turn
	 * <p>
	 * @return current players turn
	 * <p>
	 * @author Sean
	 */
	public Player getCurrentPlayersTurn() {
		return _currentPlayersTurn;
	}
	/**
	 * Method sets current players turn
	 * <p>
	 * @param player
	 * <p>
	 * @author Sean
	 */
	public void setCurrentPlayersTurn(Player player) {
		_currentPlayersTurn = player;
	}
	/**
	 * Method gets the winner
	 * <p>
	 * @return winner
	 * <p>
	 * @author Sean
	 */
	public Player getWinner() {
		return _winner;
	}
	/**
	 * Method sets the winner
	 * <p>
	 * @param winner
	 * <p
	 * @author Sean
	 */
	public void setWinner(Player winner) {
		_winner = winner;
	}
	/**
	 * Method gets the Board Object
	 * <p>
	 * @return Board
	 * <p>
	 * @author Sean
	 */
	public Board getBoard(){
		return _gameBoard;
	}
	public Player getPlayer1() {
		return _player1;
	}
	public Player getPlayer2() {
		return _player2;
	}

}
