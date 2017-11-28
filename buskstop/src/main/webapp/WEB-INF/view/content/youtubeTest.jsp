<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#youtubeBtn").on("click",function(){
		var txt = $("#url").val();
		$("#result").html(txt);
	});
});

</script>
</head>
<body>

	<input type="text" id="url">
	<sec:csrfInput/>
	<button id="youtubeBtn">url전송</button>

<div id="result">

</div>
</body>
</html>