<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
	font-family: "Lato", sans-serif;
}

.sidenav {
	height: 100%;
	width: 260px;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	padding-top: 20px;
}

.sidenav a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
}

.sidenav a:hover {
	color: #f1f1f1;
	background: purple;
	transition: 0.05s;
}
</style>

<title>Insert title here</title>
</head>
<body>
	<div class="sidenav">

		<%
String user=(String)session.getAttribute("user");
String admin=(String)session.getAttribute("admin");
%>
	
		<%if(user!=null && admin==null){ %>
		<a href="index.jsp">Home</a> 
		<a href="income.jsp">Addincome</a> 
		<a href="IncomeServlet">IncomeList</a>
		<a href="expense.jsp">AddExpense</a> 
		<a href="ExpenseServlet">Expense List</a>
		<%}%>
		<%if(admin!=null && user==null){ %>


		<a href="UserServlet">UserList</a>

		<%} %>
		<%if(user==null && admin==null){ %>
		<a href="registration.jsp">REGISTER</a>
		<a href="login.jsp">Login</a>
		<a href="aboutUs.jsp">AboutUs</a>

		<%} %>
		<%if(user!=null || admin!=null) {%>
		<h1>
			<a href="LoginServlet">LogOut</a>
		</h1>


		<%} %>
	</div>
</body>
</html>