<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="container">
	<h2>리스트 View</h2>
	<hr>
	
	<div class="row">
		<h3>검색바</h3><br>
		<div class="col-sm-2">
		</div>
		<div class="col-sm-2">
			<input type="date">
		</div>
		<div class="col-sm-2">
			<select name="category">
				<option>날짜</option>
				<option>지역</option>
				<option>체크박스</option>
				<option></option>
			</select>
		</div>
		<div class="col-sm-2">
			<input type="text" name="search" placeholder="검색어">		
		</div>
		<div class="col-sm-2">
			<input type="date">
		</div>
		<div class="col-sm-2">
		</div>
	</div>
	<br>
	<p>
	<div class="row">
		<div class="col-sm-3">
			주차 가능 여부 : <input type="checkbox" name="parking">
		</div>
		<div class="col-sm-3">
			음주 가능 여부 : <input type="checkbox" name="drinking">
		</div>
		<div class="col-sm-3">
			음식(주류) 판매 여부 : <input type="checkbox" name="foodSell">
		</div>
		<div class="col-sm-3">
			외부음식제한여부 : <input type="checkbox" name="foodRestriction">
		</div>
	</div>
	
	<hr>
	<div class="row">
		<c:forEach items="${requestScope.map.list }" var="item" varStatus="num">
			<div class="thumbnail col-sm-4">
				<img src="${initParam.rootPath }/supplierImage/${item.stageImage }" onerror='this.src="${initParam.rootPath }/supplierImage/no-image.png"'>
				<div class="caption">
					<p class="text-center">${item.stageName }</p>
					<p class="text-center">${item.stageLocation }</p>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<!-- 페이징 -->
	<div style="text-align: center; width: 100%;">
			<ul class="pagination">
				<%-- 첫페이지로 이동 --%>
				<li>
					<a href="${initParam.rootPath }/selectPremiumStage.do?page=1&category=${requestScope.map.category}&search=${requestScope.map.search}">&lt;&lt;</a>
				</li>
				<%--
					이전 페이지 그룹 처리
					만약에 이전 페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리
				 --%>
				<c:choose>
					<c:when test="${requestScope.map.pageBean.previousPageGroup }">
						<li>
							<a href="${initParam.rootPath }/selectPremiumStage.do?page=${requestScope.map.pageBean.beginPage - 1}&category=${requestScope.map.category}&search=${requestScope.map.search}">◀</a>
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
								<a href="${initParam.rootPath }/selectPremiumStage.do?page=${num}&category=${requestScope.map.category}&search=${requestScope.map.search}">${num }</a>
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
							<a href="${initParam.rootPath }/selectPremiumStage.do?page=${requestScope.map.pageBean.endPage + 1}&category=${requestScope.map.category}&search=${requestScope.map.search}">▶</a>
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
					<a href="${initParam.rootPath }/selectPremiumStage.do?page=${requestScope.map.pageBean.totalPage}&category=${requestScope.map.category}&search=${requestScope.map.search}">&gt;&gt;</a>
				</li>
			</ul>
		</div>
</div>




