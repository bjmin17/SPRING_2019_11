<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
<style>
	header {
		background-color: regba(0,255,0,0.3);
		color:black;
		text-align: center;
		padding:0.9rem;
	}
	nav{
		background-color:green;
	}
	nav input{
		width:300px;
		padding:8px;
		margin:10px;
		border : 1px solid orange;
		border-radius: 20px;
		position: relative;
		
	}
	nav input:hover::after{
		content : '동물병원 이름이나 주소를 입력하고 Enter를 누르세요';
		position : absolute;
		color:black;
		top:20px;
		left:30px;
		z-index:3;
	}
	table {
		border-collapse: collapse;
		border-spacing: 0;
	}
</style>
</head>
<body>
<header>
	<h3>my pet life</h3>
</header>
<nav>
	<form>
		<input type="text" name="s_text" placeholder="검색어를 입력한 후 Enter...">
	</form>
</nav>
<section>
	<table border="1">
		<tr>
			<th>동물병원의 이름</th>
			<th>도로명주소</th>
			<th>지번주소</th>
			<th>대행업소의 연락처</th>
			<th>위도</th>
			<th>경도</th>
			<th>데이터기준일</th>
		</tr>
		<tr>
		<c:choose>
			<c:when test="${empty H_LIST}">
				<tr><td colspan="7">데이터가 없음</td>
			</c:when>
			<c:otherwise>
				<c:forEach items="${H_LIST}" var="hs" varStatus="index"> 
					<tr>
						<td>${hs.apiDongName}</td>
						<td>${hs.apiNewAddress}</td>
						<td>${hs.apiOldAddress}</td>
						<td>${hs.apiTel}</td>
						<td>${hs.apiLat}</td>
						<td>${hs.apiLng}</td>
						<td>${hs.apiRegDate}</td>
					</tr>	
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tr>
	</table>
</section>
</body>
</html>