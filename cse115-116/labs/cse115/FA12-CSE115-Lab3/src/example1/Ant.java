package example1;

public class Ant extends AntParent {

	public Ant() {
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
