package queues;

import java.util.ArrayList;

/**
 * A simple time-ordered queue, defined by composition with an ArrayList<E>
 * @author Carl Alphonce
 */
public class QueueByCompositionWithArrayList<E> {

	private ArrayList<E> _list;

	public QueueByCompositionWithArrayList() {
		_list = new ArrayList<E>();
	}
	
	public void enqueue(E item) {
		_list.add(_list.size(), item);
	}

	public E dequeue() {
		if (_list.isEmpty()) {
			throw new EmptyQueueException("Cannot dequeue an empty queue.");
		}
		else {
			return _list.remove(0);
		}
	}
	
	public E peek() {
		if (_list.isEmpty()) {
			throw new EmptyQueueException("Cannot peek an empty queue.");
		}
		else {
			return _list.get(0);
		}
	}

	@Override public String toString() { return _list.toString(); }
}
