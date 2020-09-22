<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h2>page1 page</h2>
	<nav>
		<a href="./">page1</a>
		<a href="./page2">page2</a>
		<a href="./page3">page3</a>
		<a href="./page4">page4</a>
		<c:if test="${sessionScope.login }">
			${sessionScope.who }님 로그인 중<a href="./logout">[logout]</a>
		</c:if>		
		<c:if test="${sessionScope.login eq null}">
			<a href="./login">login</a>
		</c:if>		
	</nav>
</body>
</html>
