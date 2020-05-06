<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h4>Session List:</h4><hr><br><br>
<c:forEach var="selected" items="${session}">
${selected}<hr>
</c:forEach>
<%

		Integer itemCount=(Integer)session.getAttribute("itemCount");
		if (itemCount==null)
			itemCount=new Integer(0);		
		String[] itemsSelected;
		String itemName;
		itemsSelected=request.getParameterValues("item");

		if(itemsSelected !=null){
			for(int i=0;i<itemsSelected.length;i++){
				itemName=itemsSelected[i];
				itemCount=new Integer(itemCount.intValue()+1);
				session.setAttribute("item"+itemCount,itemName);
				session.setAttribute("itemCount",itemCount);
			}
		}
		for(int i=1;i<=itemCount.intValue();i++){
			out.println((String)session.getAttribute("item"+i)+"<hr>");
		}
%>
</body>
</html>