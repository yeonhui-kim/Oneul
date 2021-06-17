<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main id="main">

	<form class="form" action="reg" method="post"
		enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>감정선택</th>
				<td colspan="3">감정이모티콘뷰</td>
			</tr>
			<tr>
				<th>공개선택</th>
				<td colspan="3">공개 / 비공개</td>
			</tr>
			<tr>
				<td colspan="4">
					<div contenteditable="true"></div> <textarea rows="6" cols="50"
						name="content1">오늘 하루는 어떤 감사한 일이 있었나요?</textarea>
					<div contenteditable="true"></div> <textarea rows="6" cols="50"
						name="content2">어떻게 하면 더 좋은 하루를 보낼 수 있을까요?</textarea>
					<div contenteditable="true"></div> <textarea rows="6" cols="50"
						name="content3">오늘의 나를 위한 긍정의 한 줄을 남겨주세요!</textarea>
				</td>
			</tr>
		</table>


		<div>
			<input type="submit" value="저장"> <a href="list">취소</a>
		</div>
	</form>

</main>