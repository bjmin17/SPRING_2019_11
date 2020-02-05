<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
	.card-header h3 {
		display: inline-block;
		width: auto;
		padding: 5px 15px;
	}
</style>
<script>
$(function(){
	$("button.btn-c-save").click(function(){
		let cmt_writer = $("#cmt_writer").val()
		let cmt_text = $("#cmt_text").val()
		
		if(cmt_writer == "") {
			alert("댓글 작성자를 입력하세요")
			$("#cmt_writer").focus
			return false
		}
		if(cmt_text == "") {
			alert("댓글 내용을 입력하세요")
			$("#cmt_text").focus
			return false
		}
		
		// json형태로 데이터 생성 {Key값 : value값}으로 값을 싣고 json형태로 넘겨줌
		let cmt_data = {
				
				cmt_p_id:'${bbsVO.bbs_id}',
				cmt_writer:cmt_writer,
				cmt_text:cmt_text
				
				}
		
		$.ajax({
			url : '${rootPath}/bbs/cmt_write',
			method : 'POST',
			data : cmt_data,
			success : function(result) {
				// alert(result)
				$("#cmt_list").html(result)
				
			},
			error:function() {
				alert("서버와 통신 오류")
			}
			
		})
	})
	// 리스트 나갔다 오면 댓글이 안 보이는데, 보이게 하기
	// 화면 실행되면 스크립트가 자동으로 실행되도록 이벤트 설정한 것
	// 이후 bbscontroller 에서 cmm_list 메서드 생성
	// cmt_p_id에 bbs_id를 실어서 보내고, cmt_list 주소에 post 방식으로 보내고 그 결과를
	// #cmt_list.html으로 보여줘라
	// 화면이 모두 그려지고 나면 이 포스트가 제일 먼저 실행되기 때문에
	// 실제로는 jQuery문 제일 위쪽에 있는것과 같음.
	
	// 현재 페이지가 모두 그려진 후 바로 실행하라
	// ajax이지만 위의 코드와 비교하면 post로 한정된 코드
	$.post("${rootPath}/bbs/cmt_list",{cmt_p_id:"${bbsVO.bbs_id}"},function(result){
		$("#cmt_list").html(result)
	})
	
})
</script>



<article class="card">
	<div class="card-header">
		<h3>${bbsVO.bbs_subject}</h3>
		(${bbsVO.bbs_date} : ${bbsVO.bbs_time})
	</div>
	<div class="card-body">
		${bbsVO.bbs_content}
	</div>
	<div class="card-footer bg-success text-white">
		CopyRight &copy; ${bbsVO.bbs_writer}
	</div>
	<div class="card-body bg-info">
		<div id="cmt_list" class="form-group bg-white">
			댓글 리스트 보기
		</div>
		<div class="form-group">
			<input name="cmt_writer" id="cmt_writer" class="form-control" placeholder="작성자">
		</div>
		<div class="form-group">	
			<input name="cmt_text" id="cmt_text" class="form-control">
			<button class="btn btn-dark btn-c-save">저장</button>
		</div>
	</div>
	
</article>
	<div class="button-group">
		<button type="button" class="btn btn-primary">리스트보기</button>
		<button type="button" class="btn btn-warning">수정</button>
		<button type="button" class="btn btn-danger">삭제</button>
	</div>
	<% /* 답글에서 더이상의 답글은 못 달게*/ %>
	<c:if test="${bbsVO.bbs_p_id == 0}">
		<script>
			$(function(){
				
				$("button.btn-r-save").click(function(){
					let bbs_writer = $("#bbs_writer").val()
					let bbs_content = $("#bbs_content").val()
					
					if(bbs_writer == "") {
						alert('작성자를 입력하세요')
						$("#bbs_writer").focus()
						return false
					}
					if(bbs_content == "") {
						alert("답글 본문을 입력하세요")
						$("#bbs_content").focus()
						return false
					}
					$("form").submit()
				})
				
			})
		</script>
		<form:form action="${rootPath}/bbs/reply" modelAttribute="bbsVO">
			<div class="form-group">
				<input class="form-control" name="bbs_writer"
						id="bbs_writer" 
						placeholder="답글 작성자"/>
			</div>
			<textarea name="bbs_content" id="bbs_content"></textarea>
			<button class="btn btn-info btn-r-save" type="button">답글저장</button>
		</form:form>
	</c:if>
