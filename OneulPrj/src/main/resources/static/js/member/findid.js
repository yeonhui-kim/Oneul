function check(){
    let form = document.querySelector(".findid-form");
    let name = document.getElementsByName("name")[0]
    let email = document.getElementsByName("email")[0]
    
    if(name.value.length < 1){
        alert("이름을 입력하세요")
        return false;
    }
    if(email.value.length < 1){
        alert("이메일 입력하세요")
        return false;
    }
    let emailexp = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/
	if(!emailexp.test(email.value)){
		alert("이메일 형식을 지켜주세요")
		return false;
	}

    form.submit();
}