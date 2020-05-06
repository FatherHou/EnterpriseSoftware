package lesson.j2ee.ex5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class IncludeFilter
 */
public class IncludeFilter implements Filter {

	protected FilterConfig config;
    public void init(FilterConfig config)
        throws ServletException
    {
        this.config = config;
    }
    public void destroy()
    {
    }
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
        throws ServletException, IOException
    {
    	PrintWriter out = response.getWriter();
    	out.println("<h1 align=center>This is an included section!</h1>");
        chain.doFilter(request, response);
        

    }

}
