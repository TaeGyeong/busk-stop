<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div style="width: 100%; float: left;">
	<form action="${initParam.rootPath }/producer/goAddPremiumStage.do" method="post" style="float: right;">
		<sec:csrfInput/>
		<button>공연장 추가등록하기</button>
		<input type="hidden" name="userId" value='<sec:authentication property="principal.userId"/>'>
	</form>
</div>

<div id="establishList">
	<c:forEach items="${requestScope.list }" var="stage">
		<form action="${initParam.rootPath }/producer/myStageDetail.do" method="post" style="float: left; width: 100%;">
		<sec:csrfInput/>
			<button class="btn btn-default" id="establishNum" name="establishNum" value="${stage.establishNum }">선택</button>
			사업장 이름 : ${stage.stageName }
		</form>
		<form action="${initParam.rootPath }/producer/goStageUpdateView.do" method="post">
			<sec:csrfInput/>
			<button>내 공연장 정보 수정하기</button>
			<input type="hidden" name="establishNum" value='${stage.establishNum }'>
		</form>
		<hr>
	</c:forEach>
</div>

