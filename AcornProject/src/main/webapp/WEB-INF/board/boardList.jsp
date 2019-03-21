<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	
	<table border="1" class="type10">
		<tr>
			<td colspan="5">
				<form action="search">
					<select name="searchName" size="1">
						<option value="author">작성자</option>
						<option value="title">글제목</option>
					</select> <input type="text" name="searchValue"> <input
						type="submit" value="찾기">
				</form>
			</td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${boardList.list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td>
				<c:forEach begin="1" end="${dto.repIndent}">
				ㄴ
				</c:forEach> 
				<a href="retrieve?num=${dto.num}">${dto.title}</a>
				</td>
				<td>${dto.author}</td>
				<td>${dto.writeday}</td>
				<td>${dto.readcnt}</td>
			</tr>
		</c:forEach>
	</table>
	<c:forEach begin="1" end="${boardList.totalPage}" varStatus="status">
		<c:choose>
			<c:when test="${status.index eq boardList.curPage}">
       			${status.index}
		    </c:when>
			<c:otherwise>
				<a href="${pkind}?curPage=${status.index}">${status.index}</a>
  		  </c:otherwise>
		</c:choose>
	</c:forEach>
	<br>
	<a href="m/writeui">글쓰기</a>

</body>
</html>