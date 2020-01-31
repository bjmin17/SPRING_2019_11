<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	$(function(){
		
		// el태그
		// ${LOGIN == NO}해도 되는데 자바 스크립트에서는 좋은 코드가 아님
		// "${LOGIN} == NO"라 해도 되지만 나중에 보기 쉽게 하기 위해
		if( "NO" == "${LOGIN}") {
			alert("로그인을 해야 합니다.")
			$("div.login-modal").css("display", "block")
			return;
		}
		
		
		$(".nav-link").click(function(){
			
			if($(this).text() == "로그인") {
				
				$("div.login-modal").css("display", "block")
				// 모달창을 띄우고, 그 아래코드는 모두 무시하라는게 return false
				return false
				
			}
			
			if($(this).text() == "EMS") {
			/*
			
				snake case : data-menu-name
				carmel case : dataMenuName
			
				$(this).css("background-color","yellow")
				$(this).css("backgroundColor","yellow")
				카멜케이스로 사용하면서 적용하기
			*/
				let text = $(this).data("menuName")
				// alert(text)
			}
			
			
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
	  <li class="nav-item">
	    <a class="nav-link" href="javascript:void(0)" data-menu="list" data-menu-name="홈으로">EMS</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="javascript:void(0)" data-menu="bbs/free">자유게시판</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="javascript:void(0)" data-menu="bbs/notice">공지사항</a>
	  </li>
	  <c:if test="${empty MEMBER}">
		  <li class="nav-item">
		    <a class="nav-link" href="javascript:void(0)" data-menu="member/login">로그인</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="javascript:void(0)" data-menu="member/join">회원가입</a>
		  </li>
	  </c:if>
	  
	  <c:if test="${!empty MEMBER}">
		  <li class="nav-item">
		    <a class="nav-link" href="javascript:void(0)" data-menu="member/logout">로그아웃</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="javascript:void(0)" data-menu="member/logout">${MEMBER.nickname}(${MEMBER.email})</a>
		  </li>
	  </c:if>
	  
	</ul>
</nav>
