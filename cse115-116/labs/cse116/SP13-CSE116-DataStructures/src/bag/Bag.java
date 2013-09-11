package bag;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Collection<T> {

	/*
	 * This class must maintain the following invariant properties of the
	 * variable _size.
	 * 
	 * 1) The value of _size must always denote the first available variable
	 *    in the _array.
	 *    
	 * 2) The value of _size must always denote the number of items stored
	 *    in the Bag.
	 */
	private T[] _array;
	private int _size;
	private int _modCount;
	
	/*
	 * The constructor must establish the invariant properties for a new Bag.
	 */
	public Bag() {
		_size = 0;
		_array = (T[]) (new Object[10]);  // Java generics system forces us to jump through some hoops to create a T array.
		_modCount = 0;
	}
	
	@Override
	public boolean add(T item) {
		if (_size == _array.length) {
			T[] temp = (T[]) (new Object[_size*2]);
			for (int i=0; i<_size; i++) {
				temp[i] = _array[i];
			}
			_array = temp;
		}
		_array[_size] = item; // this line of code breaks both invariant properties
		_size++;  // this line of code restores both invariant properties
		_modCount++;
		return true;
	}

	@Override
	public int size() {
		return _size;
	}

	@Override
	public boolean isEmpty() {
		return _size == 0;
	}

	@Override
	public boolean contains(Object item) {
		for (int i=0; i<_size; i++) {
			if (item == _array[i]) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(Object item) {
		for (int i=0; i<_size; i++) {
			if (item == _array[i]) {
				_array[i] = _array[_size-1];
				_array[_size-1] = null;  // break the invariant properties
				_size--; // restore the invariant properties
				_modCount++;
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new BagIterator(); // basic idea
	}

	private class BagIterator implements Iterator<T> {
		private int _index;
		private int _expectedModCount;
		public BagIterator() {
			_index = 0;
			_expectedModCount = _modCount;
		}
		@Override public boolean hasNext() {
			return _index < _size;
		}

		@Override public T next() {
			if (_expectedModCount != _modCount) {
				throw new ConcurrentModificationException();
			}
			if ( hasNext() ) {
				T temp = _array[_index];
				_index++;
				return temp;
			}
			throw new NoSuchElementException();
		}

		@Override public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
