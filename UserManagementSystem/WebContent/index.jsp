<%@page import="com.dao.IncomeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h1{
  color: maroon;
  font-family: serif;

}

.main {
  margin-left: 260px; /*160 Same as the width of the sidenav */
  font-size: 15px; /* 28 Increased text to enable scrolling */
  padding: 0px 10px;
}

</style>
</head>
<body>
<h1 align="center">User Management System</h1>
<hr>
<img alt="User" src="user.jpg" width="1240" height="620" style="float:right; padding: 20px">
		<%
String user=(String)session.getAttribute("user");
String admin=(String)session.getAttribute("admin");
%>

<%-- <%double balance=new IncomeDao().getBalance(user); %> --%>
	<jsp:include page="sidebar.jsp"></jsp:include> 
<!-- 	<div class="main"> -->
<%-- 	<%if(user!=null){ %> --%>
<%-- 	<h1>Your Account Balance is : <%=balance %></h1> --%>
<%-- 	<%} %> --%>
<!-- 	</div> -->

</body>
</html>

