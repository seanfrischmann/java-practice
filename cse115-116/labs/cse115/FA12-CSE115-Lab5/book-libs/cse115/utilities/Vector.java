package cse115.utilities;

/**
 * 
 * TODO: Fill in comments for Vector
 * 
 * @author <a href="mailto:kozelsky@cse.buffalo.edu">Michael Kozelsky</a>
 * 
 * Created on: Jul 28, 2006
 * 
 * 
 * Vector.java
 */
public class Vector {

	/** The scalar representing the difference in the X direction * */
	private Integer _dx;

	/** The scalar representing the difference in the Y direction * */
	private Integer _dy;

	/**
	 * Creates a new instance of Vector with the given change in X and Y
	 * 
	 * @param dx
	 *            The difference in the X direction
	 * @param dy
	 *            The difference in the Y direction
	 */
	public Vector(Integer dx, Integer dy) {
		_dx = dx;
		_dy = dy;
	}

	/**
	 * Gets the Integer representing the change in the X direction of this
	 * vector
	 * 
	 * @return An Integer representing the change in X
	 */
	public Integer getDx() {
		return _dx;
	}

	/**
	 * Gets the Integer representing the change in the Y direction of this
	 * vector
	 * 
	 * @return An Integer representing the change in Y
	 */
	public Integer getDy() {
		return _dy;
	}

	/**
	 * Sets the change in the X direction of this Vector
	 * 
	 * @param dx
	 *            The new difference in the X direction
	 */
	public void setDx(Integer dx) {
		_dx = dx;
	}

	/**
	 * Sets the change in the Y direction of this Vector
	 * 
	 * @param dy
	 *            The new difference in the Y direction
	 */
	public void setDy(Integer dy) {
		_dy = dy;
	}

}
