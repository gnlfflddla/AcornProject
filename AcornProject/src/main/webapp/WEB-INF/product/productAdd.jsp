<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	// 상품 색상 추가
	var n=0;
	$("#AddcBtn").on("click",function(event){
		event.preventDefault();
		if(n<6){
		$("#color").after("<tr class='colors'><td>상품 색상 : <input type='text' name='pColor' class='colors2'></td></tr>");
		n++;
		}else{
			alert("색상은 5개만 추가 가능합니다.");
		}
	});
	
	// 상품 삭제
	$("#DelcBtn").on("click",function(event){
		event.preventDefault();
		$(".colors").first().remove();
		if(n>0){
		n--;
		}else if(n==0){
			alert("하나의 상품 색상은 필수 입니다..")
		}
	});
	
	// 예외처리
 	var eq= new Array();
	$("form").submit(function(){

		if($("[name=pCode]").val().length==0){
			 event.preventDefault();
			 alert("상품코드를 입력하세요.");
			 $("[name=pCode]").focus();
		}else if(true)
			var n;
		$("[name=theFile]").each(function(idx,ele){
			if($(ele).val()==""){
				n=1;
 		  	 }

		});
		if(n==1){
	 		alert("상품 이미지를 등록하세요.");
			event.preventDefault();
	 		 
		}else if($("[name=pName]").val().length==0){
			 event.preventDefault();
			 alert("상품명을 등록하세요.");
			 $("[name=pName]").focus();
		}else if($("[name=pContent]").val().length==0){
			 event.preventDefault();
			 alert("상품 내용을 등록하세요.");
			 $("[name=pContent]").focus();
 		}else if($("[name=pCategory]").attr("checked")==false){
			 event.preventDefault();
			 alert("상품 카테고리를 선택해주세요."); 
		}else if($("[name=pSize]").attr("checked")==false){
			 event.preventDefault();
			 alert("상품 사이즈를 선택해주세요.");
		}else if($("[name=pPrice]").val().length==0){
			 event.preventDefault();
			 alert("상품 가격을 등록하세요.");
			 $("[name=pPrice]").focus();
		}else if($("[name=pColor]").val().length==0){
			 event.preventDefault();
			 alert("상품 색상을 등록하세요.");
			 $("[name=pColor]").focus();
		}else if($("[name=pColor]").val().length!=0){
			
		 		$("[name=pColor]").each(function(idx,ele){
					if($(ele).val()!=""){
						eq[idx] = $(ele).val();
					}else{
						event.preventDefault();
						alert("상품 색상을 등록하세요.");
						$(ele).focus();
					}
					for(var i=idx-1; i>=0; i--){
						if(eq[idx]==eq[i]){
							event.preventDefault();
							alert("중복된 색상이 있습니다.");
						}
					}
					
				});
			}		
		
	}); 
	
	// 상품 이미지 추가
	var j=0;
	$("#AddiBtn").on("click",function(event){
		event.preventDefault();
		if(j<2){
		$("#image").after("<tr class='images'><td>상품 이미지 : <input type='file' name='pImage'></td></tr>");
		j++;
		}else{
			alert("이미지는 3개만 추가 가능합니다.");
		}
	});
	
	// 이미지 삭제
	$("#DeliBtn").on("click",function(event){
		event.preventDefault();
		$(".images").first().remove();
		if(j>0){
		 j--;
		}else if(j==0){
			alert("하나의 상품 이미지는 필수 입니다.");
		}
	});
	
});
</script>
</head>
<body>
	<form action="productAdd" method="POST"
		enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>상품 코드 : <input type="text" name="pCode"></td>
			</tr>
			 <tr id="image">
				<td>상품 이미지 : <input type="file" name="theFile"> <input
					type="button" value="이미지 추가" id="AddiBtn"> <input
					type="button" value="이미지 삭제" id="DeliBtn">
			 </td>
			</tr>
			<tr>
				<td>상품명 : <input type="text" name="pName"></td>
			</tr>
			<tr>
				<td>상품 내용 : <input type="text" name="pContent"></td>
			</tr>
			<tr>
				<td>상품 종류 : <input type="checkbox" name="pCategory" value="top">Top
					<input type="checkbox" name="pCategory" value="dress">Dress
					<input type="checkbox" name="pCategory" value="outer">Outer
					<input type="checkbox" name="pCategory" value="bottom">Bottom
				</td>
			</tr>
			<tr>
				<td>상품 사이즈 : <input type="checkbox" name="pSize" value="L">L
					<input type="checkbox" name="pSize" value="M">M <input
					type="checkbox" name="pSize" value="S">S <input
					type="checkbox" name="pSize" value="FREE">FREE
				</td>
			</tr>
			<tr>
				<td>가격 : <input type="text" name="pPrice"></td>
			</tr>
			<tr id="color">
				<td>상품 색상 : <input type="text" class="colors2" name="pColor">
					<input type="button" value="색상 추가" id="AddcBtn"> <input
					type="button" value="색상 삭제" id="DelcBtn">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="상품등록"> <input type="reset" value="등록취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>