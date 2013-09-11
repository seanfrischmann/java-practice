package bag;

import java.util.ArrayList;
import java.util.Iterator;

public class Driver {
	public static void main(String[] args) {
		ArrayList<String> b;
		b = new ArrayList<String>();
		b.add("Fred");
		b.add("Wilma");
		b.add("Pebbles");
		
		Iterator<String> itONE = b.iterator();
		System.out.println("itONE Value: "+itONE.next());
		Iterator<String> itTWO = b.iterator();
		System.out.println("itONE Value: "+itONE.next());
		System.out.println("itTWO Value: "+itTWO.next());
		itONE.remove();
		System.out.println("itONE Value: "+itONE.next());
		System.out.println("itTWO Value: "+itTWO.next());

		System.out.println("itTWO Value: "+itTWO.next());
	}
}
