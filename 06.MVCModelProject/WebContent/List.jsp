<%@page import="exam.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <c:forEach var="i" begin="1" end ="10" step="2">
   ${i}
 </c:forEach>

<!-- 따옴표로 문자열 타입인지 아닌지 결정하기 때문에 아래와 같은 방법으로 사용
if문을 하나만 사용할 경우엔 core의 if문을 사용
2개 이상의 if문을 사용할 경우엔 choose문을 사용 -->

<c:if test ="${sessionScope.id != \"admin\" }">
	<c:redirect url ="LoginForm.jsp"/>	
</c:if>

<c:choose>
	<c:when test=""></c:when>
	<c:when test=""></c:when>
	<c:when test=""></c:when>	
</c:choose>


<table border="1">
 <c:forEach var="member" items="${ requestScope.MemberList }">
   <tr><td><a href="view.kitri?id=${member.id}">${member.id}</a></td>
   <td><a href="delete.kitri?id=${member.id}">삭제</td>
    </tr>
 </c:forEach>
 </table>
 
<%-- <%
  String id = (String)session.getAttribute("id");
  ArrayList<MemberVO> arrayList = (ArrayList<MemberVO>)request.getAttribute("MemberList");
  
  if(id != null)
  {
	  out.print(id+"님 환영합니다. <a href='Logout.jsp'>로그아웃</a><br>");
	  if(!id.toUpperCase().equals("ADMIN"))
	  {
		  out.print("Admin 계정만 리스트를 확인 할 수 있습니다.");
	  }
  }
  else
	  out.print("Login이 필요합니다.");
  
  out.print("<table border='1'>");
  
  if(arrayList != null)
  {
	  for( MemberVO i : arrayList)
		{
			out.print("<tr><td><a href='view.kitri?id="+i.getId()+"'>"+i.getId()+"</td>");
			out.print("<td><a href='delete.kitri?id="+i.getId()+"'>삭제" );
			
			out.print("</td></tr>"); 			
		}
  }
  out.print("</table>");
%> --%> 
 
 
</body>
</html>