<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
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
</body>
</html>