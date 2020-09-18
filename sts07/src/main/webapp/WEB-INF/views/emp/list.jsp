<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/head.jspf" %>
</head>
<body>
<%@ include file="../template/header.jspf" %>

<div class="page-header">
	<h1>EMP리스트 페이지</h1>
</div>
<table class="table">
	<thead>
		<tr>
			<th>sabun</th>
			<th>name</th>
			<th>nalja</th>
			<th>pay</th>
			<th>dname</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="bean">
			<tr>
				<td>${bean.sabun }</td>
				<td>${bean.name }</td>
				<td>${bean.nalja }</td>
				<td>${bean.pay }</td>
				<td>${bean.dname }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="../template/footer.jspf" %>
</body>
</html>