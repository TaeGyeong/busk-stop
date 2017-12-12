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
		<li><a href="${initParam.rootPath }/selectPerformance.do">일반 공연정보 목록</a></li>
		<li><a href="${initParam.rootPath }/performanceDetailView.do?performanceNo=1">공연정보 1번 글 조회</a>
		<li><a href="${initParam.rootPath }/update_performance.do">공연정보 수정</a></li>
		<li><a href="${initParam.rootPath }/videoSelectCategoryView.do">영상등록</a></li>
		<li><a href="${initParam.rootPath }/videoListCategoryView.do">공연영상목록</a></li>
		<li><a href="${initParam.rootPath }/changeInfoCategoryView.do">영상수정/삭제</a></li>
		<li><a href="${initParam.rootPath }/stage/stageRegisterView.do">공연장 등록</a></li>
		<li><a href="${initParam.rootPath }/stageUpdateView.do">공연장수정</a></li>
		<li><a href="${initParam.rootPath }/updateStage.do?stageNo=1">공연장수정테스트</a></li>
		<h5>고객센터</h5>
		<li><a href="${initParam.rootPath }/helpView.do">고객센터 게시물 목록</a></li>
		<li><a href="${initParam.rootPath }/helpRegisterView.do">고객센터 게시글 등록</a></li>
		<h5>premiumStage</h5>
		<li><a href="${initParam.rootPath }/premiumStageEnterDate.do">프리미엄 공연장 대관일 등록</a></li>
		<h5>공연장 예약 상태</h5>
			
<form action="${initParam.rootPath }/selectMyStageSupply.do">
<sec:authorize access="isAuthenticated()">
	<input type="text" name="stageSellerId" value='<sec:authentication property="principal.userId"/>' style="display: none;">
</sec:authorize>
	<button>내가 등록한 공연장 예약 상태 보기</button>
</form>

<form action="${initParam.rootPath }/selectMyStageApply.do">
<sec:authorize access="isAuthenticated()">
	<input type="text" name="rentalUserId" value='<sec:authentication property="principal.userId"/>' style="display: none;">
</sec:authorize>
	<button>내가 신청한 공연장 예약 상태 보기</button>
</form>