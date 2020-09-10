<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LIST PAGE</h1>
	<table>
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
	<c:forEach items="${list }" var="bean">
		<tr>
			<td>${bean.deptno }</td>
			<td>${bean.dname }</td>
			<td>${bean.loc }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>