<%@ page contentType="text/html;charset=utf-8"%>
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
				<tr>
					<td class="num">4951</td>
					<td class="sort">서비스</td>
					<td class="subject"><a href="http://help.ticketmonster.co.kr/notice?no=4943" data-serial="4943">[공지] 슈퍼마트 무료배송 기준 금액 변경 안내</a></td>
					<td class="date">2017.12.05</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="uio_base_srch">
	<form id="schform" name="schform" action="http://help.ticketmonster.co.kr/notice" method="get">
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
</div>
<button onclick="location.href='${initParam.rootPath}/helpRegisterView.do'">글쓰기</button>