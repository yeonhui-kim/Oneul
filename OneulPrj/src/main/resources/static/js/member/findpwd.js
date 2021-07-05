function check(){
    let form = document.querySelector(".findpwd-form");
    let username = document.getElementsByName("username")[0]
    let name = document.getElementsByName("name")[0]
    let email = document.getElementsByName("email")[0]
    
    if(username.value.length < 1){
        alert("아이디를 입력하세요")
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