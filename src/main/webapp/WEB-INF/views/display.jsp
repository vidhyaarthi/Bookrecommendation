<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="logout.jsp" /> 
<% String bookids = (String)session.getAttribute("bookids");
String bookidsarr[] = bookids.split(",");
String bookstitle = (String)session.getAttribute("bookstitle");
String bookstitlearr[] = bookstitle.split(",");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<head>
</head>
<body>
<h1>Books for you</h1>
<form name='display' method=POST action='/userfeedback'>
			<table border="1px solid black;"style="with: 50%">
				<tr>
					<th>ID</th>
					<th>TITLE</th>
					<th>FEEDBACK</th>
				</tr>
				
				<% for(int i=0; i<bookidsarr.length;i++){ %>				
					<tr>
					<td><%=bookidsarr[i] %></td>
					<td><%=bookstitlearr[i] %></td>
					<td><select name= "value<%=i%>">
  					<option value="Liked">Liked</option>
 					<option value="Disliked">Disliked</option>
  					<option value="Notinterested">Not interested</option>  
					</select></td>
				</tr>
				<% } %>				
				</table>
				<input type="submit" value="Submit"/></form>
</body>
</html>
