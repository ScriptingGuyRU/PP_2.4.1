<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 23.04.2020
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link rel="shortcut icon" href="/logo/E.ico" type="image/x-icon">
</head>
<body>
<form action="/admin/edit" method="post">
    <p>ID пользователя:</P>
    ID :<input type="text" name="id" value="<%= request.getParameter("id")%>" readonly>
    <p>Новое имя:</P>
    Name :<input type="text" name="name" value="<%= request.getParameter("name")%>" required>
    <p>Новый пароль:</P>
    Password :<input type="text" name="password" value="<%= request.getParameter("password")%>" required>
    <p>Пол:</p>
    <select name="sex">
        <option disabled>Пол :</option>
        <option selected value="MALE">Мужской</option>
        <option selected value="FEMALE">Женский</option>
    </select>

    <p/>
    <input type="checkbox" name="user" value="user">USER<Br>
    <input type="checkbox" name="admin" value="admin">ADMIN<Br>
    <div class="w3-container">
        <p><button class="w3-button w3-cyan" type="submit">Edit</button></p>
    </div>
</form>
<jsp:include page="../logout.jsp" />
</body>
</html>
