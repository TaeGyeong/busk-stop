<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
	<form action="${initParam.rootPath }/registerArtistView.do">
		<button class="btn btn-default">아티스트 등록.</button>
	</form>
	<form action="${initParam.rootPath }/registerSupplierView.do">
		<button class="btn btn-default">공연장공급자 등록.</button>
	</form>
	<a class="btn btn-default" href="${initParam.rootPath }/updateMemberInfo.do" role="button">회원정보수정</a><br>
	<a class="btn btn-default" href="${initParam.rootPath }/member/out_member_form.do" role="button">회원탈퇴</a>
</div>