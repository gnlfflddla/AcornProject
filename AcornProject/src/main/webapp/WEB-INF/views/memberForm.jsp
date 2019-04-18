<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="./css/member.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/top.jsp" flush="true"/> 
<jsp:include page="../common/logo.jsp" flush="true"/> 
<h1>회원가입 화면입니다.</h1>
<jsp:include page="../member/memberForm.jsp"/>
</body>
</html>