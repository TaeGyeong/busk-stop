<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- requestScope.map.premiumStage / imgaeList(이미지 파일명 리스트)  -->



<!-- 프리미엄 공연장 사진목록뿌려주기. -->
<div class="container-inline">
	<c:forEach items="${requestScope.map.imageList }" var="image">
		<img src="${initParam.rootPath }/stageImage/${image }" onerror='this.src="${initParam.rootPath }/stageImage/no-image.png"'
			style="width:300px; height:300px;">
	</c:forEach>
</div>
<table class="table">
	<thead>
		<tr>
			<th>사업장번호</th>
			<th>사업자번호</th>
			<th>장소명</th>
			<th>주소</th>
			<th>면적</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${requestScope.map.premiumStage.establishNum }</td>
			<td>${requestScope.map.premiumStage.operatorNo }</td>
			<td>${requestScope.map.premiumStage.stageName }</td>
			<td>${requestScope.map.premiumStage.stageLocation }</td>
			<td>${requestScope.map.premiumStage.stageArea }</td>
		</tr>
	</tbody>
</table>

<table class="table">
	<thead>
		<tr>
			<th>주차가능여부</th>
			<th>음주가능여부</th>
			<th>음식판매여부</th>
			<th>외부음식 반입가능여부</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				<c:choose>
					<c:when test="${requestScope.map.premiumStage.stageParking eq 0 }">O</c:when>
					<c:otherwise>X</c:otherwise>
				</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${requestScope.map.premiumStage.stageDrinking eq 0 }">O</c:when>
					<c:otherwise>X</c:otherwise>
				</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${requestScope.map.premiumStage.stageFoodSell eq 0 }">O</c:when>
					<c:otherwise>X</c:otherwise>
				</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${requestScope.map.premiumStage.stageFoodRestriction eq 0 }">O</c:when>
					<c:otherwise>X</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</tbody>
</table>