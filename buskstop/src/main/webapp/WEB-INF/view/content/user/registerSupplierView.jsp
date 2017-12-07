<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function addPicture(){
	var txt = '<input type="file" name="multiImage" id="multiImage">';
	$("#image").append(txt);
}

</script>

<body>
	<div>
		<form action="${initParam.rootPath }/member/registSupplier.do"
			method="post" enctype="multipart/form-data">
			<sec:csrfInput />
			
			<!-- ######################## 필수입력 칸 ######################## -->
			<span>사업장번호</span><br>
			<input type="text" name="establishNum" id="establishNo" required="required"><br>
			
			<span>사업자번호</span><br>
			<input type="text" name="operatorNo" id="operatorNo" required="required"><br>
			
			<span>장소이름</span><br>
			<input type="text" name="stageName" id="stageName" required="required"><br>
			
			<span>주소</span><br>
			<input type="text" name="stageLocation" id="stageLocation" required="required"><br>
			
			<span>면적(m^2)</span><br>
			<input type="number" name="stageArea" id="stageArea" required="required"><br>
			
			<span>가격 (시간 당)</span><br>
			<input type="number" name="stageCost" id="stageCost" required="required"><br>
			
			<!-- ################################################################### -->
			<p><hr><p>
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
			
			<div id="image">
				<span>사진등록</span>
				<input type="file" name="multiImage" id="multiImage">
			</div>
			<hr>
			<button class="btn btn-primary" type="button" onclick=addPicture(); >사진 추가 등록</button>
			<hr>
			<button class="btn btn-primary" type="submit">등록</button>
		</form>
	</div>
