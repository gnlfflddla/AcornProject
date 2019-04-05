<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pSearch" value="${pSearch}" scope="session"/>
<c:if test="${empty pSearch==false}">
	<script>
		alert("${pSearch}");
	</script>
 </c:if>
<c:remove var="pSearch"/>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	  $("[name=pSearch]").keydown(function(key) {
          if (key.keyCode == 13) {
      		var pSearch = $(this).val();
    		location.href="ProductSearch?pSearch="+pSearch;
          }
      });

	$(".delBtn").on("click",function(){
		var num = $(this).attr("data-xxx");
		location.href="ProductCartDel?num="+num;
	});
});
</script>

<table width="100%" cellspacing="0" cellpadding="0">

	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0">
				
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td height="1" colspan="8" bgcolor="CECECE"></td>
				</tr>
				
				<tr>
					<td height="10"></td>
					<td align="right" colspan="5"> 
						상품검색: <input type="text" name="pSearch" value="">
					</td>
				</tr>

				<tr>
<c:forEach var="x" items="${productList}" varStatus="status">
						<td>
							<table style='padding:15px'>
								<tr>
									<td>
								 		<a href="productDetail?pCode=${x.pCode}">
											<img src="/images/${fn:split(x.pImage, ',')[0]}" border="0" align="center" width="200">
										</a>
									</td>
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class= "td_default" align ="center">
										${x.pName}<br>
										<font color="gray">
										 --------------------
										</font>
									</td>
									
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_gray" align ="center">
										${x.pContent}
									</td>
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_red" align ="center">
									<font color="red">
									<strong>
									<fmt:formatNumber value="${x.pPrice}" type="currency" pattern="###,###,###,###" />원
									</strong>
									</font>
									</td>
								</tr>
							</table>
						</td>
						
					<c:if test="${(status.index+1)%4==0 }">
					<tr></tr>
					</c:if>
					
	</c:forEach>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>
