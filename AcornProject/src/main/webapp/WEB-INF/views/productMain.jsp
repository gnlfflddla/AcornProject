<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<h1>상품메인화면</h1>
<body>

<!-- productAddForm .. mvc controller 등록 -->
<a href="productAddForm">상품등록</a>&nbsp; <a href="ProductCartList">장바구니</a><br>


<jsp:include page="../product/productList.jsp" flush="true"/>
</body>
</html>