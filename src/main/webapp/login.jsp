<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="mysite.jr.configurations.CommandConfigurator" %>

<c:set var="language" value="${empty param.language ? (empty sessionScope.language ? 'en_EN' : sessionScope.language) : param.language }" scope="session"/>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="bundles/bundle"/>

<!DOCTYPE html>

<meta charset="utf-8">
<title><fmt:message key="login.title"/></title>
<link rel="stylesheet" type="text/css" href="styles/main.css">
<link rel="stylesheet" type="text/css" href="styles/startForm.css">
<script src="scripts/validation.js"></script>

<a href=<%=CommandConfigurator.getInstance().getPageComand(request, CommandConfigurator.OPEN_REGISTRATION_PAGE)%>><fmt:message key="login.signup"/></a>

<form action=<%=CommandConfigurator.getInstance().getMainPath(request)%> method=post onsubmit="return validateLogin(login.value, password.value)" autocomplete>
    <input name="command" value=<%=CommandConfigurator.LOGIN%> hidden>
    <input id="login" name="login" placeholder="<fmt:message key="login.login"/>" value="<%= request.getParameter("login") == null ? "" : request.getParameter("login") %>" required>
    <input id="password" name="password" type="password" placeholder="<fmt:message key="login.password"/>" required>
    <input type="submit" value="<fmt:message key="login.send"/>">
    <p><%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %></p>
</form>
