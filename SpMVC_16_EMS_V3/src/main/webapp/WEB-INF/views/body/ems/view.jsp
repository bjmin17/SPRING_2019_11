<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$(function(){
	
	$("#btn-email-update").click(function(){
		document.location.href = "${rootPath}/ems/update/" + $(this).data("seq")
	})
	
	$("#btn-email-delete").click(function(){
		document.location.href = "${rootPath}/ems/delete/" + $(this).data("seq")
	})
	
	
})
</script>
<section>
	<article class="view">
		<table class="table">
			<tr>
				<th>받는Email</th><td>${emailVO.from_email}</td>
			</tr>
			<tr>
				<th>받는사람</th><td>${emailVO.from_name}</td>
			</tr>
			<tr>
				<th>작성일자</th><td>${emailVO.send_date}</td>
			</tr>
			<tr>
				<th>작성시각</th><td>${emailVO.send_time}</td>
			</tr>
			<tr>
				<th>제목</th><td>${emailVO.subject}</td>
			</tr>
			<tr id="view-content">
				<th>내용</th><td>${emailVO.content}</td>
			</tr>
		</table>
		<div style="padding:10px 25px" id="btn-div">
			<button id="btn-email-update" class="btn btn-warning" 
			onclick="location.href='${rootPath}/ems/update'" data-seq="${emailVO.ems_seq}">수정</button>
			<button id="btn-email-delete" class="btn btn-danger" 
			onclick="location.href='${rootPath}/ems/delete'" data-seq="${emailVO.ems_seq}">삭제</button>
			<button id="btn-email-list" class="btn btn-primary" 
			onclick="location.href='${rootPath}/'">전체보기</button>
		</div>
	</article>
</section>