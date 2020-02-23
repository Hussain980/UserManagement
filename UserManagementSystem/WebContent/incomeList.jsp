<%@page import="com.pojo.Income"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.IncomeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="color: blue;">Income List</h1>
	<%
   
List<Income> wl=(List<Income>)session.getAttribute("wlist");
%>
	<table cellpadding="10" cellspacing="10" align="center" border="1">
		<tr>
		<th>IncomeId</th>
			<th>Income</th>
			<th>Income Type</th>
			<th>Income Date</th>
			<th>user email</th>
			<th colspan="2">Action</th>
		</tr>
		<tr>
			<% for(Income i : wl){
	%>
		</tr>
		<tr>
			<td><%=i.getIncomeId()%></td>
			<td><%=i.getIncome()%></td>
			<td><%=i.getIncomeType()%></td>
			<td><%=i.getIncomeDate()%></td>
			<td><%=i.getEmail()%></td>
			<td><a href="IncomeServlet?action=edit&incomeId=<%=i.getIncomeId()%>">Edit</a></td>
			<td><a href="IncomeServlet?action=delete&incomeId=<%=i.getIncomeId()%>">Delete</a></td>

		</tr>
		<% 
}
%>
	</table>
</body>
</html>