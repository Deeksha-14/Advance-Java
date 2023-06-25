package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDaoImpl;
import pojos.product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(value = "/product", loadOnStartup = 1)
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductDaoImpl dao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		try {
			dao = new ProductDaoImpl();
		} catch (Exception e) {
			
			throw new ServletException("err in init"+getClass(), e);
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	try {
		dao.cleanUp();
	} catch (Exception e) {
		System.out.println("err in destroy"+getClass()+" , "+e);
	}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()){
			 
			ProductDaoImpl dao = new ProductDaoImpl();
			List<product> lst =dao.fetchAllProduct();
			
			for(product p: lst)
				pw.print(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("err in do get");
		}
		
	}

}
