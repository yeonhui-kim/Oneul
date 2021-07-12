
window.addEventListener("load", ()=>{
	
	

    document.body.addEventListener("click", (e)=>{
        

        if(e.target.classList.contains("profile-popup")){
            
            let screen = document.createElement("div");
            screen.style.width = "100%";
            screen.style.height = "100%";
            screen.style.position = "fixed";
            screen.style.top = "0px";
            screen.style.left = "0px"
            screen.style.zIndex = 10000;
            screen.style.backdropFilter= "blur(2px)";
            
            screen.style.opacity = 0.7;
            document.body.appendChild(screen);













            fetch(`/api/profile/${e.target.alt}`).then((response) => response.json()).then((json) => {

                    
                    let profilePopUp = document.createElement("div");
                    profilePopUp.insertAdjacentHTML("beforeend",`
                            
                        <div style=" font-family: 'S-CoreDream-3Light'; font-weight: normal; font-style: normal;padding: 20px; max-width: 720px; color:#727272; box-shadow:0px 0px 5px black;  width: 85%;  border-radius: 30px; background-color: white; position:fixed; top:50%; left:50%; transform: translate(-50%, -50%); z-index: 11000;">
                            <p style="font-size: 20px; margin-top: 0px; margin-bottom:5px; text-align: center;">나의 오늘일기</p>
                            <P style="font-size: 13px; text-align: center; margin-top:0px;">나의 일상을 돌아 봅니다 ...</P>
                            <div style=" display: flex; align-items: center; justify-content: space-around; margin-top: 15px;">
                                <div style="flex-basis: 288px; text-align: center; flex-grow: 1; flex-shrink: 1; margin-right:15px;">
                                    <img style=" width: 80%; border-radius: 15px;" src="/upload/profile/${json.id}/${json.image}" alt="">
                                </div>
                                <div style="flex-basis: 1px; height: 140px; background-color: #F2F2F2;"></div>
                                <div style="flex-basis: 431px;  flex-grow: 1.5; flex-shrink: 1.5; padding-left: 15px; align-self: flex-start;">
                                    <p style="margin-top: 17px; font-size: 13px;">${json.name} 나는</p>
                                    <p class="intro" style="font-size:13px; white-space: pre-wrap; margin-top:15px">${json.introduction}</p>
                                </div>
        
                            </div>
                        </div>
                    
                    
                    `);

                    if(json.image == "basic.jpg")
                        profilePopUp.querySelector("img").src = "/upload/profile/basic.jpg";
                    if(json.introduction == "")
                        profilePopUp.querySelector(".intro").innerHTML = "작성된 자기소개가 없습니다..."
                   
                     document.body.append(profilePopUp);
        
        
        
             
        
                    //screen onclick되면 사라짐
                    screen.onclick = (e) =>{
                        screen.remove();
                        profilePopUp.remove();
                        
                    };





            });



        }

    });


});
        
