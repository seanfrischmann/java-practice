/**
 * 
 */
package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

/**
 * @author alphonce
 *
 */
public class RemoveVisitor<E extends Comparable<E>> implements IAlgo<Object,E,Object> {
	@Override
	public Object emptyCase(LRStruct<E> host, Object _) {
		return null;
	}
	@Override
	public Object nonEmptyCase(LRStruct<E> host, Object _) {
		return host.removeFront();
	}
}
