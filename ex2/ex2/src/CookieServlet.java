

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        String uname=request.getParameter("name");
        String password=request.getParameter("password");
        String ck=request.getParameter("ck");
        
        //被选中的状态是on 没有被选中的状态下是null
        if("on".equals(ck)){
        //构造Cookie对象
        //添加到Cookie中
        Cookie c=new Cookie("users", uname+"-"+password);
        
        //设置过期时间
        c.setMaxAge(600);
        
        //存储
        response.addCookie(c);
    }
  
    }

}
