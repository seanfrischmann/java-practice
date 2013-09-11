package example1;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		example1.Terrarium t = new example1.Terrarium();
		example1.Caterpillar c1 = new example1.Caterpillar();
		example1.Ant a1 = new example1.Ant();
		example1.Caterpillar c2 = new example1.Caterpillar();
		example1.Ant a2 = new example1.Ant();
		
		t.add(c1);
		t.add(c2);
		t.add(a1);
		t.add(a2);
		
		c1.start();
		c2.start();
		a1.start();
		a2.start();
	}

}
