
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ValidateUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = (String) request.getParameter("name");//从request里获得用户名和密码
		String upswd = (String) request.getParameter("password");
		Cookie[] cs = request.getCookies();
		String name = null;
		String pswd = null;
		if(cs!=null){
		for(int j=0;j<cs.length;j++){
			Cookie c=cs[j];
			if(c.getName().equals("name")){
				name=c.getValue();
			}
			else if(c.getName().equals("password")){
				pswd=c.getValue();
			}
		}
		}
		if(name.equals(uname)&&pswd.equals(upswd)){
			((HttpServletResponse) request).sendRedirect("./test.html");
		}else{
		            if(cs!=null&&cs.length!=0){
		                for (int i = 0; i < cs.length; i++) {
		                    if(cs[i].getName().equals("name")){
		                        cs[i] = new Cookie("name",null);
		                        cs[i].setMaxAge(0);
		                        ((HttpServletResponse) request).addCookie(cs[i]);
		                    }else if(cs[i].getName().equals("password")){
		                        cs[i] = new Cookie("password",null);//删除cookie
		                        cs[i].setMaxAge(0);
		                        ((HttpServletResponse) request).addCookie(cs[i]);
		                    }
		                }
		            }
		    ((HttpServletResponse) request).sendRedirect("./UserLogin.html");//返回Login2
		}
	}

}
