package com.itshop.domain;

public class CartItem {
	private Product product;
	private int buyNum;
	private double subtotal;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int byNum) {
		this.buyNum = byNum;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
}
