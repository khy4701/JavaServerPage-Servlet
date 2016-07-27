<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "addCart.jsp">
<%
    String id = (String)session.getAttribute("id");
    String pw = (String)session.getAttribute("password"); 
    		
    if(id.equals("test") && pw.equals("1234"))
    { 	
    	out.print(id+"님 환영합니다.");
        out.print("<a href= \"Logout.jsp\">로그아웃</a>");
    }
    else
    	response.sendRedirect("LoginForm.jsp");    	
%>

 <fieldset>
 	<legend>메뉴목록</legend>
 	<input type="radio" name="menu" value="사과">사과
 	<input type="radio" name="menu" value="복숭아">복숭아
 	<input type="radio" name="menu" value="배">배
 	<input type="radio" name="menu" value="포도">포도
 	
 </fieldset>
<input type="submit" value ="장바구니" ><br>
</form>
</body>
</html>