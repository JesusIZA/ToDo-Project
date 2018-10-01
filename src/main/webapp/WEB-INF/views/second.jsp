<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="mysite.jr.configurations.CommandConfigurator" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Second Page</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
    <h1>Second Page</h1>
    <a href=<%=CommandConfigurator.getInstance().getPageComand(request, CommandConfigurator.OPEN_MAIN_PAGE)%>>Main Page</a>
    <a href=<%=CommandConfigurator.getInstance().getPageComand(request, CommandConfigurator.LOGOUT)%>>Log Out</a>
    <a href=<%=CommandConfigurator.getInstance().getPageComand(request, CommandConfigurator.OPEN_EDIT_PROFILE_PAGE)%>>Edit Profile</a>
</body>
</html>