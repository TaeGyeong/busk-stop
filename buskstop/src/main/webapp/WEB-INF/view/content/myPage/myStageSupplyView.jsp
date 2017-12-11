<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>공급자 - 공연장 예약 상태 페이지 입니다.</h1>
<table>
	<thead>
		<tr>
			<td>공연장 이름</td>
			<td>대관 날짜</td>
			<td>신청자 id</td>
			<td>신청 상태</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.stageReservation }" var="item">
		<tr>
			<td>${item.stageName }</td>
			<td>${item.rentalDate }</td>
			<td>${item.rentalUserId }</td>
			<c:set var="reservation" value="${item.rentalStateCode }">
			<c:choose>
				<c:when test="${reservation eq 0 }">
					거절됨
				</c:when>
				<c:when test="${reservation eq 2 }">
					승인됨
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-success">승인</button>
					<button type="button" class="btn btn-danger">거절</button>
				</c:otherwise>
			</c:choose>
			</c:set>
		</tr>
		</c:forEach>
	</tbody>
</table>