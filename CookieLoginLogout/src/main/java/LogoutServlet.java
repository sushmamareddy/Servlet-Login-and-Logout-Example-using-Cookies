import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		RequestDispatcher rd = req.getRequestDispatcher("link.html");
		rd.include(req, res);
		
		Cookie ck = new Cookie("name","");
		ck.setMaxAge(0);
		res.addCookie(ck);
		
		out.println("You are successfully logged out");
		
	}
}
