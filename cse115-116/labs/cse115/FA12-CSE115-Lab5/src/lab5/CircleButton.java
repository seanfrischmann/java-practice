package lab5;

public class CircleButton {
	private supportcode.Window _W;
	private ColorHolder _ch;
	
	public CircleButton(supportcode.Window w, ColorHolder ch){
		_W =w;
		_ch =ch;
	}
	public void buttonPressed(){
		supportcode.Circle cr = new supportcode.Circle(_ch);
		cr.setColor(_ch.getColor());
		_W.addCircle(cr);
		
	}
}
