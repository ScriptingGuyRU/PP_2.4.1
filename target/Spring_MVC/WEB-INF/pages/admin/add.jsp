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
        Name :<input type="text" name="name" required>
        Password :<input type="text" name="password" required>
        <p>Пол: <select name="sex">
                    <option disabled>Пол :</option>
                    <option selected value="MALE">Мужской</option>
                    <option selected value="FEMALE">Женский</option>
                </select>
        </p>
        <p/>
        <input type="checkbox" name="user" value="user">USER<Br>
        <input type="checkbox" name="admin" value="admin">ADMIN<Br>
        <button type="submit">Add</button>
    </form>
    <jsp:include page="../logout.jsp" />
</body>
</html>
