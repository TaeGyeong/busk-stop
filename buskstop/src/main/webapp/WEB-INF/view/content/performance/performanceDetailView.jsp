<%@page import="com.buskstop.vo.Performance"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, td{
		border: 1px solid black;
	}
	table{
		width:100%;
		border-collapse: collapse;
	}
	td{
		padding: 5px;
		text-align: center;
		
	}
	select{
		width:150px;height: 30px;
	}
	#container{
		width:960px;
		margin : 0 auto;
	}

</style>
</head>
<body>
<div id="container">
<% Performance performance = (Performance)request.getAttribute("performance"); %>

<h1>DETAIL VIEW - 공연 정보 글 읽기 Mock </h1>
	
<hr>

<h2>공연정보 게시판</h2>
<hr>

	<!-- Board Content -->
	<div style="border-top: 1px solid #e5e5e5; border-bottom: 1px solid #e5e5e5; overflow : hidden; position: relative">
		<div>
			<h3>${requestScope.performance.performanceNo}. ${requestScope.performance.performanceTitle}</h3>
		</div>
		<div style="float:right; position: absolute; bottom: 10px; right: 0;">
			<div style="float:right; margin-left:5px;">${requestScope.performance.performanceHits}</div>
			<div style="float:right; margin-left:20px;">조회</div>
			<div style="float:right; margin-left:20px;">${requestScope.performance.performanceRegTime} [글쓴 날짜 들어갈 곳 2017-11-01 22:00] </div>
			<div style="float:right;">${requestScope.performance.performanceUserId}<strong>님</strong></div>
		</div>
	</div>

	<div style="border-bottom: 1px solid #e5e5e5; overflow : hidden; padding : 5px; background: #f9f9f9; ">
		<div style="float:left;">
			<div style="float:left; margin-right:5px;">공연장소</div> 
			<div style="float:left; margin-right:20px;">${requestScope.performance.performanceLocation }</div>
		</div>
		<div>
			<div style="float:left; margin-right:5px;">공연 시간</div>
			<div style="float:left;">${requestScope.performance.performanceDate }</div>
		</div>
	</div>

	<div>
		<p style="color:#515151; font-size: 16px; padding:20px;">
			<img src="${initParam.rootPath }/performanceImage/${requestScope.performance.performanceImage }" alt="img">
		</p>
		<p style="color:#515151; font-size: 16px; padding:20px;">
		${requestScope.performance.performanceContent}
		</p>
	</div>
	<!-- Board Content End-->
	<!-- Comment -->
	<div>
		<div style="border: 1px solid #e5e5e5; height: 100px; padding: 10px">
		댓글은 이쯤에 구현하면 좋을듯?
		</div>
	</div>
	<!-- Comment End-->
	
	
</div>

</body>
</html>