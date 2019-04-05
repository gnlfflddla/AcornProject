<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:set var="mesg" value="${mesg}" scope="session"/>
<c:if test="${empty mesg==false}">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	//아이디 or 비밀번호 틀렸을때 
	var mesg="${mesg}"
		$(document).ready(function(){
			$("#mesg").text(mesg);
			$("#mesg").css("color","red");
		});
</script>
 </c:if>
<c:remove var="mesg" scope="session"></c:remove>

<c:set var="mesg2" value="${loginMesg}" scope="session"/>
<c:if test="${empty mesg2==false}">
	<script>
		alert("${mesg2}");
	</script>
 </c:if>
<c:remove var="mesg2"/>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function() {

		/* var count = 0;

		$("#sub").on("click", function() {
			count++;
			console.log(count);
			if (count == 5) {
				alert("본인인증");
			}
		}); */

		$("form").on("submit", function() {

			var userid = $("#userid").val();
			var passwd = $("#passwd").val();

			if (userid == 0) {
				alert("아이디를 입력해주세요.");
				event.preventDefault();
			} else if (passwd == 0) {
				alert("비밀번호를 입력해주세요.");
				event.preventDefault();
			}
		});

	});
</script>
<form action="login" method="post">
<table>
<tr>
<td>아이디</td>
<td><input type="text" name="userid" id="userid"></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="password" name="passwd" id="passwd"></td>
</tr>
</table>
<span id="mesg"></span><br>
<input type="submit" value="로그인" id="sub">
</form>
<div class="butt">
<jsp:include page="../common/search.jsp"/>
</div>