package hby;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowDarkBeer extends HttpServlet {

	/**
	 * The doPost method implements the request and response between browser and 
	 * server
	 * 
	 * @param request the browser request
	 * @param response the server response
	 * 
	 * @throws IOException if there are errors from the input
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws IOException { 
		String colorParam = "Dark"; 
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<title>");
		out.println("Brown");
		out.println("</title>");
		out.println("<body><img src=image/java.png><br>");
		out.println("<em><strong>Welcome to the Dark Beer World!</strong></em><br>");
		out.println("<h1 align=center>A Beer List of the color you selected</h1>");
		out.println("<hr>");
		out.println("<p><b>You hava selected the "+colorParam+" Beer</b></p>");
		out.println("<p><b>Choose following information:</b></p>");
		out.println("<form method=post action=SelectedBeerColor.jsp>");
		out.println("<table width=500 border=0 cellspacing=0 cellpadding=0>");
		out.println("<tr> ");
		out.println("<td width=69> ");
		out.println("<input type=checkbox name=item value=The_light_beer_of_China>");
		out.println("</td>");
		out.println("<td width=431>Item1: The light beer of China</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=69>");
		out.println("<input type=checkbox name=item value=The_amber_beer_of_China>");
	    out.println("</td>");
	    out.println("<td width=431>Item2: The amber beer of China</td>");
	    out.println("</tr>");
	    out.println("<tr>"); 
	    out.println("<td width=69>");
	    out.println("<input type=checkbox name=item value=The_beer_of_American>");
	    out.println("</td>");
	    out.println("<td width=431>Item3: The beer of American</td>");
	    out.println("</tr>");
	    out.println("</table>");
	    out.println("<hr>");
	    out.println("<p>");
	    out.println("<center>");
	    out.println("<input type=submit name=btn_submit value=Buy Now>");
	    out.println("</center>");
	    out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
