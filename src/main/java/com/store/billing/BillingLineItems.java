package com.store.billing;

import java.util.List;

public class BillingLineItems{
	private List<LineItems> itemlist;
	public void setItemlist(List<LineItems> itemlist) {
		this.itemlist = itemlist;
	}
	public List<LineItems> getItemlist() {
		return itemlist;
	}

}
