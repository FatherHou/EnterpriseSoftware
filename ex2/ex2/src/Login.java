import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{

		String name = req.getParameter("name");
		String password = req.getParameter("password");
//		Cookie uname=new Cookie("name",req.getParameter("name"));
//		Cookie uword=new Cookie("password",req.getParameter("password"));
		boolean judge = true;
		System.out.println(name);
//		HttpSession session=req.getSession();
		Cookie cookies[] = req.getCookies();
	    if (cookies != null)
	    {
	    	String cookie_name=null;
	    	String cookie_password=null;
//	    	String name2="";
//	    	String password="";
	    	for (int i = 0; i < cookies.length; i++)
	        {
	    		//这里即检测
/*	    		Cookie c=cookies[i];
	    		if(c.getName().equalsIgnoreCase("name")){
	    			name2=c.getValue();
	    		}
	    		else if(c.getName().equalsIgnoreCase("password")){
	    			password=c.getValue();
	    		}*/
	            if (cookies[i].getName().equals("name"))
	            {
	            	cookie_name=cookies[i].getValue();
//	            	res.sendRedirect("./UserLogin.html");
	            	cookies[i].setValue(name);
	            	judge = false;
	            }
	            if(cookies[i].getName().equals("password"))
	            {
	            	cookie_password=cookies[i].getValue();
	            }
	        }
/*	    	if(cookie_name!=null&&cookie_password!=null)
	    	{
	    		 System.out.println("试图使用cookie登陆"+cookie_name+"\t"+cookie_password);
	                //把姓名和密码发到ValidateUser2 进行验证,如果验证成功就跳转到登陆后的页面,否则跳回来
	                res.sendRedirect("ValidateUser2?uname=" + cookie_name
	                        + "&upswd=" + cookie_password);
	                // 验证成功就登陆
	                // 验证失败, 就返回, ,注意这里可能是死循环.. 需要特别解决和注意
	                // 因为cookie里的数据不对,返回登陆,返回后登陆又检测到cookie又验证登陆,又验证失败,返回登陆...
	                // 所以登陆失败.就删除掉cookie 
	    	}*/
	    }
	    
	    if(judge)
	    {
	    	Cookie cookie = new Cookie("name", name);
		    //�����õĻ�����cookies��д��Ӳ��,����д���ڴ�,ֻ�ڵ�ǰҳ������,����Ϊ��λ
		    cookie.setMaxAge(24*60*60);
		    res.addCookie(cookie);
	    }
	    PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		
		out.println("<html>");
		out.println("<title>");
		out.println("User list");
		out.println("</title>");
		out.println("<body><h4>User List:</h4><hr><br><br>");
	    if (cookies != null)
	    {
	        for (int i = 0; i < cookies.length; i++)
	        {
	            if (cookies[i].getName().equals("name"))
	            {
	            	
	            	out.print(cookies[i].getValue());
	            }
	        }
	    }
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}