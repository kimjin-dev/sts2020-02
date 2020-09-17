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
<table class="table">
	<thead>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>금액</th>
			<th>넘버</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list }" var="bean">
		<tr>
			<td>${bean.sabun }</td>
			<td>${bean.name }</td>
			<td>${bean.nalja }</td>
			<td>${bean.pay }</td>
			<td>${bean.deptno }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<%@ include file="../template/footer.jspf" %>
</body>
</html>