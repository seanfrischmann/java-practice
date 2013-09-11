package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ReferenceTests {
	
	private code.Homework1Practice _class;
	
	private void count_e_test(String arg0, int expected) {
		int actual = _class.count_e(arg0);
		assertTrue("Calling count_e with argument \""+arg0+"\" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	private void count_f_test(String arg0, int expected) {
		int actual = _class.count_f(arg0);
		assertTrue("Calling count_f with argument \""+arg0+"\" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	private void count_one_char_test(String arg0, char arg1, int expected) {
		int actual = _class.count_one_char(arg0, arg1);
		assertTrue("Calling count_one_char with arguments \""+arg0+"\" and \'"+arg1+"\' I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	private void count_two_chars_test(String arg0, char arg1, char arg2, int expected) {
		int actual = _class.count_two_chars(arg0, arg1, arg2);
		assertTrue("Calling count_two_chars with arguments \""+arg0+"\", \'"+arg1+"\' and \'"+arg1+"\' I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	private void count_chars_in_String_test(String arg0, String arg1, int expected) {
		int actual = _class.count_chars_in_String(arg0, arg1);
		assertTrue("Calling count_chars_in_String with arguments \""+arg0+"\" and \""+arg1+"\" I expected the result to be "+expected+", but instead it was "+actual,
				expected == actual);
	}

	@Before public void setup() {
		_class = new code.Homework1Practice();
	}
	
	@Test public void count_e_test_00() { count_e_test("", 0); }
	@Test public void count_e_test_01() { count_e_test("abcdef", 1); }
	@Test public void count_e_test_02() { count_e_test("farfalle", 1); }
	@Test public void count_e_test_03() { count_e_test("eee", 3); }
	@Test public void count_e_test_04() { count_e_test("xxxeeexxx", 3); }
	@Test public void count_e_test_05() { count_e_test("xexexexe", 4); }
	@Test public void count_e_test_06() { count_e_test("forever", 2); }
	@Test public void count_e_test_07() { count_e_test("EEE", 0); }
	@Test public void count_e_test_08() { count_e_test("EeE", 1); }
	@Test public void count_e_test_09() { count_e_test("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_-+={}[]:;\\|\"'<>,.?/`~", 1); }
		
	@Test public void count_f_test_00() { count_f_test("", 0); }
	@Test public void count_f_test_01() { count_f_test("abcdef", 1); }
	@Test public void count_f_test_02() { count_f_test("farfalle", 2); }
	@Test public void count_f_test_03() { count_f_test("fff", 3); }
	@Test public void count_f_test_04() { count_f_test("xxxfffxxx", 3); }
	@Test public void count_f_test_05() { count_f_test("xfxfxfxf", 4); }
	@Test public void count_f_test_06() { count_f_test("forever", 1); }
	@Test public void count_f_test_07() { count_f_test("FFF", 0); }
	@Test public void count_f_test_08() { count_f_test("FfF", 1); }
	@Test public void count_f_test_09() { count_f_test("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_-+={}[]:;\\|\"'<>,.?/`~", 1); }

	@Test public void count_one_char_test_00() { count_one_char_test("", 'e', 0); }
	@Test public void count_one_char_test_01() { count_one_char_test("", 'f', 0); }
	@Test public void count_one_char_test_02() { count_one_char_test("abcdef", 'e', 1); }
	@Test public void count_one_char_test_03() { count_one_char_test("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_-+={}[]:;\\|\"'<>,.?/`~", 'R', 1); }
	@Test public void count_one_char_test_04() { count_one_char_test("eEe", 'e', 2); }
	@Test public void count_one_char_test_05() { count_one_char_test("fFf", 'f', 2); }
	@Test public void count_one_char_test_06() { count_one_char_test("forever", 'e', 2); }
	@Test public void count_one_char_test_07() { count_one_char_test("forever", 'f', 1); }
	@Test public void count_one_char_test_08() { count_one_char_test("forever", 'g', 0); }
	@Test public void count_one_char_test_09() { count_one_char_test("FOREVER", 'R', 2); }

	@Test public void count_two_chars_test_00() { count_two_chars_test("", 'e', 'f', 0); }
	@Test public void count_two_chars_test_01() { count_two_chars_test("abcdef", 'a', 'b', 2); }
	@Test public void count_two_chars_test_02() { count_two_chars_test("abcdef", 'e', 'z', 1); }
	@Test public void count_two_chars_test_03() { count_two_chars_test("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_-+={}[]:;\\|\"'<>,.?/`~", 'r', 'R', 2); }
	@Test public void count_two_chars_test_04() { count_two_chars_test("forever", 'e', 'e', 4); }
	@Test public void count_two_chars_test_05() { count_two_chars_test("fFf", 'f', 'F', 3); }
	@Test public void count_two_chars_test_06() { count_two_chars_test("forever", 'v', 'R', 1); }
	@Test public void count_two_chars_test_07() { count_two_chars_test("forever", 'V', 'r', 2); }
	@Test public void count_two_chars_test_08() { count_two_chars_test("forever", 'V', 'R', 0); }
	@Test public void count_two_chars_test_09() { count_two_chars_test("FOREVER", 'V', 'R', 3); }

	@Test public void count_chars_in_String_test_00() { count_chars_in_String_test("", "ef", 0); }
	@Test public void count_chars_in_String_test_01() { count_chars_in_String_test("abcdef", "ab", 2); }
	@Test public void count_chars_in_String_test_02() { count_chars_in_String_test("abcdef", "ez", 1); }
	@Test public void count_chars_in_String_test_03() { count_chars_in_String_test("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_-+={}[]:;\\|\"'<>,.?/`~", "rR", 2); }
	@Test public void count_chars_in_String_test_04() { count_chars_in_String_test("forever", "ee", 4); }
	@Test public void count_chars_in_String_test_05() { count_chars_in_String_test("fFf", "fF", 3); }
	@Test public void count_chars_in_String_test_06() { count_chars_in_String_test("forever", "vR", 1); }
	@Test public void count_chars_in_String_test_07() { count_chars_in_String_test("forever", "Vr", 2); }
	@Test public void count_chars_in_String_test_08() { count_chars_in_String_test("forever", "VR", 0); }
	@Test public void count_chars_in_String_test_09() { count_chars_in_String_test("FOREVER", "FOREVER", 11); }

}
