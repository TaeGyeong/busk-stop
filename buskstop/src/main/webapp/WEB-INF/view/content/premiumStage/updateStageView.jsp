<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

function addPicture(){
	var txt = '<br><div class="form-group"><input class="form-control" type="file" name="multiImage" id="multiImage" required="required">';
	txt+='<button type="button" id="imageDelete" onclick=deleteImage(this);>삭제</button></div>';
	$("#image").append(txt);
}

function submitChk(){
	document.getElementById("registerForm").submit();	
}

function deleteImage(form){
	$(form).parent().remove();
}



</script>


<div>
	<form class="form-inline col-sm-offset-1" action="${initParam.rootPath }/producer/premiumStageUpdate.do" method="post" enctype="multipart/form-data" id="registerForm">
		<sec:csrfInput/>
		
		<input type="hidden" name="establishNum" value="${requestScope.map.premiumStage.establishNum }" required="required"><br>
		
		<div class="form-group">
			<label for="operatorNo">사업자번호</label><br>
			<input class="form-control" id="operatorNo" type="text" name="operatorNo" value="${requestScope.map.premiumStage.operatorNo }" required="required"><br>
		</div>
		
		<br>
		
		<div class="form-group">
			<label for="stageName">장소이름</label><br>
			<input class="form-control" id="stageName" type="text" name="stageName" value="${requestScope.map.premiumStage.stageName }" required="required"><br>
		</div>
		
		<br>
		
		<div class="form-group">
			<label for="stageLocation">주소</label><br>
			<input class="form-control" id="stageLocation" type="text" name="stageLocation" value="${requestScope.map.premiumStage.stageLocation }" required="required"><br>
		</div>
		
		<br>
		
		<div class="form-group">
			<label for="stageArea">면적(m^2)</label><br>
			<input class="form-control" type="number" id="stageArea" name="stageArea" value="${requestScope.map.premiumStage.stageArea }" required="required"><br>
		</div>
		
		<br>
		
		<div class="form-group">
			<label for="stageInstrument">구비된 악기</label>
			<input class="form-control" type="text" id="stageInstrument" name="stageInstrument" value="${requestScope.map.premiumStage.stageInstrument }">
		</div>
		
		<br>
		
		<div class="form-group">
			<label for="stageContent">글 내용</label>
			<textarea class="form-control" id="stageContent" name="stageContent">${requestScope.map.premiumStage.stageContent }</textarea>
		</div>
		
		<br>
		
		<input type="hidden" name="operatorUserId" value='<sec:authentication property="principal.userId"/>'>
		
		<p><hr><p>
		
		<!-- ################################################################### -->
		
		<table class="table">
			<tr>
				<th>주차가능여부</th>
				<th>음주가능여부</th>
				<th>음식판매여부</th>
				<th>외부음식 반입가능여부</th>
			</tr>
			<tr>
				<td>
					<span>O : </span><input type="radio" name="stageParking" id="stageParking" value="0">
					<span>X : </span><input type="radio" name="stageParking" id="stageParking" value="1">
				</td>
				<td>
					<span>O : </span><input type="radio" name="stageDrinking" id="stageDrinking" value="0">
					<span>X : </span><input type="radio" name="stageDrinking" id="stageDrinking" value="1">
				</td>
				<td>
					<span>O : </span><input type="radio" name="stageFoodSell" id="stageFoodSell" value="0">
					<span>X : </span><input type="radio" name="stageFoodSell" id="stageFoodSell" value="1">
				</td>
				<td>
					<span>O : </span><input type="radio" name="stageFoodRestriction" id="foodRestriction" value="0">
					<span>X : </span><input type="radio" name="stageFoodRestriction" id="foodRestriction" value="1">
				</td>
			</tr>
		</table>
		
		<!-- 사진 -->
		<hr>
		<button class="btn btn-primary" type="button" onclick=addPicture(); >사진 추가 등록</button>
		<hr>
		
		<div class="inline col-sm-offset-1" id="image">
			<c:forEach items="${requestScope.map.imageList }" var="image" varStatus="number">
				<div class="row">
					<img style="width:200px; height:200px;" src="${initParam.rootPath }/supplierImage/${image}" onerror='this.src="${initParam.rootPath }/supplierImage/no-image.png"'>
					<input type="hidden" name="oldImage" value="${image }">
					<br> 
					<button class="btn-danger" type="button" id="imageDelete" onclick=deleteImage(this);>삭제</button>
					<br>
				</div>
			</c:forEach>
		</div>
		
		<hr>
		
		<button class="btn btn-primary" type="button" onclick=submitChk(); >등록</button>
		
		<hr>
		
	</form>
	
	<br>
	
	<form action="${initParam.rootPath }/producer/deleteStage.do" method="post">
		<sec:csrfInput/>
		<input type="hidden" name="userId" value='<sec:authentication property="principal.userId"/>'>
		<input type="hidden" name="establishNum" value="${requestScope.map.premiumStage.establishNum }">
		<button class="btn btn-danger" type="submit" id="deleteBtn">삭제</button>
	</form>
		
</div>