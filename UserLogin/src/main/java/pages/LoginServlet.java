package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl dao;
       
   
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
	try {
		dao = new UserDaoImpl();
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
			System.out.println("err in destroy"+getClass()+" "+e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter()){
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			
			User user = dao.authenticateUser(email, password);
			if(user == null)
			{
				pw.write("<h4>login failed please login again <a href='login.html'>Retry</a><h4>");
				
			}else {
				pw.print("<h4>validated user</h4>");
				
				if(user.getRole().equals("admin"))
				{
					response.sendRedirect("admin_page");
				}
				else {
					if(user.isStatus())
					{
						response.sendRedirect("logout");
						
					}
					else {
						response.sendRedirect("candidate_list");
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("err in doPost"+getClass()+ " "+e);
		}
	}

}
