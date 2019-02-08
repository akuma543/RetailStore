package com.store.beans;

import java.util.Calendar;
import java.util.Date;

public class Customer extends Users{
private Date createdOn;
	public Date getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}
	@Override
	public double getdiscountRate() {
		
		int diffOfYear=getDiffYears(getCreatedOn(),new Date());
		if(diffOfYear>2){
			return ConstantUtil.CUSTOMERDISCOUNT;	
		}else{
		return 0.0;
		}
	}
	public static int getDiffYears(Date first, Date last) {
	    Calendar a = getCalendar(first);
	    Calendar b = getCalendar(last);
	    return b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
	    
	}

	public static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    return cal;
	}

}
