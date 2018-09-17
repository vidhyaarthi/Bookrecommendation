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
<h1>Registration Form</h1>
<form name='registration' method=POST action='/user' onSubmit="return formValidation()">
			<table style="with: 50%">
				<tr>
					<td>Enter a User Name</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Enter a password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Confirm password</td>
					<td><input type="password" name="password1" /></td>
				</tr>
				</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>

