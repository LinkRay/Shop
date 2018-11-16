package com.shop.web.servlet;

import com.shop.domain.User;
import com.shop.service.UserService;
import com.shop.utils.CommonsUtils;
import com.shop.utils.MailUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //
        Map<String, String[]> properties = request.getParameterMap();
        User user = new User();
        //映射封装
        try {
            BeanUtils.populate(user,properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String activeCode = CommonsUtils.getID();
        user.setUid(activeCode);
        user.setTelephone(null);
        user.setState(0);
        user.setCode(activeCode);

        //user传递给service层
        UserService service = new UserService();
        boolean isRegistSuccess = service.regist(user);

        //是否注册成功
        if(isRegistSuccess) {
            //发送激活邮件
            String emailMsg = "恭喜你注册成功，请点击下面链接激活"+"<a href='http://localhost:8080/bookstore/active?activeCode="+activeCode+"'>激活</a>";
            try {
                MailUtils.sendMail(user.getEmail(),emailMsg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            //跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/registSuccess.jsp");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/registFail.jsp");
        }
    }
}
