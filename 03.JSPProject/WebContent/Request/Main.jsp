<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
<h1>Main Page</h1>
<hr>

<%
  
String id = (String)session.getAttribute("id");
String pw = (String)session.getAttribute("password");

%>

<%= id %> 님 환영합니다. <a href= "Logout.jsp">로그아웃</a>



</body>
</html>