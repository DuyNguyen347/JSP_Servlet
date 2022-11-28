<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/25/2022
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Admin"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
</head>
<body>
<h3>Danh sach nhan vien trong list</h3>
<table border="1">
  <tr>
    <th>Name</th>
    <th>Age</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Username</th>
    <th>Cập nhật</th>
    <th>Xoá</th>
  </tr>
  <%
    ArrayList<Admin> adminList = (ArrayList<Admin>)request.getAttribute("adminList");
    for(int i = 0; i < adminList.size(); i++){
  %>
  <tr>
    <td><%= adminList.get(i).getName() %></td>
    <td><%= adminList.get(i).getAge() %></td>
    <td><%= adminList.get(i).getEmail() %></td>
    <td><%= adminList.get(i).getPhone() %></td>
    <td><%= adminList.get(i).getUsername() %></td>
    <td><a href="${pageContext.request.contextPath}/updateEmployee?id=<%= adminList.get(i).getId() %>">Cập nhật</a></td>
    <td><a href="${pageContext.request.contextPath}/deleteEmployee?id=<%= adminList.get(i).getId() %>">Xoá</a></td>
  </tr>
  <%} %>
</table>
<a href="addEmployee.jsp">Add employee</a>
</body>
</html>
