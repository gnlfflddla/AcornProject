<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--  <jsp:include page="../css/Form.jsp"/>  --%>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		if ('${login.passwd}'.length == 0) {

			$("#passwd").removeAttr("required");
			$("#passwd").attr("disabled", true);

			$("#passwd1").removeAttr("required");
			$("#passwd1").attr("disabled", true);
			
			$("#birthday").removeAttr("required");
			$("#birthday").attr("readonly", true);
			$("#birthday").css("border", "none");
			
			$("#email1").attr("value", '${login.email1}');
			$("#email2").attr("value", '${login.email2}');
			$("#email1").attr("readonly", true);
			$("#email2").attr("readonly", true);

			$("#emailselector").attr("hidden", true);
			$("#num").attr("hidden", true);

			$("#A_num").removeAttr("required");
			$("#A_num").attr("hidden", true);

			$("#check1").attr("hidden", true);

		} else {
			//비밀번호 정규식
			var pwJ = /^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/ //(하나 이상 대소문자,숫자,특수문자 포함된 최소 8자리 이상 )
			var pwJ1 = /^(?=.*?[a-zA-Z])(?=.*?[0-9]).{4,}$/ //하나 이상의 대소문자, 숫자포함된 5~7자리 
			var pwJ2 = /^(?=.*?[a-zA-Z0-9]).{1,}$/
			
				$("form").on("submit", function() {
					
					var passwd=$("#passwd").val();
					var post=$("#sample6_postcode").val();
					var addr1=$("#sample6_address").val();
					var addr2=$("#sample6_detailAddress").val();
					var phone1=$("#phone1").val();
					var phone2=$("#phone2").val();
					var email=$("#email").val();
					
					
					if (pwJ.test($("#passwd").val()) == false) {
						alert("비밀번호는 대소문자와 숫자,특수문자를 포함한 8자리 이상이여야 합니다.");
						$("#passwd").focus();
						event.preventDefault();
					} else if (nameJ.test(username) == false) {
						console.log(username);
						alert("이름은 한글 또는 영문자만 입력가능합니다.");
						event.preventDefault();
					}else if (birthday.length < 8) {
						alert("생년월일 8자리를 입력해주세요.");
						$("#brithday").focus();
						event.preventDefault();
					} else if (emailJ.test(email) == false) {
						alert("이메일을 확인해주세요.");
						$("#email").focus();
						event.preventDefault();
					} else if (($("#result5").text().trim()) != "인증이완료되었습니다.") {
						alert("이메일 인증은 필수입니다..");
						console.log(A_num);
						$("#email").focus();
						event.preventDefault();
					}
					
				});

		}
		
		
		//비빌번호 유효성 검사
		$("#passwd").on("keyup", function() {
			if (pwJ.test($("#passwd").val())) {
				$("#result2").text("안전");
				$("#result2").css("color", "green");
			} else if (pwJ1.test($("#passwd").val())) {
				$("#result2").text("중간");
				$("#result2").css("color", "darkorange");
			} else if (pwJ2.test($("#passwd").val())) {
				$("#result2").text("위험");
				$("#result2").css("color", "red");
			} else {
				$("#result2").text("");
			}
		}); 
		
		//비빌번호 확인
		$("#passwd1").blur("keyup", function() {
			var passwd = $("#passwd").val();
			var mesg = "비번 불일치";

			if (passwd == $(this).val()) {
				mesg = "비번 일치";
				$("#result3").css("color", "green");
			} else {
				$("#result3").css("color", "red");
			}

			$("#result3").text(mesg);

		});
 
		//이메일 선택
		$("#emailselector").on("change", function() {
			var email2 = $("#email2").val();
			var emailSelect = $(this).val();
			
			$("#email2").val(emailSelect);
			
		});
 
		$("#num").on("click", function(event) {
			
			var email1 = $("#email1").val();
			var email2 = $("#email2").val();
			var email=email1+"@"+email2;
			
			$.ajax({
				type : "post",
				url : "authenication_number",
				dataType : "text",
				headers:{
					"content-Type":"application/json"
				},
				data :JSON.stringify({email:email}),
				success : function(responseData, status, xhr) {
					$("#result4").text("이메일이 발송되었습니다.");
					$("#result4").css("color", "green");

				},
				error : function(xhr, status, error) {
					alert("error");

				}

			});

			event.preventDefault();
		});
 
 
 $("#check1").on("click",function(event){
		$.ajax({
			type : "post",
			url : "certification",
			dataType : "text",
			headers:{
				"content-Type":"application/json"
			},
			data :JSON.stringify({A_num:$("#A_num").val()}),
			success : function(responseData, status, xhr) {
			    $("#result5").text(responseData);
			    $("#result5").css("color","red");
			},
			error : function(xhr, status, error) {
				alert("error");
				
			}
			
		});
		
		event.preventDefault();
	});
		
		
		
		
				
		});
	
		
				
			
				
				
				
			
</script>

<form action="memberUpdate" method="post">
	<table border='2'>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" id="userid"
				value="${login.getUserid()}" style="border: none" required>
			</td>
		</tr>

		<tr>
			<td>이름*</td>
			<td><input type="text" name="username" id="username"
				value="${login.getUsername()}" style="border: none" required>
			</td>
		</tr>

		<tr>
			<td>생년월일*</td>
			<td><input type="text" name="birthday" id="birthday"
				value="${login.getBirthday()}" required></td>
		</tr>

		<tr>
			<td>비빌번호*</td>
			<td><input type="password" name="passwd" id="passwd"
				placeholder="비밀번호(8자리 이상)" required> <span id="result2"></span>
		</tr>

		<tr>
			<td>비빌번호 확인*</td>
			<td><input type="password" name="passwd1" id="passwd1"
				placeholder="비밀번호 재확인" required> <span id="result3"></span>
			</td>
		<tr>
			<td>주소*</td>
			<td><input type="text" name="post" id="sample6_postcode"
				value="${login.getPost()}" placeholder="우편번호" required> <input
				type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" name="addr1" id="sample6_address"
				value="${login.getAddr1()}" placeholder="주소" required> <input
				type="text" name="addr2" id="sample6_detailAddress"
				value="${login.getAddr2()}" placeholder="상세주소" required> <input
				type="text" name="addr2" id="sample6_extraAddress"
				placeholder="참고항목"></td>
		</tr>

		<tr>
			<td>휴대전화*</td>
			<td><select name="phone1" id="phoneSelect"
				value="${login.getPhone1()}" required>
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
			</select> - <input type="text" name="phone2" id="phone2"
				value="${login.getPhone2()}" required>- <input type="text"
				name="phone3" id="phone3" value="${login.getPhone3()}" required>
			</td>
		</tr>

		<tr>
			<td>이메일*</td>
			<td><input type="text" name="email1" id="email1"
				value="${login.getEmail1()}" required>@ <input type="text"
				name="email2" id="email2" value="${login.getEmail2()}" required>
				<select id="emailselector">
					<option>--이메일선택--</option>
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="gmail.com">gmail.com</option>
			</select> <br>
				<button id="num">인증번호</button> <span id="result4"></span>
				<div id="num_result">
					<input type="text" name="A_num" id="A_num" placeholder="인증번호"
						required>
					<button name="check1" id="check1">확인</button>
					<span id="result5" required></span> <input type="hidden"
						name="gradeno" id="gradeno" value="${login.getGradeno()}">
					<input type="hidden" name="reception" id="reception"
						value="${login.getReception()}">
				</div></td>
		</tr>
	</table>
	<br> <input type="submit" value="수정">
</form>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("sample6_extraAddress").value = extraAddr;

						} else {
							document.getElementById("sample6_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("sample6_detailAddress")
								.focus();
					}
				}).open();
	}
</script>