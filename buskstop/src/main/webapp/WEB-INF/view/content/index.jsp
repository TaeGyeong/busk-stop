<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%-- 
<a href="${initParam.rootPath }/login_form.do">로그인창</a><br>
<a href="${initParam.rootPath }/join_member_form.do">회원가입</a><br>
<a href="${initParam.rootPath }/performanceRegisterView.do">공연등록</a><br>
<a href="${initParam.rootPath }/performanceView.do">공연정보 목록</a><br>
 --%>
<sec:authorize access="isAuthenticated()">
	 <!-- Authentication의 getPrincipal() 호출 - User 리턴 -->
	<sec:authentication property="principal.userName"/> 님 환영합니다.<br>
</sec:authorize>

