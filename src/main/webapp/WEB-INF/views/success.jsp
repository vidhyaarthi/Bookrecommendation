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
<h1><center>Login Form</center></h1>
<form name='login' method=POST action='/userlogin'>
			<center><table style="with: 50%">
				<tr>
					<td bgcolor="#D3D3D3">Enter a User Name</td>
					<td bgcolor="#87cefa"><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td bgcolor="#D3D3D3">Enter a password</td>
					<td bgcolor="#87cefa"><input type="password" name="password" /></td>
				</tr>
				<tr>
				<td></td><td>			
					<center><input type="submit" value="Submit"/></center></td>
				</tr>
				</table></center></form>
</body>
</html>
