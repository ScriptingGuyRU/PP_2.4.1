<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 23.04.2020
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
    <link rel="shortcut icon" href="/logo/D.ico" type="image/x-icon">
</head>
<body>
<form action="/admin/delete" method="POST">
    Id :<input type="text" name="id" value="<%= request.getParameter("id")%>" required>
    <div class="w3-container">
        <p><button class="w3-button w3-cyan" type="submit">Delete</button></p>
    </div>
</form>
<jsp:include page="../logout.jsp" />
</body>
</html>
