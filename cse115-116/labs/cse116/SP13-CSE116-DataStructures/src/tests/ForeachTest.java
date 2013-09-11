package tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import bag.Bag;

public class ForeachTest {

	@Test
	public void foreach() {
		Bag<String> b = new Bag<String>();
		b.add("Fred");
		b.add("Wilma");
		for (String s : b) {
			System.out.println(s);
		}
		assertTrue(true);
	}

}
