<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

// password check
function passwordChk(){
	var pw = document.getElementById("firstInsert").value;
	var pwck = document.getElementById("secondInsert").value;
	
	if(pw!=pwck){
		document.getElementById("checkPassword").innerHTML = '비밀번호가 일치하지 않습니다.';
	}
	if(pw==pwck){
		document.getElementById("checkPassword").innerHTML = '일치!';
	}
}
// 이름 체크
function nameCheck(){
	var str = $("#name").val();
	
	var pattern = /[ㄱ-ㅎ|가-힣|a-zA-Z]/;
	
	if(!pattern.test(str)){
		alert("이름은 한글과 영문으로만 입력해주세요.");
		$("#name").val("");
	} 
}

// 핸드폰번호 체크
function phonenumCheck(){
	var str = $("#phoneNumber").val();
	
	var pattern = /[0-9]/;
	
	if(!pattern.test(str)){
		alert("번호는 숫자로만 입력해주세요.");
		$("#phoneNumber").val("");
	}
}

// mypage로 돌아가는 function
function backMyPage(){
	document.location.href="${initParam.rootPath }/member/passwordCheck.do";
}
</script>

<style>

#insert{
	text-align:center;
}

</style>
<div class="container">
	<div class="row">
		<h2 class="text-center">${requestScope.user.userId }님의 회원 정보 수정</h2>
	</div>
	<br><br>
	<!-- 전송 form -->
	<form class="center-block" action="${initParam.rootPath }/member/updateMember.do" method="post">
	
		<sec:csrfInput/>
		<input type="hidden" name="userId" value="${requestScope.user.userId }">
		
		<div class="form-group row" id="insert">
			<label class="col-sm-3" for="firstInsert">새로운 비밀번호 : </label> 
			<input class="col-sm-3 form-control" type="password" id="firstInsert" name="newpassword" required="required">
		</div>
		
		<div class="form-group row" id="insert">
			<label class="col-sm-3" for="secondInsert">비밀번호 재입력 : </label> 
			<input class="col-sm-3 form-control" type="password" id="secondInsert" name="checkPassword" required="required" onblur=passwordChk();>
		</div>
		
		
		<!-- Username -->
		<div class="form-group row" id="insert">
			<label class="col-sm-3" for="name">이름 : </label>
			<input class="col-sm-3 form-control" type="text" id="name" name="userName" required="required" onblur=nameCheck(); placeholder="${requestScope.user.userName }">
		</div>
		
		<!-- userAddress -->
		<div class="form-group row" id="insert">
			<label class="col-sm-3" for="address">주소 : </label>
			<input class="col-sm-3 form-control"type="text" id="address" name="userAddress" required="required" placeholder="${requestScope.user.userAddress }">
		</div>
		
		<!-- userPhoneNum -->
		<div class="form-group row" id="insert">
			<label class="col-sm-3" for="phoneNumber">전화번호 : </label>
			<input class="col-sm-3 form-control" type="text" id="phoneNumber" name="userPhoneNum" required="required" onblur=phonenumCheck(); placeholder="${requestScope.user.userPhoneNum }">
		</div>
		
		<div class="form-group row" id="insert">
			<label class="col-sm-3" for="email">이메일 : </label>
			<input class="col-sm-3 form-control" type="text" id="email" name="email" required="required" placeholder="${requestScope.user.email }">	
		</div>
		
		<button class="btn btn-warning" type="submit">수정</button>
		<button class="btn btn-danger" id="backBtn" onclick=backMyPage(); >취소</button>
		
	</form>
</div>