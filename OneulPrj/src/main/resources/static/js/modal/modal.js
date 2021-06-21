window.addEventListener("load", function (event) {
	// Get the modal
	let modal = document.getElementById("modal");
	
	// Get the button that opens the modal
	let openBtn = document.getElementById("open-button");
	
	// Get the <span> element that closes the modal
	let closePage = document.getElementsByClassName("close")[0];
	
	let emotion = document.querySelector("#emotion");
	console.log(emotion);
	
	// When the user clicks on the button, open the modal 
	openBtn.onclick = function() {
		
		modal.style.display = "block";
	}
	
	// When the user clicks on <span> (x), close the modal
	closePage.onclick = function() {
		modal.style.display = "none";
		emotion.style.display = "inline-block";
		
		let checkedEmotion = document.querySelector('input[name="emotionId"]:checked').value;
		if(checkedEmotion != null){
			//emotion.innerText = checkedEmotion;
			
			
			if(checkedEmotion == 1){
				emotion.className = 'happy';
			}else if(checkedEmotion == 2){
				emotion.className = 'proud';
			}else if(checkedEmotion == 3){
				emotion.className = 'flutter';
			}else if(checkedEmotion == 4){
				emotion.className = 'calm';
			}else if(checkedEmotion == 5){
				emotion.className = 'sensitive';
			}else if(checkedEmotion == 6){
				emotion.className = 'unstable';
			}else if(checkedEmotion == 7){
				emotion.className = 'tired';
			}else if(checkedEmotion == 8){
				emotion.className = 'sad';
			}else{
				emotion.className = 'upset';
			}
		}
	}
	
	
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
	
	
	
});