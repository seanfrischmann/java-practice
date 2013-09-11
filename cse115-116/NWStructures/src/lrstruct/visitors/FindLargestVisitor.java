package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class FindLargestVisitor implements IAlgo<Integer, Integer, Integer> {

	@Override
	public Integer emptyCase(LRStruct<Integer> host, Integer hypothesis) {
		return hypothesis;
	}

	@Override
	public Integer nonEmptyCase(LRStruct<Integer> host, Integer hypothesis) {
		
		Integer x = host.getDatum();

		if (x > hypothesis) {
			return host.getRest().execute(this, x);
		}
		else {
			return host.getRest().execute(this, hypothesis);
		}
	}

}
