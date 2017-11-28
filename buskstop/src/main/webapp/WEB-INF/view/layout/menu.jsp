<%@ page contentType="text/html;charset=UTF-8" %>
<%--Spring Security 커스텀태그 --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
   <sec:authorize> : 태그 하위 내용을 볼 수 있는 사용자인지 인증/권한 체크
    속성 -  access="Spring Security EL"  : 볼수 있는 권한 설정
   													
 --%>
<ul class="nav nav-stacked">
<%--인증 안된(로그인 안한) 사용자 메뉴 : 인증되면 안보여야 하는 메뉴 --%>
<sec:authorize access="!isAuthenticated()">
	<li><a href="${initParam.rootPath }/login_form.do">로그인</a></li>
	<li><a href="${initParam.rootPath }/join_member_form.do">회원가입</a></li>
</sec:authorize>


<%--인증된(로그인한) 사용자 메뉴 : 인증 안된상태에서 안보여야 하는 메뉴 --%>
<sec:authorize access="isAuthenticated()">
	<li><a id="logout" style="cursor: pointer;">로그아웃</a>
	<li><a href="${initParam.rootPath }/performanceRegisterView.do">공연등록</a></li>
	<li><a href="${initParam.rootPath }/allSelectPerformance.do">공연정보 목록</a></li>
	<li><a href="${initParam.rootPath }/update_performance.do">공연 수정</a>
	<li><a href="${initParam.rootPath }/videoSelectCategoryView.do">영상등록</a></li>
</sec:authorize>



<%--인증 관련 없는 메뉴 (로그인 여부와 관련없이 나올 메뉴) --%>

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











