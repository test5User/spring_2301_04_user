<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>age</th>
            <th>city</th>
            <th>street</th>
            <th>house</th>
            <th>action</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.address.city}</td>
                <td>${user.address.street}</td>
                <td>${user.address.house}</td>
                <td>
                    <a href="/del?id=${user.id}">delete</a>
                    <a href="/upd?id=${user.id}&name=${user.name}&age=${user.age}">update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
