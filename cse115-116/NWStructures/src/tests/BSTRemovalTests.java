package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import trees.BSTArray;
import trees.BSTBRStruct;

public class BSTRemovalTests {
	
	private BSTArray<Integer> _tree;
	private BSTBRStruct<Integer> _t2;
	private int[] _values;
	
	@Before public void setUp() {
		_tree = new BSTArray<Integer>();
		_t2 = new BSTBRStruct<Integer>();
		_values = new int[] {50, 30, 10, 20, 70, 60, 80, 90, 5, 15, 25, 35, 45, 55, 65, 75, 85, 95};
		for (int x : _values) {
			_tree.insert(x);
			_t2.insert(x);
		}
	}

	public void test(int index) {
//		System.out.println("Before: "+_tree.toString());
		_tree.remove(_values[index]);
//		System.out.println("After removing "+_values[index]+": "+_tree.toString());
		_t2.remove(_values[index]);
		assertFalse("", _tree.member(_values[index]));
	}
	
	public void testShape(int index) {
		_tree.remove(_values[index]);
		_t2.remove(_values[index]);
//		System.out.println(_tree);
//		System.out.println(_t2);
		assertTrue("", _tree.toString().equals(_t2.toString()));
	}
	
	public void testShape2(int value) {
		_tree.remove(value);
		_t2.remove(value);
		assertTrue("", _tree.toString().equals(_t2.toString()));
	}
	
	@Test public void test_00() { test( 0); }
	@Test public void test_01() { test( 1); }
	@Test public void test_02() { test( 2); }
	@Test public void test_03() { test( 3); }
	@Test public void test_04() { test( 4); }
	@Test public void test_05() { test( 5); }
	@Test public void test_06() { test( 6); }
	@Test public void test_07() { test( 7); }
	@Test public void test_08() { test( 8); }
	@Test public void test_09() { test( 9); }
	@Test public void test_10() { test(10); }
	@Test public void test_11() { test(11); }
	@Test public void test_12() { test(12); }
	@Test public void test_13() { test(13); }
	@Test public void test_14() { test(14); }
	@Test public void test_15() { test(15); }
	@Test public void test_16() { test(16); }
	@Test public void test_17() { test(17); }

	@Test public void test_20() { testShape( 0); }
	@Test public void test_21() { testShape( 1); }
	@Test public void test_22() { testShape( 2); }
	@Test public void test_23() { testShape( 3); }
	@Test public void test_24() { testShape( 4); }
	@Test public void test_25() { testShape( 5); }
	@Test public void test_26() { testShape( 6); }
	@Test public void test_27() { testShape( 7); }
	@Test public void test_28() { testShape( 8); }
	@Test public void test_29() { testShape( 9); }
	@Test public void test_30() { testShape(10); }
	@Test public void test_31() { testShape(11); }
	@Test public void test_32() { testShape(12); }
	@Test public void test_33() { testShape(13); }
	@Test public void test_34() { testShape(14); }
	@Test public void test_35() { testShape(15); }
	@Test public void test_36() { testShape(16); }
	@Test public void test_37() { testShape(17); }

	@Test public void test_40() { testShape2(-10); }
}
