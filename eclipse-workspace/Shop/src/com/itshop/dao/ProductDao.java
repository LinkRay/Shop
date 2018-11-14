package com.itshop.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itshop.domain.Product;
import com.itshop.utils.DataSourceUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ProductDao {

	public List<Product> findHotProductList() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where is_hot=? limit ?,?";
		List<Product> products = runner.query(sql, new BeanListHandler<Product>(Product.class),1,0,9);
		
		
		return products;
	}

	public List<Product> findnewProductList() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product order by pdate desc limit ?,?";
		List<Product> products = runner.query(sql, new BeanListHandler<Product>(Product.class),0,9);
		
		
		return products;
	}

}
