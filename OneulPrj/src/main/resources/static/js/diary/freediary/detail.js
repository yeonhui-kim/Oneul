/**
window.addEventListener("load",function(){
	
 let testForm = document.querySelector('#testForm');
 let commentId = testForm.firstElementChild;
 let commentDelBtn = document.querySelector('#commentDelBtn');
 let sectionClass = document.querySelector('.sectionClass');
 
	console.log(commentDelBtn);

	let request = new XMLHttpRequest();
	
	request.onload = function(){
		let list = JSON.parse(request.responseText);
		
		for(let i=0;i<list.length;i++){
			let div=`<div id="reply">
			<ol>
				<p>${list[i].id}</p>
				<p>${list[i].regDate}</p>
				<p>${list[i].content}</p>
				<a>수정</a>
				<a onclick="if(!confirm('정말 삭제하시겠습니까?')) return false;">삭제</a>
			</ol>
		</div>`;
		sectionClass.insertAdjacentHTML("beforeend",div)
		}	
	};
	request.open("GET","http://localhost:8080/diary/freediary/detail?id=6",true);
	request.send(null);	
 
	
})

function getPost(){
	testForm.action = "commentdel";
	commentId.value = "${n.id}";
}
 */
