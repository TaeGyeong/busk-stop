<%@ page contentType="text/html;charset=utf-8"%>
<h2>카테고리 선택</h2>
<form action="videoSelectCategory.do" method="post">
	<input type="hidden" name="category" value="artist"/>
	<button type="submit">아티스트</button>
</form>
<p>
<form action="videoSelectCategory.do" method="post">
	<input type="hidden" name="category" value="user"/>
	<button type="submit">일반회원</button>
</form>