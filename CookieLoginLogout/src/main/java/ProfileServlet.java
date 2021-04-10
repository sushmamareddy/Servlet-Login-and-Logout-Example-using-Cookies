import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		RequestDispatcher rd = req.getRequestDispatcher("link.html");
		rd.include(req, res);
		
		Cookie ck[] = req.getCookies();
		if(ck!=null)
		{
			String name = ck[0].getValue();
			if(!name.equals("") || name!=null)
			{
				out.println("<b>welcome to Profile <b>");
				out.println("<br> Welcome, "+name);
				
			}
		}
		else
		{
			out.println("Login first!!");
			RequestDispatcher rs = req.getRequestDispatcher("login.html");
			rs.include(req, res);
		}
		
	}
}
