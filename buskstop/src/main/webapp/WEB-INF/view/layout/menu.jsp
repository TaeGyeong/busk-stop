<%@ page contentType="text/html;charset=UTF-8" %>
<%--Spring Security 커스텀태그 --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- 시연용 메뉴CSS ***********************************************************  -->
<style type="text/css">
         /* 기본 설정*/
         a{text-decoration:none; color:#000000;}         
         a:hover{color:#ff0000;}                     
         
         /* nav tag */
         nav ul{padding-top:10px;}                    /*  상단 여백 10px  */
         nav ul li {
            display:inline;                           /*  세로나열을 가로나열로 변경 */
            border-left:1px solid #999;               /* 각 메뉴의 왼쪽에 "|" 표시(분류 표시) */
            font:bold 12px Dotum;                     /* 폰트 설정 - 12px의 돋움체 굵은 글씨로 표시 */
            padding:0 10px;                           /* 각 메뉴 간격 */
        }
         nav ul li:first-child{border-left:none;}     /* 메뉴 분류중 제일 왼쪽의 "|"는 삭제*/  
</style>
<!-- 시연용 메뉴CSS ***********************************************************  -->



<%--
   <sec:authorize> : 태그 하위 내용을 볼 수 있는 사용자인지 인증/권한 체크
    속성 -  access="Spring Security EL"  : 볼수 있는 권한 설정											
 --%>

<!--원래 UL CSS <ul class="nav nav-stacked"> -->
<ul><!-- 시연용 메뉴CSS #삭제 해주세요 -->

	<!-- <li><a href="${initParam.rootPath }/youtubeTest.do">유튜브테스트</a></li> -->
<%--인증 관련 없는 메뉴 (로그인 여부와 관련없이 나올 메뉴) --%>
	<%-- 임시용 --%>
	<%--인증 안된(로그인 안한) 사용자 메뉴 : 인증되면 안보여야 하는 메뉴 --%>
	<sec:authorize access="!isAuthenticated()">
		<li><a href="${initParam.rootPath }/login_form.do">로그인</a></li>
		<li><a href="${initParam.rootPath }/join_member_form.do">회원가입</a></li>
	</sec:authorize>
	
	<%--인증된(로그인한) 사용자 메뉴 : 인증 안된상태에서 안보여야 하는 메뉴 --%>
	<sec:authorize access="isAuthenticated()">
		<li><a id="logout" style="cursor: pointer;">로그아웃</a>
		<li><a href="${initParam.rootPath }/myPageView.do">마이페이지</a></li>
		<li><a href="${initParam.rootPath }/likeCheck.do">좋아요테스트</a></li>
		<li><a href="${initParam.rootPath }/performanceRegisterView.do">공연정보 등록</a></li>
		<li><a href="${initParam.rootPath }/allSelectPerformance.do">공연정보 목록</a></li>
		<li><a href="${initParam.rootPath }/performanceDetailView.do?performanceNo=1">공연정보 1번 글 조회</a>
		<li><a href="${initParam.rootPath }/update_performance.do">공연정보 수정</a></li>
		<li><a href="${initParam.rootPath }/videoSelectCategoryView.do">영상등록</a></li>
		<li><a href="${initParam.rootPath }/videoListCategoryView.do">공연영상목록</a></li>
		<li><a href="${initParam.rootPath }/changeInfoCategoryView.do">영상수정/삭제</a></li>
	</sec:authorize>
	
		<!-- <li><a href="${initParam.rootPath }/youtubeTest.do">유튜브테스트</a></li> -->
		<%--인증 관련 없는 메뉴 (로그인 여부와 관련없이 나올 메뉴) --%>
		<%-- 임시용 --%>	
</ul>




<!-- 
	로그아웃전송폼
	+ 로그인/로그아웃은 반드시 POST방식으로 요청하며 csrf 토큰을 보내야 한다.
	+ 로그아웃은 단순 링크이므로 아래와 같이 hidden 폼을 만들고 클릭시 Javascript에서 form을 submit하여 처리한다.
		- style="display:none" ~> 사용자에게 보이지 않게! ~> hidden form 으로 만든다.
 -->
<form id="logoutForm" action="${initParam.rootPath }/logout.do" method="post" style="display:none">
    <sec:csrfInput/>	
</form>


<script>
$(document).ready(function(){
	$("#logout").on("click", function(){
		$("#logoutForm").submit();
	});
});
</script>











