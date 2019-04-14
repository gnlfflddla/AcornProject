<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	 
		//아이디 정규식 (영문자+숫자만 가능)
		var idJ = /^[a-zA-Z0-9]+$/;
		
		//비밀번호 정규식
		var pwJ = /^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/ //(하나 이상 대소문자,숫자,특수문자 포함된 최소 8자리 이상 )
		var pwJ1 = /^(?=.*?[a-zA-Z])(?=.*?[0-9]).{4,}$/ //하나 이상의 대소문자, 숫자포함된 5~7자리 
		var pwJ2 = /^(?=.*?[a-zA-Z0-9]).{1,}$/
		

		//이름 정규식
		var nameJ = /^[가-힣a-zA-Z]+$/;
		
		
		//이메일주소 형식 체크 정규식
		/* var regExpEm = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; */

		

		//정보 모두 입력.
		$("form").on("submit", function() {
			
			var passwd = $("#passwd").val();
			var username = $("#username").val();
			var birthday = $("#birthday").val();
			var post = $("#sample6_postcode").val()
			var addr1=$("#sample6_address").val();
			var addr2=$("sample6_detailAddress").val();
			var email=$("#email1").val()+"@"+$("#email2").val();
			
			
			if (($("#result").text()) != "사용가능한 아이디 입니다.") {

				alert("아이디를 확인해주세요.");
				$("#userid").focus();
				event.preventDefault();
			}
			else if (pwJ.test($("#passwd").val()) == false) {
				alert("비밀번호는 대소문자와 숫자,특수문자를 포함한 8자리 이상이여야 합니다.");
				$("#passwd").focus();
				event.preventDefault();
			} else if (nameJ.test(username) == false) {
				console.log(username);
				alert("이름은 한글 또는 영문자만 입력가능합니다.");
				event.preventDefault();
			} else if (birthday.length < 8) {
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

		
		//아이디 중복 확인
		$("#check").on("click", function(event) {
			
			$.ajax({
				type : "post",
				url : "memberIdCheck",
				dataType : "text",
				headers:{
					"Content-Type":"application/json"
				},
				data:JSON.stringify({userid:$("#userid").val()}),
				success : function(responseData, status, xhr) {

					if (responseData == 1) {
						$("#result").text("이미 사용중인 아이디 입니다.");
						$("#result").css("color", "red");
						$("#userid").attr("readonly", false);

					} else if (responseData == 0) {
						$("#result").text("사용가능한 아이디 입니다.");
						$("#result").css("color", "green");
						$("#userid").attr("readonly", true);

						if (userid.length == 0) {
							$("#result").text("아이디를 입력해주세요.");
							$("#result").css("color", "red");
							$("#userid").attr("readonly", false);
						}
						if (idJ.test($("#userid").val()) == false) {
							$("#result").text("아이디는 영문자와 숫자로만 입력 가능합니다.");
							$("#result").css("color", "red");
							$("#userid").attr("readonly", false);
							
						}
					}

				},
				error : function(xhr, status, error) {
					alert("error");

				}

			});

			event.preventDefault();
		});

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

		
		//이메일 발송
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

		$("#check1").on("click", function(event) {
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
					$("#result5").css("color", "green");
				},
				error : function(xhr, status, error) {
					alert("error");

				}

			});

			event.preventDefault();
		});

	});
</script>  