<%@page import="com.pojo.Expense"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Expense ex = (Expense) session.getAttribute("ex");
	%>
	<form action="ExpenseServlet" method="post">
		<input type="hidden" name="action" value="updateExpense">
		
		<table align="center" cellpadding="10" cellspacing="10" border="1">
		<input type="hidden" name="id" value="<%=ex.getExpenseId() %>">
			<tr>
				<td>UserEmail:</td>
				<td><input type="email" name="userEmail"
					value="<%=ex.getUserEmail()%>" readonly="readonly"></td>
			</tr>

			<tr>
				<td>Expense:</td>
				<td><input type="text" name="expense" value="<%=ex.getExpense()%>"></td>
			</tr>
			<tr>
				<td>ExpenseType:</td>
				<td><input type="text" name="expenseType"
					value="<%=ex.getExpenseType()%>"></td>
			</tr>
			<tr>
				<td>ExpenseDate:</td>
				<td><input type="text" name="expenseDate"
					value="<%=ex.getExpenseDate()%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="submit"></td>
			</tr>
		</table>

	</form>
</body>
</html>