<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h1>회원가입</h1>
<form action="" method="post">

	<div>
		<label for="id">ID</label>
		<input type="text" name="userId" id="id">
	</div>
	<div>
		<label for="password">비밀번호</label>
		<input type="password" name="password">
	</div>
	<div class="form-group">
		<label for="name">이름</label>
		<input type="text" name="userName" id="name">
	</div>
	<div class="form-group">
		<label for="address">주소</label>
		<input type="text" name="userAddress" id="address">
	</div>
	
	<div >
		<label for="phoneNumber">핸드폰번호</label>
		<select>
			<option>010</option>
			<option>011</option>
			<option>018</option>
			<option>019</option>
		</select>
		<input type="text" name="phoneNumber" id="phoneNumber">
	</div>
	<div>
		<label for="email">이메일주소</label>
		<input type="text" name="email" id="email">
		<select name="domain">
			<option>naver.com</option>
			<option>naver.com</option>
			<option>naver.com</option>
			<option>naver.com</option>
		</select>
	</div>
	
	<button type="submit" class="btn btn-default">가입</button>
	<sec:csrfInput/><%-- csrf 토큰 --%>
</form>