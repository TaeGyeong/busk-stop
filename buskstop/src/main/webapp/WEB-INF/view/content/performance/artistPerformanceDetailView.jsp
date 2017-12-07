<%@page import="com.buskstop.vo.Performance"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	
	listComment();
	$("#btnComment").on("click",function(){
        
		$.ajax({                
            "url": "${initParam.rootPath }/performanceCommentInsert.do",
            "type": "get",
            "data" : {
            	"performanceNo":"${requestScope.map.performance.performanceNo}",
            	"performanceComment":$("#performanceComment").val(),
            	'${_csrf.parameterName}':'${_csrf.token}'
            },
            "dataType":"text",
            success: function(){
                alert("댓글이 등록되었습니다.");
                listComment();
                document.getElementById("performanceComment").value="";
            },
           	"error":function(){
           		alert("오류 발생");
           		
           	}
        });
     });
	
	
	
	$(".likeBtn").on("click", function(){
		$.ajax({
			"type":"POST",
			"url":"${initParam.rootPath}/performanceLike.do",
			"data":{
				"num":"${requestScope.map.performance.performanceNo}",
				'${_csrf.parameterName}':'${_csrf.token}'
			},
			"dataType":"text",
			"success":function(count){
				$(".likeBtn").html("<span class='glyphicon glyphicon-heart'></span>"+count);
			}
		});
	});
	
	//####################################################
	// 	팔로우 정보 조회, 팔로우, 팔로우 취소
	//####################################################
	
	
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
	
	$("#artistImage").on("click",function(){
		var form = document.createElement("form");
		form.setAttribute("charset","UTF-8");
		form.setAttribute("method","post");
		form.setAttribute("action","${initParam.rootPath }/artistInfo.do");
		
		var token = document.createElement("input");
		token.setAttribute("type","hidden");
		token.setAttribute("name","${_csrf.parameterName}");
		token.setAttribute("value","${_csrf.token}");
		
		var field = document.createElement("input");
		field.setAttribute("type","hidden");
		field.setAttribute("name","artistId");
		field.setAttribute("value","${requestScope.map.artist.artistId }");
		
		
		form.appendChild(field);
		form.appendChild(token);
		document.body.appendChild(form);
		
		form.submit();
	});
});	

function listComment(){
    $.ajax({
        //"dataType":"json",
        "url" : "/buskstop/performanceCommentList.do",
        "type": "get",
        "data" : {"performanceNo":"${requestScope.map.performance.performanceNo}"},
        "dataType" : "json",
        "success" : function(result){
            var output = "";
            $.each(result, function(){ 
            	output += '<div class="performanceComment" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
                output += '<div class="listComment'+this.performanceCommentNo+'">'+'작성자 : '+this.performanceCommentUserId+' / 등록 일자 : '+this.performanceCommentRegTime;
                output += '<a onclick="updateCommentText('+this.performanceCommentNo+',\''+this.performanceComment+'\');"> 수정 </a>';
                output += '<a onclick="deleteComment('+this.performanceCommentNo+');"> 삭제 </a> </div>';
                output += '<div class="pComment'+this.performanceCommentNo+'"> <p> 내용 : '+this.performanceComment +'</p>';
                output += '</div></div>';
            });
            $("#performanceCommentList").html(output);
        },
        "error":function(){
       		//alert("오류 발생");
       	}
    });
}
   
function deleteComment(performanceCommentNo){
    
	$.ajax({                
        "url": "${initParam.rootPath }/performanceCommentDelete.do",
        "type": "post",
        "data" : {
        	"performanceCommentNo":performanceCommentNo,
        	'${_csrf.parameterName}':'${_csrf.token}'
        },
        "dataType":"text",
        "success": function(){
            alert("댓글이 삭제되었습니다.");
            listComment();
        },
        "error":function(){
        	alert("에러 뜸 ㅠㅠ");
        }
    });
 }
 
 
function updateCommentText(performanceCommentNo,performanceComment){
	
    var output ="";
    	output += '<div class="input-group">';
    	output += '<input type="text" class="form-control" name="pComment'+performanceCommentNo+'" value="'+performanceComment+'"/>';
    	output += '<span class="input-group-btn">'
    	output += '<button class="btn btn-default" type="button" onclick="updateComment('+performanceCommentNo+');">수정</button>';
    	output += '<button class="btn btn-default" type="button" onclick="listComment();">수정 취소</button>';
    	output += ' </span></div>';
       
       $(".pComment"+performanceCommentNo).html(output);
}

function updateComment(performanceCommentNo){
		var UpdatePerformanceComment = $("[name=pComment"+performanceCommentNo+"]").val();
	$.ajax({
		"url": "${initParam.rootPath }/performanceCommentUpdate.do",
	    "type": "get",
	    "data" : {
	    	"performanceCommentNo":performanceCommentNo,
	    	"UpdatePerformanceComment":UpdatePerformanceComment,
	    	'${_csrf.parameterName}':'${_csrf.token}'
	    },
	    "dataType":"text",
	    "success" : function(){
	    	alert("댓글이 수정되었습니다.");
	    	listComment();
	    },
	    "error":function(){
	    	alert("댓글을 입력해주세요.");
	    }
		
	});
	
}
   
   
function updatePerformance(){	
	var output = "";
	output+=location.href='${initParam.rootPath }/performanceUpdate3.do?performanceNo=${param.performanceNo}';
	
}

function deletePerformance(performanceNo){
	
	var output = "";
	output+=location.href='${initParam.rootPath }/deletePerformance.do?performanceNo=${param.performanceNo}';
	
}


</script>

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
	.likeBtn{
		cursor: pointer;
	}
	
	#artistImage{
		cursor : pointer;
	}

</style>
</head>
<body>
<div id="container" style="top-margin:10px">

<h1>DETAIL VIEW - 아티스트 공연 정보 글 읽기</h1>
<hr>

<h2>공연정보 게시판</h2>
<hr>

	<!-- 아티스트 정보 -->
	<div class="container-inline">
		<h3>아티스트 정보</h3>
		<div>
			<img src="${initParam.rootPath }/artistImage/${requestScope.map.artist.artistImage }" id="artistImage" style="width:100px; height:100px;" onerror="this.src='/buskstop/performanceImage/no-image.png;'">
			<div class="text-center">
				<span>${requestScope.map.artist.artistName }</span>
				<span>${requestScope.map.artist.performance }</span>
				<span>${requestScope.map.artistSns }</span>
			</div>
			<div class="text-right" id="follow" style="overflow:hidden">
				<button type="button" id="followBtn"></button>
			</div>
		</div>
	</div>

	<!-- Board Content -->
	<div style="border-top: 1px solid #e5e5e5; border-bottom: 1px solid #e5e5e5; overflow : hidden; position: relative">
		<div>
			<h3>${requestScope.map.performance.performanceNo}. ${requestScope.map.performance.performanceTitle}</h3>
		</div>
		<div style="float:right; position: absolute; bottom: 10px; right: 0;">
			<div style="float:right; margin-left:5px;">${requestScope.map.performance.performanceHits}</div>
			<div style="float:right; margin-left:20px;">조회
			<div style="float:right; margin-left:20px;"></div><fmt:formatDate value="${requestScope.map.performance.performanceRegTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </div>
			<div style="float:right;">${requestScope.map.performance.performanceUserId}<strong>님</strong></div>
		</div>
	</div>

	<div style="border-bottom: 1px solid #e5e5e5; overflow : hidden; padding : 5px; background: #f9f9f9; ">
		<div style="float:left;">
			<div style="float:left; margin-right:5px;">공연장소</div> 
			<div style="float:left; margin-right:20px;">${requestScope.map.performance.performanceLocation }</div>
		</div>
		<div>
			<div style="float:left; margin-right:5px;">공연 시간</div>
			<div style="float:left;"><fmt:formatDate value="${requestScope.map.performance.performanceDate }" pattern="yyyy-MM-dd HH시mm분"/></div>
		</div>
	</div>

	<div>
		<p style="color:#515151; font-size: 16px; padding:20px;">
			<img src="${initParam.rootPath }/performanceImage/${requestScope.map.performance.performanceImage }" onerror="this.src='${initParam.rootPath }/performanceImage/no-image.png;'">
		</p>
		<p style="color:#515151; font-size: 16px; padding:20px;">
		${requestScope.map.performance.performanceContent}
		</p>
	</div>
	<div class="button_box" style="width: 100%;">
		<div style="float: left;">
			좋아요<a class="likeBtn" style="font-size: 18px; margin-left: 10px; text-decoration: none"><span class='glyphicon glyphicon-heart'></span>${requestScope.map.performance.likeCount }</a>
		</div>
	<!-- Board Content End-->
	<div>
	<sec:authorize access="isAuthenticated()">
		<c:if test="${requestScope.map.userId eq requestScope.map.performance.performanceUserId }">
			<input type="submit" value="수정" onclick="updatePerformance();">
			<input type="submit" value="삭제" onclick="deletePerformance();">
		</c:if>
	</sec:authorize>
		<button type="button" onclick="location.href='${initParam.rootPath }/selectPerformance.do'">목록</button>

	</div>
	<p/><p/><p/>
	<div id="performanceCommentList" style="float: left; width: 100%;"></div>
	<div style="float: left; width: 100%;">
		<textarea name="content" id="performanceComment" 
		cols="20" rows="5" placeholder="댓글을 쓰세요" style="float: left;"></textarea>
		<button type="button" id="btnComment">댓글 등록</button>
	</div>
	
	</div>
</div>
</body>