<%@page import="exam.dao.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="exam.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	MemberDAO dao = new MemberDAO();

	ArrayList<MemberVO> arrayList = dao.selectAll();
	
	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
	
	if( id !=null && pw != null)
	{
		out.print(id+"님 환영 합니다.");
	}
	
	out.print("<table border='1'>");
	for( MemberVO i : arrayList)
	{
		out.print("<tr><td><a href='view.jsp?id="+i.getId()+"'>"+i.getId()+"</td>");
		out.print("<td><a href='delete?id="+i.getId()+"'>삭제" );
		
		out.print("</td></tr>"); 			
	}
	out.print("</table>");
	
%>
</body>
</html>