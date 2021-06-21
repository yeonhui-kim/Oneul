window.addEventListener("load", function() {
	
	
	let quetionList = document.querySelector('.quetionList');
	let textarea = document.querySelector(".content");
	console.log(textarea);
	
	quetionList.oninput = function(e){
		console.log('질문선택했음');
	let text = quetionList.text;
	let value = quetionList.value;
	
	console.log(text);
	console.log(value);
	
		textarea.innerText=value;
		console.log(value);
	};


});
