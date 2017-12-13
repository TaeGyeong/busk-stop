<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script>
	function goDetail(root, no){
		document.location.href= root+'/helpDetailView.do?helpNum='+no;
	}
</script>

<h1>고객센터</h1>
<style type="text/css">

table {
	width: 100%;
	border-collapse: collapse;
}

th {
	padding: 5px;
	text-align: center;
}

td {
	padding: 5px;
	text-align: center;
}
td.subject{
	text-align: left;
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

#ct_cs{
	width:960px;
	margin: auto;
}
</style>
<div id="ct_cs">
	<div class="tb_box">
		<table border="1" class="tb_center">
			<colgroup>
				<col style="width:75px"><col style="width:88px"><col><col style="width:110px">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">분류</th>
					<th scope="col">제목</th>
					<th scope="col">등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.map.list }" var="item">
				<tr onclick="goDetail('${initParam.rootPath}', ${item.helpNum })">
					<td class="num">${item.helpNum }</td>
					<td class="sort">${item.helpCategory }</td>
					<td class="subject">${item.helpTitle }</td>
					<td class="date"><fmt:formatDate value="${item.helpRegTime }" pattern="yyyy-MM-dd"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<div class="uio_base_srch">
	<form id="schform" name="schform" >
		<fieldset>
		<legend>검색</legend>
		<select title="검색 구분" name="keyfield" style="width:70px">
			<option value="all">전체</option>
			<option value="b_title">제목</option>
			<option value="b_contents">내용</option>
		</select>
		<input type="text" id="keystr" name="key" title="검색어 입력" value="">
		<i class="btn_search"><button type="submit">검색</button></i>
		
		</fieldset>
	</form>
	<%-- 페이징 --%>
	<p/>
	<div style="text-align: center; width: 100%;">
		<ul class="pagination">
			<%-- 첫 페이지 --%>
			<li>
				<a href="${initParam.rootPath }/selectHelp.do?page=1">&lt;&lt;</a>
			</li>
			<%-- 이전 페이지 그룹 --%>
			<c:choose>
				<c:when test="${requestScope.map.pageBean.previousPageGroup }">
					<li>
						<a href="${initParam.rootPath }/selectHelp.do?page=${requestScope.map.pageBean.beginPage - 1}">◀</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="disabled">
						<a href="#">◀</a>
					</li>
				</c:otherwise>
			</c:choose>
			<%-- 현재 페이지가 속한 페이지 그룹내의 페이지들 링크 --%>
			<c:forEach begin="${requestScope.map.pageBean.beginPage }" end="${requestScope.map.pageBean.endPage }" var="num">
				<c:choose>
					<c:when test="${num == requestScope.map.pageBean.page }">
						<li class="active">
							<a href="#">${num }</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="${initParam.rootPath }/selectHelp.do?page=${num}">${num }</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<%-- 다음 페이지 그룹 --%>
			<c:choose>
				<c:when test="${requestScope.map.pageBean.nextPageGroup }">
					<li>
						<a href="${initParam.rootPath }/selectHelp.do?page=${requestScope.map.pageBean.endPage + 1}">▶</a>		
					</li>
				</c:when>
				<c:otherwise>
					<li class="disabled">
						<a href="#">▶</a>
					</li>
				</c:otherwise>
			</c:choose>
			<%-- 마지막 페이지 --%>
			<li>
				<a href="${initParam.rootPath }/selectHelp.do?page=${requestScope.map.pageBean.totalPage}">&gt;&gt;</a>
			</li>
		</ul>
	</div>
</div>
<button onclick="location.href='${initParam.rootPath}/helpRegisterView.do'">글쓰기</button>