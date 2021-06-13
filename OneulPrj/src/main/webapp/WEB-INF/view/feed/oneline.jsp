<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
<link href="/css/feed/onelineList.css" type="text/css" rel="stylesheet">
</head>


<main id="wrapper">


	<div id="main">

		<div class="btn-box">
			<a href="reg"> <img class="reg-img"
				src="../images/047add1_99902.png">
			</a>
		</div>

		<c:forEach var="n" items="${list}" varStatus="st">
			<article class="box">
				<div class="content">

					<div class="profile">
						<img class="profile-image" src="../images/user.PNG"> <a
							class="user-name">이동진</a> <a class="date"><fmt:formatDate value="${n.regDate}" pattern="yyyy년 MM월 dd일" /></a>
							<a class="edit" href="edit?id=${n.id}">수정</a>
						<a class="del" href="del?id=${n.id}" onclick="if(!confirm('삭제하시겠습니까?')) return false;">삭제</a>
					</div>					

					<a>${n.id}</a>
					<div>
						<a href="detail?id=${n.id}">${n.content}</a>
					</div>

					<div class="review-attr">
						<span>좋아요 0</span> <span>댓글 0</span>
					</div>
					<hr>
					<div class="review-btn-group">
						<!-- <input class="like" id="like-button" type="button" value="좋아요"> -->
						<a class="text">여러분의 댓글을 남겨주세요.</a>
					</div>
					<div class="comment-box d-none">
						<form>
							<input type="text" id="comment-txt"> <input type="submit"
								value="확인" id="btn">
						</form>
					</div>
				</div>
			</article>
		</c:forEach>




	</div>

</main>