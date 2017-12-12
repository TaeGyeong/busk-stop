<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
var optionNo = 0;
$(document).ready(function(){
	$("#selectTime").on("click",function(){
		alert($("#reservationDate").val());
		$.ajax({
			"url":"${initParam.rootPath}/producer/readPremiumStageReservationTimeByStageRentalDate.do",
			"type":"get",
			"data":{"reservationDate":$("#reservationDate").val()
			},
			"dataType":"json",
		    "async": "false",
		    "beforsend":function(){
		    	$("#timeCodeList").remove();
		    },
			"success":function(list){
				/* alert("일단 성공으로");
				alert(list.length); */
				$("#timeCodeList").remove();
				var n = 1;
				var reg = 0;
				var i=0;
				if(list.length != 0){
					$("#reservationTime").append('<div id="timeCodeList"></div>');
					for(i=0; i<24; i++){
						reg = 0;
						for(var j=0; j<list.length; j++){
							n = 1 + i;
							if(i == list[j]){
								reg = 1;
								j = list.length;
							}
						}
						if(reg == 0){
							$("#timeCodeList").append('<label>'+i+' ~ '+n+'시<input type="checkbox" id="timeCode" name="timeCode" value="'+i+'"></label><br>');
						}
					}
				}else{
					/* alert("list가 null"); */
					$("#reservationTime").append('<div id="timeCodeList"></div>');
					for(var i=0; i<24; i++){
						n = 1 + i;
						$("#timeCodeList").append('<label>'+i+' ~ '+n+'시<input type="checkbox" id="timeCode" name="timeCode" value="'+i+'"></label><br>');
					}
				}
			},
			"error":function(){
				alert("error");
			}
		});
	});
	
	/* $("#addOption").on("click",function(){
		var reservationDate = $("#reservationDate").val();
		var timeCode = new Array();
		$("input[name='timeCode']:checked").each(function(){
			timeCode.push($(this).val());
		});
		if(timeCode.length==0){
    		return;
    	}
		alert(timeCode.join(","));
		$.ajax({
			"url":"${initParam.rootPath}/addPremiumStageOptionBasket.do",
			"type":"get",
			"data":{
				"reservationDate":reservationDate,
				"timeCode":timeCode
			},
			"dataType":"json",
		    "async": "false",
		    "success":function(map){
		    	$("#timeCodeList").remove();
		    	optionNo += 1;
		    	var date = "날짜 : "+(map.reservationDate);
		    	date += "/ 시간 : "+(map.timeCode);
		    	date += "<input type='hidden' id='registerDate' name='registerDate' value="+map.reservationDate+"/>"
		    	date += "<input type='hidden' id='registerTime' name='registerTime' value="+map.timeCode+"/><hr>"
		    	$("#reservationOption").append(date);
		    },
		    "error":function(a,b,c){
		    	alert(c);
		    }
		});
	}); */
});
function addOption(){
	var reservationDate = $("#reservationDate").val();
	var timeCode = new Array();
	$("input[name='timeCode']:checked").each(function(){
		timeCode.push($(this).val());
	});
	var reservationCost = $("#reservationCost").val();
	if(timeCode.length==0){
		alert("시간을 선택해주세요");
		return;
	}else{
		$("#timeCodeList").remove();
		var date = "날짜 : "+(reservationDate);
    	date += "/ 시간 : "+(timeCode);
    	date += "/ 가격 : "+(reservationCost);
		date += "<input type='hidden' id='registerDate' name='registerDate' value="+reservationDate+">"
		date += "<input type='hidden' id='registerTime' name='registerTime' value="+timeCode+">"
		date += "<input type='hidden' id='registerCost' name='registerCost' value="+reservationCost+"><hr>"
		$("#reservationOption").append(date);
	}
}
var dateList = new Array();
var timeList = new Array();
var costList = new Array();
function enterOption(){
	$("input[name='registerDate']").each(function(){
		dateList.push($(this).val());
	});
	$("input[name='registerTime']").each(function(){
		timeList.push($(this).val());
	});
	$("input[name='registerCost']").each(function(){
		costList.push($(this).val());
	});
	alert(costList);
	if(dateList.length==0){
		alert("선택된 옵션이 없습니다");
		return;
	}else{
	    var y = document.createElement("INPUT");
	    y.setAttribute("type", "hidden");
	    y.setAttribute("name", "dateList");
	    y.setAttribute("value", dateList);
	    document.getElementById("registerOption").appendChild(y);
	    
	    var z = document.createElement("INPUT");
	    z.setAttribute("type", "hidden");
	    z.setAttribute("name", "timeList");
	    z.setAttribute("value", timeList);
	    document.getElementById("registerOption").appendChild(z);
	    
	    var x = document.createElement("INPUT");
	    x.setAttribute("type", "hidden");
	    x.setAttribute("name", "costList");
	    x.setAttribute("value", costList);
	    document.getElementById("registerOption").appendChild(x);
	}
	document.getElementById("registerOption").submit();
}


</script>

<h2>공연장 대관일 등록</h2>
<div class="form-group">
	<label for="reservationDate">대관날짜</label> 
	<input type="date" name="reservationDate" id="reservationDate" 
		class="form-control" required="required">
</div>
<button id="selectTime" class="btn btn-default">선택</button>
<div class="form-group">
	<label for="reservationTime">대관시간</label>
	<div id="reservationTime">
		<div></div>
	</div> 
</div>
<div class="form-group">
	<label for="reservationCost">가격 (시간 당)</label>
	<input type="number" name="reservationCost" id="reservationCost" required="required">
</div>
<button id="addOption" class="btn btn-default" onclick="addOption()">추가</button>
<div class="form-group">
	<label for="reservationOption">옵션</label> 
	<div id="reservationOption">
	</div>
</div>
<button id="enterOption" type="button" class="btn btn-default" onclick="enterOption()">등록</button>
<form action="${initParam.rootPath }/producer/enterPremiumStageOption.do" id="registerOption">
	<input type="hidden" id="establishNo" name="establishNo" value="${requestScope.map.establishNo }">
	
</form>
<div class="form-group">
	<label for="reservationOptionLsit">내 공연장 대관 옵션목록</label> 
	<table class="table">
		<thead>
			<tr>
				<th>대관날짜</th>
				<th>대관시간</th>
				<th>예약상태</th>
				<th>        </th>
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
					<td>${dateOption.stageState }</td>
					<td>
						<form action="${initParam.rootPath }/producer/deletePremiumStageOption.do">
							<input type="hidden" id="setablishNo" name="establishNo" value="${dateOption.establishNo }">
							<button type="submit" id="optionNo" name="optionNo" class="btn btn-default" value="${dateOption.optionNo }">삭제</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<form action="${initParam.rootPath }/producer/myStageDetail.do" method="post">
	<sec:csrfInput/>
	<input type="hidden" name="establishNum" value="${requestScope.map.establishNo }">
	<button class="btn btn-default" type="submit">공연장 상세보기로 이동</button>
</form>
