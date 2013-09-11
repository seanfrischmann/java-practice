package lab5;

public class SimpleDraw {
	private supportcode.Window _W;
	private ColorHolder _ch;
	private SquareButton _sb;
	private CircleButton _cb;
	private ColorButton _cl1;
	private ColorButton _cl2;
	private ColorButton _cl3;
	
	public SimpleDraw() {
		_W = new supportcode.Window();
		_ch = new ColorHolder();
		_sb = new SquareButton(_W, _ch);
		_cb = new CircleButton(_W, _ch);
		_cl1 = new ColorButton(java.awt.Color.RED, _ch);
		_cl2 = new ColorButton(java.awt.Color.BLUE, _ch);
		_cl3 = new ColorButton(java.awt.Color.ORANGE, _ch);
		_W.addSquareButton(_sb);
		_W.addCircleButton(_cb);
		_W.addColorButton(_cl1);
		_W.addColorButton(_cl2);
		_W.addColorButton(_cl3);

	}
	
}
