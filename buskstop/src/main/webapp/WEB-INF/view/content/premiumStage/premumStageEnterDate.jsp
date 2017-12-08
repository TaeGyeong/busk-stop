<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	
$(document).ready(function(){
	$("").on("click",function(){
		$.ajax({
			"url":"${initParam.rootPath}/readPremiumStageReservationTimeByStageRentalDate.do",
			"type":"post",
			"data":{"stageRentalDate":$("#reservationDate").val()
			},
			"dataType":"json",
			"success":function(list){
				var txt="";
				$.each(function(){
					
				});
				<label>시간<input type="checkbox" id="timeCode" name="timeCode" value=""></label>
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
<div class="form-group">
	<label for="reservationTime">대관시간</label>
	<div id="reservationTime">
	
	</div> 
</div>