<%@page import="java.util.Date"%>
<%@page import="com.buskstop.vo.Video"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
<<<<<<< HEAD
$(document).ready(function{
	 // ** 댓글 쓰기 버튼 클릭 이벤트 (ajax로 처리)
=======

$(document).ready(function(){
	
>>>>>>> branch 'master' of https://github.com/um006500/busk-stop.git
	$("#enterVideoCommentBtn").on("click", function(){
<<<<<<< HEAD
=======
		var videoNo= "${requestScope.video.videoNo }";
		alert(videoNo);
	
>>>>>>> branch 'master' of https://github.com/um006500/busk-stop.git
		$.ajax({
			"url": "${initParam.rootPath}/member/enterVideoComment.do",
			"type":"POST",
<<<<<<< HEAD
			"data":{"videoNo":"${requestScope.video.videoNo}",
					"videoComment":$("#videoComent")
					},
=======
			"data":{"videoNo":"${requestScope.video.videoNo }",
					"videoComment":$("#videoComment").val(),
					"${_csrf.parameterName}":"${_csrf.token}"
			},
>>>>>>> branch 'master' of https://github.com/um006500/busk-stop.git
			"dataType":"json",
			"beforesend":function(){
				alert("${requestScope.video.videoNo }");
				if($("#videoComment").val()==null){
					alert("댓글을 입력해주세요.");
					document.getElementById("#videoComment").focus();
				}
			},
			
			"success":function(list){
				var txt = "";
				$.each(list, function(){
					txt+="<tr><td>"+this.videoCommentNo+"</td>";
					txt+="<td>"+this.videoCommentUserId+"</td>";
					txt+="<td>"+ this.videoComment +"</td>";
					txt+="<td>"+this.videoCommentRegTime+"</td></tr>";
				});
				$("#videoCommentList").html(txt);
			}
		});		
	});
    
    $("#provider").on("click",function(){
    	var VideoNo = "${requestScope.video.videoNo }";
    	$.ajax({
    		"url":"${initParam.rootPath }/readVideoComment.do",
    		"type":"POST",
    		"data":{
    			"videoNo":"${requestScope.video.videoNo }",
    			"${_csrf.parameterName}":"${_csrf.token}"
    		},
    		"dataType":"json",
    		"success":function(list){
    			var txt="";
    			$.each(list,function(){
					txt+="<tr><td>"+this.videoCommentNo+"</td>";
    				txt+="<td>"+this.videoCommentUserId+"</td>";
					txt+="<td>"+this.videoComment+"</td>";
					txt+="<td>"+this.videoCommentRegTime+"</td></tr>";
    			});
    			$("#videoCommentList").html(txt);
    			$("#providerBtn").text("댓글숨기기");
    		}
    	});
    });
    
    $("#providerBtn").on("click",function(){
    	alert($("#providerBtn").text());
		if($("#providerBtn").text()=='댓글보기'){
			$.ajax({
	    		"url":"${initParam.rootPath }/readVideoComment.do",
	    		"type":"POST",
	    		"data":{
	    			"videoNo":"${requestScope.video.videoNo }",
	    			"${_csrf.parameterName}":"${_csrf.token}"
	    		},
	    		"dataType":"json",
	    		"success":function(list){
	    			var txt="";
	    			$.each(list,function(){
						txt+="<tr><td>"+this.videoCommentNo+"</td>";
	    				txt+="<td>"+this.videoCommentUserId+"</td>";
						txt+="<td>"+this.videoComment+"</td>";
						txt+="<td>"+this.videoCommentRegTime+"</td></tr>";
	    			});
	    			$("#videoCommentList").html(txt);
	    			$("#providerBtn").text("댓글숨기기");
	    		}
	    	});
		} else {
			$("#videoCommentList").html('');
			$("#providerBtn").text("댓글보기");
		}
    }); 
});
</script>
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

#provider : hover{
	cursor:point;
	color:purple;
}

.hidden{
	display:none;
}

.bold{
	font-weight:bold;
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
			<!-- **로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
			
			<!-- 댓글을 펼치고 숨기기 위한 곳. -->
			<div id="provider">
				<button id="providerBtn">댓글보기</button>
			</div>
			
			<!-- 댓글목록이 보여질 div -->
			<div id="videoCommentList">
			</div>
			 
			<div style="float:right">
				<textarea id="videoComment" rows="15" cols="150" name="videoContent" placeholder="댓글을 입력하세요."></textarea>
				<button id="enterVideoCommentBtn" type="button">등록</button>
			</div>
			
		</div>
	</div>
	<!-- Comment End-->
	
	<!-- button -->
	<div style="float:right">
		<form action="${initParam.rootPath }/videoListCategory.do">
		<input type="hidden" name="category" value="${requestScope.video.videoCategory }">
		<button style="padding:10px">목록으로</button>
		</form>
		<!-- <button style="padding:10px">이전 글로</button>
		<button style="padding:10px">다음 글로</button> -->
	</div>
	<p><p><p>
</div>

	<!-- 수정 & 삭제 -->
	<!-- 수정 -->
	<form action="" method="post">
		<button>수정</button>
	</form>
	<!-- 삭제 -->
	<form action="" method="post">
		<button>삭제</button>
	</form>
	
</div>
