function check(){
    let form = document.querySelector(".login-form");
    let username = document.getElementsByName("username")[0]
    let password = document.getElementsByName("password")[0]

    if(username.value.length < 1){
        alert("아이디를 입력하세요")
        return false;
    }
    if(password.value.length < 1){
        alert("비밀번호를 입력하세요")
        return false;
    }

    form.submit()
}