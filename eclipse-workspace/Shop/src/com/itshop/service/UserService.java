package com.itshop.service;

import java.sql.SQLException;

import com.itshop.dao.UserDao;
import com.itshop.domain.User;

public class UserService {

	public boolean regist(User user) throws SQLException {
		UserDao dao = new UserDao();
		int row = 0;
		row = dao.regist(user);
		return row>0?true:false;
	}
	//激活
	public void active(String activeCode) {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		try {
			dao.active(activeCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//校验用户名是否存在
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		long isExist = 0;
		try {
			isExist = dao.checkUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}

}
