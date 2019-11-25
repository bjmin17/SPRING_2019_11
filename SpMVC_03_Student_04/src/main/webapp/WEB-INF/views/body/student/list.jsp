<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<p></p>
<p>
<p></p>
<style>
table {
	/*
                table을 표시할 때
                table의 바깥쪽 라인과
                각 칼럼의 라인 간의 간격을 없애고자 할 때
                표를 실선모양으로 외부 라인 설정
            */
	border-collapse: collapse;
	/*
                셀과 셀 사이 간격 없애기
            */
	border-spacing: 0;
	width: 90%;
	border: 1px solid blue;
	border: 1px dotted blue;
	
	/* top, bottom 여백을 20px로 하고*/
	/* 
	left와 right 여백을 니맘대로 하세요
	좌우 중앙에 물체(box)를 위치하라
	
	*/
	margin:20px auto;
}

table tr {
	border: 1px dashed red;
}


/* td, th : td tag와 th tag에 공통된 속성을 부여하겠다 */
table td, table th{
	/* 표 안에 위아래 여백 적용 */
	padding:8px;
	vertical-align:top;

}
table th{
	text-align: left;
}

/* 조건부 서식*/
table tr:nth-child(odd){
	background-color: #fff;
}
table tr:nth-child(even){
	background-color: #ccc;
}
/*
        table row에 마우스가 위치하면
        바탕색을 gray로 설정하고
        마우스커서를 손가락 모양으로
        
        */
table tr:hover {
	background-color: gray;
	cursor: pointer;
}

</style>

<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>학과</th>
		<th>학년</th>
		<th>전화번호</th>
	</tr>
	
	<c:choose>
		<c:when test="${STDLIST == NULL}">
			<tr>
				<td colspan="5">
					데이터가 없습니다
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${STDLIST}" var="dto">
				<tr>
					<td>${dto.st_num}</td>
					<td>${dto.st_name}</td>
					<td>${dto.st_dept}</td>
					<td>${dto.st_grade}</td>
					<td>${dto.st_tel}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
