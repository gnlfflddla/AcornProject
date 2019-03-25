<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <jsp:include page="../css/Form.jsp"/>   --%> 
<c:set var="mailTo" value="${mailTo}" scope="session"/> 
<c:set var="username" value="${username}" scope="session"/>
<c:set var="userid1" value="${userid1}" scope="session"/>
  

<span>고객님께서 입력하신 이메일로 아이디가 전송되었습니다.<br></span>
<div>
<table border='2'>
<tr>
<td>이름</td>
<td>${username}</td>
</tr>

<tr>
<td>이메일</td>
<td>${mailTo}</td>
</tr>
<tr>
<td>아이디</td>
<td>
${userid1}
</td>
</tr>

</table>
</div>


<span>저희 쇼핑몰을 이용해주셔서 감사합니다.<br><br></span>

<a href="main"><button>확인</button></a>
<a href="loginUI"><button>로그인</button></a>

