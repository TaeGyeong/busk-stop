<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<form action="${initParam.rootPath }/producer/selectViewPremiumStage.do" method="post">
	<sec:csrfInput/>
	<button>내 공연장 조회</button>
	<input type="hidden" name="userId" value='<sec:authentication property="principal.userId"/>'>
</form>

<form action="${initParam.rootPath }/producer/selectEditPremiumStage.do" method="post">
	<sec:csrfInput/>
	<button>내 공연장 정보 수정</button>
	<input type="hidden" name="userId" value='<sec:authentication property="principal.userId"/>'>
</form>

<form action="${initParam.rootPath }/producer/selectDeletePremiumStage.do" method="post">
	<sec:csrfInput/>
	<button>내 공연장 삭제</button>
	<input type="hidden" name="userId" value='<sec:authentication property="principal.userId"/>'>
</form>