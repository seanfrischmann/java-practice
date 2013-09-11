package cse115.utilities;

/**
 * 
 * TODO: Fill in comments for Random
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 27, 2006
 * 
 * 
 * Random.java
 */
public class Random {

	/**
	 * Creates a random color
	 * 
	 * @return a random <code>java.awt.Color</code>
	 */
	public static java.awt.Color randomColor() {
		int r, g, b;
		r = randomInteger(0, 255);
		g = randomInteger(0, 255);
		b = randomInteger(0, 255);
		return new java.awt.Color(r, g, b);
	}

	/**
	 * Picks a random number between low and high (inclusive)
	 * 
	 * @param low
	 *            the low bound of the random number
	 * @param high
	 *            the high bound of the random number
	 * @return a random number inbetween the given values (inclusive)
	 */
	public static Integer randomInteger(Integer low, Integer high) {
		int range = high - low + 1; // add one to include both endpoints
		return low + (int) (Math.random() * range); // add low to translate
	}

	/**
	 * Creates a random dimension where the height and width are between the
	 * given values (inclusive). The width and height are determined separately -
	 * meaning this will not always return a dimension where the width and
	 * height are the same.
	 * 
	 * @param low
	 *            the low bound of the width and height value
	 * @param high
	 *            the high bound of the width and height value
	 * @return a random dimension where the height and width are values between
	 *         low and high
	 */
	public static java.awt.Dimension randomDimension(Integer low, Integer high) {
		int width = cse115.utilities.Random.randomInteger(low, high);
		int height = cse115.utilities.Random.randomInteger(low, high);
		return new java.awt.Dimension(width, height);
	}
}
