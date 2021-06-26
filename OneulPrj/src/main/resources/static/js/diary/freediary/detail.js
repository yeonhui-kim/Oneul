window.addEventListener("load", function (event) {
 	
	let modal = document.getElementById("modal");

	let openBtns = document.querySelectorAll('.open-button');
	
	let closePage = document.getElementsByClassName("close")[0];
	
	let emotion = document.querySelector("#emotion");
	
	let commentReg = document.querySelector('#commentReg');
	
	for(let i=0;i<openBtns.length;i++){
	openBtns[i].onclick = function() {
		//popup to reply
		modal.style.display = "block";
		//insert commentId
		let commentId = commentReg.firstElementChild;
		let parentCommentId = openBtns[i].parentNode.firstElementChild.firstElementChild.innerText;
		commentId.value=parentCommentId;

		};
		
	}
	

	closePage.onclick = function() {
		modal.style.display = "none";
	}
	

	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
	
	
	
});
