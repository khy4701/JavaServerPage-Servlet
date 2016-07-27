package exam.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		String phoneNum = request.getParameter("phoneNum");
		String address = request.getParameter("address");
				
		
		try {
			//1. JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. JDBC 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			// 마지막 날짜는 Default로 정의한 값으로 넣어줌
			String sql = "insert into member values(?,?,?,?,?,?,default)";
			
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, userName);
			psmt.setInt(4, Integer.parseInt(age));
			psmt.setString(5, address);
			psmt.setString(6, phoneNum);
			
			int result = psmt.executeUpdate();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		String phoneNum = request.getParameter("phoneNum");
		String address = request.getParameter("address");
				
		
		try {
			//1. JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. JDBC 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			// 마지막 날짜는 Default로 정의한 값으로 넣어줌
			String sql = "insert into member values(?,?,?,?,?,?,default)";
			
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, userName);
			psmt.setInt(4, Integer.parseInt(age));
			psmt.setString(5, address);
			psmt.setString(6, phoneNum);
			
			int result = psmt.executeUpdate();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
