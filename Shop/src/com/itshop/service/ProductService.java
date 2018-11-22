package com.itshop.service;

import java.sql.SQLException;
import java.util.List;

import com.itshop.dao.ProductDao;
import com.itshop.domain.Category;
import com.itshop.domain.PageBean;
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
			newProductList = dao.findNewProductList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newProductList;
	}

	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		List<Category> categoryList = null;
		try {
			categoryList = dao.findAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}

	public PageBean findProductListByCid(String cid, int currentPage, int currentCount) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		int totalCount = 0;
		try {
			totalCount = dao.getCount(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("totalCount:"+totalCount);
		System.out.println("currentCount:"+currentCount);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		System.out.println("-2");
		pageBean.setTotalPage(totalPage);
		int index = (currentPage-1)*currentCount;
		List<Product> list = null;
		System.out.println("-3");
		try {
			list = dao.findProductByPage(cid, index, currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("GG");
		}
		System.out.println("-4");
		pageBean.setList(list);
		System.out.println("-5");
		return pageBean;
	}

	public Product findProductByPid(String pid) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		Product product = null;
		try {
			product = dao.findProductByPid(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	

}
