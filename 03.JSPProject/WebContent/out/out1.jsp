<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="10kb"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> out 객체 : 버퍼 </h1>
<hr>

<ul>
  <li> getBufferSize() : <%=out.getBufferSize() %>
  <li> getRemaining() : <%= out.getRemaining()  %>
  <%-- <% out.clear(); %> --%>
  <br>Flush 사용.<br><%out.flush(); %>
  <li> getRemaining() : <%= out.getRemaining() %>

</ul>
</body>
</html>