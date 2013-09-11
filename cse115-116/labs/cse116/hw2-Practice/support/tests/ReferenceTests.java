package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ReferenceTests {
	
	private code.Homework2Practice _class;
	
	@Before
	public void setup() {
		_class = new code.Homework2Practice();
	}
	
	@Test
	public void count_all_test_01() {
		String s = "abcde";
		int[] expected = {1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] actual = _class.countAll(s);
		assertTrue("Calling countAll with argument \""+s+"\" I expected the result to be "+array2String(expected)+", but instead it was "+array2String(actual),
				arrayEquals(expected,actual));
	}

	@Test
	public void count_all_test_02() {
		String s = "ABCDE";
		int[] expected = {1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] actual = _class.countAll(s);
		assertTrue("Calling countAll with argument \""+s+"\" I expected the result to be "+array2String(expected)+", but instead it was "+array2String(actual),
				arrayEquals(expected,actual));
	}

	@Test
	public void count_all_test_03() {
		String s = "aaAAbbBBccCCddDDeeEE";
		int[] expected = {4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] actual = _class.countAll(s);
		assertTrue("Calling countAll with argument \""+s+"\" I expected the result to be "+array2String(expected)+", but instead it was "+array2String(actual),
				arrayEquals(expected,actual));
	}

	@Test
	public void count_all_test_04() {
		String s = "!@#$%^&*()_-+={[}]:;\"'<,>.?/\\|~`";
		int[] expected = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,s.length()};
		int[] actual = _class.countAll(s);
		assertTrue("Calling countAll with argument \""+s+"\" I expected the result to be "+array2String(expected)+", but instead it was "+array2String(actual),
				arrayEquals(expected,actual));
	}

	@Test
	public void count_all_test_05() {
		String s = "The quick brown fox!";
		int[] expected = {0,1,1,0,1,1,0,1,1,0,1,0,0,1,2,0,1,1,0,1,1,0,1,1,0,0,4};
		int[] actual = _class.countAll(s);
		assertTrue("Calling countAll with argument \""+s+"\" I expected the result to be "+array2String(expected)+", but instead it was "+array2String(actual),
				arrayEquals(expected,actual));
	}

	@Test
	public void smallest_test_01() {
		int[] a = {12, 5, 15, 9, 10, 3, 14};
		int expected = 3;
		int actual = _class.smallest(a);
		assertTrue("Calling smallest with argument "+array2String(a)+" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	@Test
	public void smallest_test_02() {
		int[] a = {4, 5, 15, 9, 10, 4, 14};
		int expected = 4;
		int actual = _class.smallest(a);
		assertTrue("Calling smallest with argument "+array2String(a)+" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	@Test
	public void smallest_test_03() {
		int[] a = {4, 5, 15, 9, 10, -4, 14};
		int expected = -4;
		int actual = _class.smallest(a);
		assertTrue("Calling smallest with argument "+array2String(a)+" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	@Test
	public void smallest_test_04() {
		int[] a = {-4, -5, -15, -9, -10, -4, -14};
		int expected = -15;
		int actual = _class.smallest(a);
		assertTrue("Calling smallest with argument "+array2String(a)+" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	@Test
	public void smallest_test_05() {
		int[] a = {7};
		int expected = 7;
		int actual = _class.smallest(a);
		assertTrue("Calling smallest with argument "+array2String(a)+" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	@Test
	public void index_of_smallest_test_01() {
		int[] a = {12, 5, 15, 9, 10, 3, 14};
		int expected = 5;
		int actual = _class.indexOfSmallest(a);
		assertTrue("Calling smallest with argument "+array2String(a)+" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	@Test
	public void index_of_smallest_test_02() {
		int[] a = {4, 5, 15, 9, 10, 4, 14};
		int expected = 0;
		int actual = _class.indexOfSmallest(a);
		assertTrue("Calling smallest with argument "+array2String(a)+" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	@Test
	public void index_of_smallest_test_03() {
		int[] a = {4, 5, 15, 9, 10, -4, 14};
		int expected = 5;
		int actual = _class.indexOfSmallest(a);
		assertTrue("Calling smallest with argument "+array2String(a)+" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	@Test
	public void index_of_smallest_test_04() {
		int[] a = {-4, -5, -15, -9, -10, -4, -14};
		int expected = 2;
		int actual = _class.indexOfSmallest(a);
		assertTrue("Calling smallest with argument "+array2String(a)+" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	@Test
	public void index_of_smallest_test_05() {
		int[] a = {7};
		int expected = 0;
		int actual = _class.indexOfSmallest(a);
		assertTrue("Calling smallest with argument "+array2String(a)+" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	private boolean arrayEquals(int[] expected, int[] actual) {
		if (expected.length != actual.length) {
			return false;
		}
		for (int i=0; i<expected.length; i++) {
			if (expected[i] != actual[i]) {
				return false;
			}
		}
		return true;
	}

	private String array2String(int[] expected) {
		StringBuffer sb = new StringBuffer();
		sb.append("[ ");
		for (int i : expected) {
			sb.append(i);
			sb.append(", ");
		}
		sb.deleteCharAt(sb.length()-2);
		sb.append("]");
		return sb.toString();
	}

}
