<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/27/2022
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form action="${pageContext.request.contextPath}/updateEmployee" name="f2" method="post">
        <div class="form-group">
            <label for="id">Id nhân viên</label>
            <input type="text" id="id" name="id" value="${admin.getId()}" readonly>
        </div>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" value="${admin.getUsername()}" >
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="text" id="password" name="password" placeholder="Nhập password..." value="${admin.getPassword()}">
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" placeholder="Nhập tên nhân viên..." value="${admin.getName()}">
        </div>
        <div class="form-group">
            <label for="age">Age</label>
            <input type="text" id="age" name="age" placeholder="Nhập age nhân viên..." value="${admin.getAge()}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" id="email" name="email" placeholder="Nhập email nhân viên..." value="${admin.getEmail()}">
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" id="phone" name="phone" placeholder="Nhập phone..." value="${admin.getPhone()}">
        </div>
        <div class="center">
            <button type="submit">Cập nhật</button>
            <button >Reset</button>
        </div>
    </form>

</head>
<body>

</body>
</html>
