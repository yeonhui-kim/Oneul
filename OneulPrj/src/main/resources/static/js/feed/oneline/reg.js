
function submitBtnClick(){
	const form = document.querySelector("form");

	const contentInput = document.querySelector(".txt");
	
	let content = contentInput.value;
	
	
	
	console.log(content);

	if(content=="" || content==null){
		alert("내용을 입력해주세요");
	}else{
		form.submit();	
	}
	
}