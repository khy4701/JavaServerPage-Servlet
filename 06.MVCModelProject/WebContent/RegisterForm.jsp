<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.1.0.js"></script>
<script>
	$(document).ready(function() {
		
		$("#btnCheck").click(function()
		{
			$.ajax( { 
				url: "CheckIdServlet",
				data : {"id" : $("#value_id").val()},   /*넘길 파라미터(id) : 값( input 태그의  id 값) */
				dataType: "json",
				success : function(data){ alert("성공" + data); console.log(data);},
				error : function(data) { alert("실패" + data) }
				// 서버 측에서 어떤 오류가 발생할 경우에 error가 수행됨.
			});			
		});

	})
</script>

</head>
<body>

<h1> Register Form</h1>
<hr>

<form action = "register.kitri" >

<fieldset>
<legend> 회원 가입 란 </legend>

<ul>
<li> 아이디 : <input type ="text" id="value_id" name="id" value="test"> 
<input type="button" value="중복확인" id="btnCheck" >
<li> 비밀번호 : <input type ="password" name="pw" value="1234">
<li> 이름 : <input type ="text" name="userName" value="기무">
<li> 나이 : <input type ="text" name="age" value="232">
<li> 주소 : <input type ="text" name="address" value="구로동">
<li> 전화번호 : <input type ="text" name="phoneNum" value="1234">
</ul>
<input type="submit" value="회원 가입">

</fieldset>
</form>

</body>
</html>