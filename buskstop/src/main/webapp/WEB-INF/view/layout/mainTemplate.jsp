<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="${initParam.rootPath }/resource/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${initParam.rootPath }/resource/bootstrap/css/bootstrap-theme.min.css">
<script src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script
	src="${initParam.rootPath }/resource/bootstrap/js/bootstrap.min.js"></script>

<style type="text/css">
</style>
<title>Insert title here</title>
</head>
<body>
	<header>
		<div class="header-container">
			<div class="header-top"></div>
			<div class="container"></div>
			<div>
			<%-- 
				<a href="${initParam.rootPath }/login_form.do">로그인창</a> 
				<a href="${initParam.rootPath }/join_member_form.do">회원가입</a>
				<a href="${initParam.rootPath }/myPageView.do">마이페이지</a>
				 --%>
			</div>
		</div>
	</header>
	<nav>
		<div class="container">
			<ul>
				<li>공연정보</li>
				<li>공연장</li>
				<li>공연영상</li>
				<li>중고거래</li>
				<li>고객센터</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<%-- 메뉴 --%>
		<nav>
			<tiles:insertAttribute name="menu"/>
		</nav>
		<section class="content">
			<tiles:insertAttribute name="content" />
		</section>
	</div>
	<footer>
		<div class="footer-container"></div>
	</footer>
</body>
</html>