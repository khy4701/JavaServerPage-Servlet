<%@page import="exam.dao.MemberVO"%>
<%@page import="exam.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");

	MemberDAO dao = new MemberDAO();
	MemberVO member = dao.selectInfo(id);
%>
    <table border ="1">
    	<tr><td> Id		 </td> <td> <%=member.getId() %>  </td></tr>
    	<tr><td> Password</td> <td> <%=member.getPw() %>  </td></tr>
    	<tr><td> Name	 </td> <td> <%=member.getUserName() %>  </td></tr>
    	<tr><td> Age	 </td> <td> <%=member.getAge() %>  </td></tr>
    	<tr><td> Address </td> <td> <%=member.getAddress() %>  </td></tr>
    	<tr><td> Date	 </td> <td> <%=member.getRegDate() %>  </td></tr>    	
    </table>
    
</body>
</html>