<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    
<link rel="stylesheet" type="text/css" href="css/css.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#main").on("click", function(){
			location.href="Main";
					
		})
		
	});
</script>
</head>

<body>

	<div align=right>
	<jsp:include page="../common/top.jsp"></jsp:include></div>
	
	<div align="center">
	<a href="MainP">
	<img alt="daemoon" src="images/dae.jpg">
	</a>
	</div>

	<jsp:include page="../common/menu.jsp"></jsp:include>
<center>
<jsp:include page="../choolcheck/choolcheck.jsp" flush="true" />
</center>
</body>
</html>