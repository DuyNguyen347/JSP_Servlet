<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/25/2022
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="checkLoginServlet" method="post">
    Username: <input type="text" name="username"/>
    Password: <input type="text" name="password"/>
    <input type="submit" value="Login"/>
    <input type="reset" value="Reset"/>
</form>
</body>
