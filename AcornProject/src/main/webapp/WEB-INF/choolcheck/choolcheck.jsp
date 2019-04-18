<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
   <c:set var="cMesg" value="${cMesg}" scope="session"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<img src="/AcornProject/images/choolStart2.png" style="width:80%;height:250px;">
<br>
 ${cMesg }
 <span id ="result">

 <h1>
 ${viewM }
 </h1>
</span>
<br>

<table cellspacing="3">
<tr>
	<td>
	30일 출석체크시 500마일리지 제공
		</td>
		<td rowspan="6">
		<c:choose>
	<c:when test="${empty cMesg==true}">

		<a href="/AcornProject/m/choolcheck">
		<img src="/AcornProject/images/cc1.png">
		</a>
		<br>
	</c:when>
	<c:otherwise>
		<img src="/AcornProject/images/cc1-black.png">
		<br>
	</c:otherwise>
	
</c:choose>
		
		
		</td>
</tr>
<tr>
	<td>
	10, 20, 30, 100 랜덤 마일리지 제공
		</td>
</tr>
<tr>
	<td>
		10 마일리지 확률 : 60%
		</td>
</tr><tr>
	<td>
		20 마일리지 확률 : 25%
		</td>
</tr><tr>
	<td>
		30 마일리지 확률 : 13%
		</td>
</tr><tr>
	<td>
		100 마일리지 확률 : 2%
		</td>
</tr>


</table>
<br><br>



<br><br>

