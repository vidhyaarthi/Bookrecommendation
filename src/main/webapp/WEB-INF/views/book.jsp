<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="logout.jsp" /> 
<% int userId =(Integer)session.getAttribute("userId"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<head>
</head>
<body>
<h1></h1>
<form name='book' method=GET action='/user/{userId}/book'>
<center><input type="submit" value="Click here to see your recommendations"/></center></form>
</body>
</html>

