window.addEventListener("load", function (event) {

	let modal = document.getElementById("modal");
	
	let openBtn = document.getElementById("open-button");
	
	let closePage = document.getElementsByClassName("close")[0];
	
	let emotion = document.querySelector("#emotion");
	
	//let checkedEmo = document.querySelector("#checked-emo");
	console.log(emotion);
	
	
	// When the user clicks on the button, open the modal 
	openBtn.onclick = function() {
		
		modal.style.display = "block";
	}
	
	// When the user clicks on <span> (x), close the modal
	closePage.onclick = function() {
		modal.style.display = "none";
		emotionDisplay();
	}
	
	
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
	
	
	
});

window.addEventListener("load",function(){
	let emotionTable = document.querySelector(".emotion-table");

	emotionTable.onclick = function(e){
		console.log(e.target);
		if(!e.target.classList.contains("emotion-icon-container")){
			return;
		}
		
		let target = e.target;
		let input = target.childNodes[0];
		console.log(input);
		input.checked = "true";

		modal.style.display = "none";
		
		//checked emotion display
		emotionDisplay();
		
	}
});

function emotionDisplay(){
	if(document.querySelector('input[name="emotionId"]:checked')==null){
		return;
	}
	let checkEmotion = document.querySelector('input[name="emotionId"]:checked').value;
		if(checkEmotion != null){
			//emotion.innerText = checkedEmotion;
			//checkedEmo.style.display = "none";
			
			emotion.style.display = "inline-block";
			
			if(checkEmotion == 1){
				emotion.className = 'happy';
			}else if(checkEmotion == 2){
				emotion.className = 'proud';
			}else if(checkEmotion == 3){
				emotion.className = 'flutter';
			}else if(checkEmotion == 4){
				emotion.className = 'calm';
			}else if(checkEmotion == 5){
				emotion.className = 'sensitive';
			}else if(checkEmotion == 6){
				emotion.className = 'unstable';
			}else if(checkEmotion == 7){
				emotion.className = 'tired';
			}else if(checkEmotion == 8){
				emotion.className = 'sad';
			}else{
				emotion.className = 'upset';
			}
		}

}