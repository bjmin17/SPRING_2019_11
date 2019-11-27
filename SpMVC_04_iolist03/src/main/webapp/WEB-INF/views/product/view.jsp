<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function(){
	
		$(".btn-update").click(function(){
			document.location.href = "${rootPath}/product/update?id=${PRO_DTO.p_code}"
		})
		$(".btn-delete").click(function(){
			
			let msg = "상품명 : ${PRO_DTO.p_name} \n"
			msg += "상품코드 : ${PRO_DTO.p_code} \n"
			msg += "삭제할까요?"
			if(confirm(msg)){
				document.location.href = "${rootPath}/product/delete?id=${PRO_DTO.p_code}"	
			}
			
		})
		
		
	})
	
	

</script>

</head>
<body>
<%@ include file="/WEB-INF/views/include/include-dept-header.jspf" %>
<section>
	<table>
		<tr>
			<th>상품코드</th><td>${PRO_DTO.p_code}</td>
			<th>상품명</th><td>${PRO_DTO.p_name}</td>
		</tr>
		<tr>
			<th>매입단가</th><td>${PRO_DTO.p_iprice}</td>
			<th>매출단가</th><td>${PRO_DTO.p_oprice}</td>
		</tr>
		<tr>
			<th>부가세</th><td>${PRO_DTO.p_vat}</td>
		</tr>
		<tr>
			<td colspan="4">
				<div class="btn-box">
					<button class="btn-update">수정</button>
					<button class="btn-delete">삭제</button>
				</div>
			</td>
		
		</tr>
	</table>
	
</section>
</body>
</html>