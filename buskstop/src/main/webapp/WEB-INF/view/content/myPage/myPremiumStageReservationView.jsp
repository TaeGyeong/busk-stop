<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<table class="table">
	<thead>
		<tr>
			<th>신청한 대관일</th>
			<th>시간</th>
			<th>가격</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.myReservationList }" var="reservation">
			<tr>
				<td>
					<fmt:formatDate value="${reservation.option.stageRentalDate }" pattern="yyy/MM/dd"/>
				</td>
				<td>
					<c:forEach items="${reservation.option.timeList }" var="timeOption">
								${timeOption}시 - ${timeOption+1}시<br>
					</c:forEach>
				</td>
				<td>${reservation.option.stageCost}</td>
				<td>
					<c:choose>
						<c:when test="${reservation.option.stageState == 0}">공연장 대관이 거절되었습니다.</c:when>
						<c:when test="${reservation.option.stageState ==1}">공연장 대관 신청중입니다.</c:when>
						<c:otherwise>공연장 대관이 완료되었습니다.</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
