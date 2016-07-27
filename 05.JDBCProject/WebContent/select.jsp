<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "java.sql.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> JDBC - Select</h1>
<hr>
<%
	//1. JDBC 드라이버 로드
	// Driver Manager를 사용할 수 있도록 하기 위함
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		out.print("JDBC 드라이브 로드 성공!<br>");
	}catch(ClassNotFoundException e)
    {
		 out.print("JDBC 드라이브 로드 실패!<br>");
    }

	Connection con = null;
	
	try{
		//2. DB 서버 연결	
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		out.print("JDBC 연결 성공!<br>");
	}catch(SQLException e)
	{
		out.print("JDBC 연결 실패!<br>");
	}
	
	//3. SQL문 실행
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	try{
		String sql = "select * from employees";
		psmt = con.prepareStatement(sql);		
		rs = psmt.executeQuery();
		
		out.print("SQL 실행 성공!<br>");
	} catch (SQLException e) {
		out.print("SQL 실행 실패!<br>");
	}

	//4. 결과 처리
	out.print("<table border =\"1\">");
	out.print("<tr> <th>Employee_id</th> <th>First_name</th> ");
	out.print("<th>Last_name</th> <th>E-Mail</th> ");
	out.print("<th>Phone Number</th> <th>Hire_Date</th></tr> ");
	
	while(rs.next())
	{
		out.print("<tr><td>");
		out.print(rs.getInt("employee_id")+" ");
		out.print("</td><td>");
		out.print(rs.getString("first_name")+"<br>");
		out.print("</td><td>");
		out.print(rs.getString("last_name"));
		out.print("</td><td>");
		out.print(rs.getString("email"));
		out.print("</td><td>");
		out.print(rs.getString("phone_number"));
		out.print("</td><td>");
		out.print(rs.getString("hire_date"));
		out.print("</td><tr>");
	}
	
	
	//5. 자원 반납
	// 생성한것의 반대로 반납함.
	try {
		rs.close();
		psmt.close();
		con.close();
		out.print("자원 반납 성공!<br>");
	} catch (SQLException e) {
		out.print("자원 반납 실패!<br>");
	}
%>


</body>
</html>