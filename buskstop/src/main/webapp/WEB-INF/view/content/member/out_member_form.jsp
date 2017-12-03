<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>정말 탈퇴하시겠습니까?</h1>
<form action="${initParam.rootPath }/member/dropUser.do" method="post">
	<sec:csrfInput/>
	<button>확인</button>
</form>
<form action="${initParam.rootPath }/myPageView.do" method="post">
	<sec:csrfInput/>
	<button>취소</button>
</form>

</body>
</html>