window.addEventListener("load", function() {
	
	
	let quetionList = document.querySelector('.quetionList');
	let textareaContent = document.querySelector(".content");
	let selectedQuestion = document.querySelector(".selectedQuestion");
	console.log(textareaContent);
	
	quetionList.oninput = function(e){
		console.log('질문선택했음');
	let text = quetionList.text;
	let value = quetionList.value;
	
	console.log(text);
	console.log(value);

		selectedQuestion.value=value;
	};


});
  window.addEventListener("load",()=>{
	const fileInput = document.querySelector("input[type='file']");
	let img = document.querySelector(".image");
	const fileDelBtn = document.querySelector(".file-del-btn");
	const changed = document.querySelector(".changed");
	
	
	
	
	fileInput.oninput = ()=>{
		let file = fileInput.files[0];
		if(file.type.indexOf("image/") < 0)
			alert("이미지 형식만 사용할 수 있습니다.");
			
		let reader = new FileReader();
		
		reader.readAsDataURL(file);
		reader.onload = (e)=>{
			console.log("reader load");
			img.src = e.target.result;
			img.style.width = "200px";
			img.style.height = "150px";
			
			fileInput.insertAdjacentElement("beforebegin",img);
		};	
		changed.value="1"; //파일바뀜	
	}
	
	//js에서 삭제버튼 onclick -> 이미지클래스 src 지우고..
	//원본파일은 컨트롤러에서 조건처리(만약에 파일이 ''이면 원래파일삭제..원래파일은? 히든으로 전달할가..
	fileDelBtn.onclick = ()=>{
		img.removeAttribute("src");
		img.removeAttribute("style");
		fileInput.value="";
		changed.value="1";
		
	}
	
});