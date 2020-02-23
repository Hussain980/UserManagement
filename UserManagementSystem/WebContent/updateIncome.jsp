<%@page import="com.pojo.Income"%>
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
		Income i = (Income) session.getAttribute("i");
	%>
	<form action="IncomeServlet" method="post">
		<input type="hidden" name="action" value="updateIncome">
		
		<table align="center" cellpadding="10" cellspacing="10" border="1">
		<input type="hidden" name="id" value="<%=i.getIncomeId() %>">
			<tr>
				<td>UserEmail:</td>
				<td><input type="email" name="userEmail"
					value="<%=i.getEmail()%>" readonly="readonly"></td>
			</tr>

			<tr>
				<td>Income:</td>
				<td><input type="text" name="income" value="<%=i.getIncome()%>"></td>
			</tr>
			<tr>
				<td>IncomeType:</td>
				<td><input type="text" name="incomeType"
					value="<%=i.getIncomeType()%>"></td>
			</tr>
			<tr>
				<td>IncomeDate:</td>
				<td><input type="text" name="incomeDate"
					value="<%=i.getIncomeDate()%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="submit"></td>
			</tr>
		</table>

	</form>
</body>
</html>