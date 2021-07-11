

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

function submitBtnClick(){
	const form = document.querySelector(".form");

	const dateInput = document.querySelector("input[type='date']");
	const emotionInput = document.querySelector("input[type='radio']");
	
	let date = dateInput.value;
	let emotion = document.querySelector("#emotion").classList.value;
	
	console.log(date);
	console.log(emotion);
	if(date==""){
		alert("예약 날짜를 선택해주세요");
	}else if(emotion==""){
		alert("감정을 선택해주세요");
	}else{
		form.submit();	
	}
	
}


window.addEventListener("load",()=>{
	const explanation = document.querySelector(".explanation");
	const questionMark = document.querySelector(".question-mark");
	
	questionMark.onclick=()=>{
		explanation.classList.toggle("d-none");
	}
	
})

