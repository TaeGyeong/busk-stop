<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="${initParam.rootPath}/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
window.onload = function followSearch(){
	$.ajax({
		"type":"post",
		"url":"${initParam.rootPath }/searchFollow.do",
		"data":{
			'${_csrf.parameterName}':'${_csrf.token}',
			'userId':'${requestScope.map.userId }',
			'artistId':'${requestScope.map.artist.artistId }'
		},
		"dataType":"text",
		"success":function(txt){
			if(txt=='follow'){
				$("#follow").html('');
				// follow 했으면 follow 버튼
				txt='<button type="button" id="followBtn" class="btn btn-default">팔로우취소</button>';
				$("#follow").html(txt);
			} else if (txt=='notFollow'){
				
				// follow 하지 않으면 unfollow 버튼
				txt='<button type="button" id="followBtn" class="btn btn-primary">팔로우</button>';					
				$("#follow").html(txt);
			}
		},
		'error':function(a,b,c){
			alert(a);
			alert(b);
			alert(c);
		}
	});
}

$(document).ready(function(){
	$("#follow").on("click","#followBtn", function(){
		if($("#followBtn").text()=='팔로우취소'){
			$.ajax({
				"type":"post",
				"url":"${initParam.rootPath }/member/unfollow.do",
				"data":{
					'${_csrf.parameterName}':'${_csrf.token}',
					'userId':'${requestScope.map.userId }',
					'artistId':'${requestScope.map.artist.artistId }'
				},
				"dataType":"text",
				"success":function(txt){
					alert(txt);
					txt='<button id="followBtn" class="btn btn-primary">팔로우</button>';
					$("#follow").html(txt);
				},
				"error":function(a,b,c){
					alert(a);
					alert(b);
					alert(c);
				}
				
			});
		} else {
			$.ajax({
				"type":"post",
				"url":"${initParam.rootPath }/member/follow.do",
				"data":{
					'${_csrf.parameterName}':'${_csrf.token}',
					'userId':'${requestScope.map.userId }',
					'artistId':'${requestScope.map.artist.artistId }'
				},
				"dataType":"text",
				"success":function(txt){
					alert(txt);
					txt='<button id="followBtn" class="btn btn-default">팔로우취소</button>';
					$("#follow").html(txt);
				},
				"error":function(a,b,c){
					alert(a);
					alert(b);
					alert(c);
				}
			});
		}
	});
	
});

function goDetail(root, no){
	document.location.href= root+'/artistPerformanceDetailView.do?performanceNo='+no
}

function goVideoDetail(root, no){
	document.location.href= root+'/readVideoByVideoNo.do?videoNo='+no
}

</script>
<style>
img{
	height:50%;
	width:50%;
}
</style>
<!-- 아티스트 정보 (프로필) -->
<div class="container-inline" style="top-margin:100%; height:100%;">
	<h2>${requestScope.map.artist.artistName } 프로필</h2>
	<div class="row">
		<div class="col-sm-5" style="vertical-align:middel;">
			<!-- 아티스트 프로필 사진 -->
			<img onerror='this.src="${initParam.rootPath }/artistImage/no-image.png"' src="${initParam.rootPath }/artistImage/${requestScope.map.artist.artistImage }">
		</div>
		<div class="col-sm-5" style="vertical-align:middle;">
			<!-- 아티스트 정보 뿌리기 -->
			<span>${requestScope.map.artist.artistName }</span><br>
			<span>${requestScope.map.artist.performance }</span><br>
			<span>${requestScope.map.artist.profile }</span><br>
			<span>${requestScope.map.artist.artistMembers }</span><br>
			<span>${requestScope.map.artist.artistSns }</span>
		</div>
		<c:if test="${requestScope.map.artist.artistId ne requestScope.map.userId }">
			<div class="col-sm-2" id="follow">
				<!-- Follow Button -->
				<button id="followBtn" class="btn btn-primary">팔로우</button>
			</div>
		</c:if>
	</div>
</div>

<p>
<hr>
<p>

<!-- 아티스트 공연정보 조회 -->
<div class="container" style="top-margin:300px;">
	<h2>공연정보</h2>
	<table style="border:solid black 1px">
	<tr>
		<th> </th>
		<th>공연제목</th>
		<th>장소</th>
		<th>공연날짜</th>
		<th>공연내용</th>
	</tr>
	<c:forEach items="${requestScope.map.performanceList }" var="performance">
			<tr class="row">
				<td class="col-sm-4" onclick="goDetail('${initParam.rootPath }',${performance.performanceNo })">
					<img src="${initParam.rootPath }/performanceImage/${performance.performanceImage }" onerror='this.src="${initParam.rootPath }/performanceImage/no-image.png"' style="width:100px; height:100px;">
				</td>
				<td class="col-sm-2" onclick="goDetail('${initParam.rootPath }',${performance.performanceNo })">${performance.performanceTitle }</td>
				<td class="col-sm-2" onclick="goDetail('${initParam.rootPath }',${performance.performanceNo })">${performance.performanceLocation }</td>
				<td class="col-sm-2" onclick="goDetail('${initParam.rootPath }',${performance.performanceNo })"><fmt:formatDate value="${performance.performanceDate }" pattern="yyyy-MM-dd HH시mm분"/></td>
				<td class="col-sm-2" onclick="goDetail('${initParam.rootPath }',${performance.performanceNo })">${performance.performanceContent }</td>
			</tr>
		</c:forEach>
	</table>
</div>

<!-- 아티스트 공연홍보영상 -->
<div class="container">
	<h2>공연홍보영상</h2>
	<table style="border:solid black 1px;">
		<tr class="row">
			<th class="col-sm-4">사진</th>
			<th class="col-sm-2">제목</th>
			<th class="col-sm-2">장소</th>
			<th class="col-sm-2">영상촬영일</th>
			<th class="col-sm-2">등록시간</th>
		</tr>
		<c:forEach items="${requestScope.map.videoList }" var="video">
			<tr onclick="goVideoDetail('${initParam.rootPath}',${video.videoNo })" class="row">
				<td class="col-sm-4">
					<img src="https://img.youtube.com/vi/${video.videoLink }/hqdefault.jpg" onerror='this.src="${initParam.rootPath }/performanceImage/no-image.png"' style="width:100px; height:100px;">
				</td>	
				<td class="col-sm-2">
					${video.videoTitle }
				</td>
				<td class="col-sm-2">
					${video.videoLocation }
				</td>
				<td class="col-sm-2">
					<fmt:formatDate value="${video.videoDate }" pattern="yyyy-MM-dd HH시 mm분"/> 
				</td>
				<td class="col-sm-2"><fmt:formatDate value="${video.videoRegTime }" pattern="yyyy-MM-dd HH시 mm분"/></td>
			</tr>
		</c:forEach>
	</table>
</div>


</body>
</html>