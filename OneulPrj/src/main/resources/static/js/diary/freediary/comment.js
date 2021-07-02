window.addEventListener("load", function(event) {

	let modal = document.getElementById("modal");

	let editModal = document.getElementById('editModal');

	let openBtns = document.querySelectorAll('.open-button');

	let editBtns = document.querySelectorAll('.edit-button');

	let closePage = document.getElementsByClassName("close")[0];

	let closePages = document.querySelectorAll('.close');

	let emotion = document.querySelector("#emotion");

	let commentReg = document.querySelector('#commentReg');
	
	let receiver = document.querySelector('.receiver');
	
	let subComments = document.querySelectorAll('.subComments');

	for (let i = 0; i < openBtns.length; i++) {
		openBtns[i].onclick = function(event) {
			//popup to reply
			modal.style.display = "block";
			//insert commentId
			let commentId = commentReg.firstElementChild;
			console.log(commentId);//사용자가선택한 아이디
			//부모댓글아이디
			let parentCommentId = openBtns[i].parentNode.parentNode.firstElementChild;
			commentId.value = parentCommentId.innerText;
			console.log(openBtns[i].parentNode.parentNode.lastElementChild.firstElementChild.innerText);
			//부모댓글유저이름
			let receriverName = openBtns[i].parentNode.parentNode.lastElementChild.firstElementChild;
			receiver.innerText = receriverName.innerText;
			//부모댓글유저이름 텍스트창에넣기
			let receiverInput = document.querySelector('.receiverInput');
			console.log(receiverInput);
			receiverInput.value = '@'+ openBtns[i].parentNode.parentNode.lastElementChild.firstElementChild.innerText;

		};
	};

/*	for(let i=0;i<subComments.length;i++){
	//쉼표로 문자열자르기(@유저이름 + 내용 구분)
		var array = subComments[i].innerText.split(',');
		let userName = array[0];
		console.log(typeof userName);
		console.log(userName);
		//p태그만들어 넣기
		let spanTag = document.querySelector('.spanTag');
		spanTag.insertAdjacentElement("afterend",userName);
	}*/
	
	//팝업창 닫기
	for(let i=0;i<closePages.length;i++){
	closePages[i].addEventListener('click', () => editModal.style.display = "none");
		
	};

	//팝업창 닫기
	closePage.onclick = function() {
		modal.style.display = "none";
		editModal.style.display = "none";
	};

	//팝업창 닫기
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
		else if (event.target == editModal) {
			editModal.style.display = "none";
		}
	}
	//댓글수정팝업
	for (let i = 0; i < editBtns.length; i++) {
		editBtns[i].onclick = function(event) {
			//popup to reply
			editModal.style.display = "block";
			//선택한 댓글의 번호가져오기
			let selectedCommentId = event.target.parentNode.parentNode.firstElementChild;
			//가져온 번호 히든인풋에 넘기기
			let inputId = editModal.firstElementChild.querySelector("input");
			inputId.value = selectedCommentId.innerText;
			//선택한 댓글의 원문가져오기
			let selectedCommentContent = event.target.parentNode.firstElementChild.nextElementSibling.nextElementSibling;
			//원문 보여주기
			let editContent = document.querySelector('.editContent');
			editContent.placeholder = selectedCommentContent.innerText;
		};
	}



});

