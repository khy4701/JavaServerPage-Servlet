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
<h1>게시판</h1>
<hr>
<c:if test ="${sessionScope.id != null }">
	<a href ="WriteForm.jsp">글쓰기 </a> <a href = "Logout.jsp">로그아웃</a>	
</c:if>
<form action = "list.kitri">

<table border="1">
<tr><th>글 번호</th><th>제목</th><th>첨부파일</th><th>조회수</th><th>다운수</th>
 <c:forEach var="component" items="${ requestScope.BoardList }">
   <tr><td>${component.num}</td>  
   
   <c:choose>
	<c:when test="${sessionScope.id != null }">
		<td><a href="view.kitri?id=${component.num}">${component.title}</a></td>
	</c:when>
	<c:when test="${sessionScope.id == null }">
		<td>${component.title}</td>
	</c:when>
   </c:choose>
   
   <%-- <td><a href = "upload/${component.fileName}">${component.fileName}</a></td> --%>
   <td><a href = "down.kitri?num=${component.num}&filename=${component.fileName}">${component.fileName}</a></td> 
   <td>${component.readCount }</td>
   <td>${component.downCount }</td></tr>

 </c:forEach>
 </table>
  <input type="text" name ="word">
  <input type="submit" value="검색">
</form>
</body>
</html>