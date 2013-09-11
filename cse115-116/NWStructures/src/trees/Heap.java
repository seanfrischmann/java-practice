package trees;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;


/*
 * INCOMPLETE DEQUEUE IMPLEMENTATION!!!
 */

public class Heap<E extends Comparable<E>> {
	
	private BRStruct<E> _heap;
	
	public Heap() {
		_heap = new BRStruct<E>();
	}
	
	public E peek() {
		return _heap.execute(new IAlgo<E,E,Object>(){
			@Override
			public E emptyCase(BRStruct<E> host, Object _) {
				throw new IllegalStateException("No values in empty heap.");
			}
			@Override
			public E nonEmptyCase(BRStruct<E> host, Object _) {
				return host.getDatum();
			}
			
		}, null); 
	}
	
	public void enqueue(E item) {
		_heap.execute(new IAlgo<Object,E,E>() {
			@Override
			public Object emptyCase(BRStruct<E> host, E arg) {
				return host.insertRoot(arg);
			}
			@Override
			public Object nonEmptyCase(BRStruct<E> host, E arg) {
				if (arg.compareTo(host.getDatum()) < 0) {
					E tempValue = host.getDatum();
					host.setDatum(arg);
					arg = tempValue;
				}
				// insert recursively on right
				host.getRight().execute(this, arg);
				// swap left and right (to restore structure/balance property)
				BRStruct<E> tempTree = host.getRight();
				host.setRight(host.getLeft());
				host.setLeft(tempTree);
				return null;
			}
			
		}, item);
	}

	public E dequeue() {
		return _heap.execute(new IAlgo<E,E,E>() {
			@Override
			public E emptyCase(BRStruct<E> host, E arg) {
				throw new IllegalStateException("No values in an empty heap");
			}
			@Override
			public E nonEmptyCase(BRStruct<E> host, E _) {
				E valueToRemove = host.getDatum();
				E leftmost = host.getLeft().execute(new IAlgo<E,E,BRStruct<E>>() {

					@Override
					public E emptyCase(BRStruct<E> host, BRStruct<E> parent) {
						E temp = parent.getDatum() ;
						parent.removeRoot();
						return temp;
					}

					@Override
					public E nonEmptyCase(BRStruct<E> host, BRStruct<E> parent) {
						// recursively remove from left
						E temp = host.getLeft().execute(this, host);
						// swap left and right (to restore structure/balance property)
						BRStruct<E> tempTree = host.getRight();
						host.setRight(host.getLeft());
						host.setLeft(tempTree);
						return temp;
					}
				}, host);
				host.setDatum(leftmost);
				// push down value in root: RESTORE ORDER PROPERTY
//				host.execute(new IAlgo<Object,E,Object>() {
//					// 
//				}, null);
				return valueToRemove;
			}
			
		}, null);
	}

	@Override
	public String toString() {
		return _heap.toString();
	}
	
}
