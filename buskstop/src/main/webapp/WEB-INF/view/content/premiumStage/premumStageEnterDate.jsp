<%@ page contentType="text/html;charset=utf-8"%>
<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	
$(document).ready(function(){
	$.ajax({
		"url":"${initParam.rootPath}/readPremiumStageReservationTimeCode.do",
		"type":"post",
		"data":{"stageRentalDate":$("#reservationDate").val(),
				"reservationNo":}
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