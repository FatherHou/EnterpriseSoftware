<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<jsp:useBean id="bearList" class="lesson.j2ee.ex6.model.BeerList" scope="request">
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>item list</title>
</head>
<body>
<h4>Session List:</h4><hr><br><br>
<c:forEach items="${bearList.beerList}" var="cbeer" varStatus="jisuan">
<c:choose>
<c:when test="${jishu[jisuan.count-1]!=0 }">
	<h5>id:${cbeer.id}</h5>
	<h5>name:${cbeer.name}</h5>
	<h5>manufacturer:${cbeer.manufacturer}</h5>
	<h5>color:${cbeer.color}</h5>
	<h5>quantity:${jishu[jisuan.count-1]}</h5>
	<hr>
</c:when>
</c:choose>
</c:forEach>
</body>
</html>