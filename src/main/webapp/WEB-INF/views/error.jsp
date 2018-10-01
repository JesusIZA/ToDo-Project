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

<p><%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %></p>