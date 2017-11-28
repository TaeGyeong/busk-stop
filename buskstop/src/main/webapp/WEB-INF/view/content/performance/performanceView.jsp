<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공연 정보 리스트</title>
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
</head>
<body>
	<div id="container">
		<h1>VIEW - 공연 정보 리스트</h1>
		<hr>
		주석<br> 작성자 : 장길웅<br> 작성일 : 2017-11-17<br> 나중에 해야 할 것들
		<ol>
			<li>게시판에 글쓴 날짜 추가 해야 하나요?</li>
			<li>좋아요 Join 실행해서 붙이기</li>
			<li>공연날짜 시간 포맷 맞추기</li>
		</ol>
		주석 끝<br>

		<hr>
		<table id="product_tb" style="display: table;">
			<thead id="thead">
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>공연장소</td>
					<td>공연날짜</td>
					<td>작성자</td>
					<!-- <td>작성일</td> -->
					<td>조회</td>
					<!-- <td>좋아요</td> -->
				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach items="${requestScope.list}" var="item">
					<tr>
						<td>${item.performanceNo}</td>
						<td>${item.performanceTitle}</td>
						<td>${item.performanceLocation}</td>
						<td>${item.performanceDate}</td>
						<td>${item.performanceUserId}</td>
						<td>${item.performanceHits}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<form action="${initParam.rootPath }/performanceSearch.do">
			<select name="category">
				<option value="title">제목</option>
				<option value="user">작성자</option>
				<option value="location">공연장소</option>
				<option value="name">공연이름</option>
				<option value="date">공연날짜</option>
				<option value="content">내용</option>
			</select>
			<input type="text" placeholder="검색" name="search">
		</form>
	</div>
</body>
</html>