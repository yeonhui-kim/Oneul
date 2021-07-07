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
				}else if(data == 3){
					alert("아이디는 영문 소문자와 숫자 4~12자리로 입력해야합니다!");
				}else if(data == 1){
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
	
	if(username.value == ''){
		alert("아이디를 입력하세요")
		return false;
	}
	let unexp = /^[a-z0-9]{4,12}$/
	if(!unexp.test(username.value)){
		alert("아이디는 영문 소문자와 숫자 4~12자리로 입력해야합니다!")
		return false;
	}
	
	if(password.value == ''){
		alert("비밀번호를 입력하세요")
		return false;
	}
	let pwdexp = /^[a-z0-9]{4,15}$/
	if(!pwdexp.test(password.value)){
		alert("비밀번호는 영문 소문자,숫자 4~15자리로 입력하세요")
		return false;
	}

	if(name.value == ''){
		alert("이름을 입력하세요")
		return false;
	}
	let nexp = 	/^[가-힣]+$/
	if(!nexp.test(name.value)){
		alert("이름은 한글만 입력 가능합니다")
		return false;
	}

	if(email.value == ''){
		alert("이메일 입력하세요")
		return false;
	}
	let emailexp = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/
	if(!emailexp.test(email.value)){
		alert("이메일 형식을 지켜주세요")
		return false;
	}


	alert("회원가입이 완료되었습니다")
	form.submit();
}      