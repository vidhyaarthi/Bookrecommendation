<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<head>
</head>
<body>
<h1>Login Form</h1>
<form name='login' method=POST action='/userlogin'>
			<table style="with: 50%">
				<tr>
					<td>Enter a User Name</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Enter a password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				</table>
			<input type="submit" value="Submit"/></form>
</body>
</html>
