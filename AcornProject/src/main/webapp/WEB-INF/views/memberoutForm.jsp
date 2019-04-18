<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>회원탈퇴가 완료되었습니다.</h1>
<p>
<div class="butt">
<a href="main"><button>메인으로 돌아가기</button></a>
</div>
</body>
</html>