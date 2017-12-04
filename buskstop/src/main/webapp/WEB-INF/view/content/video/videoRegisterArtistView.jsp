<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#registBtn").on("click",function(){
			var txt = rink($("#videoLink").val());
			$("#videoLink").val(txt);
			document.getElementById("registForm").submit();
		});
	});
	
	function rink(txt){
		var video_id = txt.split('v=')[1];
	    var ampersandPosition = video_id.indexOf('&');
	    if(ampersandPosition != -1) {
	      video_id = video_id.substring(0, ampersandPosition);
	    }
	    return video_id;
	}
</script>

<h2>아티스트 홍보영상 등록</h2>
<form action="${initParam.rootPath }/createVideo.do" id="registForm" method="post">
	<sec:csrfInput/>
	<div class="form-group">
		<label for="videoTitle">영상 제목</label> <input type="text"
			name="videoTitle" id="videoTitle" class="form-control"
			required="required">
	</div>
	<div class="form-group">
		<label for="videoRink">영상 링크</label> <input type="text"
			name="videoLink" id="videoLink" class="form-control"
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
		<input type="hidden" id ="videoCategory" name="videoCategory" value="artist" class="form-control">
	</div>
	<label>추가 정보 입력</label>
	<div class="form-group">
		<textarea rows="15" cols="150" name="videoContent"
			placeholder="영상에 대한 정보를 입력하세요."></textarea>
	</div>
	
	<%-- 사용자 id --%>
	<div class="form-group">
		<sec:authorize access="isAuthenticated()">
			<input type="hidden" name="videoUserId" id="videoUserId"
				class="form-control"
				value='<sec:authentication property="principal.userId"/>'>
		</sec:authorize>
	</div>
	<button id="registBtn" class="btn btn-default">등록</button>
	<button type="button" class="btn btn-default"
		onclick="location.href='${initParam.rootPath}/index.do'">취소</button>
</form>
