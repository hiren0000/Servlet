package servelet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.dao.LogInDao;


@WebServlet("/login")
public class Login extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  PrintWriter out = response.getWriter();
		  
		  String uname = request.getParameter("uname");
		  String pass = request.getParameter("pass");
		  
		  LogInDao dao = new LogInDao();
		  

		  try {
		  if(dao.check(uname, pass))
		  {
			  response.sendRedirect("welcome.jsp");
			  HttpSession session = request.getSession();
			  session.setAttribute("username", uname);
		  }
		  else
		  {
			  response.sendRedirect("login.jsp");
		  }
		  
		  }
		  catch(Exception e)
		  {
			  System.out.println("smtng wrng with the servelet");
			  
		  }
		
	}

	

}
