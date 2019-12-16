<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
</head>
<body>
	<style>
		fieldset div {
			display:flex;
		}
		fieldset {
			width:80%;
			border:1px solid green;
			border-radius: 10px;
			margin:10px auto;
		}
		fieldset div label{
			display:inline-block;
			width:20%;
			padding:8px;
			margin:5px;
			text-align: right;
			vertical-align:center;
		}
		fieldset div input, fieldset div select{
			display:inline-block;
			width:70%;
			padding:8px;
			margin:5px;
			border:1px solid #ddd;
		}
	</style>
	<form:form modelAttribute="bokSearchDTO">
		<fieldset>
			<div>
				<label for="srchKeyCode">검색분류</label>
				<form:select path="srchKeyCode" label="검색분류">
					<form:options items="${SeMap.srchKeyCode}" />
				</form:select>
			</div>
			<div>
				<label for="searchWrd">검색어</label>
				<form:input path="searchWrd" label="검색어" />
			</div>
			<div>
				<label for="lifeArray">생애주기</label>
				<form:select path="lifeArray" label="생애주기">
					<form:options items="${SeMap.lifeArray}" />
				</form:select>
			</div>
			<div>
				<label for="charTrgterArray">대상특성</label>
				<form:select path="charTrgterArray" label="대상특성">
					<form:options items="${SeMap.charTrgterArray}" />
				</form:select>
			</div>
			<div>
				<label for="obstKiArray">장애유형</label>
				<form:select path="obstKiArray" label="장애유형">
					<form:options items="${SeMap.obstKiArray}" />
				</form:select>
			</div>
			<div>
				<label for="obstAbtArray">장애정도</label>
				<form:select path="obstAbtArray" label="장애정도">
					<form:options items="${SeMap.obstAbtArray}" />
				</form:select>
			</div>
			<div>
				<label for="trgterIndvdlArray">가구유형</label>
				<form:select path="trgterIndvdlArray" label="가구유형">
					<form:options items="${SeMap.trgterIndvdlArray}" />
				</form:select>
			</div>
			<div>
				<label for="desireArray">욕구</label>
				<form:select path="desireArray" label="욕구">
					<form:options items="${SeMap.desireArray}" />
				</form:select>
			</div>
			<div>
				<label></label>
				<button id="btn-search">조회</button>
			</div>
		</fieldset>
	</form:form>
</body>
</html>