<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 20.04.2020
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        TABLE {
            width: 300px; /* Ширина таблицы */
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        TD, TH {
            padding: 3px; /* Поля вокруг содержимого таблицы */
            border: 1px solid black; /* Параметры рамки */
        }
        TH {
            background: #b0e0e6; /* Цвет фона */
        }
    </style>
</head>
<body>

<p> ${localeCar}</p>

<table>
    <tr>
        <th>Model</th>
        <th>Nomber</th>
        <th>Year</th>
    </tr>

    <c:forEach var="carList" items="${cars}" >
        <tr>
            <td>${carList.getModel()}</td>
            <td>${carList.number}</td>
            <td>${carList.year}</td>
        </tr>
    </c:forEach>
</table>

<form method="post" action="/car?locale=en" >
    <button type="submit">Reroll (locale en)</button>
</form>
<form method="post" action="/car?locale=ru" >
    <button type="submit">Goto Car (locale ru)</button>
</form>

<%--<img src="https://i.pinimg.com/originals/87/af/ef/87afef76100d0b704ca5b6039468a736.jpg" width="450px" height="450px">--%>

</body>
</html>
