<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	$(function(){
		$(".nav li").click(function(){
			
			// let href = $(this).attr("data-menu")
			
			// data-menu 속성에 지정된 값을 가져와라
			let href = $(this).data("menu")
			
			document.location.href = "${rootPath}/" + href
		})
	})

</script>
<header class="jumbotron">
	<h2>MY EMS</h2>
</header>
<nav>
	<ul class="nav">
	  <li class="nav-item" data-menu="list">EMS</li>
	  <li class="nav-item" data-menu="bbs/free">자유게시판</li>
	  <li class="nav-item" data-menu="bbs/notice">공지사항</li>
	  <li class="nav-item" data-menu="member/login">로그인</li>
	  <li class="nav-item" data-menu="member/join">회원가입</li>
	</ul>
</nav>
