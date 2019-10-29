<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<% if(session.getAttribute("status")!=null){%>
Register&nbsp;
<%=session.getAttribute("status")%>
<%} %>
<h1>Seller Login</h1>
<form action="./Login">
Phone Number &nbsp<input type = "text" name= "pNumber"><br><br>
Password &nbsp &nbsp &nbsp &nbsp &nbsp <input type = "password"  name = "password"><br><br><br>
<input type = "submit" name = "submit" value="login"><br><br><br>
<a href = "index.jsp">Click here for new registraion</a>
</form>
</body>
</html>

