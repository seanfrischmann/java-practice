package lab5;

import java.awt.Color;

public class ColorButton {
	
	private Color _c;
	private ColorHolder _ch;
	
	public ColorButton(Color c, ColorHolder ch) {
		_c =c;
		_ch =ch;
	}
	
	public void buttonPressed() {
		_ch.setColor(_c);
	}
}
