<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${initParam.rootPath }/member/registArtist.do" method="post">
	<sec:csrfInput/>
	아티스트 등록.<br>
	이름 : <input type="text" name="artistName"><br>
	장르 : <input type="text" name="performance"><br>
	프로필 : <input type="text" name="profile"><br>
	아티스트 사진 : <input type="text" name="artistImage"><br>
	멤버들 이름 : <input type="text" name="artistMembers"><br>
	SNS 주소 : <input type="text" name="sns"><br>
	<button></button>
</form>
</body>
</html>