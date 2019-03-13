<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align=right><jsp:include page="common/top.jsp"></jsp:include></div>
<div><jsp:include page="common/logo.jsp"></jsp:include></div>
<div><jsp:include page="common/menu.jsp"></jsp:include></div>

<h1>게시판 목록 보기</h1>
<div align="center"><jsp:include page="board/boardList.jsp"></jsp:include></div>
</body>
</html>