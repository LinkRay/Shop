//author:陈雨鑫大帅比
//time:2018-11-22
package com.itshop.web.serlvet;

import com.itshop.domain.Cart;
import com.itshop.domain.CartItem;
import com.itshop.domain.OrderItem;
import com.itshop.domain.Orders;
import com.itshop.service.OrdersService;
import com.itshop.utils.CommonsUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "OrdersServlet")
public class OrdersSerlvet extends BaseSerlvet {
    public void ordersSubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session=request.getSession();
        //测试
        session.setAttribute("uid","f55b7d3a352a4f0782c910b2c70f1ea4");

        Cart cart = (Cart)session.getAttribute("cart");
        String uid=(String)session.getAttribute("uid");
        //（保证用户登陆）如果购物车中的内容不为空，才进行以下操作
        Orders orders =new Orders();
        orders.setTotal(cart.getTotal());
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orders.setDatetime(dateFormat.format(new Date()));
        orders.setState(0);
        orders.setUid(uid);
        String oid= CommonsUtils.getUUID();
        orders.setOid(oid);
        Map<String,CartItem> cartItems = cart.getCartItems();
        for(Map.Entry<String,CartItem> entry: cartItems.entrySet()){
            CartItem cartItem=entry.getValue();
            OrderItem orderItem=new OrderItem();
            orderItem.setCount(cartItem.getBuyNum());
            orderItem.setPid(cartItem.getProduct().getPid());
            orderItem.setSubtotal(cartItem.getSubtotal());
            orderItem.setOid(oid);
            orderItem.setItemid(CommonsUtils.getUUID());

            orderItem.setProduct(cartItem.getProduct());

            orders.getOrderitems().add(orderItem);
        }
        //将orders对象存入数据库中
        OrdersService ordersService=new OrdersService();
        ordersService.ordersSubmit(orders);

        //调至到订单支付页面
        session.setAttribute("orders",orders);
//        response.sendRedirect("/Shop/order_info.jsp");
        request.getRequestDispatcher("/order_info.jsp").forward(request, response);
    }
}

