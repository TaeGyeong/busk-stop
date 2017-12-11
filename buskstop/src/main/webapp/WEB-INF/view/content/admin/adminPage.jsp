<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script>

</script>
<sec:authorize access="hasRole('ROLE_ADMIN')">

<h2>관리자 등록하기</h2>

<br>
<a href="${initParam.rootPath }/admin/member.do">회원관리</a>
<br>
<a href="${initParam.rootPath }/admin/stage.do">공연장관리</a>
<br>
<a href="${initParam.rootPath }">공연정보관리</a>
<br>
<a href="${initParam.rootPath }">영상관리</a>
<br>
<a href="${initParam.rootPath }">공연장 리뷰관리</a>
<br>
<a href="${initParam.rootPath }">공연정보 댓글관리</a>
<br>
<a href="${initParam.rootPath }">영상댓글관리</a>
<br>
<a href="${initParam.rootPath }">고객센터</a>
<br>

<div id="registForm">
	<div>
		
	</div>
</div>

</sec:authorize>