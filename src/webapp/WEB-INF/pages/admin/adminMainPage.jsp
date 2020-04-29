<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 21.04.2020
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="icon" href="/logo/A.ico" type="image/x-icon">
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


<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>password</th>
        <th>sex</th>
        <th>role</th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach var="userList" items="${usersList}" >
        <tr>
            <td>${userList.id}</td>
            <td>${userList.name}</td>
            <td>${userList.password}</td>
            <td>${userList.sex}</td>
            <td>${userList.getRole().toString()}</td>
            <td>
                <form method="get" action="/admin/edit">
                    <div>
                        <button type="submit">
                            <input hidden="true" value=${userList.id} name="id"> <!--Передаю параметры в editUserPage.jsp-->
                            <input hidden="true" value=${userList.name} name="name">
                            <input hidden="true" value=${userList.password} name="password">
                            <img src="https://upload.wikimedia.org/wikipedia/commons/c/cc/Edit_Notepad_Icon.svg"
                                 width="20px" height="20px">
                        </button>
                    </div>
                </form>
            </td>
            <td>
                <form method="get" action="/admin/delete">
                    <div>
                        <button type="submit">
                            <img src="https://cdn1.iconfinder.com/data/icons/ios-and-android-line-set-2/52/delete__remove__trash__dustbin-512.png"
                                 style="vertical-align: middle"
                                 width="20px" height="20px">
                            <input hidden="true" value=${userList.id} name="id">
                        </button>
                    </div>
                </form>
            </td>
        </tr>
        </tr>
    </c:forEach>
</table>

<form action="/admin/add" method="get">
    <button type="submit">New User</button>
</form>
<jsp:include page="../logout.jsp" />
Status: <%= session.getAttribute("status") %>
</body>
</html>
