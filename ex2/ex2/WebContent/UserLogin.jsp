<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","No-cache");
response.setDateHeader("Expires", -1);
response.setHeader("Cache-Control", "No-store");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%

//e1表达式
String names="";
String pwd="";
//取出Cookie
Cookie [] c=request.getCookies();
if(c!=null){
for(int i=0;i<c.length;i++){
    if(c[i].getName().equals("users")){
        //存着数据(用户名+密码)
        names=c[i].getValue().split("-")[0];
        pwd=c[i].getValue().split("-")[1];
        
        //再一次存起来(备用)
        request.setAttribute("xingming",names);
        request.setAttribute("mima", pwd);
    }
}
}

 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
<title>Login</title>
</head>
<body>
	<body bgcolor="#FFFFFF">
	<h1 align="center">User Login</h1>
	<hr>
	<p><b>User information:</b></p>
	<form action="./CookieServlet" method="post">
		  <table width="500" border="0" cellspacing="0" cellpadding="0">
    <tr> 
      <td width="100"> 
        User name:
      </td>
      <td width="431">
	  	<input type="text" name="name" id="uname" value="${xingming}"/>
	  </td>
    </tr>
    <tr> 
      <td width="100">
        Password:
      </td>
      <td width="431">
      	<input type="password" name="password" id="password" value="${mima }"/>
      </td>
    </tr>
  </table>
  <hr>
  <p>
    <input type="submit" name="btn_submit" value="Login">
    <input type="reset" name="btn_reset" value="Reset">
    <input type="checkbox" name="ck">remember<br>
  </p>
</body>
</html>