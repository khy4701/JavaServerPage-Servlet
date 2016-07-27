<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>영역에 값 설정 - getScope.jsp</h1>
<ul>
    <!-- session은 페이지를 껏다 키면 null로 변함(같은 브라우저 내에서만 유지) -->
	<li> Session 영역: <%= session.getAttribute("sessionScope") %>
	
	<!-- page 영역은 같은 페이지 내에서만 데이터 저장함 -->
	<li> Page 영역 : <%= pageContext.getAttribute("pageScope") %>
	
	<!-- redirect 방법으로 페이지 이동 : request 영역은 null
	forward 방법으로 페이지 이동 : request 영역은 그대로 유지 -->
	<li> Request 영역 : <%= request.getAttribute("requestScope") %>
	
	<!-- 서버를 끌 때 까지 영역의 값을 유지 -->
	<li> Application 영역 : <%= application.getAttribute("appScope") %>
</ul>
</body>
</html>