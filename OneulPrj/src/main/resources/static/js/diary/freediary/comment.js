window.addEventListener("load", function(event) {

	let modal = document.getElementById("modal");

	let editModal = document.getElementById('editModal');

	let openBtns = document.querySelectorAll('.open-button');

	let editBtns = document.querySelectorAll('.edit-button');

	let closePage = document.getElementsByClassName("close")[0];

	let closePages = document.querySelectorAll('.close');

	let emotion = document.querySelector("#emotion");

	let commentReg = document.querySelector('#commentReg');

	for (let i = 0; i < openBtns.length; i++) {
		openBtns[i].onclick = function() {
			//popup to reply
			modal.style.display = "block";
			//insert commentId
			let commentId = commentReg.firstElementChild;
			let parentCommentId = openBtns[i].parentNode.firstElementChild.firstElementChild.innerText;
			commentId.value = parentCommentId;

		};
	};


	for(let i=0;i<closePages.length;i++){
	closePages[i].addEventListener('click', () => editModal.style.display = "none");
		
	};


	closePage.onclick = function() {
		modal.style.display = "none";
		editModal.style.display = "none";
	};


	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
		else if (event.target == editModal) {
			editModal.style.display = "none";
		}
	}

	for (let i = 0; i < editBtns.length; i++) {
		editBtns[i].onclick = function(event) {
			//popup to reply
			editModal.style.display = "block";
			//선택한 댓글의 번호가져오기
			let selectedCommentId = event.target.parentNode.firstElementChild.firstElementChild.innerText;
			//가져온 번호 히든인풋에 넘기기
			let inputId = editModal.firstElementChild.querySelector("input");
			inputId.value = selectedCommentId;
			//선택한 댓글의 원문가져오기
			let selectedCommentContent = event.target.parentNode.firstElementChild.nextElementSibling;
			//원문 보여주기
			let originalContent = event.target.parentNode.firstElementChild.nextElementSibling.innerText;
			let editContent = document.querySelector('.editContent');
			editContent.placeholder = originalContent;
		};
	}



});
