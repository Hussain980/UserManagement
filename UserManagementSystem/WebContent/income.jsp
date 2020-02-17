<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%		String user = (String) session.getAttribute("user");
 %>
	<form action="IncomeServlet" method="post">
	<input type="hidden" name="action" value="addIncome">
		<table align="center" cellpadding="10" cellspacing="10" border="1">
			<tr>
				<td>UserEmail
				</td>
				<td><input type="email" name="userEmail" value="<%=user %>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>Income
				</td>
				<td><input type="text" name="income">
				</td>
			</tr>
			<tr>
				<td>IncomeType
				</td>
				<td><input type="text" name="incomeType">
				</td>
			</tr>
			<tr>
				<td>IncomeDate
				</td>
				<td><input type="date" name="incomeDate">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="save">
				</td>
			</tr>

		</table>



	</form>
</body>
</html>