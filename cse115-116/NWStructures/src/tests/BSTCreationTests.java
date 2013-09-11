package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import trees.BSTArray;

public class BSTCreationTests {

	@Test public void test_01() {
		BSTArray<Integer> tree = new BSTArray<Integer>();
		int expected = 0;
		int actual = tree.size();
		assertTrue("", expected == actual);
	}

	@Test public void test_02() {
		BSTArray<Integer> tree = new BSTArray<Integer>();
		assertTrue("", tree.isEmpty());
	}

}
