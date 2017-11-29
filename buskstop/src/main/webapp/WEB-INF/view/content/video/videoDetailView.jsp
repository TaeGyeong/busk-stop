<%@page import="com.buskstop.vo.Video"%>
<%@ page contentType="text/html;charset=utf-8"%>

<div id="container">
<hr>
<h2>동영상 상세보기</h2>
<hr>

	<!-- Board Content -->
	<div style="border-top: 1px solid #e5e5e5; border-bottom: 1px solid #e5e5e5; overflow : hidden; position: relative">
		<div>
			<h3>${requestScope.video.videoNo}. ${requestScope.video.videoTitle}</h3>
		</div>
		<div style="float:right; position: absolute; bottom: 10px; right: 0;">
			<div style="float:right; margin-left:5px;">${requestScope.조회수}</div>
			<div style="float:right; margin-left:20px;">조회</div>
			<div style="float:right; margin-left:20px;">${requestScope.video.videoRegTime}<!--  [글쓴 날짜 들어갈 곳 2017-11-01 22:00]  --></div>
			<div style="float:right;">${requestScope.video.videoUserId}<strong>님</strong></div>
		</div>
	</div>

	<div style="border-bottom: 1px solid #e5e5e5; overflow : hidden; padding : 5px; background: #f9f9f9; ">
		<div style="float:left;">
			<div style="float:left; margin-right:5px;">아티스트</div> 
			<div style="float:left; margin-right:20px;">${requestScope.video.videoㅁㄱ샨ㅅ}</div>
		</div>
		<div style="float:left;">
			<div style="float:left; margin-right:5px;">공연장소</div> 
			<div style="float:left; margin-right:20px;">${requestScope.video.videoLocation }</div>
		</div>
		<div>
			<div style="float:left; margin-right:5px;">공연 시간</div>
			<div style="float:left;">${requestScope.video.Date}</div>
		</div>
	</div>

	<div>
		<p style="color:#515151; font-size: 16px; padding:20px;">
		${requestScope.video.videoContent}
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
