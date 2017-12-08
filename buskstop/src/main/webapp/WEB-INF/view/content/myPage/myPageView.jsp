<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
	<form action="${initParam.rootPath }/registerArtistView.do">
		<button class="btn-default">아티스트 등록.</button>
	</form>
	<form action="${initParam.rootPath }/registerSupplierView.do">
		<button class="btn-default">공연장공급자 등록.</button>
	</form>
	<form action="${initParam.rootPath }/updateMemberInfo.do">
		<sec:csrfInput/>
		<button class="btn-default">회원정보수정</button>
	</form>
	<form action="${initParam.rootPath }/member/out_member_form.do" class="form-group">
		<sec:csrfInput/>
		<button id="dropBtn" class="btn-default">회원탈퇴</button>
	</form>
	
	
</div>