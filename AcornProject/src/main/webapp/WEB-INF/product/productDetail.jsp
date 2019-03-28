<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"> 


$(document).ready(function() {
	
	 // 수량 증가
	 $("#up").on("click",function(){
		 var pAmount = $("#pAmount").val();
		 $("#pAmount").val(Number(pAmount)+1);
	 });
	 
	 // 수량 감소
	 $("#down").on("click",function(){
		 var pAmount = $("#pAmount").val();
		 if(pAmount>1){
		 $("#pAmount").val(Number(pAmount)-1);
		 }
	 });
	 
	 // 장바구니 
	 $("#cart").on("click",function(){
			$("form").attr("action","ProductCartAdd");

	 });

	 // 바로구매
	 $("#buy").on("click",function(){
			$("form").attr("action","ProductBuyInstantController");

	 });
	 
	 
	 // 상품 이미지 자리바꾸기
	 $(".subImage").on("click",function(){

		 var subImage = $(this).attr("id");
		 $(".mainImage").attr("src","/images/"+subImage);
		 
	 });
	 
}); 

</script>


 <form name="ProductDetailForm" method="GET" action="#">
 	    <input type="hidden" name="pImage" value="${ProductDetail.pImage}"> 
 	    <input type="hidden" name="pCode" value="${ProductDetail.pCode}"> 
 	    <input type="hidden" name="pName" value="${ProductDetail.pName}"> 
		<input type="hidden" name="pPrice" value="${ProductDetail.pPrice}">

	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
		</tr>
		<tr>
			<td>
				<table align="center" width="710" cellspacing="0" cellpadding="0"
					border="0" style='margin-left: 30px'>
					<tr>
						<td><font size="5"><b>- 상품 정보 -</b></font>
							&nbsp;</td>
					</tr>					
					<tr>
						<td height="5"></td>
					</tr>					
					<tr>
						<td height="1" colspan="8" bgcolor="CECECE"></td>
					</tr>
					<tr>
						<td height="10"></td>
					</tr>

					<tr>
 					<%-- 	<td rowspan="7"><img class="mainImage" id="${fn:split(ProductDetail.pImage, ',')[0]}" 
 						 src="/images/${fn:split(ProductDetail.pImage, ',')[0]}" border="0" align="center" width="300" />
						</td> --%>
						<td rowspan="7"><img class="mainImage" id="${fn:split(ProductDetail.pImage, ',')[0]}" 
 						 src="/images/${ProductDetail.pImage}" border="0" align="center" width="300" />
						</td>
						<td>제품코드</td>
						<td colspan="2" style='padding-left: 30px'>${ProductDetail.pCode} &nbsp;&nbsp;&nbsp; 
						<b style="color:red"> 구매:(${OrderQuantity}개) </b>
						</td>
					</tr>
					
					<tr>
						<td>상품명</td>
						<td colspan="2" style='padding-left: 30px'>${ProductDetail.pName}</td>
					</tr>
					
					<tr>
						<td>가격</td>
						<td colspan="2" style='padding-left: 30px'>
						<fmt:formatNumber value="${ProductDetail.pPrice}" type="currency" pattern="###,###,###,###" />원
						</td>
					</tr>
					
					<tr>
						<td>배송비</td>
						<td colspan="2">
						<font color="#2e56a9" size="2"
							style='padding-left: 30px'><b> 무료배송</b> 
						</font> 
						<font size="2">(도서 산간지역 별도 배송비 추가)</font>
						</td>
					</tr>
					<tr>
						<td rowspan="2">상품옵션</td>
						<td colspan="2" style='padding-left: 30px'>
						   <select name="pColor">
								<option selected value="색상선택">색상선택</option>
								<c:forEach var="pColor" items="${pColorList}">
								<option value="${pColor}">${pColor}</option>
								</c:forEach>
						   </select>
						</td>
					</tr>
					
  					<tr>
						<td colspan="2" style='padding-left: 30px'>
						   <select name="pSize">
						        <option selected value="사이즈선택">사이즈선택</option>
								<c:forEach var="pSize" items="${pSizeList}">
								<option value="${pSize}">${pSize}</option>
								</c:forEach>
						   </select>
						</td>
					</tr>

 					<tr>
						<td>주문수량</td>
						<td style="padding-left: 30px">
						<input type="text" value="1" name="pAmount" id="pAmount" style="text-align: right; width: 70px">
							<input type="button" value="+" id="up"> <input type="button" value="-" id="down">
							</td>
					</tr>
					<tr>
					<td>&nbsp;</td>
					</tr>
					
					<tr> 
					<td>
					<c:forTokens var="token" items="${ProductDetail.pImage}" delims=",">
	 				  <img class="subImage" id="${token}" src="/images/${token}" border="0" align="center" width="50" />&nbsp;
					 </c:forTokens>
					 </td>
					</tr>
		<tr>
		<td align="center" colspan="3"> 
		<button id="buy">바로구매</button> &nbsp;&nbsp; 
		<button id="cart">장바구니</button> <td>
		</tr>
				</table>
		 </td>
		</tr>

	</table>
</form>
