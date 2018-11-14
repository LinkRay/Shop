package com.itshop.service;

import java.sql.SQLException;
import java.util.List;

import com.itshop.dao.ProductDao;
import com.itshop.domain.Product;

public class ProductService {

	public List<Product> findHotProductList() {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		List<Product> hotProductList = null;
		try {
			hotProductList = dao.findHotProductList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotProductList;
	}

	public List<Product> findnewProductList() {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		List<Product> newProductList = null;
		try {
			newProductList = dao.findnewProductList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newProductList;
	}

}
