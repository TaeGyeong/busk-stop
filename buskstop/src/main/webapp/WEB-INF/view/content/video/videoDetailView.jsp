<%@page import="java.util.Date"%>
<%@page import="com.buskstop.vo.Video"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script type="text/javascript" src="${initParam.rootPath }/scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function{
	 // ** 댓글 쓰기 버튼 클릭 이벤트 (ajax로 처리)
    $("#btnReply").click(function(){
        var replytext=$("#replytext").val();
        var bno="${dto.bno}"
        var param="replytext="+replytext+"&bno="+bno;
        $.ajax({                
            type: "post",
            url: "${path}/reply/insert.do",
            data: param,
            success: function(){
                alert("댓글이 등록되었습니다.");
                listReply2();
            }
        });
    });
	$("#enterVideoCommentBtn").on("click", function(){
		var videoNo="${requestScope.videoNo}"
		$.ajax({
			"url":"${initParam}/member/enterVideoComment.do",
			"type":"POST",
			"data":{"videoNo":"${requestScope.videoNo}".val(),
					"videoComment":$("#videoComent").val()
					},
			"dataType":"json",
			"success":function(list){
				var txt = "";
				$.each(list, function(){
					txt +="<li>"+this+"</li>";
				});
				$("videoCommentList").html(txt);
			},
			"error":function(){
				alert("오류 발생");
			}
		});		
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
			<div style="float:right">
				<textarea id="#videoContent" rows="15" cols="150" name="videoContent" placeholder="댓글을 입력하세요."></textarea>
				<button id="#enterVideoCommentBtn" type="button">등록</button>
				<%-- <c:forEach items="${requestScope.videoCommnetList }" var='list'>
					${list }
				</c:forEach> --%>
			</div>
		<div id="videoCommentList"></div> 
		</div>
	</div>
	<!-- Comment End-->
	
</div>
