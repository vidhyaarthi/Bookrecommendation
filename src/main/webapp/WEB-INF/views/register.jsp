<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<head>
<script type="text/javascript">
function formValidation()
{
var password = document.registration.password.value;
var password1 = document.registration.password1.value;
if(password == password1)
{
	return true;
}
else
{
	alert("Passwords doesnot match");
	return false;
}
}
</script>
</head>
<body>
<h1><center>Registration Form</center></h1>
<form name='registration' method=POST action='/user' onSubmit="return formValidation()">
			<center> <table border="1" style="with: 50%">
				<tr>
					<td bgcolor="#D3D3D3">Enter a User Name</td><br>
					<td bgcolor="#87cefa"><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td bgcolor="#D3D3D3">Enter a password</td><br>
					<td bgcolor="#87cefa"><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td bgcolor="#D3D3D3">Confirm password</td><br>
					<td bgcolor="#87cefa"><input type="password" name="password1" /></td>
				</tr>
				<tr>	
				<td></td><td>	
					<center><input type="submit" value="Submit"/></center></td>
				</tr>
				</table></center></form>
</body>
</html>

