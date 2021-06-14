<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<main id="main">
	<section class="">
		<h1>Feed section</h1>
		<h3>Test table</h3>
		<table>
			<c:forEach var="n" items="${list}">
				<tr>
					<td class="w-1">${n.id}</td>
					<td class="truncate text-align-left"><a
						href="detail?id=${n.id}">${n.content}[20]</a></td>
					<td class="w-2"><fmt:formatDate value="${n.regDate}"
							pattern="yyyy-MM-dd" /></td>

				</tr>
			</c:forEach>
		</table>
		<div>
			<a href="reg">글쓰기</a>
		</div>
	</section>
</main>


