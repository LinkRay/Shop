package com.itshop.dao;

import com.itshop.domain.OrderItem;
import com.itshop.domain.Orders;
import com.itshop.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

public class OrdersDao {

    public void orderSubmit(Orders orders) throws Exception{

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert into orders values(?,?,?,?,?,?,?,?)";

        runner.update(sql,orders.getOid(),orders.getDatetime()
                ,orders.getTotal(),orders.getState(),
                orders.getAddress(),orders.getName(),
                orders.getTelephone(),orders.getUid());
        for(int i=0;i<orders.getOrderitems().size();i++){
            OrderItem orderItem=orders.getOrderitems().get(i);
            String sql1="insert into orderitem values(?,?,?,?,?)";
            runner.update(sql1,orderItem.getItemid(),orderItem.getCount(),
                    orderItem.getSubtotal(),orderItem.getPid(),orderItem.getOid());
        }
        return;
    }
}
