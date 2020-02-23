<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
	font: bold;
	font-family: serif;
	
}
h1
{
  color: blue;
 
}
</style>
</head>
<body>
<h1 align="center">Registration form</h1>
	<form action="UserServlet" method="post">
	 <input type="hidden" name="action" value="addUser"> 
		<table align="center" cellpadding="10" cellspacing="10" border="1">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			
				<td>email</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
			<td colspan="2" align="center"><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>

</body>
</html>