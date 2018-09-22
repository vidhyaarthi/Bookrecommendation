<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String bookids = (String)session.getAttribute("bookids");
String bookstitle = (String)session.getAttribute("bookstitle");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<head>
</head>
<body>
<h1>Books for you</h1>
			<table style="with: 50%">
				<tr>
					<th>ID</th>
					<th>TITLE</th>
				</tr>
				<tr>
					<td>"<%=bookids %>"</td>
					<td>"<%=bookstitle %>"</td>
				</tr>
				</table>
</body>
</html>
