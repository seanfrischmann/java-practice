/**
 * 
 */
package brstruct.visitors;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

/*
 * Define a visitor on a BRStruct<E> that returns
 * a reference to the leftmost non-Empty dependent.
 * Assume that the original tree is non-Empty
 */

public class LeftmostVisitor<E> implements IAlgo<BRStruct<E>, E, BRStruct<E>> {
	@Override
	public BRStruct<E> emptyCase(BRStruct<E> host, BRStruct<E> parent) {
		return parent;
	}
	@Override
	public BRStruct<E> nonEmptyCase(BRStruct<E> host, BRStruct<E> parent) {
		return host.getLeft().execute(this, host);
	}
}
