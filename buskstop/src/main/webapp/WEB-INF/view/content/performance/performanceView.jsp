<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공연 정보 리스트</title>

<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script>
	function goDetail(root, no){
		document.location.href= root+'/performanceDetailView.do?performanceNo='+no
	}
	
	$(document).ready(function(){
		$(".likeBtn").on("click",function(){  
			$.ajax({
				"type":"POST",
				"url":"${initParam.rootPath}/performanceLike.do",
				"context" : this,
				"data":{
					"num":$(this).parent().parent().children("td:eq(0)").text(),
					'${_csrf.parameterName}':'${_csrf.token}'
				},
				"dataType":"text",
				"success":function(count){
					$(this).text("♥"+count);
				}
			});
		});
	});
</script>
<style type="text/css">

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

#product_tb{
	border: none;
}
#product_tb tr td{
	font-weight: bold;
	color: #888;
}
#product_tb tbody tr:nth-child(2n){
	background-color: #47a3d2;
}
#product_tb tbody tr:nth-child(2n) td{
	color: #fff;
}
#product_tb tbody tr:nth-child(2n) td a{
	color: #fff;
}
#product_tb tbody tr{
	line-height: 30px;
}
#product_tb thead{
	border-bottom: solid #ccc 1px;
}
#thead tr td{
	color : #000;
}
.likeBtn{
	color: red;
}
#product_tb tbody tr:nth-child(2n) .likeBtn{
	color: red;
}
.likeBtn:hover{
	color: #47a3d2;
	text-decoration: none;
}
#product_tb tbody tr:nth-child(2n) .likeBtn:hover{
	color: #fff;
}
#product_tb img{
	height : 100px;
}

#product_tb tbody tr td:nth-child(1) {
	border-right: 2px #ccc solid;
}

#product_tb tbody tr:hover{
	background-color: #ddd;
}

#product_tb tbody tr:nth-child(2n):hover{
	background-color: #337ab7;
}

</style>


</head>
<body>


	<div id="container">
		<h1>VIEW - 공연 정보 리스트</h1>
		<hr>
		<table id="product_tb" style="display: table;">
			<thead id="thead">
				<tr>
					<td>번호</td>
					<td>이미지</td>
					<td>제목</td>
					<td>공연장소</td>
					<td>공연날짜</td>
					<td>작성자</td>
					<td>작성 시간</td>
					<td>조회</td>
					<td>좋아요</td>
					<!-- <td>좋아요</td> -->
				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach items="${requestScope.map.list}" var="item">
					<tr style="cursor: pointer;">
						<td onclick="goDetail('${initParam.rootPath }', ${item.performanceNo})">${item.performanceNo}</td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.performanceNo})"><img src="${initParam.rootPath }/performanceImage/${item.performanceImage }" onerror="this.src='${initParam.rootPath }/performanceImage/no-image.png;'"></td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.performanceNo})">${item.performanceTitle}</td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.performanceNo})">${item.performanceLocation}</td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.performanceNo})"><fmt:formatDate value="${item.performanceDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.performanceNo})">${item.performanceUserId}</td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.performanceNo})"><fmt:formatDate value="${item.performanceRegTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td onclick="goDetail('${initParam.rootPath }', ${item.performanceNo})">${item.performanceHits}</td>
						<td><a class="likeBtn">♥${item.likeCount }</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<form action="${initParam.rootPath }/allSelectPerformance.do">
			<select name="category">
				<option value="title">제목</option>
				<option value="user">작성자</option>
				<option value="location">공연장소</option>
				<option value="name">공연이름</option>
				<option value="content">내용</option>
			</select> <input type="text" placeholder="검색" name="search">
			<button type="button" onclick="location.href='${initParam.rootPath}/performanceRegisterView.do'">글쓰기</button>
		</form>
		<%-- 페이징 처리 --%>
		<p/>
		<div style="text-align: center; width: 100%;">
			<ul class="pagination">
				<%-- 첫페이지로 이동 --%>
				<li>
					<a href="${initParam.rootPath }/allSelectPerformance.do?page=1&category=${requestScope.map.category}&search=${requestScope.map.search}">&lt;&lt;</a>
				</li>
				<%--
					이전 페이지 그룹 처리
					만약에 이전 페잊 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리
				 --%>
				<c:choose>
					<c:when test="${requestScope.map.pageBean.previousPageGroup }">
						<li>
							<a href="${initParam.rootPath }/allSelectPerformance.do?page=${requestScope.map.pageBean.beginPage - 1}&category=${requestScope.map.category}&search=${requestScope.map.search}">◀</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="disabled">
				 			<a href="#">◀</a>
				 		</li>
				 	</c:otherwise>
				</c:choose>
				<%--
				 	현재 page가 속한 page 그룹내의 페이지들 링크
				 	현재 pageGroup의 시작 page ~ 끝 page
				 	- 만약에 p가 현재페이지면 링크처리를 하지 않고 p가 현재 페이지가 아니라면 링크 처리.
				  --%>
				<c:forEach begin="${requestScope.map.pageBean.beginPage }"
					end="${requestScope.map.pageBean.endPage }" var="num">
					<c:choose>
						<c:when test="${num == requestScope.map.pageBean.page }">
							<li class="active">
				  				<a href="#">${num }</a>
				  			</li>
				  		</c:when>
						<c:otherwise>
							<li>
								<a href="${initParam.rootPath }/allSelectPerformance.do?page=${num}&category=${requestScope.map.category}&search=${requestScope.map.search}">${num }</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<%--
				  	다음페이지 그룹으로 이동
				  	만약에 다음페이지 그룹이 있으면 링크 처리 없으면 화살표만 나오도록 처리
				  --%>
				<c:choose>
					<c:when test="${requestScope.map.pageBean.nextPageGroup }">
						<li>
							<a href="${initParam.rootPath }/allSelectPerformance.do?page=${requestScope.map.pageBean.endPage + 1}&category=${requestScope.map.category}&search=${requestScope.map.search}">▶</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="disabled">
				  			<a href="#">▶</a>
				  		</li>
				  	</c:otherwise>
				</c:choose>
				<%-- 마지막 페이지로 이동 --%>
				<li>
					<a href="${initParam.rootPath }/allSelectPerformance.do?page=${requestScope.map.pageBean.totalPage}&category=${requestScope.map.category}&search=${requestScope.map.search}">&gt;&gt;</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>