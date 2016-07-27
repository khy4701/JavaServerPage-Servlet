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
<h1> 총 방문자 수 - application.jsp</h1>
<hr>

<%
	int count= 0;

	if (application.getAttribute("countt") == null) {
		count++;
		application.setAttribute("countt", count);
			
	} else {
		
		count = (int) application.getAttribute("countt");
		
		if( session.isNew())
		{
			count++;
		}
		application.setAttribute("countt", count);		
	}
%>

<%= count %>명 입장함.


</body>
</html>