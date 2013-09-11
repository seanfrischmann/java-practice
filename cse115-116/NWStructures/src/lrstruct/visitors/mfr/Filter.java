package lrstruct.visitors.mfr;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;
import functions.Predicate;

public class Filter<E> implements IAlgo<LRStruct<E>, E, Predicate<E>> {

	@Override public LRStruct<E> emptyCase(LRStruct<E> host, Predicate<E> _) {
		return new LRStruct<E>();
	}

	@Override public LRStruct<E> nonEmptyCase(LRStruct<E> host, Predicate<E> pred) {
		E item = host.getDatum();
		if (pred.apply(item)) {
			return host.getRest().execute(this,pred).insertFront(item);
		}
		else {
			return host.getRest().execute(this,pred);
		}
	}
}
