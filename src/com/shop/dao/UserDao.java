package com.shop.dao;

import com.shop.domain.User;
import com.shop.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDao {
    public int regist(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?)";
//        System.out.println();
        int update = runner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone()
        ,user.getSex(),user.getState(),user.getCode());
        return update;
    }
    //激活
    public void active(String activeCode) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set state = ? where code = ?";
        runner.update(sql,1,activeCode);

    }

    public boolean login(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from user where username=? and password = ? and state = 1";
        Long query = (Long) runner.query(sql, new ScalarHandler(), username,password);
        return query == 1?true:false;
    }
}