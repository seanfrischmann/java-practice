package tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import bag.Bag;

/**
 * TODO: fill in comments for SizeTests
 *
 * @author <a href="mailto:alphonce@cse.buffalo.edu">Carl G. Alphonce</a>
 *
 * Created on: Jan 29, 2007
 *
 */
public class ContainsTests{

	private Bag<String> _bag;
	private String _item;

	@Before
	public void setUp() {
		_bag = new Bag<String>();
		_item = "Fred";
	}
	
	@After
	public void tearDown() throws Exception {
		_bag = null;
		_item = null;
	}

	@Test
	public void testEmptyContainsNone() {
		boolean expected = false;
		boolean actual = _bag.contains(_item);
		assertTrue("I checked whether an empty Bag<String> contained \""+_item+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test
	public void testAddThenContains() {
		_bag.add(_item);
		boolean expected = true;
		boolean actual = _bag.contains(_item);
		assertTrue("I added \""+_item+"\" to an empty Bag<String>, and then check whether it contained \""+_item+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test public void testRemoveUsingSize() {
		Bag<String> bag = new Bag<String>();
		String s1 = "Fred1";
		String s2 = "Fred2";
		String s3 = "Fred3";
		bag.add(s1); bag.add(s2); bag.add(s3);
		bag.remove(s2);
		boolean expected = true;
		boolean actual = bag.contains(s3);
		assertTrue("", expected == actual);
	} 

}
