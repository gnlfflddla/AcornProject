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
	
	//이메일 선택
	$("#emailselector").on("change", function() {
		var email2 = $("#email2").val();
		var emailSelect = $(this).val();
		
		$("#email2").val(emailSelect);
		
	});
			
});

</script> 

<form action="memberIdSearch" method="post">
<table border='2'>
<tr>
<td>이름</td>
<td><input type="text" name="username" id="username" required></td>
</tr>
<tr>
<td>휴대전화</td>
<td>
<select name="phone1" id="phoneSelect" required>
<option value="010">010</option>
<option value="011">011</option>
<option value="016">016</option>
</select>
-
<input type="text" name="phone2" id="phone2" required>-
<input type="text" name="phone3" id="phone3" required>
</td>
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
<input type="submit" value="메일 보내기" id="submit">
</form>
<div class="butt">
<a href="main"><button>메인으로 돌아가기 </button></a>
</div>