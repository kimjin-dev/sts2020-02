<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/head.jspf" %>
<script type="text/javascript">
	$(function(){
		if('${title}'=='Add'){
			$('.form-group').eq(2).remove();
			$('.form-group').eq(0).remove();
		}
	});
</script>
</head>
<body>
<%@ include file="../template/header.jspf" %>
<div class="page-header">
  <h1>${title } page <small>EMP</small></h1>
</div>
<form class="form-horizontal" method="post">
  <div class="form-group">
    <label for="sabun" class="col-sm-2 control-label">sabun</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="sabun" id="sabun" 
      	placeholder="sabun" value="${bean.sabun }">
    </div>
  </div>
  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" id="name" 
      placeholder="name" value="${bean.name }">
    </div>
  </div>
  <div class="form-group">
    <label for="nalja" class="col-sm-2 control-label">nalja</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="nalja" id="nalja"
      placeholder="nalja" value="${bean.nalja }">
    </div>
  </div>
  <div class="form-group">
    <label for="pay" class="col-sm-2 control-label">pay</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="pay" id="pay" 
      placeholder="pay" value="${bean.pay }">
    </div>
  </div>
  <div class="form-group">
    <label for="deptno" class="col-sm-2 control-label">deptno</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="deptno" id="deptno"
       placeholder="deptno" value="${bean.deptno }">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">${title eq 'Add'?'입 력':'수 정' }</button>
    </div>
  </div>
</form>
<%@ include file="../template/footer.jspf" %>
</body>
</html>