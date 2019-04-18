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
<h1>회원탈퇴 화면입니다.</h1>
<c:choose>
        <c:when test="${login.passwd!=null}">
        <jsp:include page="../member/withdrawalForm.jsp" flush="true"/>
            
        </c:when>         
        <c:otherwise>
           <jsp:include page="../member/naver_withdrawalForm.jsp" flush="true"/> 
         </c:otherwise>
</c:choose>

</body>
</html>