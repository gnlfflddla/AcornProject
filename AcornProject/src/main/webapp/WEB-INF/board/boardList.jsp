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
			<td colspan="6">
				<form action="search">
					<select name="kind" id="kind" size="1">
						<option value="1">공지사항</option>
						<option value="2">이벤트</option>
						<option value="3">QnA</option>
					</select>
					<select name="searchName" id="searchName" size="1">
						<option value="author">작성자</option>
						<option value="title">글제목</option>
					</select> <input type="text" name="searchValue" id="searchValue"> <input
						type="submit" id="sub" value="찾기">
				</form>
			</td>
		</tr>
		<tr>
			<td><b>번호</b></td>
			<td><b>분류</b></td>
			<td><b>제목</b></td>
			<td><b>작성자</b></td>
			<td><b>날짜</b></td>
			<td><b>조회수</b></td>
		</tr>
		<c:forEach items="${boardList.list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td>
				<c:if test="${dto.kind eq '1'}">공지사항</c:if>
				<c:if test="${dto.kind eq '2'}">이벤트</c:if>
				<c:if test="${dto.kind eq '3'}">QnA</c:if>
				</td>
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