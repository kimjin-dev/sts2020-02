<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<c:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
	<c:url value="/resources/js/jquery-1.12.4.min.js" var="jquery"/>
	<c:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
	<c:url value="/" var="root" />
	<link rel="stylesheet" type="text/css" href="${bootstrapCSS }"/>
	<script type="text/javascript" src="${jquery }"></script>
	<script type="text/javascript" src="${bootstrapJS }"></script>
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
      <a class="navbar-brand" href="#">비트교육센터</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${root }">HOME <span class="sr-only">(current)</span></a></li>
        <li><a href="#">LOGIN</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">LIST<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${root }dept/">DEPT</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="${root}emp/ }">EMP</a></li>
          </ul>
        </li>
      </ul>
    
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</body>
</html>
