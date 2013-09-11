package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class CopyVisitor<E> implements IAlgo<LRStruct<E>, E, Object> {

	@Override
	public LRStruct<E> emptyCase(LRStruct<E> host, Object _) {
		return new LRStruct<E>();
	}

	@Override
	public LRStruct<E> nonEmptyCase(LRStruct<E> host, Object _) {
		return host.getRest().execute(this,_).insertFront(host.getDatum());

//		An alternative approach, which some students will be more comfortable with:
//		LRStruct<E> copyOfRest = host.getRest().execute(this,_);
//		copyOfRest.insertFront(host.getDatum());
//		return copyOfRest;
	}
	
	public static void main(String[] args) {
		LRStruct<String> list1 = new LRStruct<String>();
		list1.insertFront("C").insertFront("B").insertFront("A");
		LRStruct<String> list2 = list1.execute(new CopyVisitor<String>(), null);
		System.out.println("list1 is "+ list1);
		System.out.println("list2 is "+ list2);
		list1.removeFront();
		list1.setDatum("XYZ");
		System.out.println("list1 is "+ list1);
		System.out.println("list2 is "+ list2);
	}

}
