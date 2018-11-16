package com.shop.web.servlet;

import com.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/active")
public class activeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得激活码
        String activeCode = request.getParameter("activeCode");

        // service
        UserService service = new UserService();
        service.active(activeCode);
        // 跳转到登录界面
        response.sendRedirect(request.getContextPath()+"login.jsp");
    }
}
