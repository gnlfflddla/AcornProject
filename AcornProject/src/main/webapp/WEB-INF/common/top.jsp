<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="../css/css.css">
<p class = "font">
<!-- 여기 껍데기로 보내기 빼고 바로 jsp로 보냈음 -->

<c:choose>
	<c:when test="${login != null}">
		<a href="logout" >로그아웃</a>&nbsp;&nbsp;
		<a href="myPage">나의정보</a>&nbsp;&nbsp;
		<a href="choolcheckUI">출석체크</a>&nbsp;&nbsp;
		<c:if test="${login.gradeno eq 'admin'}">
		<a href="productAddForm">상품등록</a>&nbsp;&nbsp;
		</c:if>
		<a href="ProductCartList">장바구니</a>&nbsp;&nbsp;
		<a href="ProductOrderList">구매목록</a>&nbsp;&nbsp;
	</c:when>

	<c:otherwise>
		<a href="loginUI">로그인</a>&nbsp;&nbsp;
		<a href="agreementUI">회원가입</a>&nbsp;&nbsp;
		
	</c:otherwise>
</c:choose>
<a href="boardList">게시판</a>&nbsp;&nbsp;<br>

</p>