package code;

public class Lab4 {
	
	private Record _rec1;
	private Record _rec2;
	
	public Lab4() {
		this._rec1 = new Record();
		this._rec2 = new Record();
	}
	
	public void mystery() {
		this._rec2 = new Record();
	}
	
	public void swap() {
		Record temp;
		temp = this._rec1;
		this._rec1 = _rec2;
		this._rec2 = temp;
	}

}
