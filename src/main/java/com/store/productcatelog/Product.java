package com.store.productcatelog;

public class Product {
private int productId;
private double price;
public int getProductId() {
	return productId;
}
public Product(int productId, double price, String productCategory) {
	this.productId = productId;
	this.price = price;
	this.productCategory = productCategory;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getProductCategory() {
	return productCategory;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}
private String productCategory;

}
