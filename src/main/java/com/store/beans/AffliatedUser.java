package com.store.beans;

public class AffliatedUser extends Users{

	@Override
	public double getdiscountRate() {
		
		return ConstantUtil.AFFLDISCOUNT;
	}

}
