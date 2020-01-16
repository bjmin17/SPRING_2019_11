<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>

<style>
	article {
		display: flex;
		flex-flow: wrap;
	}
	
	
	.book-title, .book-body {
		display: inline-block;
		width: 24.3%;
		padding:5px 16px;
		margin:5px;
		background-color: #eee;
	}
	
	div.book-title {
		background-color: #ccc;
		text-align:right;
	}
	
</style>
</head>
<body>
	<section>
	<article>
		<div class="book-title">도서코드</div>
		<div class="book-body">${BOOK.b_code}</div>
	
		<div class="book-title">도서명</div>
		<div class="book-body">${BOOK.b_name}</div>
	
		<div class="book-title">출판사</div>
		<div class="book-body">${BOOK.b_comp}</div>

		<div class="book-title">저자</div>
		<div class="book-body">${BOOK.b_auther}</div>

		<div class="book-title">구입년도</div>
		<div class="book-body">${BOOK.b_year}</div>

		<div class="book-title">구입가격</div>
		<div class="book-body">
			<!-- type이 number에 maxFractiondigits="3"이면 세자리마다 , 찍어주고
			type이 currency이면 통화기호 써줌 -->
			<fmt:formatNumber value="${BOOK.b_iprice}" type="number" maxFractionDigits="3" var="commaPrice"/>
			${commaPrice}
			<fmt:formatNumber value="${BOOK.b_iprice}" type="currency" maxFractionDigits="3" var="currPrice"/>
			${currPrice}
			<fmt:setLocale value="en_us"/>
			<fmt:formatNumber value="0.1" type="percent" maxFractionDigits="3"/>
		</div>
	</article>
</section>
</body>
</html>