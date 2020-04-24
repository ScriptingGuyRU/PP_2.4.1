<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 23.04.2020
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/admin/add" method="post">
        <p>Имя:</P>
        Name :<input type="text" name="name" required>
        <p>Пароль:</P>
        Password :<input type="text" name="password" required>
        <p>Пол:</p>
        <select name="sex">
            <option disabled>Пол :</option>
            <option selected value="MALE">Мужской</option>
            <option selected value="FEMALE">Женский</option>
        </select>

        <select name="role">
            <option disabled>Role :</option>
            <option selected value="ADMIN">Admin</option>
            <option selected value="USER">User</option>
        </select>
        <button type="submit">Add</button>
    </form>
</body>
</html>
