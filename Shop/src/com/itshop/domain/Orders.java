/*author:陈雨鑫大帅逼
* time:2018-11-21*/
package com.itshop.domain;

import java.util.Date;
import java.util.ArrayList;

public class Orders {


    public String getOid() {
        return Oid;
    }

    public void setOid(String oid) {
        Oid = oid;
    }

    private String Oid;
    private String datetime;
    private double total;
    private int state=0;
    private String address;
    private String name;
    private String telephone;
    //用户id
    private String uid;
    //包含的订单项
    private ArrayList<OrderItem> orderitems=new ArrayList<>();

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ArrayList<OrderItem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(ArrayList<OrderItem> orderitems) {
        this.orderitems = orderitems;
    }




}
