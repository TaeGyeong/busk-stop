<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	
$(document).ready(function(){
	$("#selectTime").on("click",function(){
		$.ajax({
			"url":"${initParam.rootPath}/readPremiumStageReservationTimeByStageRentalDate.do",
			"type":"get",
			"data":{"stageRentalDate":$("#reservationDate").val()
			},
			"dataType":"json",
		    "async": "false",
			"success":function(list){
				alert("일단 성공으로");
				alert(list.length);
				$("#timeCodeList").remove();
				if(list.length != 0){
					for(var i=0; i<24; i++){
						for(var j=0; j<list.length; j++){
							if(i != this.val()){
								alert("list가 null아님");
								$("#reservationTime").append('<label>'+i+'<input type="checkbox" id="timeCode" name="timeCode" value="'+this.val()+'"></label>');
							}
						}
					}
				}else{
					alert("list가 null");
					$("#reservationTime").append('<div id="timeCodeList"></div>');
					var n = 1;
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
	
	$("#addOption").on("click",function(){
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
		    "beforesend":function(){
		    	alert("가기전");
		    	if(timeCode.length==0){
		    		alert("시간을 선택해주세요");
		    	}
		    },
		    "success":function(map){
		    	$("#timeCodeList").remove();
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
	});
	
});
	
</script>

<h2>공연장 대관일 등록</h2>
<div class="form-group">
	<label for="reservationDate">대관날짜</label> 
	<input type="date" name="reservationDate" id="reservationDate" 
		class="form-control" required="required">
</div>
<button id="selectTime">선택</button>
<div class="form-group">
	<label for="reservationTime">대관시간</label>
	<div id="reservationTime">
		
	</div> 
</div>
<button id="addOption">추가</button>
<div class="form-group">
	<label for="reservationOption">옵션</label> 
	<div id="reservationOption">
	</div>
</div>