package com.store.billing;


import java.util.List;

import com.store.beans.ConstantUtil;

public class Billing {
	public double calculate(BillingLineItems lineItems,double discountrate){
		 List<LineItems> obj= lineItems.getItemlist();
		 double totalAmount;
		 double discountedAmount=0.0;
		 double grossAmount=0.0;
		 
		 for(LineItems item:obj){
			 if(!item.getCategory().equalsIgnoreCase(ConstantUtil.GROCERY)){
				 discountedAmount+=item.getPrice()*item.getStocks(); 
			 }
			 grossAmount+=item.getPrice()*item.getStocks(); 
		 }
		 
		 if(discountrate==0.0)
		 {
			 totalAmount=grossAmount; 
		 }else{
			 totalAmount=grossAmount-(discountedAmount*discountrate/100);
			 }
		 if(totalAmount>=100)
		 {
			 totalAmount=totalAmount-(Math.floor(totalAmount/100)*5);
		 }
		return totalAmount;
	}
}
