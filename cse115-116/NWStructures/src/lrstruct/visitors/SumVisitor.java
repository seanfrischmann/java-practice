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
public class SumVisitor implements IAlgo<Integer,Integer,Object> {

	@Override public Integer emptyCase(LRStruct<Integer> host, Object _) {
		return 0;
	}

	@Override public Integer nonEmptyCase(LRStruct<Integer> host, Object _) {
		return host.getDatum() + host.getRest().execute(this, _);
	}
}
