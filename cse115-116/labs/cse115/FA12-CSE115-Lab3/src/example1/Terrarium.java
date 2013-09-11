package example1;

public class Terrarium extends TerrariumParent {
	
	private static final long serialVersionUID = 3762947683657571632L;

	public Terrarium() {
	}
	
	public void add(Ant ant) {
		super.addCritter(ant);
	}

	public void add(Caterpillar caterpillar) {
		super.addCritter(caterpillar);
	}

	public void add(Butterfly butterfly) {
		super.addCritter(butterfly);
	}
}
