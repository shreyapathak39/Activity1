package p1;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doThings(request, response);
	}//end doPost
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doThings(request, response);
	}
	
	protected void doThings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
	
		if(username.equals("ramesh")&&password.equals("123"))
		{
			// ---- create a session
			HttpSession session = request.getSession(true); // always create new session
			
			session.setAttribute("username",username);
			session.setAttribute("logintime", new Date().toString());
			
			request.getRequestDispatcher("SessionServlet").forward(request, response);
			
			// move user to SessionServlet
		}
		else
		{
			// for wrong users
			 System.out.println("user not found ");
	            request.getRequestDispatcher("LoginPage.html").include(request, response);  
		}
		
	}
	
	

}