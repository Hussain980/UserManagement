<%@page import="com.pojo.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.ExpenseDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<h1 align="center" style="color: blue;">Expense List</h1>
	<%
   
List<Expense> exlist =(List<Expense>)session.getAttribute("exlist");
%>
	<table cellpadding="10" cellspacing="10" align="center" border="1">
		<tr>
		<th>ExpenseId</th>
			<th>Expense</th>
			<th>Expense Type</th>
			<th>ExpenseDate</th>
			<th>user email</th>
			<th colspan="2">Action</th>
		</tr>
		<tr>
			<% for(Expense ex : exlist){
	%>
		</tr>
		<tr>
			<td><%=ex.getExpenseId()%></td>
			<td><%=ex.getExpense()%></td>
			<td><%=ex.getExpenseType()%></td>
			<td><%=ex.getExpenseDate()%></td>
			<td><%=ex.getEmail()%></td>
			<td><a href="ExpenseServlet?action=edit&expenseId=<%=ex.getExpenseId()%>">Edit</a></td>
			<td><a href="ExpenseServlet?action=delete&expenseId=<%=ex.getExpenseId()%>">Delete</a></td>

		</tr>
		<% 
}
%>
	</table>
</body>
</html>