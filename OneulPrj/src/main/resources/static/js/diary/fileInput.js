/**
 * 
 */
 
 window.addEventListener("load",()=>{
	const fileInput = document.querySelector("input[type='file']");
	
	const fileDelBtn = document.querySelector(".file-del-btn");
	
	const img = document.querySelector(".image");
	
	img.onclick = (e)=> {//이벤트 위임
		e.preventDefault();
		var event = new MouseEvent("click", {
			'view': window,
			'bubbles': true,
			'cancelable': true
		});
		fileInput.dispatchEvent(event);
	}

	
	fileInput.oninput = ()=>{
		let file = fileInput.files[0];
		if(file.type.indexOf("image/") < 0){
			alert("이미지 형식만 사용할 수 있습니다.");
			fileInput.value="";
			return;
		}
			
		let reader = new FileReader();
		
		reader.readAsDataURL(file);
		reader.onload = (e)=>{
			console.log("reader load");
			
			img.classList.remove("basic");
			img.src = e.target.result;
			
			//fileDelBtnContainer.insertAdjacentElement("beforebegin",img);
			fileDelBtn.style.display = '';
		};
		
			
	}
	fileDelBtn.onclick = ()=>{
		img.src = "/images/icon/picture.png"
		img.classList.add("basic");
		fileInput.value="";
		
		fileDelBtn.style.display = 'none';
		
	}
});


window.addEventListener("load", ()=>{
	const fileDelBtn = document.querySelector(".file-del-btn");
	
	let img = document.querySelector(".image");
	
	if(img.classList.contains("basic")){ //기본사진일때
		console.log("dd");
		fileDelBtn.style.display = 'none';
		
	}else{
		fileDelBtn.style.display = '';
	}
})
