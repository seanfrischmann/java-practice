package model;

import java.awt.Color;

public class Player {

	private Color _color;
	private int _score;
	private String _name;
	
	public Player(Color c, String name) {
		_color = c;
		_score = 0;
		_name = name;
	}

	public Color getColor() {
		return _color;
	}

	public String getName() {
		return _name;
	}

	public int getScore() {
		return _score;
	}

	public void setScore(int score) {
		this._score = score;
	}

}
