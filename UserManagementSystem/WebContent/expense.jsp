<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<%	String user = (String) session.getAttribute("user"); %>
<form action="ExpenseServlet" method="post">
	<input type="hidden" name="action" value="addExpense"> 
		<table align="center" cellpadding="10" cellspacing="10" border="1">
			<tr>
				<td>UserEmail
				</td>
				<td><input type="text" name="userEmail" value="<%=user %>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>Expense
				</td>
				<td><input type="text" name="expense">
				</td>
			</tr>
			<tr>
				<td>expenseType
				</td>
				<td><input type="text" name="expenseType">
				</td>
			</tr>
			<tr>
				<td>expenseDate
				</td>
				<td><input type="date" name="expenseDate">
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