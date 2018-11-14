package com.itshop.web.serlvet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itshop.domain.Product;
import com.itshop.service.ProductService;
import java.util.List;
/**
 * Servlet implementation class IndexSerlvet
 */
public class IndexSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService service = new ProductService();
		
		//准备热门商品 --- List<Product>
		List<Product> hotProductList = service.findHotProductList();
		
		//准备最新商品 --- List<Product>
		List<Product> newProductList = service.findnewProductList();
		request.setAttribute("hotProductList", hotProductList);
		request.setAttribute("newProductList", newProductList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
