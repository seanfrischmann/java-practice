package trees;

import java.util.Iterator;
import java.util.NoSuchElementException;

import queues.Queue;
import queues.QueueByCompositionWithLRStruct;
import stack.Stack;
import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;
import brstruct.LeftRemoveRootVisitor;
import brstruct.visitors.FindVisitor;
import brstruct.visitors.traversals.InOrderVisitor;
import brstruct.visitors.traversals.PostOrderVisitor;
import brstruct.visitors.traversals.PreOrderVisitor;

@SuppressWarnings("unused")
public class BSTBRStruct<E extends Comparable<E>> implements Iterable<E>{

	private BRStruct<E> _brs;

	private BRStruct<E> getTree() { return _brs; }
	
	public BSTBRStruct() {
		_brs = new BRStruct<E>();
	}
	
	public boolean isEmpty() {
		return _brs.execute(new IAlgo<Boolean,E,Object>() {
			@Override public Boolean emptyCase(BRStruct<E> host, Object _) { return true; }
			@Override public Boolean nonEmptyCase(BRStruct<E> host, Object _) { return false; }		
		}, null);
	}

	public int size() {
		return _brs.execute(new IAlgo<Integer,E,Object>() {
			@Override public Integer emptyCase(BRStruct<E> host, Object _) { return 0; }
			@Override public Integer nonEmptyCase(BRStruct<E> host, Object _) {
				return 1 + _brs.getLeft().execute(this,_) + _brs.getRight().execute(this,_); }		
		}, null);
	}

	public BSTBRStruct<E> insert(E item) {
		BRStruct<E> tree = _brs.execute(new FindVisitor<E>(), item);
		tree.execute(new IAlgo<Object,E,E>(){
			@Override
			public Object emptyCase(BRStruct<E> host, E item) {
				// item is not in tree, so insert it				
				return host.insertRoot(item);
			}
			@Override
			public Object nonEmptyCase(BRStruct<E> host, E item) {
				// item is already in tree - do not insert again
				// NOTE UNIQUENESS ASSUMPTION
				return host;
			}
		}, item);
		return this;
	}

	public BSTBRStruct<E> remove(E item) {
		BRStruct<E> tree = _brs.execute(new FindVisitor<E>(), item);
		tree.execute(new LeftRemoveRootVisitor<E>(), item);
		return this;
	}

	public boolean member(E item) {
		BRStruct<E> tree = _brs.execute(new FindVisitor<E>(), item);
		return tree.execute(new IAlgo<Boolean,E,Object>(){
			@Override
			public Boolean emptyCase(BRStruct<E> host, Object _) {
				return false;
			}
			@Override
			public Boolean nonEmptyCase(BRStruct<E> host, Object _) {
				return true;
			}
		}, null);
	}
	
	@Override
	public String toString() {
		return _brs.toString();
	}
	
	public Queue<E> preOrder() {
		Queue<E> q = new Queue<E>();
		_brs.execute(new PreOrderVisitor<E>(), q);
		return q;
	}
	
	public Queue<E> inOrder() {
		Queue<E> q = new Queue<E>();
		_brs.execute(new InOrderVisitor<E>(), q);
		return q;
	}
	
	public Queue<E> postOrder() {
		Queue<E> q = new Queue<E>();
		_brs.execute(new PostOrderVisitor<E>(), q);
		return q;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new BSTIterator();
	}

	// made private for the time being
	private Iterator<E> breadthFirstIterator() {
		return new BFIterator();
	}

	
	private class LeftPusher implements IAlgo<Object, E, Stack<BRStruct<E>>> {
		@Override
		public Object emptyCase(BRStruct<E> host, Stack<BRStruct<E>> stack) {
			return null;
		}

		@Override
		public Object nonEmptyCase(BRStruct<E> host, Stack<BRStruct<E>> stack) {
			stack.push(host);
			return host.getLeft().execute(this, stack);
		}
	}

	private class BSTIterator implements Iterator<E> {

		private Stack<BRStruct<E>> _stack;
		
		public BSTIterator() {
			_stack = new Stack<BRStruct<E>>();
			_brs.execute(new LeftPusher(), _stack);
		}

		@Override public boolean hasNext() {
			return ! _stack.isEmpty();
		}

		@Override public E next() {
			if (hasNext()) {
				BRStruct<E> current = _stack.pop();
				current.getRight().execute(new LeftPusher(), _stack);
				return current.getDatum();
			}
			else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class BFIterator implements Iterator<E> {

		private QueueByCompositionWithLRStruct<BRStruct<E>> _queue;  // invariant - only contains non-empty trees!
		
		public BFIterator() {
			_queue = new QueueByCompositionWithLRStruct<BRStruct<E>>();
			_brs.execute(new NonEmptyTreeEnqueuer(), _queue);
		}

		@Override public boolean hasNext() {
			return ! _queue.isEmpty();
		}

		@Override public E next() {
			BRStruct<E> current = _queue.dequeue();
			current.getLeft().execute(new NonEmptyTreeEnqueuer(), _queue);
			current.getRight().execute(new NonEmptyTreeEnqueuer(), _queue);
			return current.getDatum();
		}

		@Override public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private class NonEmptyTreeEnqueuer implements IAlgo<Object,E,QueueByCompositionWithLRStruct<BRStruct<E>>> {
		@Override public Object emptyCase(BRStruct<E> host, QueueByCompositionWithLRStruct<BRStruct<E>> _) {
			return null;
		}
		@Override public Object nonEmptyCase(BRStruct<E> host, QueueByCompositionWithLRStruct<BRStruct<E>> q) {
			q.enqueue(host);
			return null;
		}
	}
	
}
