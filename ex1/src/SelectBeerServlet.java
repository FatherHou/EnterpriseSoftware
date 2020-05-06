
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

public class SelectBeerServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		this.doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException { 
		String colorParam = request.getParameter("color"); 
		PrintWriter out = response.getWriter();
		if(colorParam.equals("brown")){
			response.sendRedirect("/ex1/ShowBrownBeer");	
		}
		else if(colorParam.equals("dark")){
			RequestDispatcher view=request.getRequestDispatcher("/ShowDarkBeer");
			view.forward(request, response);
		}
		else{
			out.println("<html> " + "<body>"
					+ "<h1 align=center>Beer Color</h1>" + "<br>"
					+ "My selected beer color is: " + colorParam + "</body>" + "</html>");
			}
	}
}
