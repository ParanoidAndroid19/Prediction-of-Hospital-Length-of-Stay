package com.conn.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.dao.LoginInfoDaoImpl;
import com.conn.dao.LoginInfoInterface;
import com.conn.pojo.LoginInfo;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if(action==null)
			response.sendRedirect("login.jsp");
		if(action.equals("registration")){
			
			String name = request.getParameter("name");
			String user_name = request.getParameter("user_name");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String pincode = request.getParameter("pincode");
			long contact_no = Long.parseLong(request.getParameter("contact_no"));
			String role = request.getParameter("role");
			String status = "active";
		    LoginInfo loginInfo = new  LoginInfo(name, user_name, password,
				 address, contact_no, city,state,
					 pincode, role, status);
		    LoginInfoInterface loginInfoInterface = new LoginInfoDaoImpl();
		    boolean isSaved = loginInfoInterface.saveLoginInfo(loginInfo);
		    String pageName="";
		    if(isSaved){
		    	pageName="success.jsp";
		    }else{
		    	pageName="login.jsp";
		        request.setAttribute("message", "sorry try again later");
		    }
		    	
		    RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageName);
			requestDispatcher.forward(request, response);
		    
			
		}else if(action.equals("login")){
			
			String user_name = request.getParameter("user_name");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			String status = "active";
			LoginInfoInterface loginInfoInterface = new LoginInfoDaoImpl();
			LoginInfo loginInfo =  loginInfoInterface.getLoginInfoByUserNameAndPasswordAndRoleAndStatus(user_name, password, role, status);
			String pageName="";
			if(loginInfo!=null){
				session.setAttribute("user",loginInfo);
				if(role.equals("doctor"))
					pageName = "doctorHome.jsp";
				else if(role.equals("admin"))
					pageName = "adminHome.jsp";
				
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageName);
				requestDispatcher.forward(request, response);
			}
			else{
				request.setAttribute("message", "Invalid user name or password");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			}
			
			
		}
		
	}

}
