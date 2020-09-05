package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doThings(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		// getSession(false)-> provide old session otherwise create new one

		PrintWriter out = response.getWriter();
	
	if(session != null)
	{
		String username = (String) session.getAttribute("username");
		String  LoginTime = (String) session.getAttribute("LoginTime");


		
		out.print("<HTML><BODY>");
		out.print("Welcome "+username+"<br/>");
		out.print("<hr/>");
		
		out.print("</BODY></HTML>");
		request.getRequestDispatcher("LogoutServlet").forward(request, response);
		
	}
	else
	{
		response.sendRedirect("LoginPage.html");
	}

}
}
