<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:include page="../css/Form.jsp"/>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
		//비밀번호 정규식
		var pwJ=/^[A-Za-z0-9]{4,12}$/;
		
	 //정보 모두 입력.
	 $("form").on("submit",function(){
		var userid=$("#userid").val();
		var passwd=$("#passwd").val();
		var passwd1=$("#passwd1").val();
		var username=$("#username").val();
		var post=$("#sample4_postcode").val();
		var addr1=$("#addr1").val();
		var addr2=$("#addr2").val();
		var phone1=$("#phone1").val();
		var phone2=$("#phone2").val();
		var phone3=$("#phone3").val();
		var email1=$("#email1").val();
		var email2=$("#email2").val();
		//var A_num=$("#A_num").val();
		
		var result=$("#result").text();
		var result4=$("#result4").text();
		
		if(userid.length==0){
			alert("아이디를 입력해주세요.");
			$("#userid").focus();
			event.preventDefault();
		}else if(result!="사용가능한아이디입니다."){
			alert("아이디를 확인해주세요.");
			$("#userid").focus();
			event.preventDefault();
		}else if(passwd.length==0){
			alert("비밀번호를 입력해주세요.");
			$("#passwd").focus();
			event.preventDefault();
		}else if(passwd1.length==0){
			alert("비밀번호를 확인해주세요.");
			$("#passwd1").focus();
			event.preventDefault();
		}else if(username.length==0){
			alert("이름을 입력해주세요.");
			$("#username").focus();
			event.preventDefault();
		}else if(phone2.length==0 ||phone3.length==0){
			alert("휴대전화번호를 확인해주세요.");
			$("#phone2").focus();
			event.preventDefault();
		}else if(email1.length==0 || email2.length==0){
			alert("이메일을 확인해주세요.");
			$("#email1").focus();
			event.preventDefault();
		}else if(A_num.length==0){
			alert("이메일 인증은 필수입니다..");
			$("#email1").focus();
			event.preventDefault();
		}else if(result4!="인증이완료되었습니다."){
			alert("이메일 인증은 필수입니다..");
			$("#email1").focus();
			event.preventDefault();
		} else if(post.length==0 || addr1.length==0 || addr2.length==0){
			alert("주소를 입력해주세요.");
			$("#sample4_postcode").focus();
			event.preventDefault();
		} 
	 });
	 
	 //아이디 중복 확인
	$("#check").on("click",function(event){
		$.ajax({
			type : "GET",
			url : "MemberIdCheckServlet",
			dataType : "text",
			data : {
				userid : $("#userid").val()
			},
			success : function(responseData, status, xhr) {
			    $("#result").text(responseData);
			    $("#result").css("color","red");
			},
			error : function(xhr, status, error) {
				alert("error");
				
			}
			
		});
		
		event.preventDefault();
	});
	 
	 //비빌번호 유효성 검사
	$("#passwd").blur("keyup",function(){
		if(pwJ.test($("#passwd").val())){
			$("#result2").text("");
		}else{
			$("#result2").text("숫자 or 문자로만 4~12자리 입력");
			$("#result2").css("color","red");
		}
	});
		
	 //비빌번호 확인
	 $("#passwd1").blur("keyup",function(){
		 var passwd=$("#passwd").val();
		 var mesg="비번 불일치";
			
		if(passwd==$(this).val()){
				mesg="비번 일치";
		}
			
		$("#result3").text(mesg);
		$("#result3").css("color","red"); 
		
	 });
	 
	 //이메일 선택
	 $("#emailSelect").on("change",function(){
		var email=$(this).val();
		$("#email2").val(email);
	 });
	 
	 //인증번호
	 $("#num").on("click",function(){
		$("#num_result").show(); 
		event.preventDefault();
	 });
	 
	 $("#num").on("click",function(event){
			$.ajax({
				type : "GET",
				url : "Authenication_numberServlet",
				dataType : "text",
				data : {
					email1:$("#email1").val(),
					email2:$("#email2").val(),
				},
				success : function(responseData, status, xhr) {
					$("#result5").text("이메일이 발송되었습니다.");
					$("#result5").css("color","red");

				},
				error : function(xhr, status, error) {
					alert("error");
					
				}
				
			});
			
			event.preventDefault();
		});
	 
	 $("#check1").on("click",function(event){
			$.ajax({
				type : "GET",
				url : "Authenication_numberServlet",
				dataType : "text",
				data : {
					A_num : $("#A_num").val()
				},
				success : function(responseData, status, xhr) {
				    $("#result4").text(responseData);
				    $("#result4").css("color","red");
				},
				error : function(xhr, status, error) {
					alert("error");
					
				}
				
			});
			
			event.preventDefault();
		});
	 
}); 

</script>   

<form action="MemberAddServlet" method="post">
<table border='2'>
<tr>
<td>아이디*</td>
<td>
<input type="text" name="userid" id="userid">
<button id="check">아이디 중복 확인</button>
<span id="result"></span>
</td>
</tr>

<tr>
<td>비밀번호*</td>
<td>
<input type="password" name="passwd" id="passwd">
<span id="result2"></span>
</td>

</tr>

<tr>
<td>비밀번호 확인*</td>
<td>
<input type="password" name="passwd1" id="passwd1">
<span id="result3"></span>
</td>

</tr>

<tr>
<td>이름*</td>
<td><input type="text" name="username" id="username"></td>
</tr>

<tr>
<td>주소*</td>
<td>
<input type="text" name="post" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" name="addr1" id="sample4_roadAddress" placeholder="도로명주소">
<input type="text" name="addr2" id="sample4_jibunAddress" placeholder="지번주소">
<span id="guide" style="color:#999"></span>
</td>
</tr>

<tr>
<td>휴대전화*</td>
<td>
<select name="phone1" id="phone1">
<option value="010">010</option>
<option value="011">011</option>
<option value="016">016</option>
<option value="017">017</option>
<option value="019">019</option>
</select>
-
<input type="text" name="phone2" id="phone2">-
<input type="text" name="phone3" id="phone3">
</td>
</tr>

<tr>
<td>이메일*</td>
<td>
<input type="text" name="email1" id="email1">@
<input type="text" name="email2" id="email2" placeholder="직접입력">
<select id="emailSelect">
<option>--이메일선택--</option>
<option value="nanver.com">naver.com</option>
<option value="daum.net">daum.net</option>
<option value="gmail.com">gmail.com</option>
</select>
<br>
<button id="num">인증번호</button>
<span id="result5"></span>
<div id="num_result" hidden="true">
<input type="text" name="A_num" id="A_num">
<button name="check1" id="check1">확인</button>
<span id="result4"></span>
</div>
</td>
</tr>
<!-- 비밀번호 확인 질문
비밀번호 확인 답변 -->
</table>
<br>
<input type="submit" value="회원가입">
</form>
<div class="butt">
<a href="MainServlet"><button>메인으로 돌아가기</button></a>
</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>