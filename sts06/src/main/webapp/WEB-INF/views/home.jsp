<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="utf-8" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<c:url value="/resources/css/bootstrap.min.css" var="bootcss"/>
	<c:url value="/resources/js/jquery-1.12.4.min.js" var="jquery"/>
	<c:url value="/resources/js/bootstrap.min.js" var="bootjs"/>
	<link rel="stylesheet" type="text/css" href="${bootcss }"/>
	<script type="text/javascript" src="${jquery }"></script>
	<script type="text/javascript" src="${bootjs }"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath }/">비트교육센터</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath }/">HOME <span class="sr-only">(current)</span></a></li>
        <li><a href="${pageContext.request.contextPath }/login/">LOGIN</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath }/emp/">EMP</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="${pageContext.request.contextPath }/dept/">DEPT</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container">
	<div class="row">
	  <div class="col-md-12" id="content">
	  <!-- begin content -->
	  
	  <!-- end content -->
	  </div>
	  <div class="col-md-12" id="footer">
	  	<address>비트캠프 서울시 서초구 강남대로 459 (서초동, 백암빌딩)</address>
		Copyright &copy; 비트캠프 All rights reserved.
	  </div>
	</div>
</div>
</body>
</html>
