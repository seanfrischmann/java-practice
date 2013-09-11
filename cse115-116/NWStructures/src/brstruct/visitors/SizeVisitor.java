package brstruct.visitors;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

public class SizeVisitor implements IAlgo<Integer,Integer,Object> {

	@Override
	public Integer emptyCase(BRStruct<Integer> host, Object arg) {
		return 0;
	}

	@Override
	public Integer nonEmptyCase(BRStruct<Integer> host, Object _) {
		return 1 + host.getLeft().execute(this,_) + host.getRight().execute(this,_);
	}

}
