package queues;

import lrstruct.LRStruct;
import lrstruct.visitors.EmptyVisitor;

/**
 * A simple time-ordered queue, defined by composition with an LRStruct<E>
 * @author Carl Alphonce
 */
public class QueueByCompositionWithLRStruct<E> {

	private LRStruct<E> _front;
	private LRStruct<E> _back;

	public QueueByCompositionWithLRStruct() {
		_front = new LRStruct<E>();
		_back = _front;
	}
	
	public QueueByCompositionWithLRStruct<E> enqueue(E item) {
		_back.insertFront(item);
		_back = _back.getRest();
		return this;
	}

	public E dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException("Cannot dequeue an empty queue.");
		}
		else {
			E item = _front.getDatum();
			_front = _front.getRest();
			return item;
			/*
			 * NOTE: Simply doing this:
			 *       return _front.removeFront() 
			 * will not do the right thing when there is only one item in
			 * the queue, as _front and _back will refer to different empty
			 * LRStructs.
			 */
		}
	}
	
	public E peek() {
		if (isEmpty()) {
			throw new EmptyQueueException("Cannot peek an empty queue.");
		}
		else {
			return _front.getDatum();
		}
	}

	public boolean isEmpty() {
		return _front.execute(new EmptyVisitor<E>(), null);
	}
	
	@Override public String toString() { return _front.toString(); }
}
