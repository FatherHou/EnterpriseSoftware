<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="beercolor" class="hby.Beer" scope="request">
<jsp:setProperty property="color" name="beercolor" value="Light"/>
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String color = request.getParameter("color");
	if(color.equals("amber")){
%>
	<!--if use this statement:response.sendRedirect("ShowAmberBeer.jsp") the result is? -->
    <jsp:forward page="ShowAmberBeer.jsp" />
<%	}
	if(color.equals("brown")){
		response.sendRedirect("ShowBrownBeer");
	}
	if(color.equals("dark")){
	    RequestDispatcher view = request.getRequestDispatcher("ShowDarkBeer");
	    view.forward(request, response);
	}
%>
<jsp:include page="Header_act.jsp">
	<jsp:param name="subTitle" value="Welcome to the Light Beer World!"/>
</jsp:include>
<jsp:include page="BeerListEL.jsp">
	<jsp:param name="beerel2" value="Light"/>
</jsp:include>
<jsp:include page="BeerListEL2.jsp"/>
<%@ include file="DisplayItem.jsp" %>
<html>
<body>
<h2>color:<jsp:getProperty property="color" name="beercolor"/></h2>
</body>
</html>