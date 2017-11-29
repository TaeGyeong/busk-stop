<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h2>카테고리선택</h2>
<form action="${initParam.rootPath }/videoListCategory.do" method="post">
	<sec:csrfInput/>
	<input type="hidden" name="category" value="artist"/>
	<button type="submit">아티스트</button>
</form>
<p>
<form action="${initParam.rootPath }/videoListCategory.do" method="post">
	<sec:csrfInput/>
	<input type="hidden" name="category" value="user"/>
	<button type="submit">일반회원</button>
</form>