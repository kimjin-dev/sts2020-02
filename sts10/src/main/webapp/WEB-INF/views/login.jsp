<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>login page</h2>
	<nav>
		<a href="/sts10/">page1</a>
		<a href="/sts10/page2">page2</a>
		<a href="/sts10/page3">page3</a>
		<a href="/sts10/page4">page4</a>
		<a href="/sts10/login">login</a>
	</nav>
	<div>
		<form action="result" method="post">
			<div>
				<label for="id">id</label>
				<input type="text" name="id" id="id"/>
			</div>
			<div>
				<label for="pw">pw</label>
				<input type="text" name="pw" id="pw"/>
			</div>
			<div>
				<button>로그인</button>
			</div>
		</form>
	</div>
</body>
</html>