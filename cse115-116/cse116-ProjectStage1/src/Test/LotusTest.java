package Test;

import static org.junit.Assert.*;

import java.awt.Color;

import game.Board;
import game.Player;

import org.junit.Before;
import org.junit.Test;

public class LotusTest {
	
	private game.Lotus _l;
	private Player _player1;
	private Player _player2;
	private Board _b;

	@Before
	public void setUp(){
		
	}
	@Test
	
	// Checks if the colors are assigned to the correct players
	public void test1() {
		_player1 = new Player(Color.RED);
		_player2 = new Player(Color.BLUE);
		assertTrue("", _player1.getColor() == Color.RED);
		assertTrue("", _player2.getColor() == Color.BLUE);
	}
	@Test
	//Makes sure that the end stack of player 1 is not already 10, which would make him the winner
	public void test2() {
		_b = new Board(_player1, _player2);
		int hi = _b.getEndSquare().getPlayersEndStack(_player1);
		assertTrue("", hi == 0);
	}
	@Test
	//Makes sure that the end stack of player 2 is not already 10, which would make him the winner
	public void test3() {
		_b = new Board(_player1, _player2);
		int ho = _b.getEndSquare().getPlayersEndStack(_player2);
		assertTrue("", ho == 0);
	}
	@Test
	//tests to see if the winner method works for player 1. The setWinner method checks to see if player 1's end stack is 10 and if so sets him to be the winner.
	public void test4() {
		int hy = _b.getEndSquare().getStackSize();
		if ( hy == 10) {
			_l.setWinner(_player1);
		}
		Player expected = _player1; 
		Player actual = _l.getWinner();
		assertTrue("", actual == expected);
	}
	@Test
	//tests to see if the winner method works for player 2. The setWinner method checks to see if player 2's end stack is 10 and if so sets him to be the winner.
	public void test5() {
		int hp = _b.getEndSquare().getPlayersEndStack(_player2) + 10;
		if ( hp == 10) {
			_l.setWinner(_player2);
		}
		assertTrue("", _l.getWinner() == _player2);
	}
		
	/*	//game.Lotus.startGame();
		
		Player p1 = new Player(Color.red);
		Player p2 = new Player(Color.blue);
		
		assertTrue("", p1.getColor() == Color.RED);
		assertTrue("", p2.getColor() == Color.BLUE);*/
	}


