package ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Board;
import model.Position;
import model.StartPosition;

public class Game implements Runnable, ActionListener {
	
	private ArrayList<JButton> _buttons;
	private Board _board;
	
	public Game() {
		_board = new Board();
		_board.setActionListener(this);
	}
	
	@Override public void run() {
		JFrame window = new JFrame("Stage 1");
		Container c = window.getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.X_AXIS));

		JPanel start = new JPanel();
		start.setLayout(new BoxLayout(start, BoxLayout.Y_AXIS));

		JPanel startRed = new JPanel();
		startRed.setLayout(new BoxLayout(startRed, BoxLayout.X_AXIS));

		JPanel startBlue = new JPanel();
		startBlue.setLayout(new BoxLayout(startBlue, BoxLayout.X_AXIS));

		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

		JPanel upperLeft = new JPanel();
		upperLeft.setLayout(new BoxLayout(upperLeft, BoxLayout.X_AXIS));

		JPanel lowerLeft = new JPanel();
		lowerLeft.setLayout(new BoxLayout(lowerLeft, BoxLayout.X_AXIS));

		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.X_AXIS));

		c.add(start);
		c.add(left);
		c.add(right);
		start.add(startRed);
		start.add(startBlue);
		left.add(upperLeft);
		left.add(lowerLeft);
		
		_buttons = new ArrayList<JButton>();
		for (int i=0; i<4; i++) {
			createStartButton(startRed, _board.getRedStart(i));
			createStartButton(startBlue, _board.getBlueStart(i));
		}
		for (int i=0; i<3; i++) {
			createTrackButton(upperLeft, _board.getLeft(i));
			createTrackButton(lowerLeft, _board.getRight(i));
		}
		for (int i=3; i<13; i++) {
			createTrackButton(right, _board.getCommon(i));
		}
		
		update(_board.getBoard());
				
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
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
			_buttons.get(i).setText(board.get(i));
		}
	}

}
