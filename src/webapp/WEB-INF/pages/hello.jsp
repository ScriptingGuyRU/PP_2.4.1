<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<c:forEach var="msq" items="${messages}">
    <h1>${msq}</h1>
</c:forEach>

<%--<img src="https://1.bp.blogspot.com/-yi7t7kq3DB8/Xk86VJmCHgI/AAAAAAAAAEc/EV2A9zeC8CkNsjlIHSIeJ0svjnEDa-rvgCLcBGAsYHQ/s1600/%25D0%259C%25D0%25B8%25D0%25BB%25D1%258B%25D0%25B5%2B%25D0%25B0%25D0%25BD%25D0%25B8%25D0%25BC%25D0%25B5%2B%25D0%25B4%25D0%25B5%25D0%25B2%25D1%2583%25D1%2588%25D0%25BA%25D0%25B8.png" height="200px" width="200px"/>--%>
<form method="get" action="/car" >
    <button type="submit">Goto Car</button>
</form>
</body>
</html>