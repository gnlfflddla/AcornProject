<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%-- <jsp:include page="../css/Form.jsp"/> --%>

<form>
<table border='2'>
<tr>
<th>아이디</th>
<td>${login.getUserid()}</td>
</tr>
<tr>
<th>이름</th>
<td>${login.getUsername()}</td>
</tr>
<tr>
<th>생년월일</th>
<td>${login.getBirthday()}</td>
</tr>
<tr>
<th>주소</th>
<td>
${login.getAddr()}

</td>
</tr>
<tr>
<th>휴대전화</th>
<td>
${login.getPhone()}
</td>
</tr>
<tr>
<th>이메일</th>
<td>
${login.getEmail()}
</td>
</tr>
</table>
</form>
<div class="butt">
<a href="memberUpdateUI"><button>수정</button></a>
<a href="main"><button>메인으로 돌아가기</button></a>
<a href="withdrawalUI"><button>회원탈퇴</button></a>
</div>