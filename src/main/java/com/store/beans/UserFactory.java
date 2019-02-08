package com.store.beans;

public class UserFactory {
public Users getUser(String userType){
	if(userType==null)
		return null;
	else if(userType.equals(ConstantUtil.EMP)){
		return new Employee();
	}
	else if(userType.equals(ConstantUtil.AFFL)){
		return new AffliatedUser();
	}
	else if(userType.equals(ConstantUtil.CUST)){
		return new Customer();
	}
	return null;
}
}
