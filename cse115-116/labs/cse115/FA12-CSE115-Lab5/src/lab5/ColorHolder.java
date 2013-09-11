package lab5;

import java.awt.Color;


public class ColorHolder {
	 
	private Color _c;
	
	public ColorHolder() {
		_c = java.awt.Color.WHITE;
	}
	public void setColor(Color c){
		_c = c;
	}
	public Color getColor() {
		return _c;
	}
}
