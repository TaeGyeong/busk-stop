<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${initParam.rootPath }/member/registSupplier.do" method="post">
	<sec:csrfInput/>
	공연장공급자 등록.<br>
	사업장번호 : <input type="text" name="establishNum"><br>
	사업자번호 : <input type="text" name="operatorNum"><br>
	장소명 : <input type="text" name="stageName"><br>
	주소 : <input type="text" name="stageLocation"><br>
	면적 : <input type="text" name="stageArea"><br>
	대표사진 : <input type="text" name="stageImage"><br>
	<button></button>
</form>

</body>
</html>