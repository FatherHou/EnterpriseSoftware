<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="MyFirstTag" prefix="mytag"%>
<%@ taglib uri="MySecondTag" prefix="simple"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select a color for beer!</title>
</head>
<body>
<%@ include file="Header_ins.jsp" %>
<h1 align="center">Beer Selection Page</h1>
<!-- Commit to a Servlet Page -->
<!-- form method="POST" action="SelectBeer.do" -->
<!-- Commit to a JSP Page -->
<form method="POST" action="BeerList.jsp">
This application has been visited  
<simple:counter/> 
  times.<p> 
  There are kinds of beer for choose.<p>
 <simple:colorSelect/>
  <center> 
    <input type="SUBMIT" value="Submit"> 
  </center>
</form>
</body>
</html>
