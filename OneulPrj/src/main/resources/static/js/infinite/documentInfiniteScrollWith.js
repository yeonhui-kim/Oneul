function isEmpty(param) {
  return Object.keys(param).length === 0;
}




//url containerClass callbackReceivedJsonReturningHTML 
// 이함수를 실행면 특정한container에 url로요청을해서 받은json객체를html로꽂아주는 역할을 하게된다
// 반드시 이함수를 실행할때 윈도우가 onload 된상태에서 실행하는것이 안전하겠다
function documentInfiniteScrollWith(requestUrl, containerClass, returningHTML,query,scrollClass) {




    // queyr undefined 이면 "" 넣어준다
    if(query === undefined) 
        query = ""; 
	
	
	
	// 스콜의 기준을 잡아줄 element 구해줌
	let scrollElement = document.querySelector(scrollClass);

    // 스크롤러블 초기값구해준다
    let scrollable = scrollElement.scrollHeight - parseInt(window.getComputedStyle(scrollElement).getPropertyValue('height'));

    // 맨처음 끝에 닿았을때 로딩되는 data는 requestUrl/2 부터 이다 그리고 한번 로딩되면 그다음에 닿으면 request/3 이다
    // 밑에 count 1값은 로딩되자마자용되서 ++ 이되서 count는 바로 2가된다
    let count = 1;

    // 콘테이너 찾아놓는다
    let container = window.document.querySelector(containerClass);

    // 함수실행되면 콘테이너에 있던거 일단 비운다
    container.innerHTML = "";

    // scrollElement.oncscroll 에넣어줄 callback 함수를 정의해준다 (스크롤값이 바뀔때마다실행되는 event함수)
    let infiniteScrollCallBack = () => {

        if (Math.floor(scrollElement.scrollTop) > scrollable-200) {

            // 로딩중에는 이벤트막아놈
            scrollElement.removeEventListener("scroll", infiniteScrollCallBack);


            // 로딩중 loading화면을 띄워줌
            let imgContainer = window.document.createElement("div");
            imgContainer.style.display="flex";
            imgContainer.style.justifyContent="center";
            let img = window.document.createElement("img");
            img.src = "/images/icon/loading.gif";
            img.style.width="100px";
            img.style.height="100px";
            // img imgContainer에 꽂아준다
            imgContainer.insertAdjacentElement("afterbegin",img);


            // container element 안에 로딩화면 띄워준다
            container.insertAdjacentElement("beforeend", imgContainer);


            // 비동기로 데이터 가져와서 해줄 콜백 정의
            fetch(`${requestUrl}/${count}?q=${query}`).then((response) => response.json(), ()=>{

                imgContainer.remove();
    
                // scrollable 최신화해줌
                scrollable = scrollElement.scrollHeight - parseInt(window.getComputedStyle(scrollElement).getPropertyValue('height'));
    
                // 다음페이지가 없기떄문에 이벤트를 다시살리지 않는다.
                container.insertAdjacentHTML("beforeend", "연결에 실패하였습니다. url을 확인해주세요.");
                return;
    
    
            }).then((json) => {
                if (!isEmpty(json))
                    container.insertAdjacentHTML("beforeend", returningHTML(json));
                else {
                    // loading중 없앰
                    imgContainer.remove();

                    // scrollable 최신화해줌
                    scrollable = scrollElement.scrollHeight - parseInt(window.getComputedStyle(scrollElement).getPropertyValue('height'));

                    // 다음페이지가 없기떄문에 이벤트를 다시살리지 않는다.
                    container.insertAdjacentHTML("beforeend", "다음 페이지가 없습니다");
                    return;
                }

                // adjacent 끝나기떄문에 loading중 없앰
                imgContainer.remove();
                
                // 로딩이끝나면 scroll을 제일 마지막 에봤던 위치로 보내준다
                scrollElement.scrollTo(0,scrollable-200);
                
                
                // scrollable 최신화해줌
                scrollable = scrollElement.scrollHeight - parseInt(window.getComputedStyle(scrollElement).getPropertyValue('height'));

                //로딩이끝났기떄문에 다시 event 채워줌
                scrollElement.addEventListener("scroll", infiniteScrollCallBack);
                
                count++;

            });


        }

    };


            //최초호출시 한번 로딩


            // 로딩중에는 이벤트막아놈
            scrollElement.removeEventListener("scroll", infiniteScrollCallBack);


            // 로딩중 loading화면을 띄워줌
            let imgContainer = window.document.createElement("div");
            imgContainer.style.display="flex";
            imgContainer.style.justifyContent="center";
            let img = window.document.createElement("img");
            img.src = "/images/icon/loading.gif";
            img.style.width="100px";
            img.style.height="100px";
            // img imgContainer에 꽂아준다
            imgContainer.insertAdjacentElement("afterbegin",img);


            // container 안에 로딩화면 띄워준다
            container.insertAdjacentElement("beforeend", imgContainer);


            // 비동기로 데이터 가져와서 해줄 콜백 정의
            fetch(`${requestUrl}/${count}?q=${query}`).then((response) => response.json(), ()=>{

                imgContainer.remove();
    
                // scrollable 최신화해줌
                scrollable = scrollElement.scrollHeight - parseInt(window.getComputedStyle(scrollElement).getPropertyValue('height'));
    
                // 다음페이지가 없기떄문에 이벤트를 다시살리지 않는다.
                container.insertAdjacentHTML("beforeend", "연결에 실패하였습니다. url을 확인해주세요.");
                return;
    
    
            }).then((json) => {
                if (!isEmpty(json)){
                    container.insertAdjacentHTML("beforeend", returningHTML(json));
                    // adjacent 끝나기떄문에 loading중 없앰
                    imgContainer.remove();
                    
                    // 로딩이끝나면 scroll을 제일 마지막 에봤던 위치로 보내준다
                    scrollElement.scrollTo(0,0);
                    
                    
                    // scrollable 최신화해줌
                    scrollable = scrollElement.scrollHeight - parseInt(window.getComputedStyle(scrollElement).getPropertyValue('height'));

                    //로딩이끝났기떄문에 다시 event 채워줌
                    scrollElement.addEventListener("scroll", infiniteScrollCallBack);

                    count++;
                }else {
                    // loading중 없앰
                    imgContainer.remove();

                    // scrollable 최신화해줌
                    scrollable = scrollElement.scrollHeight - parseInt(window.getComputedStyle(scrollElement).getPropertyValue('height'));

                    // 다음페이지가 없기떄문에 이벤트를 다시살리지 않는다.
                    container.insertAdjacentHTML("beforeend", "다음 페이지가 없습니다");
                    return;
                }



            });





};


