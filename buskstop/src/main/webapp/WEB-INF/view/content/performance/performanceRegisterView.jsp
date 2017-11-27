<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>공연정보 등록</h2>
	<form action="${initParam.rootPath }/performanceRegister.do" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="performanceNo">공연 id</label>
			<input type="number" name="performanceNo" id="performanceNo" class="form-control" required="required">
		</div>
		<div class="form-group">
			<label for="performanceName">공연 이름</label>
			<input type="text" name="performanceName" id="performanceName" class="form-control" required="required">
		</div>
		<div class="form-group">
			<label for="performanceTitle">글제목</label>
			<input type="text" name="performanceTitle" id="performanceTitle" class="form-control" required="required">
		</div>
		<div class="form-group">
			<label for="performanceLocation">공연장소</label>
			<input type="text" name="performanceLocation" id="performanceLocation" class="form-control" required="required">
		</div>
		<div class="form-group">
			<label for="performanceDate">공연날짜</label>
			<input type="date" name="performanceDate" id="performanceDate" class="form-control" required="required">
		</div>
		<div class="form-group">
			<label>입력글</label>
			<textarea rows="30" cols="30" name="performanceContent" id="performanceContent" required="required"></textarea>
		</div>
		<div class="form-group">
			<label for="performanceImage">이미지</label>
			<input type="text" name="performanceImage" id="performanceImage" class="form-control" required="required">
		</div>
		<div class="form-group">
			<label for="performanceUserId">사용자 id</label>
			<input type="text" name="performanceUserId" id="performanceUserId" class="form-control" required="required">
		</div>
		<!-- 공연장 번호 -->
		<button type="submit" class="btn btn-default">등록</button>
		<sec:csrfInput/><%-- csrf 토큰 --%>
	</form>
	
</body>
</html>