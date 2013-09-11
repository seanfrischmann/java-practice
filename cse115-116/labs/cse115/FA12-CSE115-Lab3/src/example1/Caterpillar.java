package example1;

public class Caterpillar extends CaterpillarParent {

	public Caterpillar() {
		super();
		createTimer(this);
	}
	
	public void start() {
		startTimer();
	}

	public void stop() {
		stopTimer();
	}


}
