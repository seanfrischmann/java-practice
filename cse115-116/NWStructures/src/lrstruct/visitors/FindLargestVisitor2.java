package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class FindLargestVisitor2 implements IAlgo<Integer, Integer, Integer> {

	@Override
	public Integer emptyCase(LRStruct<Integer> host, Integer hypoth) {
		throw new IllegalStateException("Empty list has no largest");
	}

	@Override
	public Integer nonEmptyCase(LRStruct<Integer> host, Integer hypoth) {
		return host.getRest().execute(new IAlgo<Integer, Integer, Integer>() {
			@Override
			public Integer emptyCase(LRStruct<Integer> host, Integer hyp) {
				return hyp;
			}

			@Override
			public Integer nonEmptyCase(LRStruct<Integer> host, Integer hyp) {
				Integer x = host.getDatum();
				if (x > hyp) {
					return host.getRest().execute(this, x);
				} else {
					return host.getRest().execute(this, hyp);
				}
			}
		}, host.getDatum());
	}
}
