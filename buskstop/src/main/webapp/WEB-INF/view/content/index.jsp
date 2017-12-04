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

<h3>테스트 코드 - index.jsp</h3>
		<li><a href="${initParam.rootPath }/likeCheck.do">좋아요테스트</a></li>
		<li><a href="${initParam.rootPath }/performanceRegisterView.do">공연정보 등록</a></li>
		<li><a href="${initParam.rootPath }/allSelectPerformance.do">공연정보 목록</a></li>
		<li><a href="${initParam.rootPath }/performanceDetailView.do?performanceNo=1">공연정보 1번 글 조회</a>
		<li><a href="${initParam.rootPath }/update_performance.do">공연정보 수정</a></li>
		<li><a href="${initParam.rootPath }/videoSelectCategoryView.do">영상등록</a></li>
		<li><a href="${initParam.rootPath }/videoListCategoryView.do">공연영상목록</a></li>
		<li><a href="${initParam.rootPath }/changeInfoCategoryView.do">영상수정/삭제</a></li>
		<li><a href="${initParam.rootPath }/stageUpdateView.do">공연장수정</a></li>
		<li><a href="${initParam.rootPath }/stageUpdateView.do">공연장수정테스트</a></li>