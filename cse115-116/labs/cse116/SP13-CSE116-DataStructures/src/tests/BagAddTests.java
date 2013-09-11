package tests;

import static org.junit.Assert.assertTrue;

import javax.swing.JLabel;

import org.junit.Test;

import bag.Bag;

public class BagAddTests {

	@Test public void testAddUsingSize() {
		Bag<String> b = new Bag<String>();
		String s = "Fred";
		b.add(s);
		int expected = 1;
		int actual = b.size();
		assertTrue("I added \""+s+
			"\" to an initially empty Bag<String>, "+
			"expecting its size to be "+expected+
			", but it was "+actual,
		expected == actual);
	}

	@Test public void testAddUsingSize_2() {
		Bag<JLabel> b = new Bag<JLabel>();
		JLabel s = new JLabel();
		b.add(s);
		int expected = 1;
		int actual = b.size();
		assertTrue("I added \""+s+
			"\" to an initially empty Bag<JLabel>, "+
			"expecting its size to be "+expected+
			", but it was "+actual,
		expected == actual);
	}

	@Test public void testAddDuplicateUsingSize() {
		Bag<String> b = new Bag<String>();
		String s = "Fred";
		b.add(s);
		b.add(s);
		int expected = 2;
		int actual = b.size();
		assertTrue("I added \""+s+
			"\" twice to an initially empty Bag<String>, "+
			"expecting its size to be "+expected+
			", but it was "+actual,
		expected == actual);
	}

	@Test public void testAddUsingContains() {
		Bag<String> b = new Bag<String>();
		String s = "Fred";
		b.add(s);
		boolean expected = true;
		boolean actual = b.contains(s);
		assertTrue("I added \""+s+
			"\" to an initially empty Bag<String>, "+
			"expecting it to be there, but it wasn't.",
		expected == actual);
	}

	@Test
	public void addOneStringSize() {
		Bag<String> b = new Bag<String>();
		String s = "";
		b.add(s);
		int expected = 1;
		int actual = b.size();
		assertTrue("I added one item to the Bag, expecting its size to be "+expected+", but its size was "+actual, actual == expected);
	}

	@Test
	public void addOneStringTwiceSize() {
		Bag<String> b = new Bag<String>();
		String s = "";
		b.add(s);
		b.add(s);
		int expected = 2;
		int actual = b.size();
		assertTrue("I added one item to the Bag twice, expecting its size to be "+expected+", but its size was "+actual, actual == expected);
	}

	@Test
	public void addTwoStringsSize() {
		Bag<String> b = new Bag<String>();
		String s = "one";
		String t = "two";
		b.add(s);
		b.add(t);
		int expected = 2;
		int actual = b.size();
		assertTrue("I added two items to the Bag, expecting its size to be "+expected+", but its size was "+actual, actual == expected);
	}

	@Test
	public void addManyStringsSize() {
		Bag<String> b = new Bag<String>();
		String s = "one";
		int expected = 2000000;
		for (int i=0; i<expected; i++) {
			b.add(s);
		}
		int actual = b.size();
		assertTrue("I added "+expected+" items to the Bag, expecting its size to be "+expected+", but its size was "+actual, actual == expected);
	}




}
