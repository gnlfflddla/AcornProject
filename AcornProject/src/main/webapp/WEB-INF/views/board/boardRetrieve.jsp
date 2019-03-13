<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글자세히 보기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".ccmt").on("click",function() {
			var id = $(this).attr("id");
			$("#trccm").remove();
			var tagadd = "<tr id='trccm'>";
			tagadd += "<td><div><input type='text' id='cuserid' name='author' " ;
			tagadd+="value='UserID'></div></td><td>";
			tagadd += "<input type='hidden' name='comment_boardnum' value='${retrieve.num}'><br>";
			tagadd += "<div><textarea name='comment_content' id='ccontent' cols='50' rows='2'maxlength='6000' ";
			tagadd+="style='overflow: hidden; line-height: 14px; height: 39px;' title='댓글입력'></textarea>";
			tagadd += "</div></td><td><div><input type='button' class='cmtReply' id='' value='[등록]'></input></div></td></tr>";
			$(tagadd).insertAfter($("tr[name=trcm"+ id + "]"));
			$(".cmtReply").attr("id",id);
		});
		$("body").on("click",".cmtReply",function(){
			var id = $(this).attr("id");
			var rootnum=$("#rootnum"+id).val();
			var repRoot=$("#repRoot"+id).val();
			var repStep=$("#repStep"+id).val();
			var author = $("#cuserid").val();
			var content = $("#ccontent").val();
			var url = "ccwrite.do?";
			url+="rootnum="+rootnum+"&repRoot="+repRoot+"&repStep="+repStep+"&author="+author+"&content="+content;
			
			
			window.location.href = url;
			
			
		});
			
		$(".upcmt").on("click", function() {
			var id = $(this).attr("id");
			console.log(id)
		});
		$(".upcmt").on("click", function() {
			var id = $(this).attr("id");
			console.log(id)

		});

						/* 	$("#writeCmt").on("click", function() {
								var queryString = $("form[name=commentForm]").serialize();
								$.ajax({
									type : "post",
									url : "cwrite.do",
									data : queryString,
									dataType : "text",
									success : function(responsedata, status, xhr) {
										console.log(responsedata);
									},
									error : function(jqXHR, textStatus, errorThrown) {
										console.log(errorThrown);
									}
								});
							}); */
					});
</script>
</head>
<body>
	<h1>글 자세히 보기</h1>
	<form action="update.do" method="post">
		<!-- 글 수정시 필요 -->
		<input type="hidden" name="num" value="${retrieve.num}"> 글번호 :
		${retrieve.num} &nbsp;&nbsp;&nbsp;&nbsp; 조회수 : ${retrieve.readcnt}<br>
		제목 : <input type="text" name="title" value="${retrieve.title}"><br>
		작성자 : <input type="text" name="author" value="${retrieve.author}"><br>
		내용 :
		<textarea rows="10" name="content">${retrieve.content}</textarea>
		<input type="submit" value="수정">
	</form>
	<a href="list.do">목록</a>
	<a href="delete.do?num=${retrieve.num}">삭제</a>
	<a href="replyui.do?num=${retrieve.num}">답변달기</a>
	<hr>
	
	<c:if test="${cmtPDTO != null}">
		<c:forEach var="comment" items="${cmtPDTO.list}">
			<input type='hidden' id='rootnum${comment.num}' value='${retrieve.num}'>
			<input type='hidden' id='repRoot${comment.num}' value='${comment.repRoot}'>
			<input type='hidden' id='repStep${comment.num}' value='${comment.repStep}'>
			<table>
				<tr name="trcm${comment.num}" id="${comment.num}">
					<c:forEach begin="1" end="${comment.repIndent}">
						<td>ㄴ</td>
					</c:forEach> <!-- 아이디, 작성날짜 -->
					<td width="150">
						<div>
							<font style="font-weight: bold">${comment.author}<br>
								<font size="2" color="lightgray">${comment.writeday}</font>
						</div>
					</td>

					<!-- 본문 내용 -->

					<td width="550">
						<div>${comment.content}</div>
					</td>
					<td width="100">
						<div>
							<a href="#" class="ccmt" id="${comment.num}">[답변]</a><br>
							<!-- 부모댓글 번호확인 -->
							<%-- <c:if test="작성자 아이디와 로그인 아이디가 같을경우 활성화"> --%>
							<a href="#" class="upcmt" id="${comment.num}">[수정]</a> <br>
							<a href="#" class="delccmt" id="${comment.num}">[삭제]</a> <br>
							<%-- 	</c:if> --%>
						</div>
					</td>
				</tr>
			</table>
			<hr>
		</c:forEach>
	</c:if>
	<%-- <c:if test="로그인 했을경우 댓글 가능"> --%>
	<form action="cwrite.do" method="get">
		<input type="hidden" name="comment_boardnum" value="${retrieve.num}"><br>
		<table>

			<tr>
				<td>
					<div>
						<input type="text" id="userid" name="comment_author"
							value="UserID">
					</div>
				</td>
				<td>
					<div>
						<textarea name="comment_content" id cols="50" rows="2"
							maxlength="6000"
							style="overflow: hidden; line-height: 14px; height: 39px;"
							title="댓글입력"></textarea>
					</div>
				</td>
				<td>
					<div>
						<button>[등록]</button>
					</div>
				</td>
			</tr>

		</table>
	</form>
	<%-- </c:if> --%>
</body>
</html>