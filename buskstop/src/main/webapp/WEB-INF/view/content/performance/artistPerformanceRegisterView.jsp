<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	$("#dateBtn").on("click", function(){
		$("#performanceDate").val($("#performanceDay").val() + " " + $("#performanceTime").val());
	});
	
	$("#searchStage").on("click", function(){
		var address = "${initParam.rootPath}/searchStageByAddress.do"; //doGet()방식으로 요청
		left1 = (screen.availWidth - 600) / 2;
		top1 = (screen.availHeight - 500) / 2;
		window.open(address, "newWin", 'width=600 ,height=500 ,top=' + top1 + ',left=' + left1 + ',resizable=no');
	});
});
</script>
	<h2>공연정보 등록</h2>
	<form action="${initParam.rootPath }/artist/performanceRegister.do" method="post" class="performance_register_form" enctype="multipart/form-data">
		
		<%-- 공연id hidden --%>
		<div class="form-group">
			<input type="hidden" name="performanceNo" id="performanceNo" class="form-control" required="required" value="0">
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
			<input type="text" name="performanceLocation" id="performanceLocation" class="form-control" required="required" readonly="readonly" placeholder="버튼을 통해 장소를 검색해 주세요.">  
			<!-- <input type="text" name="performanceLocation" id="performanceLocation" class="form-control" required="required"> -->
			<input type="button" id="selectStage" value="대관한 장소 선택" class="btn btn-default col-sm-2">
			<input type="button" id="searchStage" value="직접 검색" class="btn btn-default col-sm-1"><br>
		</div>
		<label>공연날짜</label><br>
		<div class="form-group">
			<label class="col-sm-2">공연일시</label><input type="date" name="performanceDay" id="performanceDay" class="form-control col-sm-3" required="required">
		</div>
		<div class="form-group">
			<label class="col-sm-2">공연시간</label><input type="time" name="performanceTime" id="performanceTime" class="form-control col-sm-3" required="required">
		</div>
		<div class="form-group">
			<button type="button" class="btn btn-default col-sm-1" id="dateBtn">날짜 확인</button>
			<input type="datetime" readonly="readonly" name="performanceDate" id="performanceDate" class="form-control col-sm-3" required="required">
		</div>
		<label class="col-sm-12">추가 정보 입력</label> 
		<div class="form-group">
			<textarea rows="15" cols="150" name="performanceContent" placeholder="공연에 대한 정보를 입력하세요."></textarea>
		</div>
		
		<div class="form-group">
			<label for="multiImage">이미지</label>
			<input type="file" name="multiImage" id="multiImage" class="form-control">
		</div>
		
		<%-- 사용자 id hidden --%>
		<div class="form-group">
			<sec:authorize access="isAuthenticated()">
			<input type="hidden" name="performanceUserId" id="performanceUserId" class="form-control" value='<sec:authentication property="principal.userId"/>'>
			</sec:authorize>
		</div>
		
		
		<!-- 공연장 번호 -->
		<button type="submit" class="btn btn-default">등록</button> 
		<button type="button" class="btn btn-default" onclick="location.href='${initParam.rootPath}/performanceView.do'">취소</button>
		<sec:csrfInput/><%-- csrf 토큰 --%>
	</form>
	
	
</body>
</html>