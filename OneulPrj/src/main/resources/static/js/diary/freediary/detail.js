window.addEventListener("load", function (event) {
 	
	let modal = document.getElementById("modal");
	
	//let openBtn = document.getElementById("open-button");
	let openBtns = document.querySelectorAll('.open-button');
	
	let closePage = document.getElementsByClassName("close")[0];
	
	let emotion = document.querySelector("#emotion");
	
	for(let i=0;i<openBtns.length;i++){
	openBtns[i].onclick = function() {
		
		modal.style.display = "block";
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
