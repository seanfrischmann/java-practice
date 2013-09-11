package stack;

import java.util.ArrayList;

/**
 * A stack, defined by composition with an ArrayList<E>
 * @author Carl Alphonce
 */
public class StackByCompositionWithArrayList<E> {
	
	private ArrayList<E> _front;
	
	public StackByCompositionWithArrayList() {
		_front = new ArrayList<E>();
	}	
	
	public void push(E item) {
		_front.add(_front.size(), item);
	}	
	
	public E pop() {
		if (_front.isEmpty()) {
			throw new EmptyStackException("Cannot pop an empty stack.");
		}
		else { 
			return _front.remove(_front.size()-1);
		}
	}	
	
	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException("Cannot peek an empty stack.");
		}
		else { 
			return _front.get(_front.size()-1);
		}
	}
	
	public boolean isEmpty() {
		return _front.isEmpty();
	}
	
	@Override public String toString() {
		return _front.toString();
	}
}
