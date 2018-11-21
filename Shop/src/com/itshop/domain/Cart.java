package com.itshop.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
	//n个购物项
	private Map<String,CartItem> cartItems = new HashMap<>();
	// 商品总计
	
	private double total;

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


	
	
}
