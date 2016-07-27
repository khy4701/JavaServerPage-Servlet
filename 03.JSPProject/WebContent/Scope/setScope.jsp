<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>영역에 값 설정 - setScope.jsp</h1>

<%
	pageContext.setAttribute("pageScope", "PAGE");
	session.setAttribute("sessionScope", "SESSION");
	request.setAttribute("requestScope", "REQUEST");
	application.setAttribute("appScope", "APPLICATION");
	
	response.sendRedirect("getScope.jsp");
	//request.getRequestDispatcher("getScope.jsp").forward(request, response);
	
%>

</body>
</html>