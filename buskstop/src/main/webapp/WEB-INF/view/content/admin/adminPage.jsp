<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script>

</script>
<sec:authorize access="hasRole('ROLE_ADMIN')">

<label>관리자 등록하기</label>

<a href="${initParam.rootPath }/admin/member.do">회원관리</a>
<a href="${initParam.rootPath }">공연장관리</a>
<a href="${initParam.rootPath }">공연정보관리</a>
<a href="${initParam.rootPath }">영상관리</a>
<a href="${initParam.rootPath }">공연장 리뷰관리</a>
<a href="${initParam.rootPath }">영상댓글관리</a>
<a href="${initParam.rootPath }">고객센터</a>

<div id="registForm">
	<div>
		
	</div>
</div>

</sec:authorize>