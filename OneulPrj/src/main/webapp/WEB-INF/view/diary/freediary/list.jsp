<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<main id="main">
	<section class="">
		<h1>자유일기</h1>
		<h3>내가 쓴 자유일기 목록</h3>
		<table>
			<tr>
				<th>번호</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="n" items="${list}" varStatus="st">
				<tr>
					<td>${n.id}</td>
					<td><a href="detail?id=${n.id}">${n.content}</a></td>
					<td>${n.memberId}</td>
					<td><fmt:formatDate value="${n.regDate}" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<a href="reg">글쓰기</a>
		</div>
	</section>
</main>


