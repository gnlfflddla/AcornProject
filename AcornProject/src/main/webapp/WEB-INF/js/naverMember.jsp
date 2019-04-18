<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	if('${naverInfo}'!=null){
	var id='${naverInfo.id}';
	
	$("#check").removeAttr("required");
	$("#result").removeAttr("required");
	$("#check").attr("hidden",true);
	
	$("#userid").attr("value",id);
	$("#userid").attr("readonly", true);
	
	$("#passwd").attr("disabled", true);
	$("#passwd1").attr("disabled", true);
	
	$("#username").attr("value",'${naverInfo.name}');
	$("#birthday").attr("value",'${naverInfo.birthday}');
	$("#username").attr("value",'${naverInfo.name}');
	
	var email='${naverInfo.email}'.split('@');
	$("#email1").attr("value",email[0]);
	$("#email2").attr("value",email[1]);
	$("#email1").attr("readonly", true);
	$("#email2").attr("readonly", true);
	
	$("#emailselector").attr("hidden",true);
	$("#num").attr("hidden",true);
	
	$("#A_num").removeAttr("required");
	$("#A_num").attr("hidden",true);
	
	$("#check1").attr("hidden",true);
	
	
	}
	
});
</script>	
</head>
<body>

</body>
</html>