<%@page import="exam.vo.MemberVO"%>
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

<c:set var ="member" value= "${requestScope.memberInfo}"/>
<table border ="1">
    	<tr><td> Id		 </td> <td> ${member.id }        </td></tr>
    	<tr><td> Name	 </td> <td> ${member.userName }  </td></tr>
    	<tr><td> Tel	 </td> <td> ${member.phoneNum }  </td></tr>    
    	<tr><td> Age	 </td> <td> ${member.age }  	  </td></tr>
    	<tr><td> Address </td> <td> ${member.address }   </td></tr>
    	<tr><td> Date	 </td> <td> ${member.regDate }   </td></tr>
    	
</table>


<%-- <%
   MemberVO member = (MemberVO)request.getAttribute("memberInfo");

%>
 --%>
<%-- <table border ="1">
    	<tr><td> Id		 </td> <td> <%=member.getId() %>  </td></tr>
    	<tr><td> Password</td> <td> <%=member.getPw() %>  </td></tr>
    	<tr><td> Name	 </td> <td> <%=member.getUserName() %>  </td></tr>
    	<tr><td> Age	 </td> <td> <%=member.getAge() %>  </td></tr>
    	<tr><td> Address </td> <td> <%=member.getAddress() %>  </td></tr>
    	<tr><td> Date	 </td> <td> <%=member.getRegDate() %>  </td></tr>    	
</table> --%>

</body>
</html>