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
				if(list.length != 0){
					for(var i=0; i<24; i++){
						for(var j=0; j<list.length; j++){
							if(i != this.val()){
								alert("if문");
								$("#reservationTime").append('<label>'+i+'<input type="checkbox" id="timeCode" name="timeCode" value="'+this.val()+'"></label>');
							}
						}
					}
				}else{
					alert("list가 null");
					for(var i=0; i<24; i++){
						$("#reservationTime").append('<label>'+i+'<input type="checkbox" id="timeCode" name="timeCode" value="'+i+'"></label>');
					}
				}
			},
			"error":function(){
				alert("error");
			}
		});
	});
	
	$("#addOption").on("click", function(){
		var reservationDate = $("#reservationDate").val();
		var selectTimes = $("input[name='timeCode']:checked").each(function(i){
			selectTimes.push($(this).val());
		});
		var optionBasket = {"reservationDate":reservationDate, "timeCode":selectTime};
		
		$.ajax({
			"url":"${initParam.rootPath}/addPremiumStageOptionBasket.do",
			"type":"get",
			"data":{
				"optionBasket":optionBasket
			},
			"dataType":"json",
		    "async": "false",
		    "success":function(txt){
		    	/* $.each(list,function(){
		    		$("#reservationOption").append("날짜"+this.stageRentalDate);
		    	}); */
		    	$("#reservationOption").append("옵션 : 날짜"+txt);
		    },
		    "error":function(){
		    	alert("error");
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