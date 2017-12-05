<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>

<script>

	$(document).ready(function(){
		
		$(".submit").click(function(){
			if($("#searchName").val()=="" && $("#searchLocation").val()=="" && $("#searchInstrument").val()==""){
				alert("검색할 키워드를 입력해주세요.");
			} else if ( $("#reservationStart").val()==""){
				alert("대관 날짜를 선택해주세요.")	
			} else if ( $("restervationEnd").val()==""){
				alert("날짜를 선택하세유.")	
			}
		})
		
		
	});
	
	$(function() {

		$(".calendar").datepicker({
			buttonImageOnly : true,
			numberOfMonths : 2,
			dateFormat : "yymmdd"
		});
	});
	
	function goDetail(root, no){
		document.location.href= root+'/stageDetailView.do?stageNo='+no
	}

</script>
<style type="text/css">

table {
	width: 100%;
	border-collapse: collapse;
}

td {
	padding: 5px;
	text-align: center;
}

select {
	width: 150px;
	height: 30px;
}

#container {
	width: 960px;
	margin: 0 auto;
}
</style>
</head>
<body>


</body>
	<hr>
	<form class="stageReservation" action="${initParam.rootPath}/stageReservation.do">
		<input type="text" name="searchName" id="searchName" placeholder="팀명으로 검색">
		<input type="date" name="stageReservation" class="calendar" id="stageReservation" >
		<input type="text" name="searchLocation" id="searchLocation" placeholder="장소로 검색">
		<input type="text" name="searchInstrument" id="searchInstrument" placeholder="악기로 검색">
		<br>
		<input type="checkbox" name="box" value="주차장">주차장 유무 
		<input type="checkbox" name="box" value="음주">음주 가능
		<input type="checkbox" name="box" value="식사">식사 가능
		<input type="checkbox" name="box" value="외부음식">외부음식 반입 가능
		
		<input type="button" name="search" class="submit" value="검색">
	</form>
	<hr>
	<h1>대관한 목록</h1>
	<hr>
	<table id="stageReservation">
		<thead id="thead">
		<tr>
			<td>번호 </td>
			<td>제목</td>
			<td>공연장소</td>
			<td>공연날짜</td>
			<td>공급자</td>
			<td>예약 가능</td>
		</tr>
		</thead>
		<tbody id="tbody">
		<c:forEach items="${requestScope.map.list}" var="item">
					<tr style="cursor: pointer;">
					<td>${item.stageNo }</td>
					<td>${item.stageName }</td>
					<td>${item.stageNLocation }</td>
					<td>${item.stageRegTime }</td>
					<td>${item.stageSellerId }</td>
					<td>${item.stageNo }</td>
					<!-- 
						<td onclick="goDetail('${initParam.rootPath }', ${item.stageNo})">${item.stageNo}</td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.stageNo})"><img src="${initParam.rootPath }/performanceImage/${item.stageImage }" onerror="this.src='${initParam.rootPath }/performanceImage/no-image.png;'"></td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.stageNo})">${item.Name} </td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.stageNo})">${item.stageLocation}</td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.stageNo})">${item.stageInstrument }</td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.stageNo})">${item.stageSellerId}</td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.stageNo})"></td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.stageNo})">${item.stageReservation}</td>
					-->
					</tr>
				</c:forEach>
			</tbody>
		</tbody>
	</table>
	
	<button type="button" onclick="location.href='${initParam.rootPath}/stageRegisterView.do'">등록하기</button>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


</html>