package lrstruct.visitors.mfr;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;
import functions.UnaryFunction;

public class Map<O,E> implements IAlgo<LRStruct<O>, E, UnaryFunction<O,E>> {

	@Override public LRStruct<O> emptyCase(LRStruct<E> host, UnaryFunction<O,E> _) {
		return new LRStruct<O>();
	}

	@Override public LRStruct<O> nonEmptyCase(LRStruct<E> host, UnaryFunction<O,E> f) {
		return host.getRest().execute(this,f).insertFront(f.apply(host.getDatum()));
	}
}
