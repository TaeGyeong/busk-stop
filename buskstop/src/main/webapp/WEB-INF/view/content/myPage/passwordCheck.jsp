<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
${requestScope.errorMsg}
<form action="${initParam.rootPath }/checkUserPassword.do" method="post">
	<sec:csrfInput/>
	<input type="hidden" name="category" value="${param.category }">
	<input type="password" name="password">
	<input type="hidden" name="userId" value="<sec:authentication property='principal.userId'/>">
	<button>비밀번호확인</button>
</form>
