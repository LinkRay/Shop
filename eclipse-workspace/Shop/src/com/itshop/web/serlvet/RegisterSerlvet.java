package com.itshop.web.serlvet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.itshop.domain.User;
import com.itshop.service.UserService;
import com.itshop.utils.CommonsUtils;
import com.itshop.utils.MailUtils;

/**
 * Servlet implementation class RegisterSerlvet
 */
public class RegisterSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//获得表单数据
		Map<String, String[]> properties = request.getParameterMap();
		User user = new User();
		try {
			//指定类型转换器
			ConvertUtils.register(new Converter() {
				
				@Override
				public Object convert(Class clazz, Object value) {
					// TODO Auto-generated method stub
					//将string转成Date
					SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
					java.util.Date parse = null;
					try {
						parse = format.parse(value.toString());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return parse;	
				}
			}, Date.class);
			//映射封装
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// uid
		user.setUid(CommonsUtils.getUUID());
		
		//telephone 
		user.setTelephone(null);
		//state
		user.setState(0);
		//code
		String activeCode = CommonsUtils.getUUID();
		user.setCode(activeCode);
		
		//将user传递给service层
		UserService service = new UserService();
		boolean isRegisterSuccess = false;
		try {
			 isRegisterSuccess = service.regist(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 是否注册成功
		if(isRegisterSuccess) {
			//发送激活邮件
			String emailMsg = "恭喜您注册成功，请点击下面的链接进行激活"+
			"<a href='http://localhost:8080/Shop/active?activeCode="+activeCode+"'>激活</a>";
			try {
				MailUtils.sendMail(user.getEmail(), emailMsg);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//跳转到成功页面
			response.sendRedirect(request.getContextPath()+"/registerSuccess.jsp");
		}
		else {
			//跳转到失败页面
			response.sendRedirect(request.getContextPath()+"/registerFail.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
