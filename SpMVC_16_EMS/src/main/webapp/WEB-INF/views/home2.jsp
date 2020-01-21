<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MY EMS</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link href="${rootPath}/static/css/main.css?ver=2020-01-20-002" type="text/css" rel="stylesheet">
<link href="${rootPath}/static/css/email-write.css?ver=2020-01-20-002" type="text/css" rel="stylesheet">

</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header2.jsp" %>
	<c:choose>
		<c:when test="${BODY == 'WRITE'}">
			<%@ include file="/WEB-INF/views/body/ems/write.jsp" %>		
		</c:when>
		<c:otherwise>
			<%@ include file="/WEB-INF/views/body/ems/list.jsp" %>
		</c:otherwise>
	</c:choose>
<div class="bottom-button">
	<button type="button" class="btn btn-primary">메일보내기</button>
</div>
</body>
</html>