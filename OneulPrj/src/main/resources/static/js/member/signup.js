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
				if(data == 1){
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