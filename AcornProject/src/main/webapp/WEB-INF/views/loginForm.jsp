<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="./css/login.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><a href="main" style="text-decoration:none; color:black;">로그인 화면입니다.</a></h1>
<jsp:include page="../common/top.jsp" flush="true"/> 
<jsp:include page="../common/logo.jsp" flush="true"/> 
<jsp:include page="../member/loginForm.jsp"/>
</body>
</html>