<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<%@ include file="template/head.jspf" %>
</head>
<body>
<%@ include file="template/header.jspf" %>

<div class="jumbotron">
	<h1>Hello world!</h1>
	<P>  The time on the server is ${serverTime}. </P>
</div>

<%@ include file="template/footer.jspf" %>
</body>
</html>
