<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String first_num = request.getParameter("first");
	String second_num = request.getParameter("second");
	String operator = request.getParameter("opearator");

	int result =0 ;
	
	if(operator.equals("plus"))
		result = Integer.parseInt(first_num) + Integer.parseInt(second_num);
	else if( operator.equals("sub"))
		result = Integer.parseInt(first_num) - Integer.parseInt(second_num);
	else if( operator.equals("mul"))
		result = Integer.parseInt(first_num) * Integer.parseInt(second_num);
	else if( operator.equals("div"))
		result = Integer.parseInt(first_num) / Integer.parseInt(second_num);
	

	out.print(result);
%>

</body>
</html>