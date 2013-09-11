package lab5;

public class SquareButton {
	private supportcode.Window _W;
	private ColorHolder _ch;
	
	public SquareButton(supportcode.Window w,ColorHolder ch) {
		_W =w;
		_ch=ch;
	}
	public void buttonPressed(){
		supportcode.Square sq = new supportcode.Square(_ch);
		sq.setColor(_ch.getColor());
		_W.addSquare(sq);
		
	}
}
