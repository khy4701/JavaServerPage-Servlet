<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> Login Form</h1>

<hr>

<!-- Servlet에서 Annotation으로 설정한 경로값을 입력 -->
<form action = "LoginServlet" >
	<fieldset>
		<legend>로그인</legend>
		<ul>
			<li> 아이디 : <input : type="text" name ="id">
			<li> 비밀번호: <input : type="password" name ="pwd">
					
		</ul>
		<input type="submit" value="로그인">
	</fieldset>
</form>
</body>
</html>