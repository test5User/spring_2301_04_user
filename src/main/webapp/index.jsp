<%@ page import="by.itclass.constants.AppConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index Page</title>
</head>
<body>
    <p>
        <a href="<%= AppConstants.ALL_USERS_URL%>">All users</a>
    </p>
    <p>
        <a href="<%= AppConstants.ADD_USER_URL%>">Add user</a>
    </p>
</body>
</html>
