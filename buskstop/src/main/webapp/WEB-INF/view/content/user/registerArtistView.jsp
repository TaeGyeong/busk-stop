<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${initParam.rootPath }/member/registArtist.do" method="post" enctype="multipart/form-data">
	<sec:csrfInput/>
	아티스트 등록.<br>
	이름 : <input type="text" name="artistName" required="required"><br>
	장르 : <input type="text" name="performance" required="required"><br>
	프로필 : <input type="text" name="profile" required="required"><br>
	아티스트 사진 : <input type="file" name="multiImage" required="required"><br>
	멤버들 이름 : <input type="text" name="artistMembers" required="required"><br>
	SNS 주소 : <input type="text" name="sns" required="required"><br>
	<div class="form-group">
		<sec:authorize access="isAuthenticated()">
			<input type="hidden" name="artistId" id="performanceUserId" class="form-control" value='<sec:authentication property="principal.userId"/>'>
		</sec:authorize>
	</div>
	<button>등록</button>
</form>
</body>
</html>