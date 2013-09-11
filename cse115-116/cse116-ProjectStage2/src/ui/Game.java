package ui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Board;
import model.Piece;
import model.Player;
import model.Position;
import model.StartPosition;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import finch.FinchController;

public class Game implements Runnable, ActionListener {
	
	private ArrayList<JButton> _buttons;
	private Board _board;
	private JFrame _window;
	private String _currentTurn = Driver.getArgs()[1];
	private JLabel _turn = new JLabel();
	private Finch _finch;
	private boolean _useFinch = false;
	
	
	public Game() throws AWTException {
		gameController();
		_board = new Board();
		_board.setActionListener(this);		
		

	}
	
	@Override public void run() {
		_window = new JFrame("Stage 2");
		Container c = _window.getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		
		JPanel nameAndSkip = new JPanel();
		nameAndSkip.setLayout(new BoxLayout(nameAndSkip, BoxLayout.X_AXIS));
		nameAndSkip.add(_turn);
		JButton skipTurn = new JButton("Skip Turn");
		ActionListener skipTurnListener = new SkipHandler(this);
		skipTurn.addActionListener(skipTurnListener);
		nameAndSkip.add(skipTurn);
		
		JPanel playerNames = new JPanel();
		playerNames.setLayout(new BoxLayout(playerNames, BoxLayout.Y_AXIS));
		ArrayList<JLabel> jArray = new ArrayList<JLabel>();
		for (int i = 1; i < Driver.getArgs().length; i++){
			jArray.add(new JLabel(Driver.getArgs()[i] + " is player " + i));
			jArray.get(i - 1).setOpaque(true);
			jArray.get(i - 1).setBackground(_board.getPlayerArray().get(i - 1).getColor());
			if((i-1) == 2 ||(i-1) == 3 || (i - 1) == 5){
				jArray.get(i - 1).setForeground(Color.black);
			}
			else{
				jArray.get(i - 1).setForeground(Color.white);
			}
			playerNames.add(jArray.get(i - 1));		
		}
		
		JPanel start = new JPanel();
		start.setLayout(new BoxLayout(start, BoxLayout.Y_AXIS));
		
		ArrayList<JPanel> startPanels = new ArrayList<JPanel>();
		for(int i=0; i < _board.getNumberOfPlayers(); i++){
			startPanels.add(new JPanel());
			startPanels.get(i).setLayout(new BoxLayout(startPanels.get(i), BoxLayout.X_AXIS));
			start.add(startPanels.get(i));
		}
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new BoxLayout(boardPanel, BoxLayout.X_AXIS));
		
		JPanel startPanel = new JPanel();
		startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.X_AXIS));

		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

		JPanel upperLeft = new JPanel();
		upperLeft.setLayout(new BoxLayout(upperLeft, BoxLayout.X_AXIS));
		
		JPanel centerLeft = new JPanel();
		centerLeft.setLayout(new BoxLayout(centerLeft, BoxLayout.X_AXIS));

		JPanel lowerLeft = new JPanel();
		lowerLeft.setLayout(new BoxLayout(lowerLeft, BoxLayout.X_AXIS));

		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.X_AXIS));

		c.add(startPanel);
		c.add(boardPanel);
		boardPanel.add(left);
		boardPanel.add(right);
		startPanel.add(playerNames);
		startPanel.add(start);
		c.add(nameAndSkip);
		
		left.add(upperLeft);
		left.add(centerLeft);
		left.add(lowerLeft);
		
		start.add(nameAndSkip);
		
		_buttons = new ArrayList<JButton>();
		for (int i=0; i<_board.getStartPositionArray(0).length; i++) {
			for(int j=0; j<_board.getStartPositionArraySize(); j++){
				createStartButton(startPanels.get(j), _board.getStartPosition(j, i));
			}
		}
		
		for (int i=0; i<3; i++) {
			createTrackButton(upperLeft, _board.getLeft(i));
			createTrackButton(lowerLeft, _board.getRight(i));
			createTrackButton(centerLeft, _board.getCenter(i));						
		}
		for (int i=3; i<14; i++) {
			createTrackButton(right, _board.getCommon(i));
		}
		
		update(_board.getBoard());
				
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_window.pack();
		_window.setVisible(true);
	}

	public void createStartButton(JPanel panel, StartPosition pos) {
		createButton(panel, new StartHandler(pos));
	}

	public void createTrackButton(JPanel panel, Position pos) {
		createButton(panel, new TrackHandler(pos));
	}

	private void createButton(JPanel panel, ActionListener listener) {
		JButton b;
		b = new JButton();
		panel.add(b);
		b.addActionListener(listener);
		_buttons.add(b);
	}

	@Override public void actionPerformed(ActionEvent e) {
		update(_board.getBoard());
	}

	private void update(ArrayList<String> board) {
		for (int i=0; i<_buttons.size(); i++) {
			if(_board.boardArray().get(i).getOffset() != 0){
				if(_board.boardArray().get(i).getOffset() == 2){
					_buttons.get(i).setText(board.get(i)+" + 2");
				}
				else{
					_buttons.get(i).setText(board.get(i)+" + 5");
				}
			}
			else if(!_board.boardArray().get(i).isForwardPosition()){
				_buttons.get(i).setText(board.get(i)+" -");
			}
			else{
				_buttons.get(i).setText(board.get(i));
			}			
			if (!_board.boardArray().get(i).getStack().isEmpty()){
				Player getPlayer = _board.boardArray().get(i).peekTop().getPlayer();
				_buttons.get(i).setBackground(getPlayer.getColor());			
				if(_board.getNumberOfPlayers() > 2 && getPlayer == _board.getPlayerArray().get(2)){
					_buttons.get(i).setForeground(Color.black);					
				}
				else if(_board.getNumberOfPlayers() > 3 && getPlayer == _board.getPlayerArray().get(3)){
					_buttons.get(i).setForeground(Color.black);
				}
				else if(_board.getNumberOfPlayers() == 6 && getPlayer == _board.getPlayerArray().get(5)){
					_buttons.get(i).setForeground(Color.black);
				}
				else{
					_buttons.get(i).setForeground(Color.white);
				}
				_buttons.get(i).setOpaque(true);
			}
			else {
				_buttons.get(i).setBackground(null);
				_buttons.get(i).setForeground(null);
			}
		}
		for (int i = 1; i < Driver.getArgs().length; i++){
			_currentTurn = _board.getCurrentPlayersTurn().getName();
			_turn.setText("Current player's turn: " +" "+ _currentTurn + " ");
			if (i == Driver.getArgs().length){
				i = 1;
			}
		}
		if(_useFinch){
			_finch.setLED(_board.getCurrentPlayersTurn().getColor());
		}
		_window.pack();
	}
	public class SkipHandler implements ActionListener{
		
		private Game _game;
		
		public SkipHandler(Game game){
			_game = game;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Position> board = _board.boardArray();
			boolean hasPiece = false;
			for(int i = 0; i < board.size(); i++){
				Piece topPiece = board.get(i).peekTop();
				if(topPiece != null && topPiece.getPlayer() == _board.getCurrentPlayersTurn()){
					hasPiece = true;
					break;
				}			
			}
			if(hasPiece){
				JOptionPane.showMessageDialog(_window, "You may not skip your turn, please select one of your pieces to move!");
			}
			else{
				_board.setNextPlayersTurn();
				update(_board.getBoard());
			}
		}
		
	}
	public class TrackHandler implements ActionListener{
		private Position _pos;

		public TrackHandler(Position pos) {
			_pos = pos;
		}

		@Override public void actionPerformed(ActionEvent e) {
			if(!_pos.getStack().isEmpty() && (_board.canMoveForward(_pos.peekTop()))){
				_pos.moveTop();
				if(_board.getWinner() != null){
					JOptionPane.showMessageDialog(_window, _board.getWinner().getName() + " Wins!");
					System.exit(0);
				}
				_board.setNextPlayersTurn();
				update(_board.getBoard());
			}
			else{
				JOptionPane.showMessageDialog(null, "Not a valid move! Please select a position with your piece on top.");
			}						
		}
	}
	public class StartHandler implements ActionListener {

		private StartPosition _pos;

		public StartHandler(StartPosition pos) {
			_pos = pos;
		}
		
		@Override public void actionPerformed(ActionEvent e) {
			if(!_pos.getStack().isEmpty() && (_board.canMoveForward(_pos.peekTop()))){
				Object[] tracks = {"Top", "Center", "Bottom"};
				int selectedOption = JOptionPane.showOptionDialog(null, "Please choose a track.", "Track Chooser", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, tracks, tracks[0]);
				if(selectedOption == JOptionPane.YES_OPTION){
					_pos.moveTopTrack();
					if(_board.getWinner() != null){
						JOptionPane.showMessageDialog(_window, _board.getWinner().getName() + "Wins");
						System.exit(0);
					}
					_board.setNextPlayersTurn();
					update(_board.getBoard());
				}
				else if(selectedOption == JOptionPane.NO_OPTION){
					_pos.moveCenterTrack();
					if(_board.getWinner() != null){
						JOptionPane.showMessageDialog(_window, _board.getWinner().getName() + "Wins");
						System.exit(0);
					}
					_board.setNextPlayersTurn();
					update(_board.getBoard());
				}
				else if(selectedOption == JOptionPane.CANCEL_OPTION){
					_pos.moveBottomTrack();
					if(_board.getWinner() != null){
						JOptionPane.showMessageDialog(_window, _board.getWinner().getName() + "Wins");
						System.exit(0);
					}
					_board.setNextPlayersTurn();
					update(_board.getBoard());
				}
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Not a valid move! Please select a position with your piece on top.");
			}					
		}
	}
	public void gameController() throws AWTException{
		if (Driver.getArgs().length < 3 || Driver.getArgs().length > 7){
			JOptionPane.showMessageDialog(_turn, "Sorry that is not a valid argument. \n You must have at least 2 players and at most 6 players to play.");
			System.exit(0);
		}
		if (Driver.getArgs()[0].equals("finch")){
			System.out.println(Driver.getArgs()[0]);
			_finch = new Finch();
			_useFinch = true;
			new FinchController(_finch);			
		}
		if (!Driver.getArgs()[0].equals("mouse") && !Driver.getArgs()[0].equals("finch")){
			JOptionPane.showMessageDialog(_turn, "Sorry that is not a valid argument. \n Please input either 'mouse' or 'finch' as the first argument. \n If you need more information on what to choose, read instructions \n located in the User Manual folder."); 
			System.exit(0);
		}
	}
}
