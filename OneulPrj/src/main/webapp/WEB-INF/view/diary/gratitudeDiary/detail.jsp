<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main id="main">

	<section class="">
		<table border="1">
			<tr>
				<th>감정선택</th>
				<td colspan="3">감정이모티콘뷰</td>
			</tr>
			<tr>
				<th>질문선택</th>
				<td colspan="3">질문선택지</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3"><input type="file" name="f"></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td colspan="3"><fmt:formatDate value="${gratitudeDiary.regDate}" pattern="yyyy-MM-dd a hh:mm:ss" /></td>
			</tr>
			<tr>
				<th>공개선택</th>
				<td colspan="3">공개 / 비공개</td>
			</tr>
			<tr>
				<td colspan="4">${gratitudeDiary.content}</td>
			</tr>
		</table>
		<div>
			<a href="list">목록</a> <a href="edit?id=${gratitudeDiary.id}">수정</a> 
			<a href="del?id=${gratitudeDiary.id}"
				onclick="if(!confirm('정말 삭제하시겠습니까?')) return false;">삭제</a>
		</div>

	</section>

</main>