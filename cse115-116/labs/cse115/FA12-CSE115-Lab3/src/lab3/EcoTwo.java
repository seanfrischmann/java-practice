package lab3;

public class EcoTwo {
private example1.Terrarium _t1;
private example1.Terrarium _t2;
	public EcoTwo() {
		_t1 = new example1.Terrarium();
		_t2 = new example1.Terrarium();
	}
	public void addAnt() {
		example1.Ant a = new example1.Ant();
		_t1.add(a);
		a.start();
		example1.Terrarium temp;
		temp = _t1;
		_t1 = _t2;
		_t2 = temp;
	}
	public void addButterfly() {
		example1.Butterfly b = new example1.Butterfly();
		_t1.add(b);
		b.start();
		example1.Terrarium temp;
		temp = _t1;
		_t1 = _t2;
		_t2 = temp;
	}
	public void addCaterpillar() {
		example1.Caterpillar c = new example1.Caterpillar();
		_t1.add(c);
		c.start();
		example1.Terrarium temp;
		temp = _t1;
		_t1 = _t2;
		_t2 = temp;
	}
}
