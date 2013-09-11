package tests;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import bag.Bag;

public class IteratorTests {

	private Iterator<String> _itE;
	private Iterator<String> _itNE;
	
	@Before
	public void setup() {
		Bag<String> b1 = new Bag<String>();
		_itE = b1.iterator();
		Bag<String> b2 = new Bag<String>();
		b2.add("Fred");
		b2.add("Wilma");
		b2.add("Pebbles");
		_itNE = b2.iterator();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void callingNextOnEmpty() {
		_itE.next();
	}

	@Test(expected=NoSuchElementException.class)
	public void callingNextAtEnd() {
		while (_itNE.hasNext()) {
			_itNE.next();
		}
		_itNE.next();
	}

	@Test(expected=UnsupportedOperationException.class)
	public void callingRemove() {
		_itNE.remove();
	}
}
