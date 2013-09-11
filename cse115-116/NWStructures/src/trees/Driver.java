package trees;

public class Driver {
	public static void main(String[] args) {
		
//		BST<Double> t = new BST<Double>();
//		t.insert(100.0);
//		t.insert(30.0);
//		t.insert(140.0);
//		t.insert(20.0);
//		t.insert(50.0);
//		t.insert(110.0);
//		t.insert(150.0);
//		t.insert(10.0);
//		t.insert(40.0);
//		t.insert(90.0);
//		t.insert(120.0);
//		t.insert(170.0);
//		t.insert(70.0);
//		t.insert(130.0);
//		t.insert(160.0);
//		t.insert(180.0);
//		t.insert(60.0);
//		t.insert(80.0);
//		t.insert(125.0);

//		System.out.println("PRE-ORDER: " + t.preOrder());
//		System.out.println("IN-ORDER: " + t.inOrder());
//		System.out.println("POST-ORDER: " + t.postOrder());

		BSTArray<String> t1 = new BSTArray<String>();
//		t1.insert("E").insert("C").insert("H").insert("A").insert("D").insert("G").insert("I").insert("B").insert("F");
		t1.insert("E").insert("D").insert("G").insert("B").insert("F").insert("I").insert("A").insert("C").insert("H");
		System.out.println(t1);
//		System.out.println("PRE-ORDER: " + t1.preOrder());
//		System.out.println("IN-ORDER: " + t1.inOrder());
//		System.out.println("POST-ORDER: " + t1.postOrder());

		
//		System.out.println(t);
//		BRStruct<Double> tree = t.getTree();
//		FindVisitor<Double> f = new FindVisitor<Double>();
////		System.out.println(tree.execute(f, 40));
//		tree.execute(f, 97.8).insertRoot(97.8);
//		System.out.println(t);
		
		
//		BST<Integer> t = new BST<Integer>();
//		t.insert(50).insert(30).insert(10).insert(20).insert(70).insert(60).insert(80);
//		
//		System.out.println("In-order iteration");
//		Iterator<Integer> i;
//		i = t.iterator();
//		while (i.hasNext()) {
//			System.out.println("THE NEXT VALUE IS: "+i.next() + " ");
//		}
////		System.out.println();
////		System.out.println("Breadth-first iteration");
////		i = t.breadthFirstIterator();
////		while (i.hasNext()) {
////			System.out.print(i.next() + " ");
////		}
	}
}
