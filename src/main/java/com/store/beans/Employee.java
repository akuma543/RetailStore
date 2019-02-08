package com.store.beans;

public class Employee extends Users{

@Override
public double getdiscountRate() {
	
	return ConstantUtil.EMPDISCOUNT;
}
}
