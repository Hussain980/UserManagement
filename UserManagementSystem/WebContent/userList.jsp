<%@page import="com.pojo.User"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
h1{
   font-family: serif;
   font-size: xx-large;
   color: maroon;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" >List of Users</h1>
<%
/*   UserDao dv = new UserDao();
List<User> wl = dv.getUserList();
 */
 List<User> wl=(List<User>)session.getAttribute("wlist");
%>
<table cellpadding="10" cellspacing="10" align="center" border="1">
<tr>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th colspan="2">Action</th>
</tr>
<%
 for (User u : wl){
%>
<tr>
<td><%=u.getName()  %></td>
<td><%=u.getEmail()  %></td>
<td><%=u.getPassword()  %></td>
<td><a href="UserServlet?action=edit&email=<%=u.getEmail()%>">Edit</a></td>
<td><a href="UserServlet?action=delete&email=<%=u.getEmail()%>">Delete</a></td>
</tr>
<%
 }
%>

</table>

</body>
</html>