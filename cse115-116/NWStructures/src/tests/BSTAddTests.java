package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import trees.BSTArray;

public class BSTAddTests {

	@Test public void test_01() {
		BSTArray<Integer> tree = new BSTArray<Integer>();
		tree.insert(0);
		int expected = 1;
		int actual = tree.size();
		assertTrue("", expected == actual);
	}

	@Test public void test_02() {
		BSTArray<Integer> tree = new BSTArray<Integer>();
		int value = 0;
		tree.insert(value);
		assertTrue("", tree.member(value));
	}

	@Test public void test_03() {
		BSTArray<Integer> tree = new BSTArray<Integer>();
		int v0 = 4;
		int v1 = 2;
		int v2 = 1;
		int v3 = 3;
		int v4 = 6;
		int v5 = 5;
		int v6 = 7;
		tree.insert(v0).insert(v1).insert(v2).insert(v3).insert(v4).insert(v5).insert(v6);
		assertTrue("", tree.member(v0) 
				&& tree.member(v1)
				&& tree.member(v2)
				&& tree.member(v3)
				&& tree.member(v4)
				&& tree.member(v5)
				&& tree.member(v6)
		);
	}

}
