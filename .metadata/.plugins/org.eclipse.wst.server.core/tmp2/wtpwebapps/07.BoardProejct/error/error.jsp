<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>에러 페이지 Error.jsp</h1>
<hr>
<%
 String msg = (String)request.getAttribute("errorMsg");
 String backUrl = (String)request.getAttribute("errorUrl");
 
 out.print(msg+"<br>");
 out.print("<a href= '"+backUrl +"'>뒤로가기"); 
 
%>
</body>
</html>