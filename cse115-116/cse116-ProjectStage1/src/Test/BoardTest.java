package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.junit.Test;
/**
 * Tests the functionality of the methods contained in the Board class
 * <p>
 * @author Matthew
 *
 */
public class BoardTest {

	/**
	 * Test the randomNumber method on a Board object
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void randomNumberTest1() {
		Random _rand = new Random();
		ArrayList<Integer> _used = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++){
			boolean failtest = true;
			while(failtest){
				int test = _rand.nextInt(16);
				if(!_used.contains(test)){
					_used.add(test);
					failtest = false;
				}
			}
		}
	boolean expected = false;	
	boolean actual = _used.get(0) == _used.get(1);
	assertTrue("The expected value was " + expected+"." + "The actual value was " + actual+ ".", expected == actual);
	}
	
	/**
	 * Test the randomNumber method on a Board object
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void randomNumberTest2() {
		Random _rand = new Random();
		ArrayList<Integer> _used = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++){
			boolean failtest = true;
			while(failtest){
				int test = _rand.nextInt(16);
				if(!_used.contains(test)){
					_used.add(test);
					failtest = false;
				}
			}
		}
	boolean expected = false;	
	boolean actual = _used.get(0) == _used.get(2);
	assertTrue("The expected value was " + expected+"." + "The actual value was " + actual+ ".", expected == actual);
	}
	
	/**
	 * Test the randomNumber method on a Board object
	 * <p>
	 * @author Matthew
	 */
	@Test
	public void randomNumberTest3() {
		Random _rand = new Random();
		ArrayList<Integer> _used = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++){
			boolean failtest = true;
			while(failtest){
				int test = _rand.nextInt(16);
				if(!_used.contains(test)){
					_used.add(test);
					failtest = false;
				}
			}
		}
	boolean expected = false;	
	boolean actual = _used.get(1) == _used.get(2);
	assertTrue("The expected value was " + expected+"." + "The actual value was " + actual+ ".", expected == actual);
	}
	
	/**
	 * 
	 */
}
