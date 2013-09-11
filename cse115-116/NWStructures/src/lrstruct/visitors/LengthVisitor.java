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
public class LengthVisitor<E> implements IAlgo<Integer,E,Object> {

	@Override public Integer emptyCase(LRStruct<E> host, Object _) {
		return 0;
	}

	@Override public Integer nonEmptyCase(LRStruct<E> host, Object _) {
		return 1 + host.getRest().execute(this, _);
	}

}
