package com.itshop.service;

import com.itshop.dao.OrdersDao;
import com.itshop.domain.Orders;

public class OrdersService {

    public boolean ordersSubmit(Orders orders){

        try{
        OrdersDao ordersDao= new OrdersDao();
        ordersDao.orderSubmit(orders);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;

    }
}

