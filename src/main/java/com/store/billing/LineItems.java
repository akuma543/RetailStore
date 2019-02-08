package com.store.billing;

public class LineItems {
	private String pid;
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private int stocks;

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	private double price;

	public LineItems(String pid, String category, int stocks, double price) {
		super();
		this.pid = pid;
		this.category = category;
		this.stocks = stocks;
		this.price = price;
	}


}
