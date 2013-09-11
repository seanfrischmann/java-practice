package game;

/**
 * This class defines the SpecialSquare object
 * The SpecialSquare extends from the Square class
 * <p>
 * @author Sean
 */
public class SpecialSquare extends Square {
	/**
	 * The constructor of SpecialSquare takes an int
	 * This int is the represents the height of a Stack 
	 * Then this height is assigned to a variable
	 * <p>
	 * @author Sean  
	 */
	private int _startingHeight;
	
	public SpecialSquare(int startingHeight){
		_startingHeight = startingHeight;
	}
	
	@Override
	public int getHeight(){
		return _startingHeight + super.getHeight();
	}

}
