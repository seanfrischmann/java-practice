package lab2;

public class EcoSystem {

	public EcoSystem() {
		example1.Terrarium t;
		t = new example1.Terrarium();
		example1.Caterpillar c1;
		example1.Caterpillar c2;
		c1 = new example1.Caterpillar();
		c2 = new example1.Caterpillar();
		t.add(c1);
		t.add(c2);
		example1.Ant a1;
		a1 = new example1.Ant();
		t.add(a1);
		example1.Butterfly b1;
		example1.Butterfly b2;
		b1 = new example1.Butterfly();
		b2 = new example1.Butterfly();
		t.add(b1);
		t.add(b2);
		c1.start();
		a1.start();
		b1.start();
		b2.start();
		
	}
	public static void main(String args[]){
		new EcoSystem();
	}
	
}
