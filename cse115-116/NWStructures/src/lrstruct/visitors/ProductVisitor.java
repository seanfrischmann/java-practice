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
public class ProductVisitor implements IAlgo<Integer,Integer,Object> {
	/* (non-Javadoc)
	 * @see lrstruct.LRStruct.IAlgo#emptyCase(lrstruct.LRStruct, I)
	 */
	@Override
	public Integer emptyCase(LRStruct<Integer> host, Object _) {
		return 1;  // 1 is the identity element of *
	}

	/* (non-Javadoc)
	 * @see lrstruct.LRStruct.IAlgo#nonEmptyCase(lrstruct.LRStruct, I)
	 */
	@Override
	public Integer nonEmptyCase(LRStruct<Integer> host, Object _) {
		return host.getDatum() * host.getRest().execute(this, _);
	}
}
