<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

// id : 한글 / 특수문자 / 공백 체크
function idCheck(){
	var str = $("#id").val();
	
	var pattern1 = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	var pattern2 = /[~!@#$%^&*()_+|<>?:{}]/;
	var pattern3 = /\s/;
	
	if(pattern1.test(str)){
		alert("한글은 사용하실 수 없습니다.");
		$("#id").val("");
	}
	
	if(pattern2.test(str)){
		alert("특수문자는 사용하실 수 없습니다.");
		$("#id").val('');
	}
	if(pattern3.test(str)){
		alert("공백은 사용하실 수 없습니다.");
		$("#id").val('');
	}
}

function nameCheck(){
	var str = $("#name").val();
	
	var pattern1 = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	var pattern2 = /[a-z]/;
	if(!(pattern1.test(str)||pattern1.test(str))){
		alert("이름은 한글과 영문으로만 입력해주세요.");
		$("#name").val("");
	}
}

function phonenumCheck(){
	var str = $("#phoneNumber").val();
	
	var pattern = /[0-9]/;
	
	if(!pattern.test(str)){
		alert("번호는 숫자로만 입력해주세요.");
		$("#phoneNumber").val("");
	}
}

</script>
<h1>회원가입</h1>
<form action="${initParam.rootPath }/join_member.do" id="submitForm" method="post">
	<div>
		<label for="id">ID</label> 
		<input type="text" name="userId" id="id" onblur=idCheck(); required="required">
		<button id="duplicatedCheckBtn">id 중복체크</button>
	</div>
	<div>
		<label for="password">비밀번호</label> 
		<input type="password" name="password" required="required">
	</div>
	<div class="form-group">
		<label for="name">이름</label> 
		<input type="text" name="userName" id="name" onblur=nameCheck(); required="required">
	</div>
	<div class="form-group">
		<label for="address">주소</label> 
		<input type="text" name="userAddress" id="address" required="required">
	</div>

	<div>
		<label for="phoneNumber">핸드폰번호</label> 
		<input type="text" name="userPhoneNum" id="phoneNumber" onblur=phonenumCheck(); required="required">
	</div>
	<div>
		<label for="email">이메일주소</label> 
		<input type="text" name="email" id="email"  required="required">
	</div>
	<%-- csrf 토큰 --%>
	<sec:csrfInput />
	<button id="joinBtn">가입</button>
</form>