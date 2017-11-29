<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h2>카테고리 선택</h2>
<form action="${initParam.rootPath }/videoSelectCategory.do" method="post">
	<sec:csrfInput/>
	<label for="artist">아티스트</label> - <input id="artist" type="radio" name="videoCategory" value="artist">
	<label for="user">일반회원</label> - <input id="user" type="radio" name="videoCategory" value="user">
	<button type="submit">확인</button>
</form>

