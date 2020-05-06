<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>item List</title>
</head>
<body>
<h4>Session List:</h4><hr><br><br>
 <table width="500" border="0" cellspacing="0" cellpadding="0">
    <c:forEach var="item" items="${hou}">
    <tr> 
      <td width="69">${item}</td>
    </tr>
    </c:forEach>
  </table>
</body>
</html>