<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 
 
 <%-- <%
MemberDTO dto=(MemberDTO)session.getAttribute("login");
%> --%>  
  
 
    
  
<form action="MemberUpdateServlet" method="post">
<table border='2'>
<tr>
<td>아이디</td>
<td>
<%-- <%=dto.getUserid() %> --%>
${login.getUserid()}
</td>
</tr>

<tr>
<td>이름*</td>
<td>
<%-- <%=dto.getUsername() %> --%>
${login.getUsername()}
</td>
</tr>

<tr>
<td>비밀번호*</td>
<td><input type="password" name="passwd" id="passwd"></td>

</tr>

<tr>
<td>비밀번호 확인*</td>
<td>
<input type="password" name="passwd1" id="passwd1">
<span id="result2"></span>
</td>

</tr>

<tr>
<td>주소*</td>
<td>
<input type="text" name="post" id="post" placeholder="우편번호" value="${login.getPost()}">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" name="addr1" id="addr1" placeholder="도로명주소" value="${login.getAddr1()}">
<input type="text" name="addr2" id="addr2" placeholder="지번주소" value="${login.getAddr2()}">
<span id="guide" style="color:#999"></span>
</td>
</tr>

<tr>
<td>휴대전화*</td>
<td>
<select name="phone1" id="phone1" value="${login.getPhone1()}">
<option value="010">010</option>
<option value="011">011</option>
<option value="016">016</option>
<option value="017">017</option>
<option value="019">019</option>
</select>
-
<input type="text" name="phone2" id="phone2" value="${login.getPhone2()}">-
<input type="text" name="phone3" id="phone3" value="${login.getPhone3()}">
</td>
</tr>

<tr>
<td>이메일*</td>
<td>
<input type="text" name="email1" id="email1" value="${login.getEmail1()}">@
<input type="text" name="email2" id="email2" placeholder="직접입력" value="${login.getEmail2()}">
<select id="emailSelect"> 
<option>--이메일선택--</option>
<option value="naver.com">naver.com</option>
<option value="daum.net">daum.net</option>
<option value="gmail.com">gmail.com</option>
</select>
</td>
</tr>
<!-- 비빌번호 확인 질문
비빌번호 확인 답변 -->
</table>
<br>
<input type="submit" value="수정">
</form>
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