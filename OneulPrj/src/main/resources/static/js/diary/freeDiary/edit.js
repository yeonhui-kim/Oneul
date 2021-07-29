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
