package com.shop.service;

import com.shop.dao.UserDao;
import com.shop.domain.User;

import java.sql.SQLException;

public class UserService {
    public boolean regist(User user) {
        UserDao dao = new UserDao();
        int row = 0;
        try {
            row = dao.regist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(row);
        return row > 0 ? true : false;
    }
    //激活
    public void active(String activeCode) {
        UserDao dao = new UserDao();
        try {
            dao.active(activeCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean login(String username, String password) {
        UserDao dao = new UserDao();
        boolean isSuccess = false;
        try {
             isSuccess = dao.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
