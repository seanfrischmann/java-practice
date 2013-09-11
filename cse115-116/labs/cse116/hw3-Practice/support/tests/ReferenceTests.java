package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ReferenceTests {

	private code.Homework3Practice _class;

	public String hashMapsAreTheSame(HashMap<String,Integer> a, HashMap<String,Integer> b) {
		String diff = "";
		Set<String> aKeySet = a.keySet();
		Set<String> bKeySet = b.keySet();
		if (!aKeySet.equals(bKeySet)) {
			ArrayList<String> al = new ArrayList<String>(aKeySet);
			ArrayList<String> bl = new ArrayList<String>(bKeySet);
			al.removeAll(bKeySet);
			bl.removeAll(aKeySet);
			diff += "\nThe keysets differ: ";
			if (!al.isEmpty()) {
				diff += "\n\t***********************************************************************";
				diff += "\n\tExpected answer has these extra keys (words that your solution missed):"; 
				for (String s : al) {
					diff += "\n\t\t\""+s+"\"";
				}
			}
			if (!bl.isEmpty()) {
				diff += "\n\t**************************************************************************";
				diff += "\n\tComputed answer has these extra keys (non-words that your solution found):"; 
				for (String s : bl) {
					diff += "\n\t\t\""+s+"\"";
				}
			}
		}
		else { // keysets are the same, check counts
			String diffValues = "";
			for (String s : aKeySet) {
				int aCount = a.get(s);
				int bCount = b.get(s);
				if (aCount != bCount) {
					diffValues += "\n\tfor key \""+s+"\", expected count is "+aCount+" while computed count is "+bCount+".";
				}
			}
			if (diffValues.length() != 0) {
				diff = "\nThe computed counts differ as follows:"+diffValues;
			}
		}
		return diff;
	}

	@Before
	public void setup() {
		_class = new code.Homework3Practice();
	}

	@Test public void count_test_01() {
		String s = "SampleInputFiles/SampleTextFile1.txt";
		HashMap<String,Integer> expected = new HashMap<String,Integer>();
		expected.put("This",3);
		expected.put("is",3);
		expected.put("a",3);
		expected.put("file",3);
		expected.put("of",3);
		expected.put("text",3);
		expected.put("on",3);
		expected.put("three",3);
		expected.put("lines",3);
		HashMap<String,Integer> actual = _class.count(s);
		testRunner(expected,actual);
	}

	@Test public void count_test_02() {
		String s = "SampleInputFiles/SampleTextFile2.txt";
		HashMap<String,Integer> expected = new HashMap<String,Integer>();
		HashMap<String,Integer> actual = _class.count(s);
		testRunner(expected,actual);
	}

	@Test public void count_test_03() {
		String s = "SampleInputFiles/SampleTextFile3.txt";
		HashMap<String,Integer> expected = new HashMap<String,Integer>();
		expected.put("Project",2);
		expected.put("Gutenberg's",1);
		expected.put("Gutenberg",1);
		expected.put("Alice's",1);
		expected.put("Adventures",1);
		expected.put("in",1);
		expected.put("Wonderland",1);
		expected.put("by",1);
		expected.put("Lewis",1);
		expected.put("Carroll",1);
		expected.put("This",1);
		expected.put("eBook",2);
		expected.put("is",1);
		expected.put("for",1);
		expected.put("the",3);
		expected.put("use",1);
		expected.put("of",2);
		expected.put("anyone",1);
		expected.put("anywhere",1);
		expected.put("at",2);
		expected.put("no",2);
		expected.put("cost",1);
		expected.put("and",1);
		expected.put("with",2);
		expected.put("almost",1);
		expected.put("restrictions",1);
		expected.put("whatsoever",1);
		expected.put("You",1);
		expected.put("may",1);
		expected.put("copy",1);
		expected.put("it",3);
		expected.put("give",1);
		expected.put("away",1);
		expected.put("or",2);
		expected.put("re-use",1);
		expected.put("under",1);
		expected.put("terms",1);
		expected.put("License",1);
		expected.put("included",1);
		expected.put("this",1);
		expected.put("online",1);
		expected.put("www",1);
		expected.put("gutenberg",1);
		expected.put("org",1);
		HashMap<String,Integer> actual = _class.count(s);
		testRunner(expected,actual);
	}

	@Test public void count_test_04() {
		String s = "SampleInputFiles/SampleTextFile4.txt";
		HashMap<String,Integer> expected = new HashMap<String,Integer>();
		expected.put("the",2);
		expected.put("quick",2);
		expected.put("brown",2);
		HashMap<String,Integer> actual = _class.count(s);
		testRunner(expected,actual);
	}

	@Test public void count_test_05() {
		String s = "SampleInputFiles/SampleTextFile5.txt";
		HashMap<String,Integer> expected = new HashMap<String,Integer>();
		expected.put("\"Aldrig",1);
		expected.put("har",1);
		expected.put("så",1);
		expected.put("många",1);
		expected.put("utställningar",2);
		expected.put("från",1);
		expected.put("ett",2);
		expected.put("och",3);
		expected.put("samma",1);
		expected.put("museum",1);
		expected.put("turnerat",1);
		expected.put("i",3);
		expected.put("resten",1);
		expected.put("av",1);
		expected.put("Europa",1);
		expected.put("konstaterar",1);
		expected.put("Moderna",1);
		expected.put("museet",1);
		expected.put("radar",1);
		expected.put("pressmeddelande",1);
		expected.put("upp",1);
		expected.put("sju",1);
		expected.put("som",1);
		expected.put("är",2);
		expected.put("på",2);
		expected.put("väg",1);
		expected.put("eller",1);
		expected.put("turné",1);
		expected.put("hos",1);
		expected.put("ledande",1);
		expected.put("museer",1);
		expected.put("Spanien",1);
		expected.put("Tyskland",1);
		expected.put("Schweiz",1);
		expected.put("Storbritannien",1);
		expected.put("Finland",1);
		expected.put("Estland",1);
		expected.put("Italien",1);
		expected.put("Frankrike",1);
		expected.put("\"",1);
		expected.put("Source:",1);
		expected.put("http://www",1);
		expected.put("svd",2);
		expected.put("se/kultur/modernas-utstallningar-pa-turne-svdse_7509538",1);
		HashMap<String,Integer> actual = _class.count(s);
		testRunner(expected,actual);
	}

	private void testRunner(HashMap<String, Integer> expected, HashMap<String, Integer> actual) {
		String difference = this.hashMapsAreTheSame(expected, actual);
		assertTrue(difference, difference.equals(""));
	}

}
