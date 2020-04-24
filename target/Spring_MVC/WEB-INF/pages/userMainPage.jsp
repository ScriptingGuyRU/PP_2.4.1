<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 23.04.2020
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <iframe src="https://coronavirus-monitor.ru/map" frameBorder="0" height="500" width="1500" style="max-width: 100%;"></iframe>

    <script src="https://apps.elfsight.com/p/platform.js" defer></script>
    <div class="elfsight-app-ac156760-2281-4766-bd4f-d8f93f7ef965"></div>

    <form action="/logout" method="post">
        <a href="/logout"></a>
        <button type="submit">LogOut</button>
    </form>
</body>
</html>
