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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2cf9bb3da4e98eebd3e7696702b01439&libraries=services"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	listComment();
	$("#btnComment").on("click",function(){
        
		$.ajax({                
            "url": "${initParam.rootPath }/performanceCommentInsert.do",
            "type": "get",
            "data" : {
            	"performanceNo":"${requestScope.performance.performanceNo}",
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
				"num":"${requestScope.performance.performanceNo}",
				'${_csrf.parameterName}':'${_csrf.token}'
			},
			"dataType":"text",
			"success":function(count){
				$(".likeBtn").html("<span class='glyphicon glyphicon-heart'></span>"+count);
			}
		});
	});
	
});	

function listComment(){
    $.ajax({
        //"dataType":"json",
        "url" : "/buskstop/performanceCommentList.do",
        "type": "get",
        "data" : {"performanceNo":"${requestScope.performance.performanceNo}"},
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

///////////////////////////////////////////////////////////////////////////////////////////
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('${requestScope.performance.performanceLocation }', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === daum.maps.services.Status.OK) {

        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new daum.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new daum.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
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

</style>
</head>
<body>
<div id="container">

<h1>DETAIL VIEW - 공연 정보 글 읽기</h1>
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
			<div style="float:right; margin-left:20px;">조회
			<div style="float:right; margin-left:20px;"></div><fmt:formatDate value="${requestScope.performance.performanceRegTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </div>
			<div style="float:right;">${requestScope.performance.performanceUserId}<strong>님</strong></div>
		</div>
	</div>

	<div style="border-bottom: 1px solid #e5e5e5; overflow : hidden; padding : 5px; background: #f9f9f9; ">
		<div style="float:left;">
			<div style="float:left; margin-right:5px;">공연장소</div> 
			<%-- <div style="float:left; margin-right:20px;">${requestScope.performance.performanceLocation }</div> --%>
			<p style="margin-top:-12px">
			    <em class="link">
			        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
			            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
			        </a>
			    </em>
			</p>
			<div id="map" style="width:100%;height:350px;"></div>
		</div>
		<div>
			<div style="float:left; margin-right:5px;">공연 시간</div>
			<div style="float:left;"><fmt:formatDate value="${requestScope.performance.performanceDate }" pattern="yyyy-MM-dd HH시mm분"/></div>
		</div>
	</div>

	<div>
		<p style="color:#515151; font-size: 16px; padding:20px;">
			<img src="${initParam.rootPath }/performanceImage/${requestScope.performance.performanceImage }" onerror="this.src='${initParam.rootPath }/performanceImage/no-image.png;'">
		</p>
		<p style="color:#515151; font-size: 16px; padding:20px;">
		${requestScope.performance.performanceContent}
		</p>
	</div>
	<div class="button_box" style="width: 100%;">
		<div style="float: left;">
			좋아요<a class="likeBtn" style="font-size: 18px; margin-left: 10px; text-decoration: none"><span class='glyphicon glyphicon-heart'></span>${requestScope.performance.likeCount }</a>
		</div>
	<!-- Board Content End-->
	<div>
	<sec:authorize access="isAuthenticated()">
		<input type="submit" value="수정" onclick="updatePerformance();">
		<input type="submit" value="삭제" onclick="deletePerformance();">
		</sec:authorize>
		<button type="button" onclick="location.href='${initParam.rootPath }/allSelectPerformance..do'">목록</button>

	</div>
	<p/><p/><p/>
	<div id="performanceCommentList" style="float: left; width: 100%;"></div>
	<div style="float: left; width: 100%;">
		<textarea name="content" id="performanceComment" 
		cols="20" rows="5" placeholder="댓글을 쓰세요" style="float: left;"></textarea>
		<button type="button" id="btnComment">댓글 등록</button>
	</div>
	
</div>
</body>
