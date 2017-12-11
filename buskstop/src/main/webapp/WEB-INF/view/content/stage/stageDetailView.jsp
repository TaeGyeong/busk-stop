<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<script type="text/javascript" src="${initParam.rootPath}/resource/jquery/jquery-3.2.1.min.js"></script>
<script>
function updatePerformance(){	
	var output = "";
	output+=location.href='${initParam.rootPath }/updateStage.do?stageNo=${param.stageNo}';
	
}

function deletePerformance(performanceNo){
	
	var output = "";
	output+=location.href='${initParam.rootPath }/deleteStage.do?stageNo=${param.stageNo}';
	
}

$(document).ready(function(){
	$("#reservationBtn").on("click", function(){
		$.ajax({
			"url" : "${initParam.rootPath}/insertStageRservation.do",
			"type" : "post",
			"data" : {
				"rentalNoNumber" : 0,
				"stageNo" : "${requestScope.map.stage.stageNo}",
				"rentalStateCode" : 1,
				"rentalUserId" : "${requestScope.map.userId}",
				'${_csrf.parameterName}':'${_csrf.token}'
			},
			"dataType":"text",
			"success":function(msg){
				alert(msg);
				location.reload();
			},
			"error":function(jqXHR, textStatus, errorThrown, msg){
				alert(msg + textStatus + " : " + errorThrown);
				location.reload();
			}
		});
	});
	
	$("#cancelBtn").on("click", function(){
		$.ajax({
			"url" : "${initParam.rootPath}/cancelStageReservation.do",
			"type" : "post",
			"data" : {
				"stageNo" : "${requestScope.map.stage.stageNo}",
				'${_csrf.parameterName}':'${_csrf.token}'
			},
			"dataType":"text",
			"success":function(msg){
				alert(msg);
				location.reload();
			},
			"error":function(jqXHR, textStatus, errorThrown, msg){
				alert(msg + textStatus + " : " + errorThrown);
				location.reload();
			}
		});
	});
});
</script>
<style type="text/css">
	table, td{
		border: 1px solid black;
	}
	table{
		width:100%;
		border-collapse: collapse;
		border-spacing: 150px;
	}
	td{
		padding: 5px;
		text-align: center;
		width: 300px;
		background: white;
		
	}
	select{
		width:150px;height: 30px;
	}
	#container{
		width:960px;
		margin : 0 auto;
	}	
</style>
<div id="container">
	<h1>DETAIL VIEW - 공연장 글 읽기 </h1>
	<hr>
	
	<h2>공연장 게시판</h2>
	
	<!-- Board Content -->
	<div style="border-top: 1px solid #e5e5e5; border-bottom: 1px solid #e5e5e5; overflow : hidden; position: relative">
		<div style="width: 50%; float: left;">
			<h3>${requestScope.map.stage.stageNo}. ${requestScope.map.stage.stageName}</h3>
		</div>
		<div style="float:left; width: 50%; margin-top: 20px;">
			<div style="float:right; margin-left:20px;"><fmt:formatDate value="${requestScope.map.stage.stageRegTime}" pattern="yyyy-MM-dd HH:mm:ss"/></div><br>
			<div style="float:right;">${requestScope.map.stage.stageSellerId}<strong>님</strong></div>
		</div>
	</div>
	
	
	<div>
		<c:forEach var="img" items="${requestScope.map.stageImage }">
			<p style="color:#515151; font-size: 16px; padding:20px;">
				<img src="${initParam.rootPath }/stageImage/${img.stageImageLocation }.jpg" onerror="this.src='${initParam.rootPath }/performanceImage/no-image.png;'">
			</p>
		</c:forEach>
	</div>
	
	<div>
		<hr style="float:bottom">
		<p style="color:#515151; font-size: 16px; padding:20px;">
		<label> 내용 : </label>
			${requestScope.map.stage.stageContent}
		</p>
	</div>
	
	<div>
		<hr style="float:bottom">
		<p style="color:#515151; font-size: 16px; padding:20px;">
			<label>구비된 악기 : </label>
			${requestScope.map.stage.stageInstrument}
		</p>
	</div>
	<div>
		<hr style="float:bottom">
		<p style="color:#515151; font-size: 16px; padding:20px;">
			<label>예약 날짜 : </label>
			<fmt:formatDate value="${requestScope.map.stage.stageRentalDate}" pattern="yyyy-MM-dd"/>&nbsp;&nbsp;
			<fmt:formatDate value="${requestScope.map.stage.stageStartTime}" pattern="HH시 mm분"/>&nbsp;
			~&nbsp;<fmt:formatDate value="${requestScope.map.stage.stageEndTime}" pattern="HH시 mm분"/>
		</p>
	</div>
	<div style="border-bottom: 1px solid #e5e5e5; overflow : hidden; padding : 5px; background: #f9f9f9; ">
		<div style="position:static; float:left;">
			<div style="float:left; margin-right:5px; width:100%;">공연장소</div> 
			<%-- <div style="float:left; margin-right:20px;">${requestScope.performance.performanceLocation }</div> --%>
			<div id="map" style="position:static; width:800px; height:400px"></div>
			<script type="text/javascript" src="${initParam.rootPath}/resource/jquery/jquery-3.2.1.min.js"></script>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2cf9bb3da4e98eebd3e7696702b01439&libraries=services"></script>
			<script type="text/javascript">
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = {
			        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			        level: 3 // 지도의 확대 레벨
			    };  
	
				// 지도를 생성합니다    
				var map = new daum.maps.Map(mapContainer, mapOption); 
		
				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new daum.maps.services.Geocoder();
		
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch('${requestScope.map.stage.stageLocation}', function(result, status) {
		
				    // 정상적으로 검색이 완료됐으면 
				     if (status === daum.maps.services.Status.OK) {
		
				        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
		
				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new daum.maps.Marker({
				            map: map,
				            position: coords
				        });
		
				        // 인포윈도우로 장소에 대한 설명을 표시합니다
				        var infowindow = new daum.maps.InfoWindow({
				            content: '<div style="width:150px;text-align:center;padding:6px 0;">${requestScope.stage.stageName}</div>'
				        });
				        infowindow.open(map, marker);
		
				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        map.setCenter(coords);
				    } 
				});    
			</script>
		</div>
	</div>
	
	<div>
		<hr style="float:bottom">
		<table>
			<tr>
				<td> ↓ 주차장 유무  ↓</td>
				<td> ↓ 음주가능 여부 ↓  </td>
				<td> ↓ 외부음식 반입 여부 ↓ </td>
				<td> ↓ 식사 판매  ↓ </td>
				<td> ↓ 에약가능 여부 ↓ </td>
			</tr>
			<tr>
			<td>
			<c:set var="parking" value="${requestScope.map.stage.stageParking }"/>
			<c:choose>
				<c:when test="${parking eq 1}">
					완비
				</c:when>
				<c:otherwise>
					미비
				</c:otherwise>
			</c:choose>
			</td>
			<td>
			<c:set var="drinking" value="${requestScope.map.stage.stageDrinking }"/>
			<c:choose>
				<c:when test="${drinking eq 1}">
					O
				</c:when>
				<c:otherwise>
					X
				</c:otherwise>
			</c:choose>
			</td>
			<td>
			<c:set var="foodSell" value="${requestScope.map.stage.stageFoodSell }"/>
			<c:choose>
				<c:when test="${foodSell eq 1}">
					O
				</c:when>
				<c:otherwise>
					X
				</c:otherwise>
			</c:choose>
			</td>
			<td>
			<c:set var="foodRestriction" value="${requestScope.map.stage.stageFoodRestriction }"/>
			<c:choose>
				<c:when test="${foodRestriction eq 1}">
					O
				</c:when>
				<c:otherwise>
					X
				</c:otherwise>
			</c:choose>
			</td>
			<td>
			<c:set var="reservation" value="${requestScope.map.stage.stageReservation }"/>
			<c:choose>
				<c:when test="${reservation eq 1}">
					<button type="button" class="btn btn-success" id="reservationBtn">예약하기</button>
				</c:when>
				<c:when test="${requestScope.map.userId eq requestScope.map.rentalUserId }">
					예약 불가
					<button type="button" class="btn btn-default" id="cancelBtn">예약취소</button>
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-danger" onclick="alert('예약 불가능한 공연장 입니다.');">예약불가</button>
				</c:otherwise>
			</c:choose>
			</td>
			</tr>
	</table>
	</div>
	
	<div class="button_box" style="width: 100%;">
		
		<!-- Board Content End-->
		<div>
			<sec:authorize access="isAuthenticated()">
				<c:if test="${requestScope.map.stage.stageSellerId eq requestScope.map.userId }">
					<input type="submit" value="수정" onclick="updatePerformance();" class="btn btn-default">
					<input type="submit" value="삭제" onclick="deletePerformance();" class="btn btn-default">
				</c:if>
			</sec:authorize>
			<button type="button" onclick="history.back();" class="btn btn-default">목록</button>
		</div>
	</div>
</div>