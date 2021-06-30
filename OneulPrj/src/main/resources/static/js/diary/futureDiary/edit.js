/**
 * 
 */
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


window.addEventListener("load",()=>{
	//과거날짜 선택 불가
	const dateInput = document.querySelector("input[type='date']");
	console.log(dateInput);
	let date = new Date();
    let year = date.getFullYear();
    let month = ("0" + (1 + date.getMonth())).slice(-2);
    let day = ("0" + date.getDate()).slice(-2);

    let today =  year + "-" + month + "-" + day;
	
	dateInput.min = today;
});
//input hidden 1 : 원래 파일 이름
//input hidden 2 : 변경여부
//변경안됐으면..업데이트할때 파일은 냅둠
/*
window.addEventListener("load", ()=>{
	const fileDelBtn = document.querySelector(".file-del-btn");
	const fileInput = document.querySelector("input[type='file']");
	
	if(fileInput.value == ''){
		console.log("dd");
		fileDelBtn.style.display = 'none';
		
	}else{
		fileDelBtn.style.display = '';
	}
})*/