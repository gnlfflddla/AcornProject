<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="../css/Form.jsp"/>

<c:set var="mesg" value="${mesg}" scope="session"/>
<c:if test="${empty mesg==false}">
<script type="text/javascript">   
alert('${mesg}');
</script>
</c:if>
<c:remove var="mesg" scope="session"/>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">   
$(document).ready(function(){
	 $("form").on("submit",function(){
		 var username=$("#username").val();
		 var phone1=$("#phone1").val();
		 var phone2=$("#phone2").val();
		 var phone3=$("#phone3").val();
		 var email1=$("#email1").val();
		 var email2=$("#email2").val();
		 
		 if(username.length==0){
				alert("아이디를 입력해주세요.");
				$("#userid").focus();
				event.preventDefault();
		 }else if(phone1.length==0 || phone2.length==0 || phone3.length==0){
				alert("휴대전화번호를 확인해주세요.");
				$("#phone2").focus();
				event.preventDefault();
		 }else if(email1.length==0 || email2.length==0){
				alert("이메일을 확인해주세요.");
				$("#email1").focus();
				event.preventDefault();
		}
				
	 });
});

</script>

<form action="MemberIdSearchServlet" method="post">
<table border='2'>
<tr>
<td>이름</td>
<td><input type="text" name="username" id="username"></td>
</tr>
<tr>
<td>휴대전화</td>
<td>
<select name="phone1" id="phone1">
<option>010</option>
<option>011</option>
<option>017</option>
</select>
-
<input type="text" name="phone2" id="phone2">-
<input type="text" name="phone3" id="phone3">
</td>
</tr>

<tr>
<td>이메일</td>
<td>
<input type="text" name="email1" id="email1">@
<input type="text" name="email2" id="email2" placeholder="직접입력">
<select>
<option>naver.com</option>
<option>daum.net</option>
<option>google.com</option>
</select>
</td>
</tr>
</table>
<input type="submit" value="메일 보내기">
</form>