package lab3;

public class EcoOne {
private example1.Terrarium _t;
	public EcoOne() {
		_t = new example1.Terrarium();
	}
	public void addAnt() {
		example1.Ant a = new example1.Ant();
		_t.add(a);
		a.start();
	}
	public void addButterfly() {
		example1.Butterfly b = new example1.Butterfly();
		_t.add(b);
		b.start();
	}
	public void addCaterpillar() {
		example1.Caterpillar c = new example1.Caterpillar();
		_t.add(c);
		c.start();
	}
}
