<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	//삭제버튼
	$(".delBtn").on("click",function(){
		var num = $(this).attr("data-xxx");
		location.href="ProductCartDel?num="+num;
	});
	
 // 전체선택
	$("#allCheck").on("click",function(){
		var result = this.checked;
		$(".check").each(function(idx,data){
			this.checked=result;
		});
	});
	
 	// 장바구니 수정
	$(".updateBtn").on("click",function(){
		var num = $(this).attr("id"); 
		var pAmount = $("#CART_AMOUNT"+num).val();
		var pPrice = $(this).attr("data-price");
		$.ajax({
			type:'get',
			url:'ProductCartUpdate',
			data:{
				num: num,
				pAmount: pAmount
			},
			dataType:'text',
			success:function(data,status,xhr){
				if(data=="success"){
				 alert("수정 성공");
			     var sum = pAmount*pPrice;
				 $("#sum"+num).text(sum.toLocaleString()+"원");

				}
			},
			error:function(xhr,status,ex){
				console.log(ex);
			}			
		}); //end ajax
	});//end update
	
 	//장바구니 선택 삭제
	$("#delAllCart").on("click",function(){
		
		$("form").attr("action","ProductCartAllDel");
		$("form").submit();
	}); 
	
 	//주문하기
	$(".orderBtn").on("click",function(){
		var num = $(this).attr("data-xxx");
		location.href="ProductCartOrderConfirm?num="+num;
	});                
	
 	//전체 주문하기
	$("#orderAllConfirm").on("click",function(){
		$("form").attr("action","ProductCartOrderAllConfirmController");
		$("form").submit();
	});

});

</script>

<table width="90%" cellspacing="0" cellpadding="0" border="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center">
		<input type="checkbox" name="allCheck" id="allCheck"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	
	
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>



 <form name="myForm">
	    	  
    <c:forEach var="x" items="${ProductCartList}">
 
		<tr>
			<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
			<input type="checkbox"
				name="check" id="check" class="check" value="${x.num}"></td>
			<td class="td_default" width="80">${x.num}</td>
			
			<%-- <td class="td_default" width="80"><img
				src="/images/${fn:split(x.pImage, ',')[0]}" border="0" align="center"
				width="80" /></td> --%>
				<td class="td_default" width="80"><img
				src="/images/${x.pImage}" border="0" align="center"
				width="80" /></td>
				
			<td class="td_default" width="300" style='padding-left: 30px'>${x.pName}
				<br> <font size="2" color="#665b5f">[옵션 : 사이즈(${x.pSize})
					, 색상(${x.pColor})]
			</font></td>
			<td class="td_default" align="center" width="110">
			<fmt:formatNumber value="${x.pPrice}" type="currency" pattern="###,###,###,###" />원
			</td>
			<td class="td_default" align="center" width="90">
			<input class="input_default" type="text" name="CART_AMOUNT"
				id="CART_AMOUNT${x.num}" style="text-align: right" maxlength="3"
				size="2" value="${x.pAmount}"></input></td>
				
			<td><input type="button" value="수정"
				class="updateBtn" id="${x.num}" data-price="${x.pPrice}"/></td>	
						
			<td class="td_default" align="center" width="80"
				style='padding-left: 5px'>
				<span id="sum${x.num}">
			 	 <fmt:formatNumber value="${x.pPrice*x.pAmount}" type="currency" pattern="###,###,###,###" />원
				</span></td>
			
			<td><input type="button" value="주문" class="orderBtn" data-xxx="${x.num}"></td>
			
			<td class="td_default" align="center" width="30"
				style='padding-left: 10px'><input type="button" value="삭제"
				class="delBtn" data-xxx="${x.num}"></td>
				
			<td height="10"></td>
		</tr>
</c:forEach>
	</form>
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black"
			href="#" id="orderAllConfirm"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="a_black" href="#" id="delAllCart"> 전체 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>