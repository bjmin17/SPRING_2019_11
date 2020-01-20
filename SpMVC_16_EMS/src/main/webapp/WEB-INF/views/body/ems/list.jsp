<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section>
	<article>
		<table class="table">
			<tr>
				<th>NO</th>
				<th>받는Email</th>
				<th>받는사람</th>
				<th>제목</th>
				<th>작성일자</th>
				<th>작성시각</th>
			</tr>
			<c:choose>
				<c:when test="${empty LIST}">
					<tr>
						<td colspan="6">데이터가 없습니다</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${LIST}" var="VO" varStatus="in">
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
							<td>6</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<div style="padding:10px 25px">
			<button id="btn-email-send" onclick="location.href='${rootPath}/ems/input'">메일보내기</button>
		</div>
	</article>
</section>