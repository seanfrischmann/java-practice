package model;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import ui.Driver;

/**
 * The board class serves as the underlying game logic.
 * It combines and assembles all the other components related to the game logic.
 * This class does not construct the GUI, but it provides the correct implementation and 
 * dictates the way the GUI is constructed.
 * <p> 
 * @author Sean & Anna & Matthew
 */
public class Board {
	
	private ActionListener _listener;
	
	private Position[] _top;
	private Position[] _bottom;
	private Position[] _center;
	private ArrayList<StartPosition[]> _startPositions = new ArrayList<StartPosition[]>();	
	private ArrayList<Integer> _randomPosition = new ArrayList<Integer>();
	
	
	private int _numberOfPlayers = (Driver.getArgs().length) - 1;
	private ArrayList<Player> _playerArray = new ArrayList<Player>();
	private Player _currentPlayersTurn;
	private Player _winner = null;
	private int _startingPlayer = 0;

	
	/**
	 * Sets the ActionListener to the passed in variable.
	 * <p>
	 * @param al
	 * <p>
	 * @author Sean & Anna
	 */
	public void setActionListener(ActionListener al) {
		_listener = al;
	}
	
	/**
	 * Notifies the ActionListener if a change has occured
	 * <p>
	 * @author Sean & Anna
	 */
	
	public void notifyOfChange() {
		if (_listener != null) {
			_listener.actionPerformed(null);
		}
	}
	
	/**
	 * Constructor of the Board class.
	 * First it determines the number of players in the game.
	 * Second it adds the number of players to the game.
	 * Then it creates the underlying arrays and starting areas, and their size, for the set number of players.
	 * <p>
	 * @author Sean & Anna
	 */
	public Board() {
		addPlayers(_numberOfPlayers);
		_currentPlayersTurn = _playerArray.get(_startingPlayer);
		createPositions();		
		
		if(_numberOfPlayers == 2){
			StartPosition[] redStart = new StartPosition[4];			
			StartPosition[] blueStart = new StartPosition[4];			
			createStartArea(redStart, "R", _playerArray.get(0));
			_startPositions.add(redStart);
			createStartArea(blueStart, "B", _playerArray.get(1));
			_startPositions.add(blueStart);
		}
		if(_numberOfPlayers == 3){
			StartPosition[] redStart = new StartPosition[4];			
			StartPosition[] blueStart = new StartPosition[4];			
			createStartArea(redStart, "R", _playerArray.get(0));
			_startPositions.add(redStart);
			createStartArea(blueStart, "B", _playerArray.get(1));
			_startPositions.add(blueStart);
			StartPosition[] greenStart = new StartPosition[4];
			createStartArea(greenStart, "G", _playerArray.get(2));
			_startPositions.add(greenStart);
		}
		if(_numberOfPlayers >= 4){
			StartPosition[] redStart = new StartPosition[3];			
			StartPosition[] blueStart = new StartPosition[3];			
			createStartArea(redStart, "R", _playerArray.get(0));
			_startPositions.add(redStart);
			createStartArea(blueStart, "B", _playerArray.get(1));
			_startPositions.add(blueStart);
			StartPosition[] greenStart = new StartPosition[3];
			createStartArea(greenStart, "G", _playerArray.get(2));
			_startPositions.add(greenStart);
			StartPosition[] whiteStart = new StartPosition[3];
			createStartArea(whiteStart, "W", _playerArray.get(3));
			_startPositions.add(whiteStart);
		}
		if(_numberOfPlayers >= 5){
			StartPosition[] blackStart = new StartPosition[3];
			createStartArea(blackStart, "K", _playerArray.get(4));
			_startPositions.add(blackStart);
		}
		if(_numberOfPlayers == 6){
			StartPosition[] yellowStart = new StartPosition[3];
			createStartArea(yellowStart, "Y", _playerArray.get(5));
			_startPositions.add(yellowStart);
		}		
	}
	
	/**
	 * Creates random numbers to be utilized for randomizing the location of the special positions.
	 * <p>
	 * @param numbers
	 * @param size
	 * @param arrayList
	 * <p>
	 * @author Sean & Anna	
	 */
	
	private void randomNumber(int numbers, int size, ArrayList<Integer> arrayList){
		Random _rand = new Random();
		for(int i = 0; i < numbers; i++){
			boolean failTest = true;
			while(failTest){
				int test = _rand.nextInt(size);
				if(!arrayList.contains(test)){
					arrayList.add(test);				
					failTest = false;
				}
			}
		}						
	}
	
	/**
	 * Method that generates the non-starting positions on the Board.
	 * Using the randomNumber() method the different locations of the special positions are created.
	 * Also places the special positions on the Board.
	 * <p>
	 * @author Sean & Anna
	 */
	
	private void createPositions(){	
		_top = new Position[14];
		_bottom = new Position[14];
		_center = new Position[14];
		randomNumber(3, 14, _randomPosition);
		for(int i=0; i<3; i++){
			ArrayList<Integer> randomTrack = new ArrayList<Integer>();
			randomNumber(1, 3, randomTrack);
			if(randomTrack.get(0) == 0){
				if(_randomPosition.get(0) == i){
					_top[i] = (new Position(2, i, this));
					_bottom[i] = (new Position(0, i, this));
					_center[i]  = (new Position(0, i, this));
				}
				else if(_randomPosition.get(1) == i){
					_top[i]  = (new Position(5, i, this));
					_bottom[i] = (new Position(0, i, this));
					_center[i] = (new Position(0, i, this));
				}
				else if(_randomPosition.get(2) == i){
					_top[i]  = (new BackwardsPosition(0, i, this));
					_bottom[i] = (new Position(0, i, this));
					_center[i] = (new Position(0, i, this));
				}
				else{
					_top[i]  = (new Position(0, i, this));
					_bottom[i] = (new Position(0, i, this));
					_center[i] = (new Position(0, i, this));
				}
			}
			else if(randomTrack.get(0) == 1){
				if(_randomPosition.get(0) == i){
					_top[i] = (new Position(0, i, this));
					_bottom[i] = (new Position(2, i, this));
					_center[i]  = (new Position(0, i, this));
				}
				else if(_randomPosition.get(1) == i){
					_top[i]  = (new Position(0, i, this));
					_bottom[i] = (new Position(5, i, this));
					_center[i] = (new Position(0, i, this));
				}
				else if(_randomPosition.get(2) == i){
					_top[i]  = (new Position(0, i, this));
					_bottom[i] = (new BackwardsPosition(0, i, this));
					_center[i] = (new Position(0, i, this));
				}
				else{
					_top[i]  = (new Position(0, i, this));
					_bottom[i] = (new Position(0, i, this));
					_center[i] = (new Position(0, i, this));
				}
			}
			else if(randomTrack.get(0) == 2){
				if(_randomPosition.get(0) == i){
					_top[i] = (new Position(0, i, this));
					_bottom[i] = (new Position(0, i, this));
					_center[i]  = (new Position(2, i, this));
				}
				else if(_randomPosition.get(1) == i){
					_top[i]  = (new Position(0, i, this));
					_bottom[i] = (new Position(0, i, this));
					_center[i] = (new Position(5, i, this));
				}
				else if(_randomPosition.get(2) == i){
					_top[i]  = (new Position(0, i, this));
					_bottom[i] = (new Position(0, i, this));
					_center[i] = (new BackwardsPosition(0, i, this));
				}
				else{
					_top[i]  = (new Position(0, i, this));
					_bottom[i] = (new Position(0, i, this));
					_center[i] = (new Position(0, i, this));
				}
			}
		}
		for(int i=3; i<14; i++){
			if(_randomPosition.get(0) == i){
				_top[i] = (new Position(2, i, this));
				_bottom[i] = _top[i];
				_center[i] = _top[i];
			}
			else if(_randomPosition.get(1) == i){
				_top[i]  = (new Position(5, i, this));
				_bottom[i] = _top[i];
				_center[i] = _top[i];
			}
			else if(_randomPosition.get(2) == i){
				_top[i]  = (new BackwardsPosition(0, i, this));
				_bottom[i] = _top[i];
				_center[i] = _top[i];
			}
			else{
				_top[i]  = (new Position(0, i, this));
				_bottom[i] = _top[i];
				_center[i] = _top[i];
			}
		}
	}
	
	/**
	 * Method that adds the players from the command line arguments to the _playerarray.
	 * Also sets the color of the players to the correct color,
	 * as well as sets the name of each player based on the input of the command line arguments.
	 * <p> 
	 * @param numberOfPlayers
	 * <p>
	 * @author Sean & Anna & Matthew
	 */
	
	public void addPlayers(int numberOfPlayers){		
		if(_numberOfPlayers == 2){
			_playerArray.add(new Player(Color.red, Driver.getArgs()[1]));
			_playerArray.add(new Player(Color.blue, Driver.getArgs()[2]));
		}
		if(_numberOfPlayers == 3){
			_playerArray.add(new Player(Color.red, Driver.getArgs()[1]));
			_playerArray.add(new Player(Color.blue, Driver.getArgs()[2]));
			_playerArray.add(new Player(Color.green, Driver.getArgs()[3]));
		}
		if(_numberOfPlayers == 4){
			_playerArray.add(new Player(Color.red, Driver.getArgs()[1]));
			_playerArray.add(new Player(Color.blue, Driver.getArgs()[2]));
			_playerArray.add(new Player(Color.green, Driver.getArgs()[3]));
			_playerArray.add(new Player(Color.white, Driver.getArgs()[4]));
		}
		if(_numberOfPlayers == 5){
			_playerArray.add(new Player(Color.red, Driver.getArgs()[1]));
			_playerArray.add(new Player(Color.blue, Driver.getArgs()[2]));
			_playerArray.add(new Player(Color.green, Driver.getArgs()[3]));
			_playerArray.add(new Player(Color.white, Driver.getArgs()[4]));
			_playerArray.add(new Player(Color.black, Driver.getArgs()[5]));
		}
		if(_numberOfPlayers == 6){
			_playerArray.add(new Player(Color.red, Driver.getArgs()[1]));
			_playerArray.add(new Player(Color.blue, Driver.getArgs()[2]));
			_playerArray.add(new Player(Color.green, Driver.getArgs()[3]));
			_playerArray.add(new Player(Color.white, Driver.getArgs()[4]));
			_playerArray.add(new Player(Color.black, Driver.getArgs()[5]));
			_playerArray.add(new Player(Color.yellow, Driver.getArgs()[6]));
		}
	}
	
	/**
	 * Boolean value that determines if a Piece is occupying a space that allows it to move forward.
	 * Firstly it checks of the Piece selected is of the current player's color.
	 * If so it allows a Piece to be moved forward.
	 * Otherwise a Piece cannot be moved.
	 * If a Piece selected is not of the current player's color then the Piece cannot be moved.
	 * @param p
	 * <p>
	 * @return boolean
	 * <p>
	 * @author Sean & Anna
	 */
	
	public boolean canMoveForward(Piece p){
		if(p.getPlayer() == _currentPlayersTurn){
			return true;
		}
		ArrayList<Position> board = boardArray();
		boolean hasPiece = false;
		for(int i = 0; i < board.size(); i++){
			Piece topPiece = board.get(i).peekTop();
			if(topPiece != null && topPiece.getPlayer() == _currentPlayersTurn){
				hasPiece = true;
			}			
		}
		return !hasPiece;
	}
	
	/**
	 * Method that generates the initial starting areas of the game.
	 * These positions contain a players Pieces, 
	 * these Pieces are of the player's color,
	 * and their individual identity is preserved.
	 * <p>
	 * @param startPosition
	 * @param s
	 * @param p
	 * <p>
	 * @author Sean & Anna
	 */
	
	private void createStartArea(StartPosition[] startPosition, String s, Player p){
		for (int i=0; i < startPosition.length; i++) {
			startPosition[i] = (new StartPosition(0,i,this));
			populate(startPosition[i], s, p, i+1);
		}
	}

	/**
	 * Method that populates a particular Position with a Piece.
	 * Multiple Pieces can populate a single Position.
	 * The int parameter howMany determines this count. 
	 * <p>
	 * @param pos
	 * @param s
	 * @param p
	 * @param howMany
	 * <p>
	 * @author Sean & Anna
	 */
	
	private void populate(Position pos, String s, Player p, int howMany) {
		for (int i=0; i<howMany; i++) {
			pos.putOn(new Piece(s,p, pos));
		}
	}
	
	/**
	 * Method that returns an ArrayList<Position> object.
	 * It creates this object, but does not display the values contained as a String object.
	 * This object contains the Positions and their stacks of the Board.
	 * <p>
	 * @return ArrayList<Position>
	 * <p>
	 * @author Sean & Anna
	 */
	
	public ArrayList<Position> boardArray(){
		ArrayList<Position> temp = new ArrayList<Position>();
		for (int i=0; i<_startPositions.get(0).length; i++) {
			for(int j=0; j<_startPositions.size(); j++){
				temp.add(_startPositions.get(j)[i]);
			}
		}		
		for (int i=0; i<3; i++) {
			temp.add(_top[i]);
			temp.add(_bottom[i]);
			temp.add(_center[i]);						
		}
		for (int i=3; i<14; i++) {
			temp.add(_bottom[i]);
		}
		return temp;
	}
	
	/**
	 * Method that returns an ArrayList<Position> object.
	 * Creates a temp object of ArrayList<Position>, 
	 * and puts its values to Strings.  
	 * This allows the values of the Stacks at their particular Positions to be read as Strings.
	 * <p>
	 * @return ArrayList<Position>
	 * <p>
	 * @author Sean & Anna
	 */
	public ArrayList<String> getBoard() {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i=0; i<_startPositions.get(0).length; i++) {
			for(int j=0; j<_startPositions.size(); j++){
				temp.add(_startPositions.get(j)[i].toString());
			}
		}		
		for (int i=0; i<3; i++) {
			temp.add(_top[i].toString());
			temp.add(_bottom[i].toString());
			temp.add(_center[i].toString());						
		}
		for (int i=3; i<14; i++) {
			temp.add(_bottom[i].toString());
		}
		return temp;
	}
	/**
	 * Method returns a StartPosition[] object.
	 * The particular object returned is determined by the value of i.
	 * i denotest the postion in the array to return
	 * <p>
	 * @param i
	 * <p>
	 * @return StartPosition[]
	 * <p>
	 * @author Sean & Anna
	 */
	
	public StartPosition[] getStartPositionArray(int i){
		return _startPositions.get(i);
	}
	
	/**
	 * Method the returns the size of the StartPositonArray.
	 * <p>
	 * @return int
	 * <p>
	 * @author Sean & Anna
	 */
	
	public int getStartPositionArraySize(){
		return _startPositions.size();
	}
	
	/**
	 * Method that returns a particular StartPosition object in a startPositionArray object.
	 * <p>
	 * @param startPositionArray
	 * @param startPosition
	 * <p>
	 * @return StartPosition
	 * <p>
	 * @author Sean & Anna
	 */
	
	public StartPosition getStartPosition(int startPositionArray, int startPosition){
		return _startPositions.get(startPositionArray)[startPosition];
	}
	
	/**
	 * Method that returns a Position in the _top array.
	 * The parameter int i determines the position of the array.
	 * <p>
	 * @param i
	 * <p>
	 * @return Position
	 * <p>
	 * @author Sean & Anna
	 */
	
	public Position getLeft(int i) { return _top[i]; }
	
	/**
	 * Method that returns a Position in the _bottom array.
	 * The parameter int i determines the position of the array.
	 * <p>
	 * @param i
	 * <p>
	 * @return Position
	 * <p>
	 * @author Sean & Anna
	 */
	
	public Position getRight(int i) { return _bottom[i]; }
	
	/**
	 * Method that returns a Position in the _center array.
	 * The parameter int i determines the position of the array.
	 * <p>
	 * @param i
	 * <p>
	 * @return Position
	 * <p>
	 * @author Sean & Anna
	 */
	
	public Position getCenter(int i){ return _center[i];}
	
	/**
	 * Method that returns a Position in the _bottom array.
	 * The parameter int i determines the position of the array.
	 * Due to the configuration of the tracks getting the _bottom array will return a position past the initial 3 positions.
	 * <p>
	 * @param i
	 * <p>
	 * @return Position
	 * <p>
	 * @author Sean & Anna
	 */
	
	public Position getCommon(int i) { return _bottom[i]; }
	
	/**
	 * Method that returns a Position[] array.
	 * Specifically the _top array 
	 * <p>
	 * @return Position[]
	 * <p>
	 * @author Sean & Anna
	 */
	
	public Position[] leftTrack() {
		return _top;
	}

	public Position[] rightTrack() {
		return _bottom;
	}
	public Position[] centerTrack(){
		return _center;
	}

	public int getNumberOfPlayers() {
		return _numberOfPlayers;
	}
	
	public ArrayList<Player> getPlayerArray(){
		return _playerArray;
	}

	public Player getCurrentPlayersTurn() {
		return _currentPlayersTurn;
	}

	public void setNextPlayersTurn() {
		if(_currentPlayersTurn == _playerArray.get(_playerArray.size()-1)){
			_startingPlayer = 0;			
		}
		else{
			_startingPlayer++;			
		}
		_currentPlayersTurn = _playerArray.get(_startingPlayer);
	}
	
	public Player getWinner(){
		if(_numberOfPlayers < 4){
			for(int i=0; i<_playerArray.size(); i++){
				if(_playerArray.get(i).getScore() == 10){
					_winner = _playerArray.get(i);
					return _winner;
				}
			}	
		}
		else{
			for(int i=0; i<_playerArray.size(); i++){
				if(_playerArray.get(i).getScore() == 6){
					_winner = _playerArray.get(i);
					return _winner;
				}
			}
		}
		return _winner;
	}
}
