<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Request 객체 - login.jsp</h1>
<hr>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pwd");

	if(id.equals("test") && pw.equals("1234"))
	{
		// Main.jsp로 이동
		
		// 1) Redirect 방법
        // 서버에서 바로 Response하여 다시 Request로 요청하는 방법(다시 요청시 새로운 사용자로 인식)
        // http://localhost:8100/03.JSPProject/Request/LoginForm.jsp 에서 
        // http://localhost:8100/03.JSPProject/Request/Main.jsp로 주소 변경됨
		
        // 세션 생성
        session.setAttribute("id", id);
		session.setAttribute("password", pw);
        
        response.sendRedirect("menu.jsp");
		
		
		
		// 2) Forward 방법
        // 서버에서 페이지 변경을 끝내고 돌려주는 방법.
        //  http://localhost:8100/03.JSPProject/Request/LoginForm.jsp 에서 
		// http://localhost:8100/03.JSPProject/Request/Login.jsp?id=test&pwd=1234 로 변경.
		/* RequestDispatcher dispatcher = request.getRequestDispatcher("Main.jsp");
		dispatcher.forward(request, response); */
	}
	else
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("LoginForm.jsp");
		dispatcher.forward(request, response);
	}
	
%>

</body>
</html>