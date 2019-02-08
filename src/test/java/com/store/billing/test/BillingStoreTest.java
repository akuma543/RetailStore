package com.store.billing.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import com.store.beans.AffliatedUser;
import com.store.beans.ConstantUtil;
import com.store.beans.Customer;
import com.store.beans.Employee;
import com.store.beans.UserFactory;
import com.store.billing.Billing;
import com.store.billing.BillingLineItems;
import com.store.billing.LineItems;
import com.store.productcatelog.Product;
import com.store.productcatelog.ProductRepository;

public class BillingStoreTest {
	ProductRepository prepo;
	Product prod;
	@Test
	public void testCalculate_ForEmployee() {

		ArrayList<LineItems> items = new ArrayList<LineItems>();
		items.add(createLineItem("002", 5));
		items.add(createLineItem("003", 10));
		double espected = 52.5;
		UserFactory userfactory = new UserFactory();
		Employee emp = (Employee) userfactory.getUser(com.store.beans.ConstantUtil.EMP);

		BillingLineItems billingItems = new BillingLineItems();
		billingItems.setItemlist(items);
		Billing billingObj = new Billing();
		double billAmount = billingObj.calculate(billingItems, emp.getdiscountRate());
		Assert.assertEquals(espected, billAmount, 0.0);

		System.out.println("Total billAmount before discount for Employee of Store: 75");
		System.out.println("billAmount after discount for Employee of Store: " + billAmount);

	}

	@Test
	public void testCalculate_ForAffliated() {

		ArrayList<LineItems> items = new ArrayList<LineItems>();

		items.add(createLineItem("002", 5));
		items.add(createLineItem("003", 5));
		double espected = 45.0;
		UserFactory userfactory = new UserFactory();
		AffliatedUser affUser = (AffliatedUser) userfactory.getUser(com.store.beans.ConstantUtil.AFFL);

		BillingLineItems billingItems = new BillingLineItems();
		billingItems.setItemlist(items);

		Billing billingObj = new Billing();

		double billAmount = billingObj.calculate(billingItems, affUser.getdiscountRate());
		Assert.assertEquals(espected, billAmount, 0.0);

		System.out.println("billAmount before discount for Affliated user: 50");
		System.out.println("billAmount after discount for Affliated user: " + billAmount);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCalculate_ForCustomer_moreThan2Years() {

		ArrayList<LineItems> items = new ArrayList<LineItems>();

		items.add(createLineItem("002", 10));
		double espected = 47.5;
		UserFactory userfactory = new UserFactory();
		Customer cust = (Customer) userfactory.getUser(com.store.beans.ConstantUtil.CUST);
		cust.setCreatedOn(new Date("19/09/2015"));
		BillingLineItems billingItems = new BillingLineItems();
		billingItems.setItemlist(items);

		Billing billingObj = new Billing();

		double billAmount = billingObj.calculate(billingItems, cust.getdiscountRate());
		Assert.assertEquals(espected, billAmount, 0.0);

		System.out.println("billAmount before discount for customer for more than 2 years: 50");
		System.out.println("billAmount after discount for customer for more than 2 years: " + billAmount);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCalculate_ForCustomer_lessThan2Years() {

		
		ArrayList<LineItems> items = new ArrayList<LineItems>();

		items.add(createLineItem("002", 20));
		items.add(createLineItem("002", 10));
		items.add(createLineItem("003", 10));
		
		double espected = 190.0;
		UserFactory userfactory = new UserFactory();
		Customer cust = (Customer) userfactory.getUser(com.store.beans.ConstantUtil.CUST);
		cust.setCreatedOn(new Date("19/09/2017"));
		BillingLineItems billingItems = new BillingLineItems();
		billingItems.setItemlist(items);

		Billing billingObj = new Billing();

		double billAmount = billingObj.calculate(billingItems, cust.getdiscountRate());
		Assert.assertEquals(espected, billAmount, 0.0);
		System.out.println("billAmount before discount for customer for Less than 2 years: 200");
		System.out.println("billAmount after discount for customer for Less than 2 years: " + billAmount);

	}

	@Test
	public void testCalculate_ForCustomer_moreThan100$() {

		ArrayList<LineItems> items = new ArrayList<LineItems>();

		items.add(createLineItem("002", 20));
		items.add(createLineItem("003", 20));
		double espected = 135.0;
		UserFactory userfactory = new UserFactory();
		Employee emp = (Employee) userfactory.getUser(com.store.beans.ConstantUtil.EMP);

		BillingLineItems billingItems = new BillingLineItems();
		billingItems.setItemlist(items);

		Billing billingObj = new Billing();

		double billAmount = billingObj.calculate(billingItems, emp.getdiscountRate());
		Assert.assertEquals(espected, billAmount, 0.0);

		System.out.println("billAmount before discount for more than 100$: 200");
		System.out.println("billAmount after discount for more than 100$: " + billAmount);

	}

	@Test
	public void testCalculate_ForNoDiscount() {

		
		ArrayList<LineItems> items = new ArrayList<LineItems>();
		items.add(createLineItem("001", 8));// grocery
		double espected = 40.0;
		UserFactory userfactory = new UserFactory();
		Employee emp = (Employee) userfactory.getUser(com.store.beans.ConstantUtil.EMP);

		BillingLineItems billingItems = new BillingLineItems();
		billingItems.setItemlist(items);

		Billing billingObj = new Billing();

		double billAmount = billingObj.calculate(billingItems, emp.getdiscountRate());
		Assert.assertEquals(espected, billAmount, 0.0);
		System.out.println("billAmount with no discount: " + billAmount);

	}

	@Test
	public void testCalculate_ForEmployee_withGroceryItem() {
		
		ArrayList<LineItems> items = new ArrayList<LineItems>();
		
		items.add(createLineItem("001", 20 ));//grocery
		items.add(createLineItem("002", 20));
		items.add(createLineItem("003", 20));
		double espected = 230.0;
		UserFactory userfactory = new UserFactory();
		Employee emp = (Employee) userfactory.getUser(com.store.beans.ConstantUtil.EMP);

		BillingLineItems billingItems = new BillingLineItems();
		billingItems.setItemlist(items);

		Billing billingObj = new Billing();

		double billAmount = billingObj.calculate(billingItems, emp.getdiscountRate());
		Assert.assertEquals(espected, billAmount, 0.0);
		System.out.println("Total billAmount before discount for Employee of Store with grocery : 300");
		System.out.println("billAmount after discount for Employee of Store with grocery: " + billAmount);

	}

	private LineItems createLineItem(String productId, int qty) {
		HashMap<String ,Product> hm=new HashMap<String ,Product>();	
		hm.put("001", new Product(001,5.0,ConstantUtil.GROCERY));
		hm.put("002", new Product(002,5.0,ConstantUtil.ELECTRONICS));
		hm.put("003", new Product(003,5.0,ConstantUtil.ELECTRONICS));

		 prepo = new ProductRepository(hm);
		 prod = prepo.getproductById(productId);
		return new LineItems(productId, prod.getProductCategory(), qty, prod.getPrice());
	}

}
