package brstruct.visitors.traversals;

import queues.Queue;
import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

public class PreOrderVisitor<E extends Comparable<E>> implements IAlgo<Object,E,Queue<E>> {

	@Override public Object emptyCase(BRStruct<E> host, Queue<E> arg) {
		return null;
	}

	@Override public Object nonEmptyCase(BRStruct<E> host, Queue<E> q) {
		q.enqueue(host.getDatum());
		host.getLeft().execute(this, q);
		host.getRight().execute(this, q);
		return null;
	}

}
