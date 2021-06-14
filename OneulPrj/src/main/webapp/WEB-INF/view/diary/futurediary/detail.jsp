<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<main id="main">
	<section class="">
		<h1>Feed section</h1>
		<h3>Test table</h3>
		 <table border="1">
                           
                           <tr>
                              <th>작성일</th>
                              <td colspan="3"><fmt:formatDate value="${futureDiary.regDate}" pattern="yyyy-MM-dd HH:mm"/></td>
                           </tr>
                           
                           
                           <tr>
                              <td colspan="4">
                                 ${futureDiary.content}
                              </td>
                           </tr>
                        </table>
                  <div>
                     <a href="list">목록</a>
                     <a href="edit?id=${futureDiary.id}">수정</a>
                     <a href="del?id=${futureDiary.id}" onclick="if(!confirm('삭제하시겟슺니가?'))return false;">삭제</a>
                   													
                  </div>

	</section>
</main>


