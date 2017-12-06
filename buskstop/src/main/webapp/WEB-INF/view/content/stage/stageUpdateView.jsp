<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
$(document).ready(function(){
	$(document).on("click", "#addImage", function(){
		$('<div><input type="file" name="imgs" class="form-control" id="inputImage"><div style="text-align: center;"><label>이미지 미리보기</label><br><img id="imgView" src="#" alt="img" style="height: 300px;"/></div><button type="button" id="addImage" class="btn btn-default">추가</button><button id="deleteImage" class="btn btn-default" type="button">삭제</button></div>').appendTo("#img_box");
	});
	$(document).on("click", "#deleteImage", function(){
		$(this).parent().remove();
	});
});

$(function(){
	$(document).on("change", "#inputImage", function(){
		readURL(this);
	});
});

function readURL(input){
	if(input.files && input.files[0]){
		var reader = new FileReader();
		
		reader.onload = function(e){
			$(input).next().children().last().attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}
</script>

<form action="${initParam.rootPath }/updateStageChange.do" method="post" enctype="multipart/form-data">

	<div class="form-group">
		<label>공급자 아이디</label>
		<input type="text" name="stageSellerId" value="${requestScope.stage.stageSellerId }" class="form-control" readonly="readonly">
	</div>

	<div class="form-group">
		<label>공연장 번호</label>
		<input type="text" name="stageNo" class="form-control" value="${param.stageNo }" readonly>
	</div>
	
	<div class="form-group">
		<label>공연장 이름</label>
		<input type="text" name="stageName" class="form-control" value="${requestScope.stage.stageName }">
	</div>
		
	<div class="form-group">
		<label>공연장 주소</label>
		<input type="text" name="stageLocation" class="form-control" value="${requestScope.stage.stageLocation }">
	</div>
		
	<div class="form-group">
		<label>가격</label>
		<input type="number" name="stageCost" class="form-control" value="${requestScope.stage.stageCost }">
	</div>
		
	<div class="form-group">
		<label>면적</label>
		<input type="number" name="stageArea" class="form-control" value="${requestScope.stage.stageArea }">
	</div>
		
	<div class="form-group">
		<label>구비된 악기</label>
		<input type="text" name="instrument" class="form-control" value="${requestScope.stage.instrument }">
	</div>

	<div class="form-group" id="img_box">
		<label>이미지</label>
		<button type="button" id="addImage" class="btn btn-default">추가</button><h6 style="color: red;">* 이미지는 다시 입력하여야 합니다.</h6>
			<input type="file" name="imgs" class="form-control" id="inputImage">
			<div style="text-align: center;">
				<label>이미지 미리보기</label><br>
				<img alt="img" src="#" id="imgView" style="height: 300px;">
			</div>
	</div>
	
	<div class="form-group">
		<label>추가 내용 입력</label>
		<textarea rows="15" cols="150" name="stageContent">${requestScope.stage.stageContent }</textarea>
	</div>

	<div class="form-group">
		<label>주차장 유무</label><br>
		
		<c:set var="parking" value="${requestScope.stage.stageParking }"/>
		<c:choose>
			<c:when test="${parking eq 1}">
				<label style="font-weight: normal;"><input type="radio" name="stageParking" value="1" checked="checked">주차장 완비</label>
				<label style="font-weight: normal;"><input type="radio" name="stageParking" value="0">주차장 미비</label>
			</c:when>
			<c:otherwise>
				<label style="font-weight: normal;"><input type="radio" name="stageParking" value="1">주차장 완비</label>
				<label style="font-weight: normal;"><input type="radio" name="stageParking" value="0" checked="checked">주차장 미비</label>
			</c:otherwise>
		</c:choose>
	</div>
		
	<div class="form-group">
		<label>음주가능 여부</label><br>
		
		<c:set var="drinking" value="${requestScope.stage.stageDrinking }"/>
		<c:choose>
			<c:when test="${drinking eq 1}">
				<label style="font-weight: normal;"><input type="radio" name="stageDrinking" value="1" checked="checked">음주 가능</label>
				<label style="font-weight: normal;"><input type="radio" name="stageDrinking" value="0">음주 불가</label>
			</c:when>
			<c:otherwise>
				<label style="font-weight: normal;"><input type="radio" name="stageDrinking" value="1">음주 가능</label>
				<label style="font-weight: normal;"><input type="radio" name="stageDrinking" value="0" checked="checked">음주 불가</label>
			</c:otherwise>
		</c:choose>	
	</div>
		
	<div class="form-group">
		<label>음식 (유료)제공 여부</label><br>
		
		<c:set var="foodSell" value="${requestScope.stage.stageFoodSell }"/>
		<c:choose>
			<c:when test="${foodSell eq 1}">
				<label style="font-weight: normal;"><input type="radio" name="stageFoodSell" value="1" checked="checked">음식 제공</label>
				<label style="font-weight: normal;"><input type="radio" name="stageFoodSell" value="0">음식 미제공</label>
			</c:when>
			<c:otherwise>
				<label style="font-weight: normal;"><input type="radio" name="stageFoodSell" value="1">음식 제공</label>
				<label style="font-weight: normal;"><input type="radio" name="stageFoodSell" value="0" checked="checked">음식 미제공</label>
			</c:otherwise>
		</c:choose>
	</div>
		
	<div class="form-group">
		<label>외부음식 반입 가능 여부</label><br>
		
		<c:set var="foodRestriction" value="${requestScope.stage.stageFoodRestriction }"/>
		<c:choose>
			<c:when test="${foodRestriction eq 1}">
				<label style="font-weight: normal;"><input type="radio" name="stageFoodRestriction" value="1" checked="checked">반입 가능</label>
				<label style="font-weight: normal;"><input type="radio" name="stageFoodRestriction" value="0">반입 불가</label>
			</c:when>
			<c:otherwise>
				<label style="font-weight: normal;"><input type="radio" name="stageFoodRestriction" value="1">반입 가능</label>
				<label style="font-weight: normal;"><input type="radio" name="stageFoodRestriction" value="0" checked="checked">반입 불가</label>
			</c:otherwise>
		</c:choose>
	</div>
		
	<div class="form-group">
		<label>예약가능 여부</label><br>
		
		<c:set var="reservation" value="${requestScope.stage.stageReservation }"/>
		<c:choose>
			<c:when test="${reservation eq 1}">
				<label style="font-weight: normal;"><input type="radio" name="stageResurvation" value="1" checked="checked">예약 가능</label>
				<label style="font-weight: normal;"><input type="radio" name="stageResurvation" value="0">예약 불가</label>
			</c:when>
			<c:otherwise>
				<label style="font-weight: normal;"><input type="radio" name="stageResurvation" value="1">예약 가능</label>
				<label style="font-weight: normal;"><input type="radio" name="stageResurvation" value="0" checked="checked">예약 불가</label>
			</c:otherwise>
		</c:choose>	
	</div>
	
	<button type="submit" class="btn btn-default">수정완료</button>
	<button type="button" class="btn btn-default" onclick="history.back();">취소</button>
	
	<sec:csrfInput /><%-- csrf 토큰 --%>
</form>

