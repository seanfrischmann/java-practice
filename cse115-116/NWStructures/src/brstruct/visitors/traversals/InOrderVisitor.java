package brstruct.visitors.traversals;

import queues.Queue;
import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

public class InOrderVisitor<E extends Comparable<E>> implements IAlgo<Object,E,Queue<E>> {

	@Override public Object emptyCase(BRStruct<E> host, Queue<E> arg) {
		return null;
	}

	@Override public Object nonEmptyCase(BRStruct<E> host, Queue<E> arg) {
		host.getLeft().execute(this, arg);
		arg.enqueue(host.getDatum());
		host.getRight().execute(this, arg);
		return null;
	}
}
