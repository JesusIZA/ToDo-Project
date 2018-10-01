<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="mysite.jr.configurations.CommandConfigurator" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="styles/main.css">
<link rel="stylesheet" type="text/css" href="styles/startForm.css">
<script src="scripts/validation.js"></script>

<a href=<%=CommandConfigurator.getInstance().getPageComand(request, CommandConfigurator.OPEN_LOGIN_PAGE)%>>Log In</a>

<form action=<%=CommandConfigurator.getInstance().getMainPath(request)%> method=post onsubmit="return validateRegistration(name.value, email.value, login.value, password.value)" autocomplete>
    <input name="command" value="registration" hidden>
    <input name="name" placeholder="Name" value="<%= request.getParameter("name") == null ? "" : request.getParameter("name") %>" required>
    <input name="email" type="email" placeholder="Email" value="<%= request.getParameter("email") == null ? "" : request.getParameter("email") %>" required>
    <input name="login" placeholder="Login" value="<%= request.getParameter("login") == null ? "" : request.getParameter("login") %>" required>
    <input name="password" type="password" placeholder="Password" value="<%= request.getParameter("password") == null ? "" : request.getParameter("password") %>" required>
    <input type="submit" value="Registration">
    <p><%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %></p>
</form>