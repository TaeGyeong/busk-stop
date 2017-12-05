<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style type="text/css">
	/* 	
		공연장 대관 등록 개발용 CSS
		+ 개발용이므로 통합 후 삭제
	*/
	body { font-family:'돋움'; }
	.demand{ padding: 0.01em 16px;
			 color: #000!important; 
			 background-color: #ddffff!important; 
			 border-left: 6px solid #ccc!important; 
			 border-color: #2196F3!important;
			 }
	.demand p { color: #000!important; 
				background-color: #ddffff!important;
				border-color: #2196F3!important; 
				font-size: 12px; font-weight: normal; 
				line-height: 1.5; 
				color: #000!important; 
				box-sizing: inherit;
				margin: 10px 0;
				}
</style>

<h2>공연장 대관 등록(stageRegisterView.do)</h2>
<div class="demand">
	<p><b>요구사항 :</b> 한 개의 공연장 대관정보 글을 등록한다.<br>
		 - 내용 : 공연장 이름, 주소(지도확인), 면적, 대관가능 날짜(시간), 시간당가격, 사진, 공급자 정보(이름, 연락처)를 필수로 입력받고<br> 주차장 유무, 음주가능여부, 식사판매여부, 외부음식 반입가능여부를 선택적으로 입력한다.<br>
		 - 프리미엄 공급자의 경우 글을 등록 할 시 자동으로 등록글에 프리미엄 표시를 붙여준다.<br>
		 + 등록 후에는 글 상세보기 페이지와 같은 페이지를 제공하여 자신의 글을 확인시켜준다.
		</p>
   </div>
   <hr>
   
<div style="width:960px; margin:auto;">
	<h1>대관 공연장 등록하기</h1>
	
	<form action="${initParam.rootPath }/stageRegister.do" method="post" enctype="multipart/form-data">
		<%-- 공연장 번호 hidden --%>
		<input type="hidden" name="stageNo" value="0">
		<%-- 등록자 id hidden --%>
		<sec:authorize access="isAuthenticated()">
			<input type="hidden" name="seller" value='<sec:authentication property="principal.userId"/>'>
		</sec:authorize>
		
		<div class="form-group">
			<label>공연장 이름</label>
			<input type="text" name="stageName" class="form-control" required="required">
		</div>
			
		<div class="form-group">
			<label>공연장 주소</label>
			<input type="text" name="stageLocation" class="form-control" required="required">
		</div>
			
		<div class="form-group">
			<label>가격</label>
			<input type="number" name="stageCost" class="form-control" required="required">
		</div>
			
		<div class="form-group">
			<label>면적</label>
			<input type="number" name="stageArea" class="form-control" required="required">
		</div>
			
		<div class="form-group">
			<label>구비된 악기</label>
			<input type="text" name="instrument" class="form-control">
		</div>
			
		<div class="form-group">
			<label>이미지</label>
			<input type="file" name="stageImage" class="form-control" multiple="multiple">
		</div>
			
		<div class="form-group">
			<label>추가 내용 입력</label>
			<textarea rows="15" cols="150" name="stageContent"></textarea>
		</div>
		
		<div class="form-group">
			<label>주차장 유무</label><br>
			<label style="font-weight: normal;"><input type="radio" name="stageParking" value="1">주차장 완비</label>
			<label style="font-weight: normal;"><input type="radio" name="stageParking" value="0">주차장 미비</label>
		</div>
			
		<div class="form-group">
			<label>음주가능 여부</label><br>
			<label style="font-weight: normal;"><input type="radio" name="stageDrinking" value="1">음주 가능</label>
			<label style="font-weight: normal;"><input type="radio" name="stageDrinking" value="0">음주 불가</label>
		</div>
			
		<div class="form-group">
			<label>음식 (유료)제공 여부</label><br>
			<label style="font-weight: normal;"><input type="radio" name="stageFoodSell" value="1">음식 제공</label>
			<label style="font-weight: normal;"><input type="radio" name="stageFoodSell" value="0">음식 미제공</label>
		</div>
			
		<div class="form-group">
			<label>외부음식 반입 가능 여부</label><br>
			<label style="font-weight: normal;"><input type="radio" name="stageFoodRestriction" value="1">반입 가능</label>
			<label style="font-weight: normal;"><input type="radio" name="stageFoodRestriction" value="0">반입 불가</label>
		</div>
			
		<div class="form-group">
			<label>예약가능 여부</label><br>
			<label style="font-weight: normal;"><input type="radio" name="stageReservation" value="1">예약 가능</label>
			<label style="font-weight: normal;"><input type="radio" name="stageReservation" value="0">예약 불가</label>
		</div>
		
		<sec:csrfInput/><%-- csrf 토큰 --%>
		<button type="submit" class="btn btn-default">등록</button>
	</form>
</div>