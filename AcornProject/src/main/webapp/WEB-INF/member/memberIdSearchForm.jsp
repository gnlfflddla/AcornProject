<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%-- <jsp:include page="../css/Form.jsp"/> --%>

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
	
		/* //휴대전화 정규식
		var pj=/^01([0|1|6]?)?[\-\.]?([0-9]{3,4})?[\-\.]?([0-9]{4})$/;
		
	 $("form").on("submit",function(){
		 var username=$("#username").val();
		 var phone1=$("#phone1").val();
		 var phone2=$("#phone2").val();
		 var email=$("#email").val();
		 
		 if(username.length==0){
				alert("이름을 입력해주세요.");
				$("#userid").focus();
				event.preventDefault();
		 }else if(phone1.length==0 || phone2.length==0){
				alert("휴대전화번호를 확인해주세요.");
				$("#phone").focus();
				event.preventDefault();
		 }else if(email.length==0){
				alert("이메일을 확인해주세요.");
				$("#email").focus();
				event.preventDefault();
		}
	 });
	 
	 $("#emailSelect").on("change",function(){
		 var email=$("#email").val();
		 var emailSelect=$(this).val();
		
		if(email.includes("@")==true){
			$("#email").val(email+emailSelect);
		}else{
			$("#email").val(email+"@"+emailSelect);
		}
	 });
	 
	 $("#passwd").blur("keyup",function(){
			if(pj.test($("#passwd").val())){
				$("#result2").text("");
			}else{
				$("#result2").text("숫자 or 문자로만 4~12자리 입력");
				$("#result2").css("color","red");
			}
		}); */
			
});

</script> 

<form action="memberIdSearch" method="post">
<table border='2'>
<tr>
<td>이름</td>
<td><input type="text" name="username" id="username"></td>
</tr>
<tr>
<td>휴대전화</td>
<td>
<select name="phone" id="phoneSelect">
<option value="010">010</option>
<option value="011">011</option>
<option value="016">016</option>
</select>
-
<input type="tel" name="phone" id="phone1">-
<input type="tel" name="phone" id="phone2">
</td>
</tr>

<tr>
<td>이메일</td>
<td>
<input type="email" name="email" id="email" >
<select id="emailSelect">
<option value="">--이메일선택--</option>
<option value="naver.com">naver.com</option>
<option value="daum.net">daum.net</option>
<option value="gmail.com">gmail.com</option>
</select>
</td>
</tr>
</table>
<input type="submit" value="메일 보내기" id="submit">
</form>
<div class="butt">
<a href="main"><button>메인으로 돌아가기 </button></a>
</div>