package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class EmptyVisitor<E> implements IAlgo<Boolean,E,Object> {
	@Override
	public Boolean emptyCase(LRStruct<E> host, Object _) {
		return true;
	}
	@Override
	public Boolean nonEmptyCase(LRStruct<E> host, Object _) {
		return false;
	}
}
