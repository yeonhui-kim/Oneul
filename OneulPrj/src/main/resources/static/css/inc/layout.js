    	window.addEventListener("load", ()=>{
    		
    		let navClicked = window.document.querySelector(".nav-clicked");
    		
    		
    		
    		
    		if(navClicked.value == "feed"){
	    		let feedIcon = window.document.querySelector(".feedIcon");
    			feedIcon.src = "https://image.flaticon.com/icons/png/128/2948/2948037.png";
    		} else if ( navClicked.value == "calendar"){
				let calIcon = window.document.querySelector(".calIcon");  
    			calIcon.src = "https://image.flaticon.com/icons/png/128/2948/2948088.png";

    		} else if (navClicked.value == "mypage"){
				let myIcon = window.document.querySelector(".myIcon");    			    			
    			myIcon.src = "https://image.flaticon.com/icons/png/512/996/996484.png";

    		} else if (navClicked.value == "reg"){
				let writeIcon = window.document.querySelector(".writeIcon");    			
    			writeIcon.src = "https://image.flaticon.com/icons/png/128/561/561169.png";    			
    		} else if (navClicked.value == "diary"){
				let diaryIcon = window.document.querySelector(".diaryIcon");    
    			diaryIcon.src = "https://image.flaticon.com/icons/png/128/2947/2947998.png";    			

    		}
	    		
    		
    		
    	});