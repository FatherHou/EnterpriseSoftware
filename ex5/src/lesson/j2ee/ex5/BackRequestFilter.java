package lesson.j2ee.ex5;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class BackRequestFilter
 */
public class BackRequestFilter implements Filter {

	private FilterConfig config = null;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponse httprep = (HttpServletResponse) response;
		String redirectPath=config.getInitParameter("redirectPath");
		String hosturl=httpreq.getRequestURI();
		String method = httpreq.getMethod().toLowerCase();
		if(method.equals("get")){
		if(hosturl!="SelectBeer.jsp"){
			httprep.sendRedirect(redirectPath);
			return;
		}
		}
		else{
			chain.doFilter(request, response);
			return;
		}
	}

	public void destroy() {
		this.config = null;

	}

}
