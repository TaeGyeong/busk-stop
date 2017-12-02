<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${initParam.rootPath }/member/registSupplier.do" method="post" enctype="multipart/form-data">
	<sec:csrfInput/>
	<input type="hidden" name="userId" value='<sec:authentication property="principal.userId"/>'>
	공연장공급자 등록.<br>
	사업장번호 : <input type="text" name="establishNum" required="required"><br>
	사업자번호 : <input type="text" name="operatorNum" required="required"><br>
	장소명 : <input type="text" name="stageName" required="required"><br>
	주소 : <input type="text" name="stageLocation" required="required"><br>
	면적 : <input type="text" name="stageArea" required="required"><br>
	대표사진 : <input type="file" name="multiImage"><br>
	<button>등록</button>
</form>

</body>
</html>