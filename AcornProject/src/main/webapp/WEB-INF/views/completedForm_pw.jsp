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
<h1>비밀번호 찾기 - 메일전송 확인.</h1>
<jsp:include page="../common/top.jsp" flush="true"/> 
<jsp:include page="../common/logo.jsp" flush="true"/> 
<jsp:include page="../mail/completedForm_pw.jsp"/>

</body>
</html>