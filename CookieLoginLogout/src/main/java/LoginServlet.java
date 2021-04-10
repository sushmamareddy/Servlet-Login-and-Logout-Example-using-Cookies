import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html"); 
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		if(pass.equals("admin"))
		{
			out.println("You are successfully logged in!");
			out.println("<br> Welcome, "+name);
			RequestDispatcher rd = req.getRequestDispatcher("link.html");
			rd.include(req, res);
			
			Cookie ck = new Cookie("name",name);
			res.addCookie(ck);
		}
		else
		{
			out.println("Sorry,username and password error!");
			RequestDispatcher rd  = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
}
