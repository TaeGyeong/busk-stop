<%@page import="java.util.Date"%>
<%@page import="com.buskstop.vo.Video"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style type="text/css">
table, td {
	border: 1px solid black;
}

table {
	width: 100%;
	border-collapse: collapse;
}

td {
	padding: 5px;
	text-align: center;
}

select {
	width: 150px;
	height: 30px;
}

#container {
	width: 960px;
	margin: 0 auto;
}
</style>
<div id="container">
<hr>
<h2>동영상 상세보기</h2>
<hr>
<!-- youtube -->
	<div style="float:left; ">
			<div style="float:left; margin-right:5px;">${requestScope.video.videoNo}. ${requestScope.video.videoTitle}</div> 
			<div style="float:right; margin-right:15px; ">조회수 : ${requestScope.video.videoHits}</div>
			<div style="float:right; margin-right:15px; ">등록일자 : ${requestScope.video.videoRegTime}</div>
			<div style="float:right; margin-right:15px; ">게시자 : ${requestScope.video.videoUserId} 님</div>
			<div style="float:left; margin-right:20px;">${requestScope.video.videoLink }</div>
	</div>
<!-- youtube END -->
<table id="product_tb" style="display: table;">
	<thead id="thead">
	</thead>
	<tbody id="tbody">
		<tr>
			<td>아티스트</td> 
			<td>${requestScope.video.videoArtist}</td>
		</tr>
		<tr>
			<td>공연장소</td> 
			<td>${requestScope.video.videoLocation }</td>
		</tr>
		<tr>
			<td>영상 속 공연 시간</td>
			<td>${requestScope.video.videoDate }</td>
		</tr>
	</tbody>
</table>
		<div>
			<p style="border: 1px solid #e5e5e5; color:#515151; font-size: 16px; padding:20px;">
			${requestScope.video.videoContent}
			</p>
		</div>
	
	<!-- Comment -->
	<div>
		<div style="border: 1px solid #e5e5e5; height: 100px; padding: 10px">
		댓글은 이쯤에 구현하면 좋을듯?
		</div>
	</div>
	<!-- Comment End-->
	
</div>
