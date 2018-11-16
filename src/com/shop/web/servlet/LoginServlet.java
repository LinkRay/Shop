package com.shop.web.servlet;

import com.shop.domain.User;
import com.shop.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        Map<String, String[]> properties = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service = new UserService();
        System.out.println(user.getUsername()+" "+user.getPassword());
        boolean isLoginSuccess = service.login(user.getUsername(),user.getPassword());
        if(isLoginSuccess) {
            //登录成功
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/registFail.jsp");
        }
    }
}
