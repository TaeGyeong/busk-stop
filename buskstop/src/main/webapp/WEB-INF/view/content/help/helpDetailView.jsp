<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript" src="${initParam.rootPath}/resource/jquery/jquery-3.2.1.min.js"></script>
<script>

function updateHelp(){	
	var output = "";
	output+=location.href='${initParam.rootPath }/updateHelp2.do?helpNum=${param.helpNum}';
	
}

function deleteHelp(helpNum){
	
	var output = "";
	output+=location.href='${initParam.rootPath }/deleteHelp.do?helpNum=${param.helpNum}';
	
}

</script>
<style type="text/css">
	table, td{
		border: 1px solid black;
	}
	table{
		width:100%;
		border-collapse: collapse;
		border-spacing: 150px;
	}
	td{
		padding: 5px;
		text-align: center;
		width: 300px;
		background: white;
		
	}
	select{
		width:150px;height: 30px;
	}
	#container{
		width:960px;
		margin : 0 auto;
	}	
</style>
<div id="contatiner">
	<h1>고객센터 글 상세보기</h1>
	<hr>
	
	<h2>문의 게시판</h2>
	<div style="border-top: 1px solid #e5e5e5l border-bottom: 1px solid #e5e5e5; overflow:hidden; position:relative">
		<div style="width:50%; float: left;">
			<h3>${requestScope.map.help.helpNum }. ${requestScope.map.help.helpCategory } - ${requestScope.map.help.helpTitle }</h3>		
		</div>
		<div style="float:left; width: 50%; margin-top: 20px;">
			<div style="float:right; margin-left:20px;"><fmt:formatDate value="${requestScope.map.help.helpRegTime}" pattern="yyyy-MM-dd HH:mm:ss"/></div><br>
			<div style="float:right;">${requestScope.map.help.helpUserId}<strong>님</strong></div>
		</div>
	</div>
	
	
	<div>
		<p style="color:#515151; font-size:16px; padding:20px;">
			<!-- 이미지가 아무것도 입력 되어있지 않았다면 아무것도 출력 안함 -->
			<c:if test="${requestScope.map.help.helpImage == null && requestScope.map.help.helpImage2 == null}">
			
			</c:if>
			<!-- 이미지가 하나만 입력 되었다면 하나만 출력 -->
			<c:if test="${requestScope.map.help.helpImage != null && requestScope.map.help.helpImage2 == null}">
				<img src="${initParam.rootPath }/helpImage/${requestScope.map.help.helpImage}" onerror="this.src='${initParam.rootPath }/helpImage/no-image.png;'">
			</c:if>
			<c:if test="${requestScope.map.help.helpImage == null && requestScope.map.help.helpImage2 != null}">
				<img src="${initParam.rootPath }/helpImage/${requestScope.map.help.helpImage2}" onerror="this.src='${initParam.rootPath }/helpImage/no-image.png;'">
			</c:if>
			<!-- 이미지가 두개 입력 되었다면 두개 모두 출력 -->
			<c:if test="${requestScope.map.help.helpImage != null && requestScope.map.help.helpImage2 != null}">
				<img src="${initParam.rootPath }/helpImage/${requestScope.map.help.helpImage}" onerror="this.src='${initParam.rootPath }/helpImage/no-image.png;'">
				<img src="${initParam.rootPath }/helpImage/${requestScope.map.help.helpImage2}" onerror="this.src='${initParam.rootPath }/helpImage/no-image.png;'">
			</c:if>
		</p>
	</div>
	
	 
	<div>
		<hr style="float:bottom">
		<p style="color:#515151; font-size: 16px; padding:20px;">
		<label> 내용 : </label>
			${requestScope.map.help.helpContent}
		</p>
	</div>

	<div class="button_box" style="width: 100%;">
		<div>
				<input type="submit" value="수정" onclick="updateHelp();" class="btn btn-default">
					<input type="submit" value="삭제" onclick="deleteHelp();" class="btn btn-default">
				
			<button type="button" onclick="history.back();" class="btn btn-default">목록</button>
		</div>
	</div>

</div>