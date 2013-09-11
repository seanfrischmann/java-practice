package lrstruct.visitors.mfr;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;
import functions.BinaryFunction;

public class Reduce<O,E> implements IAlgo<O, E, BinaryFunction<O,E,O>> {

	@Override public O emptyCase(LRStruct<E> host, BinaryFunction<O,E,O> f) {
		return f.identity();
	}

	@Override public O nonEmptyCase(LRStruct<E> host, BinaryFunction<O,E,O> f) {
		return f.apply(host.getDatum(),host.getRest().execute(this,f));
	}
}
