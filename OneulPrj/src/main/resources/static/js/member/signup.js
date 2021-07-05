window.addEventListener("load",function(){
	let checkid = document.querySelector(".checkid");
	
	$('.username').change(()=>{
		$('.checkid').show();
		$('#id_check_sucess').hide();
	})
	
	checkid.onclick=function(){
		$.ajax({
			url : "/member/checkid",
			type : "post",
			dataType : "json",
			data : {"username" : $('.username').val()},
			success : function(data){
				if(data==2){
					alert("아이디를 입력해주세요")
				}
				else if(data == 1){
					alert("중복된 아이디입니다.");
				}else if(data == 0){
					alert("사용가능한 아이디입니다.");
					$('#id_check_sucess').show();
					$('.checkid').hide();
					return;
				}
			}
		})
	}
	
	
})

function check(){
	let form = document.querySelector(".signup-form");
	let username = document.getElementsByName("username")[0]
	let password = document.getElementsByName("password")[0]
	let name = document.getElementsByName("name")[0]
	let email = document.getElementsByName("email")[0]
	
	if(username.value.length < 1){
		alert("아이디를 입력하세요")
		return false;
	}
	if(password.value.length < 1){
		alert("비밀번호를 입력하세요")
		return false;
	}
	if(name.value.length < 1){
		alert("이름을 입력하세요")
		return false;
	}
	if(email.value.length < 1){
		alert("이메일 입력하세요")
		return false;
	}

	form.submit();
}      