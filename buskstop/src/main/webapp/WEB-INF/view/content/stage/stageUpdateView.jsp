<%@ page contentType="text/html;charset=utf-8"%>

<form action="#" method="post" enctype="multipart/form-data">

	<div class="form-group">
		<label>공급자 아이디</label>
		<input type="text" name="stageSellerId" value="" class="form-control" readonly="readonly">
	</div>

	<div class="form-group">
		<label>공연장 번호</label>
		<input type="text" name="stageNo" class="form-control" value="" readonly>
	</div>
	
	
	
	<div class="form-group">
		<label>공연장 이름</label>
		<input type="text" name="stageName" class="form-control" value="">
	</div>
		
	<div class="form-group">
		<label>공연장 주소</label>
		<input type="text" name="stageLocation" class="form-control" value="">
	</div>
		
	<div class="form-group">
		<label>가격</label>
		<input type="number" name="stageCost" class="form-control" value="">
	</div>
		
	<div class="form-group">
		<label>면적</label>
		<input type="number" name="stageArea" class="form-control" value="">
	</div>
		
	<div class="form-group">
		<label>구비된 악기</label>
		<input type="text" name="stageInstrument" class="form-control" value="">
	</div>
		
	<div class="form-group">
		<label>이미지</label>
		<input type="file" name="multiImage" class="form-control">
	</div>
		
	<div class="form-group">
		<label>추가 내용 입력</label>
		<textarea rows="15" cols="150" name="stageContent"></textarea>
	</div>
	
	<div class="form-group">
		<label>주차장 유무</label><br>
		<label style="font-weight: normal;"><input type="radio" name="stageParking" value="yes">주차장 완비</label>
		<label style="font-weight: normal;"><input type="radio" name="stageParking" value="no">주차장 미비</label>
	</div>
		
	<div class="form-group">
		<label>음주가능 여부</label><br>
		<label style="font-weight: normal;"><input type="radio" name="stageDrinking" value="yes">음주 가능</label>
		<label style="font-weight: normal;"><input type="radio" name="stageDrinking" value="no">음주 불가</label>
	</div>
		
	<div class="form-group">
		<label>음식 (유료)제공 여부</label><br>
		<label style="font-weight: normal;"><input type="radio" name="stageFoodSell" value="yes">음식 제공</label>
		<label style="font-weight: normal;"><input type="radio" name="stageFoodSell" value="no">음식 미제공</label>
	</div>
		
	<div class="form-group">
		<label>외부음식 반입 가능 여부</label><br>
		<label style="font-weight: normal;"><input type="radio" name="stageFoodRestriction" value="yes">반입 가능</label>
		<label style="font-weight: normal;"><input type="radio" name="stageFoodRestriction" value="no">반입 불가</label>
	</div>
		
	<div class="form-group">
		<label>예약가능 여부</label><br>
		<label style="font-weight: normal;"><input type="radio" name="stageResurvation" value="yes">예약 가능</label>
		<label style="font-weight: normal;"><input type="radio" name="stageResurvation" value="no">예약 불가</label>
	</div>
	
</form>