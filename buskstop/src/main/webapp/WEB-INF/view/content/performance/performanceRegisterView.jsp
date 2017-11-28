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
	<form action="${initParam.rootPath }/performanceRegister.do"
		method="post">

/
		<div class="form-group">
			<label for="performanceNo">공연 id</label> <input type="number"
				name="performanceNo" id="performanceNo" class="form-control"
				required="required">
		</div>
		
		<div class="form-group">
			<label for="performanceName">공연 이름</label> <input type="text"
				name="performanceName" id="performanceName" class="form-control"
				required="required">
		</div>
		<div class="form-group">
			<label for="performanceTitle">글제목</label> <input type="text"
				name="performanceTitle" id="performanceTitle" class="form-control"
				required="required">
		</div>
		<div class="form-group">
			<label for="performanceLocation">공연장소</label> <input type="text"
				name="performanceLocation" id="performanceLocation"
				class="form-control" required="required">
		</div>
		<div class="form-group">
			<label for="performanceDate">공연날짜</label> <input type="date"
				name="performanceDate" id="performanceDate" class="form-control"
				required="required">
		</div>

		<label>추가 정보 입력</label>
		<div class="form-group">
			<textarea rows="15" cols="150" name="performanceContent"
				placeholder="공연에 대한 정보를 입력하세요."></textarea>
		</div>
		<div class="form-group">
			<label for="performanceImage">이미지</label> 
			<input type="file"	name="performanceImage" 
			id="performanceImage" class="form-control">
		</div>


		<div class="form-group">
			<label for="performanceUserId">사용자 id</label> <input type="text"
				name="performanceUserId" id="performanceUserId" class="form-control">
		</div>
		
		
		<sec:csrfInput />
		<%-- csrf 토큰 --%>
		<button type="submit" class="btn btn-default">등록</button>
		<button type="button" class="btn btn-default"
			onclick="history.back();">취소</button>
	</form>
	
</body>
</html>