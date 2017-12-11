<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-inline">
	<c:forEach items="${requestScope.map.imageList }" var="image">
		<img src="${initParam.rootPath }/supplierImage/${image }" onerror='this.src="${initParam.rootPath }/stageImage/no-image.png"'
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

<table class="table">
	<thead>
		<tr>
			<th>대관날짜</th>
			<th>대관시간</th>
			<th>가격</th>
			<th>예약상태</th>
			<th>예약신청자</th>
			<th>수락/거절</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.map.optionList }" var="dateOption">
			<tr>
				<td><fmt:formatDate value="${dateOption.stageRentalDate }" pattern="yyy/MM/dd"/></td>
				<td>
					<c:forEach items="${requestScope.map.timeList }" var="timeOption">
						<c:choose>
							<c:when test="${dateOption.optionNo eq timeOption.optionNo }">
								${timeOption.timeCode}시 - ${timeOption.timeCode+1}시,
							</c:when>
						</c:choose>
					</c:forEach>
				</td>
				<td>${dateOption.stageCost }</td>
				<td>
					<c:choose>
						<c:when test="${dateOption.stageState == 2}">대관완료</c:when>
						<c:when test="${dateOption.stageState ==1}">수락대기</c:when>
						<c:otherwise>신청대기</c:otherwise>
					</c:choose>
				</td>
				<td></td>
				<td>
					<c:choose>
						<c:when test="${dateOption.stageState == 2}">대관완료</c:when>
						<c:when test="${dateOption.stageState ==1}">
							<from action="">
								<button class="btn btn-defalut">수락</button>
								<button class="btn btn-defalut">거절</button>
							</from>
						</c:when>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<form action="${initParam.rootPath }/producer/goPremiumStageEnterDate.do" method="get">
	<input type="hidden" name="establishNo" value="${requestScope.map.premiumStage.establishNum }">
	<button class="btn btn-default" type="submit">대관일 등록으로 이동</button>
</form>