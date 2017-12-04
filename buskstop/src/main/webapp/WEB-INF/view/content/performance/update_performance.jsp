<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$("#dateBtn").on("click", function(){
		alert($("#performanceTime").val());
		$("#performanceDate").val($("#performanceDay").val() + " " + $("#performanceTime").val());
	});
});
</script>
<body>
	<form action="${initParam.rootPath }/performanceUpdate2.do"
		method="post" enctype="multipart/form-data">
	
 		<div class="form-group">
			<label for="no">공연 번호 </label> <input type="text"
				name="performanceNo" id="no" class="form-control"
				value="${param.performanceNo}" readonly>
				
		</div>
		<div class="form-group">
			<label for="id">수정할 공연 이름 </label> <input type="text"
				name="performanceName" id="name" class="form-control"
				value="${requestScope.Performance.performanceName }">
		</div>
		<div class="form-group">
			<label for="title">수정할 게시글 제목 </label> <input type="text"
				name="performanceTitle" id="title" class="form-control"
				value="${requestScope.Performance.performanceTitle }">
		</div>
		<div class="form-group">
			<label for="location">수정할 공연 위치 </label> <input type="text"
				name="performanceLocation" id="location" class="form-control"
				value="${requestScope.Performance.performanceLocation }">
		</div>
		<div class="form-group">
			<label for="date">수정할 공연 날짜 </label> <input type="date"
				name="performanceDay" id="performanceDay" class="form-control">
		</div>
		<div class="form-group">
			<label class="col-sm-2">수정할 공연시간</label>
			<input type="time" name="performanceTime" id="performanceTime" class="form-control col-sm-3" required="required">
		</div>
		<div class="form-group">
			<button type="button" class="btn btn-default col-sm-1" id="dateBtn">날짜 확인</button>
			<input type="datetime" readonly="readonly" name="performanceDate" id="performanceDate" class="form-control col-sm-3" required="required">
		</div>
		
		<div class="form-group">
			<label for="content">수정할 공연 내용 </label>
			<textarea rows="15" cols="150" name="performanceContent" >${requestScope.Performance.performanceContent}</textarea>
		</div>

		<div class="form-group">
			<label for="performanceImage">이미지</label> <input type="file"
				name="multiImage" id="multiImage" class="form-control">
		</div>

		<div class="form-group">
			 <label for="userId">사용자 id </label> 
			<input type="text"
				name="performanceUserId" id="performanceUserId" class="form-control"
				value="<sec:authentication property="principal.userId"/>" readonly>
		</div>


		<button type="submit" class="btn btn-default">정보수정</button>
		<button type="button" onclick="history.back();">취소</button>

		<sec:csrfInput />
		<%-- csrf 토큰 --%>

	</form>
</body>
</html>