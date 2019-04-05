<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
</script>

<c:forEach var="dto" items="${OrderDetail}">
	<table width="80%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
		</tr>

		<tr>
			<td><b>주문상품 확인</b></td>
		</tr>

		<tr>
			<td height="15">
		</tr>

		<tr>
			<td>
				<hr size="1" color="CCCCCC">
			</td>
		</tr>

		<tr>
			<td height="5">
		</tr>

		<tr>
			<td>
				<table width="100%" cellspacing="0" cellpadding="0">
					<tr>
						<td class="td_default" align="center"><strong>주문번호</strong></td>
						<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
						<td class="td_default" align="center"><strong>판매가</strong></td>
						<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>

					</tr>

					<tr>
						<td colspan="4">
							<hr size="1" color="CCCCCC">
						</td>
					</tr>

					<tr>
						<td class="td_default" width="80">${dto.num}</td>
	
 							<td class="td_default" width="80">
 							 <img src="/images/${fn:split(dto.pImage, ',')[0]}" border="0" align="center" width="80">
 							</td>
												
<%-- 							<td class="td_default" width="80"><img
							src="/images/${dto.pImage}" border="0" align="center"
							width="80"/></td> --%>
							
						<td class="td_default" width="300" style='padding-left: 30px'>${dto.pName}
							<br> <font size="2" color="#665b5f">[옵션 : 사이즈(${dto.pSize})
								, 색상(${dto.pColor})]
						</font></td>
						<td class="td_default" align="center" width="110"><fmt:formatNumber value="${dto.pPrice}" type="currency" pattern="###,###,###,###" />원
						</td>
						<td class="td_default" align="center" width="90">${dto.pAmount}</td>

					</tr>


					<tr>
						<td height="30" colspan="4"></td>
						<td class="td_default" align='right'>총 결제 금액 : <fmt:formatNumber value="${dto.pPrice*dto.pAmount}" type="currency" pattern="###,###,###,###" />원 </td>
					</tr>
				</table> <tr>
			<td>
					<hr size="1" color="CCCCCC">
				</td>
			</tr>

		</td>
	</tr>
	
	<!--  고객 정보 시작-->
		<tr>
		<td height="30">
	
		</tr>

	<tr>
		<td><b>배송 정보</b></td>
	</tr>

	<tr>
		<td height="15">
	
		</tr>
	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse:collapse" bordercolor="#CCCCCC">
				<tr>
					<td width="125" height="35" class="td_default">
						
						이 름
					</td>
					<td height="35" class="td_default">${dto.orderName}</td>
				</tr>
				<tr>
					<td height="35" class="td_default">
						
						우편번호
					</td>
					<td height="35" class="td_default">${dto.post}</td>
				</tr>
				<tr>
					<td height="35" class="td_default">
						
						주 소
					</td>
					<td height="35" class="td_default">
						${dto.addr1}<br>
						${dto.addr2}
					</td>
				</tr>
				
				<tr>
					<td height="35" class="td_default">
						휴대전화
					</td>
					<td height="35" class="td_default">
					${dto.phone1}-${dto.phone2}-${dto.phone3}
					</td>
				</tr>
				<tr>
					<td>결제수단</td>
					<td>${dto.payMethod}</td>
				</tr>
			</table>							
		</td>
	</tr>
</table>							
</c:forEach>