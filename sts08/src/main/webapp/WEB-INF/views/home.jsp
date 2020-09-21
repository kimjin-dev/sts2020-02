<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css"/>
	<style type="text/css">
		table>tbody>tr{
			cursor: pointer;
		}
	</style>
	<script type="text/javascript" src="resources/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
	<script type="text/javascript">
	
	$(function(){
		$('nav a').eq(0).click(function(){
			console.log("logo");
			return false;
		});
		$('nav a').eq(1).click(function(){
			console.log("home");
			return false;
		});
		$('nav a').eq(2).click(function(){
			console.log('login');
			return false;
		});
		$('.dropdown-menu a').click(function(){
			console.log($(this).text());
			if($(this).text()=='dept'){
				listPage();
			}
			return false;
		});
		
		
	});
	
	function listPage(){
		$('.jumbotron').before('<div><h2 class="page-header">DEPT LIST</h2></div>').hide();
		$('.jumbotron').after('<div id="content"></div>');
		$('#content').html('<table class="table"><thead><tr><th>deptno</th><th>dname</th><th>loc</th></tr></thead><tbody></tbody></table>');
		$.getJSON('dept/',function(data){
			var array=data.root;
			console.log(array);
			for(var i=0; i<array.length; i++)
			$('#content table tbody').append('<tr><td>'+array[i].deptno
					+'</td><td>'+array[i].dname+'</td><td>'+array[i].loc+'</td></tr>');
		});
		$(document).on('click','table>tbody>tr',function(){
			var deptno=$(this).find("td").first().text();
			if(deptno){
				deptDetail(deptno);
			}
		});
	}
	function deptDetail(num) {
		$.getJSON('dept/'+num,function(data){
			console.log(data);
			$('#myModal form .form-group input').eq(0).val(data.deptno);
			$('#myModal form .form-group input').eq(1).val(data.dname);
			$('#myModal form .form-group input').eq(2).val(data.loc);
			$('#myModal form .form-group input').prop('readonly',true);
			$('#myModal').modal();
			$('#myModal .modal-footer button').eq(1).click(function(){
				console.log(this);
				$('#myModal form .form-group input').eq(1).prop('readonly',false);
				$('#myModal form .form-group input').eq(2).prop('readonly',false);
				$(this).off('click');
				$(this).click(function(){
					deptEdit();
				});
			});
		});
	}
	function deptEdit(){
		var params={
				'deptno':$('#deptno').val()
				,'dname':$('#dname').val()
				,'loc':$('#loc').val()
		};
		console.log('update',params);
		$.ajax({
			url:'dept/',
			method:'put',
			data: JSON.stringify(params),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
			success:function(data){
				console.log('update success...');
				$('.jumbotron').prev().remove();
				$('.jumbotron').next().remove();
				listPage();
				$('#myModal').modal('hide');
			}
		});
	}
	</script>
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
        <li class="active"><a href="#">HOME <span class="sr-only">(current)</span></a></li>
        <li><a href="#">LOGIN</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">TABLE <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">emp</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">dept</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-right">
        <div class="form-group">
          <label for="sabun">sabun</label>
          <input type="text" class="form-control" placeholder="sabun">
        </div>
        <div class="form-group">
          <label for="deptno">deptno</label>
          <input type="text" class="form-control" placeholder="deptno">
        </div>
        <button type="submit" class="btn btn-default">LOGIN</button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="jumbotron">
	<h1>Hello world!  </h1>
	<P>  The time on the server is ${serverTime}. </P>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <form class="form-horizontal">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <div class="modal-body">
		<div class="form-group">
		    <label for="deptno" class="col-sm-2 control-label">deptno</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="deptno" id="deptno" placeholder="deptno">
		    </div>
		</div>
		<div class="form-group">
		    <label for="dname" class="col-sm-2 control-label">dname</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="dname" id="dname" placeholder="dname">
		    </div>
		</div>
		<div class="form-group">
		    <label for="loc" class="col-sm-2 control-label">loc</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="loc" id="loc" placeholder="loc">
		    </div>
		</div>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">수정</button>
        <button type="button" class="btn btn-danger">삭제</button>
      </div>
    </form>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>