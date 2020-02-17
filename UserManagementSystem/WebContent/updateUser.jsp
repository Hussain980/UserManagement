
<!DOCTYPE html>
<%@page import="com.pojo.User"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% User u=(User)session.getAttribute("u"); %>
	<form action="UserServlet" method="post">
	<input type="hidden" name="action" value="updateUser"> 
		<table align="center" border="1" cellpadding="10" cellspacing="10">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%=u.getName()%>"></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="<%=u.getEmail()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password" value="<%=u.getPassword()%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="submit"></td>
			</tr>
		</table>

	</form>

</body>
</html>