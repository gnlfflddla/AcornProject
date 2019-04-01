<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<h1>게시판 글쓰기 화면</h1>
<form action="write" method="post">
	게시판 : 
	<select name="kind">
		<option value="1">공지사항</option>
		<option value="2">이벤트</option>
		<option value="3">QnA</option>
	</select><br>
	제목 : <input type="text" name="title"><br>
	작성자 : <input type="text" name="author" value="${login.userid}" readonly="readonly"><br>
	내용 : <textarea name="content" rows="5"></textarea><br>
	<input type="submit" value="저장">
</form>
<a href="boardList">목록보기</a>
</body>
</html>