<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
<c:set var="mesg" value="${mesg}" scope="session"/>
<c:if test="${empty mesg==false}">
<script type="text/javascript">
	alert('${mesg}') 
</script>
</c:if>
<c:remove var="mesg" scope="session"></c:remove>
<style>
 b{
	 color:red;
 }
</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	
		//이메일 선택
		$("#emailselector").on("change", function() {
			var email2 = $("#email2").val();
			var emailSelect = $(this).val();
			
			$("#email2").val(emailSelect);
			
		});
	});

</script> 
<form action="naver_withdrawal" method="post">
<b>본인여부를 확인하기 위해서 등록된 이메일을 입력해주세요.</b>
<table border='2'>
<tr>
<td>아이디</td>
<td>
${login.getUserid()}
</td>
</tr>

<tr>
<td>이름</td>
<td>${login.getUsername()}</td>
</tr>

<tr>
<td>이메일</td>
<td>
<input type="text" name="email1" id="email1" required>@
<input type="text" name="email2" id="email2" required>
<select id="emailselector">
<option value="">--이메일선택--</option>
<option value="naver.com">naver.com</option>
<option value="daum.net">daum.net</option>
<option value="gmail.com">gmail.com</option>
</select>
</td>
</tr>

</table>
<input type="submit" value="탈퇴">
</form>
<div class="butt">
<a href="main"><button>메인으로 돌아가기</button></a>
</div>