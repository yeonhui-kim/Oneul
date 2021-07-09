/**
 * 
 */
   window.addEventListener("load", ()=>{
			
        	
        	let editBox = document.querySelector(".upside-container-edit-box");
            
            
            let configButton = document.querySelector(".upside-container-edit-img");
           
            
            //config button 누르면 팝업menu 떠보자
            configButton.onclick = (e)=>{
            	  editBox.classList.remove("d-none");
            	//투명 screen 만들어서 띄워줌
                  let whiteScreen = document.createElement("div");
                  whiteScreen.style.width = "100%";
                  whiteScreen.style.height = "100%";
                  whiteScreen.style.position = "fixed";
                  whiteScreen.style.top = "0px";
                  whiteScreen.style.left = "0px"
                  whiteScreen.style.zIndex = 5;
                  whiteScreen.style.opacity = 0.7;
                  document.body.appendChild(whiteScreen);
                 
                  //screen onclick되면 사라짐 
                  whiteScreen.onclick = (e) =>{
                	  
                	whiteScreen.remove();
                  	editBox.classList.add("d-none");
                  };
                  
                  //editBox도 onclick되면 사라짐 
                  editBox.onclick = ()=>{
                	  
                	 whiteScreen.remove();
                     editBox.classList.add("d-none");  
                	  
                  };
                  
             
            };
            
          }
     )