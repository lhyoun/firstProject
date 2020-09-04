<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">

</head>
<body>
<div class="login-page">
  <div class="form">
    <form class="login-form" action="login.do" >
      <input type="text" id="id" name="id" placeholder="username"/>
      <input type="password" id="pw" name="pw" placeholder="password"/>
      <button type="submit" id="btnLogin">login</button>
      <p class="message">계정생성은 본사에 문의하세요.</p>
    </form>
  </div>
</div>

<script>
// $('.message a').click(function(){
//    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
// });

// $("#btnLogin").on('click', function () {
// 	var query={"id":$("#id").val(), "pw":$("#pw").val()};
// 	$.ajax({
// 		type:"post",
// 		url:"login.do",
// 		async:false,
// 		data:query,
// 		dataType:"text",
// 		success:function(data,textStatus){
// 			if(data=="로그인 되었어요"){
// 				location.href="main.do";
// 			}else if(data=="비밀번호를 확인하세요"){
// 				alert("비밀번호를 확인하세요")
// 			}else{
// 				alert("아이디를 확인하세요")
// 			}
// 		}, error:function(data,textStatus){
// 			alert("error")
// 		}, complete:function(data,textStatus){}
// 	});
// }); 

</script>
</body>
</html>