<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>ProductDesign</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">ProductDesign</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/company">Company</a></li>
            <li><a href="/product">Product</a></li>
            <li><a href="/design">Design</a></li>
        </ul>
        <c:choose>
            <c:when test="${empty sessionScope.principal}">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/user/join"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> MyPage</a></li>
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
                </ul>
            </c:otherwise>
        </c:choose>

    </div>
</nav>