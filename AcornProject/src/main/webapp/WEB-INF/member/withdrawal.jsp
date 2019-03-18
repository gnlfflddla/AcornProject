<%@page import="com.dto.MemberDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%-- <% 
MemberDTO dto=(MemberDTO)session.getAttribute("login");
String mesg=(String)session.getAttribute("mesg");
System.out.println(mesg);
if(mesg!=null){ 
%>  
<script type="text/javascript">
	alert('<%=mesg%>') 
	
	</script>

<%
}
%>  --%>

<c:set var="mesg" value="${mesg}" scope="session"/>
<c:if test="${empty mesg==false}">
<script type="text/javascript">
	alert('${mesg}') 
	</script>
</c:if>
<c:remove var="mesg" scope="session"></c:remove>

<form action="WithdrawalServlet" method="post">
본인여부를 확인하기 위해서 등록된 아이디의 비빌번호를 입력해주세요.
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
<td>비밀번호</td>
<td>
<input type="password" name="passwd">
</td>
</tr>

</table>
<input type="submit" value="탈퇴">
</form>