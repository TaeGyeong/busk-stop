<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h2>아티스트 홍보영상 등록</h2>
<form action="${initParam.rootPath }/createVideo.do" method="post">
	<sec:csrfInput/>
	<div class="form-group">
		<label for="videoTitle">영상 제목</label> <input type="text"
			name="videoTitle" id="videoTitle" class="form-control"
			required="required">
	</div>
	<div class="form-group">
		<label for="videoRink">영상 링크</label> <input type="text"
			name="videoRink" id="videoRink" class="form-control"
			required="required">
	</div>
	<div class="form-group">
		<label for="videoLocation">공연장소</label> <input type="text"
			name="videoLocation" id="videoLocation"
			class="form-control" required="required">
	</div>
	
	<div class="form-group">
		<label for="videoDate">공연날짜</label> <input type="date"
			name="videoDate" id="videoDate" class="form-control"
			required="required">
	</div>
	<div class="form-group">
		<label for="videoArtist">아티스트명</label> <input type="text"
			name="videoArtist" id="videoArtist" class="form-control"
			required="required">
	</div>
	<div class="form-group">
		<label for="videoCategory">카테고리</label> 
		<select name="videoCategory">
			<option value="performance">공연영상</option>
			<option value="practice">연습영상</option>
		</select>
	</div>
	<label>추가 정보 입력</label>
	<div class="form-group">
		<textarea rows="15" cols="150" name="videoContent"
			placeholder="영상에 대한 정보를 입력하세요."></textarea>
	</div>
</form>
