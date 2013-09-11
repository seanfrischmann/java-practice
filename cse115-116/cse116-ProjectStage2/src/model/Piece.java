package model;



public class Piece {
	
	private String _string;
	private Player _player;
	private Position[] _track;
	private Position _startingPostion;

	public Piece(String s, Player p, Position sp) {
		_string = s;
		_player = p;
		_startingPostion = sp;
	}
	
	public void setTrack(Position[] track) {
		_track = track;
	}
	
	@Override public String toString() {
		return _string;
	}

	public Position[] getTrack() {
		return _track;
	}

	public Player getPlayer() {
		return _player;
	}

	public Position getStartingPostion() {
		return _startingPostion;
	}
}
