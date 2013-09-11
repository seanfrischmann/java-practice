package example1;

public class Butterfly extends ButterflyParent {

	public Butterfly() {
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
