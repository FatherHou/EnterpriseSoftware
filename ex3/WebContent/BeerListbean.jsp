<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="beercolor" class="hby.Beer" scope="request">
<jsp:setProperty property="color" name="beercolor" value="light"/>
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BeerList bean</title>
</head>
<body>
<h1>color:<jsp:getProperty property="color" name="beer"/></h1>
</body>
</html>