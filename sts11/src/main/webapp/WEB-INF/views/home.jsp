<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="utf-8" %>

<html>
<head>
	<title>Home</title>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <style type="text/css">
    	#area{
    		background-color: aqua;
    		height: 300px;
    		overflow: scroll;
    	}
    </style>
    <script type="text/javascript">
     	var sock=new SockJS('./sendMsg');
     	sock.onmessage=function(e){
     		$('#area>ul').append('<li>'+e.data+'</li>');
     		$('#area').scrollTop(300);
     	};
     	$(function(){
     		$('button').click(function(){
     			if($('input').val()){
     				sock.send($('input').val());
     				$('input').val('');
     			}
     		});
     	});
     	
    </script>
</head>
<body>
<div class="container">
	<h1>웹챗팅</h1>
	<div>
		<div>
			<div id="area">
				<ul></ul>
			</div>
		</div>
		<input type="text"/>
		<button class="btn btn-primary">입력</button>
	</div>
</div>
</body>
</html>
