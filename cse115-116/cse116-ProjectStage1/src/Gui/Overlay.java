package Gui;

import game.Lotus;
import game.Piece;
import game.Square;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This class serves as our main GUI class
 * This class is composed of all the necessary buttons and actionListners
 * The class acts independently from the JBackgroundPanel class
 * Allowing either to be modified without conflicting with each other
 * This class extends JPanel
 * <p>
 * @author Matthew & Sean
 */
public class Overlay extends JPanel{
	
	private Dimension d;
	private boolean _startingAreaMove = false;
	private boolean buttonPressed = true;
	private Square _startSquare;
	private Square _endSquare;
	private Stack<Piece> _startStack;
	private Lotus _lotus;
	private Square[] _squareArray;
	
	private JButton _js1;
	private JButton _js2;
	private JButton _js3;
	private JButton _js4;
	private JButton _js5;
	private JButton _js6;
	private JButton _js7;
	private JButton _js8;
	private JButton _j1;
	private JButton _j2;
	private JButton _j3;
	private JButton _j4;
	private JButton _j5;
	private JLabel _j6;
	private JButton _j7;
	private JPanel _j8;
	private JButton _j9;
	private JLabel _j10;
	private JButton _j11;
	private JButton _j12;
	private JPanel _j13;
	private JButton _j14;
	private JButton _j15;
	private JButton _j16;
	private JButton _j17;
	private JButton _j18;
	private JButton _j19;
	private JLabel _j20;
	private JButton _j21;
	private JLabel _j22;
	private JButton _j23;
	private JButton _j24;
	private JButton _j25;
	
	/**
	 * The constructor establishes the Dimensions of the JPanel, creates a new Lotus Object, 
	 * sets the GridLayout, and adds all of the swing components to the JPanel.
	 * Also the ActionListeners are attached to their corresponding buttons.
	 * Finally the swing components are updated to display their corresponding values
	 * <p> 
	 * @author Matthew & Sean 
	 */
	public Overlay(){
		_lotus = new Lotus();
		
		d = new Dimension(700,700);
		this.setOpaque(false);
		this.setLayout(new GridLayout(5,5,30,30));
		this.setMaximumSize(d);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.setSize(d);
		
		
	/* 		Testing position of elements in GridLayout
			JButtons now are added in correct order and resize properly
	*/	

		_js1 = new JButton();
		_js1.setBackground(Color.RED);
		_js1.setOpaque(true);
		ActionListener startButton1 = new StackMoveListener(this,  _lotus.getBoard().getStartArea().getOneStackPlayer1());
		_js1.addActionListener(startButton1);
		
		_js2 = new JButton();
		_js2.setBackground(Color.RED);
		_js2.setOpaque(true);
		ActionListener startButton2 = new StackMoveListener(this,  _lotus.getBoard().getStartArea().getTwoStackPlayer1());
		_js2.addActionListener(startButton2);
		
		_js3 = new JButton();
		_js3.setBackground(Color.RED);
		_js3.setOpaque(true);
		ActionListener startButton3 = new StackMoveListener(this,  _lotus.getBoard().getStartArea().getThreeStackPlayer1());
		_js3.addActionListener(startButton3);
		
		_js4 = new JButton();
		_js4.setBackground(Color.RED);
		_js4.setOpaque(true);
		ActionListener startButton4 = new StackMoveListener(this,  _lotus.getBoard().getStartArea().getFourStackPlayer1());
		_js4.addActionListener(startButton4);
		
		_js5 = new JButton();
		_js5.setBackground(Color.BLUE);
		_js5.setOpaque(true);
		ActionListener startButton5 = new StackMoveListener(this,  _lotus.getBoard().getStartArea().getOneStackPlayer2());
		_js5.addActionListener(startButton5);
		
		_js6 = new JButton();
		_js6.setBackground(Color.BLUE);
		_js6.setOpaque(true);
		ActionListener startButton6 = new StackMoveListener(this,  _lotus.getBoard().getStartArea().getTwoStackPlayer2());
		_js6.addActionListener(startButton6);
		
		_js7 = new JButton();
		_js7.setBackground(Color.BLUE);
		_js7.setOpaque(true);
		ActionListener startButton7 = new StackMoveListener(this,  _lotus.getBoard().getStartArea().getThreeStackPlayer2());
		_js7.addActionListener(startButton7);
		
		_js8 = new JButton();
		_js8.setBackground(Color.BLUE);
		_js8.setOpaque(true);
		ActionListener startButton8 = new StackMoveListener(this,  _lotus.getBoard().getStartArea().getFourStackPlayer2());
		_js8.addActionListener(startButton8);
		
		_squareArray = _lotus.getBoard().getSquareArray();
				
		_j1 = new JButton();
		add(_j1);
		_j1.setOpaque(true);
		ActionListener square10 = new SquareMoveListener(this,_squareArray[10]);
		_j1.addActionListener(square10);
		
		_j2 = new JButton();
		if (_squareArray[11].getStackSize() == 0){
			_j2.setBackground(Color.WHITE);
		}
		else{
			_j2.setBackground(_squareArray[11].getPiece().getPlayer().getColor());
		}
		add(_j2);
		_j2.setOpaque(true);
		ActionListener square11 = new SquareMoveListener(this,_squareArray[11]);
		_j2.addActionListener(square11);
		
		_j3 = new JButton();
		add(_j3);
		_j3.setOpaque(true);
		ActionListener square12 = new SquareMoveListener(this,_squareArray[12]);
		_j3.addActionListener(square12);
		
		_j4 = new JButton();
		add(_j4);
		_j4.setOpaque(true);
		ActionListener square13 = new SquareMoveListener(this,_squareArray[13]);
		_j4.addActionListener(square13);
		
		_j5 = new JButton();
		add(_j5);
		_j5.setOpaque(true);
		ActionListener square14 = new SquareMoveListener(this,_squareArray[14]);
		_j5.addActionListener(square14);
		
		 _j6 = new JLabel();
		add(_j6);
		_j6.setOpaque(false);
		
		_j7 = new JButton();
		add(_j7);
		ActionListener square0 = new SquareMoveListener(this,_squareArray[0]);
		_j7.addActionListener(square0);		
		_j7.setOpaque(true);
		
		_j8 = new JPanel();
		_j8.setLayout(new GridLayout(0,2));
		_j8.add(_js1);
		_j8.add(_js2);
		_j8.add(_js3);
		_j8.add(_js4);
		add(_j8);
		_j8.setOpaque(false);
		
		_j9 = new JButton();
		add(_j9);
		ActionListener square4 = new SquareMoveListener(this,_squareArray[4]);
		_j9.addActionListener(square4);
		_j9.setOpaque(true);
		
		_j10 = new JLabel();
		add(_j10);
		_j10.setOpaque(false);
		
		_j11 = new JButton();
		add(_j11);
		_j11.setOpaque(true);
		ActionListener square9 = new SquareMoveListener(this,_squareArray[9]);
		_j11.addActionListener(square9);
		
		_j12 = new JButton();
		add(_j12);
		_j12.setOpaque(true);
		ActionListener square1 = new SquareMoveListener(this,_squareArray[1]);
		_j12.addActionListener(square1);
		
		_j13 = new JPanel();
		_j13.setLayout(new GridLayout(0,2));
		_j13.add(_js5);
		_j13.add(_js6);
		_j13.add(_js7);
		_j13.add(_js8);
		add(_j13);
		_j13.setOpaque(false);
		
		_j14 = new JButton();
		add(_j14);
		_j14.setOpaque(true);
		ActionListener square5 = new SquareMoveListener(this,_squareArray[5]);
		_j14.addActionListener(square5);
		
		_j15 = new JButton();
		add(_j15);
		_j15.setOpaque(true);
		ActionListener square15 = new SquareMoveListener(this,_squareArray[15]);
		_j15.addActionListener(square15);
		
		_j16 = new JButton("Skip Turn");
		_j16.setBackground(Color.GREEN);
		add(_j16);
		_j16.setOpaque(true);
		ActionListener skip = new SkipTurnListener(this);
		_j16.addActionListener(skip);
		
		_j17 = new JButton();
		add(_j17);
		_j17.setOpaque(true);
		ActionListener square2 = new SquareMoveListener(this,_squareArray[2]);
		_j17.addActionListener(square2);
		
		_j18 = new JButton();
		add(_j18);
		_j18.setOpaque(true);
		ActionListener square3 = new SquareMoveListener(this,_squareArray[3]);
		_j18.addActionListener(square3);
		
		_j19 = new JButton();
		add(_j19);
		_j19.setOpaque(true);
		ActionListener square6 = new SquareMoveListener(this,_squareArray[6]);
		_j19.addActionListener(square6);
		
		_j20 = new JLabel();
		add(_j20);
		_j20.setOpaque(false);
		
		_j21 = new JButton();
		add(_j21);
		_j21.setOpaque(true);
		ActionListener square8 = new SquareMoveListener(this,_squareArray[8]);
		_j21.addActionListener(square8);
		
		_j22 = new JLabel();
		add(_j22);
		_j22.setOpaque(false);
		
		_j23 = new JButton();
			add(_j23);
		_j23.setOpaque(true);
		ActionListener square7 = new SquareMoveListener(this,_squareArray[7]);
		_j23.addActionListener(square7);
		
		_j24 = new JButton("End Space");
		_j24.setBackground(Color.YELLOW);
		add(_j24);
		_j24.setOpaque(true);
		ActionListener square17 = new SquareMoveListener(this, _lotus.getBoard().getEndSquare());
		_j24.addActionListener(square17);
		
		_j25 = new JButton();
			add(_j25);
		_j25.setOpaque(true);
		ActionListener square16 = new SquareMoveListener(this,_squareArray[16]);
		_j25.addActionListener(square16);
		
		updateJButtons();
	}
	/**
	 * Method updates all of the JButtons, their color and the text they should display
	 * in relation to the height of the stack on the Square and which Player own the top Piece of the Stack
	 * <p>
	 * @author Matthew & Sean
	 */
	public void updateJButtons(){
		_js1.setText(Integer.toString(_lotus.getBoard().getStartArea().getOneStackPlayer1().size()));
		_js2.setText(Integer.toString(_lotus.getBoard().getStartArea().getTwoStackPlayer1().size()));
		_js3.setText(Integer.toString(_lotus.getBoard().getStartArea().getThreeStackPlayer1().size()));
		_js4.setText(Integer.toString(_lotus.getBoard().getStartArea().getFourStackPlayer1().size()));
		_js5.setText(Integer.toString(_lotus.getBoard().getStartArea().getOneStackPlayer2().size()));
		_js6.setText(Integer.toString(_lotus.getBoard().getStartArea().getTwoStackPlayer2().size()));
		_js7.setText(Integer.toString(_lotus.getBoard().getStartArea().getThreeStackPlayer2().size()));
		_js8.setText(Integer.toString(_lotus.getBoard().getStartArea().getFourStackPlayer2().size()));
		
		_j1.setText(Integer.toString(_squareArray[10].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[10]){
			_j1.setText(Integer.toString(_squareArray[10].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[10]){
			_j1.setText(Integer.toString(_squareArray[10].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[10]){
			_j1.setText(Integer.toString(_squareArray[10].getStackSize()) + " + 2");
		}
		if (_squareArray[10].getStackSize() == 0){
			_j1.setBackground(Color.WHITE);
		}
		else{
			_j1.setBackground(_squareArray[10].getPiece().getPlayer().getColor());
		}
		
		_j2.setText(Integer.toString(_squareArray[11].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[11]){
			_j2.setText(Integer.toString(_squareArray[11].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[11]){
			_j2.setText(Integer.toString(_squareArray[11].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[11]){
			_j2.setText(Integer.toString(_squareArray[11].getStackSize()) + " + 2");
		}
		if (_squareArray[11].getStackSize() == 0){
			_j2.setBackground(Color.WHITE);
		}
		else{
			_j2.setBackground(_squareArray[11].getPiece().getPlayer().getColor());
		}
		
		_j3.setText(Integer.toString(_squareArray[12].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[12]){
			_j3.setText(Integer.toString(_squareArray[12].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[12]){
			_j3.setText(Integer.toString(_squareArray[12].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[12]){
			_j3.setText(Integer.toString(_squareArray[12].getStackSize()) + " + 2");
		}
		if (_squareArray[12].getStackSize() == 0){
			_j3.setBackground(Color.WHITE);
		}
		else{
			_j3.setBackground(_squareArray[12].getPiece().getPlayer().getColor());
		}
		
		_j4.setText(Integer.toString(_squareArray[13].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[13]){
			_j4.setText(Integer.toString(_squareArray[13].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[13]){
			_j4.setText(Integer.toString(_squareArray[13].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[13]){
			_j4.setText(Integer.toString(_squareArray[13].getStackSize()) + " + 2");
		}
		if (_squareArray[13].getStackSize() == 0){
			_j4.setBackground(Color.WHITE);
		}
		else{
			_j4.setBackground(_squareArray[13].getPiece().getPlayer().getColor());
		}
		
		_j5.setText(Integer.toString(_squareArray[14].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[14]){
			_j5.setText(Integer.toString(_squareArray[14].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[14]){
			_j5.setText(Integer.toString(_squareArray[14].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[14]){
			_j5.setText(Integer.toString(_squareArray[14].getStackSize()) + " + 2");
		}
		if (_squareArray[14].getStackSize() == 0){
			_j5.setBackground(Color.WHITE);
		}
		else{
			_j5.setBackground(_squareArray[14].getPiece().getPlayer().getColor());
		}
		
		_j7.setText(Integer.toString(_squareArray[0].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[0]){
			_j7.setText(Integer.toString(_squareArray[0].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[0]){
			_j7.setText(Integer.toString(_squareArray[0].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[0]){
			_j7.setText(Integer.toString(_squareArray[0].getStackSize()) + " + 2");
		}
		if (_squareArray[0].getStackSize() == 0){
			_j7.setBackground(Color.WHITE);
		}
		else{
			_j7.setBackground(_squareArray[0].getPiece().getPlayer().getColor());
		}
		
		_j9.setText(Integer.toString(_squareArray[4].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[4]){
			_j9.setText(Integer.toString(_squareArray[4].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[4]){
			_j9.setText(Integer.toString(_squareArray[4].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[4]){
			_j9.setText(Integer.toString(_squareArray[4].getStackSize()) + " + 2");
		}
		if (_squareArray[4].getStackSize() == 0){
			_j9.setBackground(Color.WHITE);
		}
		else{
			_j9.setBackground(_squareArray[4].getPiece().getPlayer().getColor());
		}
		
		_j11.setText(Integer.toString(_squareArray[9].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[9]){
			_j11.setText(Integer.toString(_squareArray[9].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[9]){
			_j11.setText(Integer.toString(_squareArray[9].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[9]){
			_j11.setText(Integer.toString(_squareArray[9].getStackSize()) + " + 2");
		}
		if (_squareArray[9].getStackSize() == 0){
			_j11.setBackground(Color.WHITE);
		}
		else{
			_j11.setBackground(_squareArray[9].getPiece().getPlayer().getColor());
		}
		
		_j12.setText(Integer.toString(_squareArray[1].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[1]){
			_j12.setText(Integer.toString(_squareArray[1].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[1]){
			_j12.setText(Integer.toString(_squareArray[1].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[1]){
			_j12.setText(Integer.toString(_squareArray[1].getStackSize()) + " + 2");
		}
		if (_squareArray[1].getStackSize() == 0){
			_j12.setBackground(Color.WHITE);
		}
		else{
			_j12.setBackground(_squareArray[1].getPiece().getPlayer().getColor());
		}
		
		_j14.setText(Integer.toString(_squareArray[5].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[5]){
			_j14.setText(Integer.toString(_squareArray[5].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[5]){
			_j14.setText(Integer.toString(_squareArray[5].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[5]){
			_j14.setText(Integer.toString(_squareArray[5].getStackSize()) + " + 2");
		}
		if (_squareArray[5].getStackSize() == 0){
			_j14.setBackground(Color.WHITE);
		}
		else{
			_j14.setBackground(_squareArray[5].getPiece().getPlayer().getColor());
		}
		
		_j15.setText(Integer.toString(_squareArray[15].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[15]){
			_j15.setText(Integer.toString(_squareArray[15].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[15]){
			_j15.setText(Integer.toString(_squareArray[15].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[15]){
			_j15.setText(Integer.toString(_squareArray[15].getStackSize()) + " + 2");
		}
		if (_squareArray[15].getStackSize() == 0){
			_j15.setBackground(Color.WHITE);
		}
		else{
			_j15.setBackground(_squareArray[15].getPiece().getPlayer().getColor());
		}
		
		_j17.setText(Integer.toString(_squareArray[2].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[2]){
			_j17.setText(Integer.toString(_squareArray[2].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[2]){
			_j17.setText(Integer.toString(_squareArray[2].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[2]){
			_j17.setText(Integer.toString(_squareArray[2].getStackSize()) + " + 2");
		}
		if (_squareArray[2].getStackSize() == 0){
			_j17.setBackground(Color.WHITE);
		}
		else{
			_j17.setBackground(_squareArray[2].getPiece().getPlayer().getColor());
		}
		
		_j18.setText(Integer.toString(_squareArray[3].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[3]){
			_j18.setText(Integer.toString(_squareArray[3].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[3]){
			_j18.setText(Integer.toString(_squareArray[3].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[3]){
			_j18.setText(Integer.toString(_squareArray[3].getStackSize()) + " + 2");
		}
		if (_squareArray[3].getStackSize() == 0){
			_j18.setBackground(Color.WHITE);
		}
		else{
			_j18.setBackground(_squareArray[3].getPiece().getPlayer().getColor());
		}
		
		_j19.setText(Integer.toString(_squareArray[6].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[6]){
			_j19.setText(Integer.toString(_squareArray[6].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[6]){
			_j19.setText(Integer.toString(_squareArray[6].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[6]){
			_j19.setText(Integer.toString(_squareArray[6].getStackSize()) + " + 2");
		}
		if (_squareArray[6].getStackSize() == 0){
			_j19.setBackground(Color.WHITE);
		}
		else{
			_j19.setBackground(_squareArray[6].getPiece().getPlayer().getColor());
		}
		
		_j21.setText(Integer.toString(_squareArray[8].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[8]){
			_j21.setText(Integer.toString(_squareArray[8].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[8]){
			_j21.setText(Integer.toString(_squareArray[8].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[8]){
			_j21.setText(Integer.toString(_squareArray[8].getStackSize()) + " + 2");
		}
		if (_squareArray[8].getStackSize() == 0){
			_j21.setBackground(Color.WHITE);
		}
		else{
			_j21.setBackground(_squareArray[8].getPiece().getPlayer().getColor());
		}
		
		if (_lotus.getCurrentPlayersTurn() == _lotus.getPlayer1()){ 
			_j22.setText("Player 1's Turn");
			_j22.setHorizontalAlignment(SwingConstants.CENTER);
		}
		else {
			_j22.setText("Player 2's Turn");
			_j22.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		_j23.setText(Integer.toString(_squareArray[7].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[7]){
			_j23.setText(Integer.toString(_squareArray[7].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[7]){
			_j23.setText(Integer.toString(_squareArray[7].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[7]){
			_j23.setText(Integer.toString(_squareArray[7].getStackSize()) + " + 2");
		}
		if (_squareArray[7].getStackSize() == 0){
			_j23.setBackground(Color.WHITE);
		}
		else{
			_j23.setBackground(_squareArray[7].getPiece().getPlayer().getColor());
		}
	
		_j25.setText(Integer.toString(_squareArray[16].getStackSize()));
		if (_lotus.getBoard().getBackwardsSquare() == _squareArray[16]){
			_j25.setText(Integer.toString(_squareArray[16].getStackSize()) + " - ");
		}
		else if (_lotus.getBoard().getSpecialSquare1() == _squareArray[16]){
			_j25.setText(Integer.toString(_squareArray[16].getStackSize()) + " + 1");
		}
		else if (_lotus.getBoard().getSpecialSquare2() == _squareArray[16]){
			_j25.setText(Integer.toString(_squareArray[16].getStackSize()) + " + 2");
		}
		if (_squareArray[16].getStackSize() == 0){
			_j25.setBackground(Color.WHITE);
		}
		else{
			_j25.setBackground(_squareArray[16].getPiece().getPlayer().getColor());
		}
	
	}
	/**
	 * When a JButton is pressed, that is not in the starting area,
	 * this method either sets the starting square or the ending square.
	 * <p>
	 * @param overlay
	 * @param square
	 * @author Sean
	 *
	 */
	public class SquareMoveListener implements ActionListener{
		private Overlay _overlay;
		private Square _passedSquare;
		public SquareMoveListener(Overlay overlay, Square square){
			_overlay = overlay;
			_passedSquare = square;					
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(buttonPressed){
				if(_startingAreaMove){
					if(_passedSquare == _squareArray[0] || _passedSquare == _squareArray[4]){
						_startSquare = _passedSquare;
						buttonPressed = false;						
					}
					else{
						JOptionPane.showMessageDialog(null,	 "Not a Valid Move, Please select the square to the right, or to the left.");
					}
				}
				else {
					if(_passedSquare.getStackSize() == 0){
						JOptionPane.showMessageDialog(null,	 "Not a Valid Move, Please try again.");
					}
					else{
						_startSquare = _passedSquare;
						buttonPressed = false;
					}				
				}					
			}
			else {
				_endSquare = _passedSquare;
				if(_startingAreaMove){
					if(!_lotus.stackMove(_startSquare, _startStack, _endSquare)){
						JOptionPane.showMessageDialog(null,	 "Not a Valid Move, Please try again.");
					}					
					_startingAreaMove = false;
					updateJButtons();
					buttonPressed = true;
				}
				else{					
					if(!_lotus.squareMove(_startSquare, _endSquare)){
						JOptionPane.showMessageDialog(null,	 "Not a Valid Move, Please try again.");
						buttonPressed = true;
					}
					else{
						updateJButtons();
						buttonPressed = true;
						if(_lotus.getWinner() != null){
							if(_lotus.getWinner() == _lotus.getPlayer1()){
								String winner = "Player 1 wins!";
								JOptionPane.showMessageDialog(null,	 winner);
								System.exit(0);
							}
							else{
								String winner = "Player 2 wins!";
								JOptionPane.showMessageDialog(null,	 winner);
								System.exit(0);
							}							
						}
					}
				}				
				
			}			
		}	
	}
	/**
	 * When a starting area JButton is pressed, this method sets the start stack
	 * 
	 * @param overlay
	 * @param stack
	 * @author sean
	 *
	 */
	public class StackMoveListener implements ActionListener{		
		private Overlay _overlay;
		private Stack<Piece> _passedStack;
		public StackMoveListener(Overlay overlay, Stack<Piece> stack){
			_overlay = overlay;
			_passedStack = stack;			
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!_passedStack.isEmpty() && _passedStack.peek().getPlayer() == _lotus.getCurrentPlayersTurn()){
				_startStack = _passedStack;
				_startingAreaMove = true;
			}
			else{
				JOptionPane.showMessageDialog(null,	 "Not a Valid Move, Please try a different stack.");
			}
									
		}		
	}
	/**
	 * This method is used when skip JButton is pressed and checks to see
	 * if the player has a valid move, if not it sets the current player to 
	 * the other players turn.
	 * @author sean
	 *
	 */
	public class SkipTurnListener implements ActionListener{
		private Overlay _overlay;
		
		public SkipTurnListener(Overlay overlay){
			_overlay = overlay;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Square[] squaresOnBoard = _lotus.getBoard().getSquareArray();
			boolean hasPiece = false;
			for(int i = 0; i < squaresOnBoard.length; i++){
				Piece topPiece = squaresOnBoard[i].getPiece();
				if(topPiece != null && topPiece.getPlayer() == _lotus.getCurrentPlayersTurn()){
					hasPiece = true;
				}			
			}
			if(_lotus.getBoard().getStartArea().hasPiece(_lotus.getCurrentPlayersTurn())){
				hasPiece = true;
			}
			if(!hasPiece){
				if(_lotus.getCurrentPlayersTurn() == _lotus.getPlayer1()){
					_lotus.setCurrentPlayersTurn(_lotus.getPlayer2());
					
				}
				else{
					_lotus.setCurrentPlayersTurn(_lotus.getPlayer1());
				}
			}
			else{
				JOptionPane.showMessageDialog(null,	 "You must move one of your pieces.");
			}
			updateJButtons();
			
		}
		
	}
}
