<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<main id="main">
	<section class="">
		<h1>Feed section</h1>
		<h3>Test table</h3>
		<form class="form" action="reg" method="post" enctype="multipart/form-data">
                           <table border="1">  
                           <lable>예약날짜</lable>                      
                            <input type="date" name="bookingDate">
                            <tr>
                              	<td colspan="4">
                              		
                              		<label>공개</label>
                              		<input type="checkbox" value="1" name="pub">
                              		<label>비공개</label>
                              		<input type="checkbox" value="0" name="pub">
                              	</td>
                              </tr>  
                              <tr>
                                 <td colspan="4">
                                 <textarea rows="20" cols="80" name="content"></textarea>
                                    
                                 </td>
                              </tr>
                           </table>
                           
                     <div>
                        <input type="submit" value="저장">
                        <a href="list">취소</a>
                     </div>
                  </form>

	</section>
</main>


