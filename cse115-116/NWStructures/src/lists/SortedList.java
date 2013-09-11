/**
 * 
 */
package lists;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;
import lrstruct.visitors.FindVisitor;
import lrstruct.visitors.NotEmptyVisitor;
import lrstruct.visitors.RemoveVisitor;

/**
 * @author alphonce
 *
 */
public class SortedList<E extends Comparable<E>> {

	private LRStruct<E> _list;
	
	public SortedList() {
		_list = new LRStruct<E>();
	}
	
	// This method shows one style of defining and using
	// a visitor: anonymously in-place
	public SortedList<E> insert(E item) {
		_list.execute(new IAlgo<Object,E,E>() {
			@Override
			public Object emptyCase(LRStruct<E> host, E arg) {
				return host.insertFront(arg);
			}
			@Override
			public Object nonEmptyCase(LRStruct<E> host, E arg) {
				if (arg.compareTo(host.getDatum()) < 0) {
					return host.insertFront(arg);
				}
				else {
					return host.getRest().execute(this, arg);
				}
			}
		}, item);
		return this;
	}
	
	// This method shows another style of defining and using
	// a visitor: defining it independently
	public void remove(E item) {
		LRStruct<E> location = _list.execute(new FindVisitor<E>(), item); 
		location.execute(new RemoveVisitor<E>(), null);
	}
	
	public Boolean member(E item) {
		LRStruct<E> location = _list.execute(new FindVisitor<E>(), item); 
		return location.execute(new NotEmptyVisitor<E>(), null);
	}
	
	public E removeFirst() {
		return _list.removeFront();
	}

	@Override
	public String toString() {
		return (String) _list.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getClass().equals(obj.getClass())) {
			@SuppressWarnings("unchecked") SortedList<E> rhs = (SortedList<E>) obj;
			return this.toString().equals(rhs.toString());
		}
		return false;
	}
}
