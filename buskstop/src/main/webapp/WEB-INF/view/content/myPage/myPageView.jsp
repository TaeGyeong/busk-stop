<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
마이페이지

<form action="${initParam.rootPath }/registerArtistView.do">
	<button>아티스트 등록.</button>
</form>
<form action="${initParam.rootPath }/registerSupplierView.do">
	<button>공연장공급자 등록.</button>
</form>
<form action="${initParam.rootPath }/updateMemberInfo.do">
	<sec:csrfInput/>
	<button>회원정보수정</button>
</form>
<form action="${initParam.rootPath }/out_member_form.do">
	<sec:csrfInput/>
	<button>회원탈퇴</button>
</form>

