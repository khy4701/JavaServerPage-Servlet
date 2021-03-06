package exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckIdServlet
 */
@WebServlet("/CheckIdServlet")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		System.out.println("id : " + id);

		
		try {
			//1. JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. JDBC 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			// 마지막 날짜는 Default로 정의한 값으로 넣어줌
			String sql = "select id from member where id = ?";
			PreparedStatement psmt = con.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			ResultSet rs = psmt.executeQuery();
			
			// 4.결과 처리
			PrintWriter out = response.getWriter();
			if( rs.next())
			{				
/*				out.print("{\"id\" : \""+ rs.getString("id") + "\"}");
				System.out.println("{\"id\" : \""+ rs.getString("id") + "\"}");*/
				out.print("{\"asdasd\" : \""+ "asdasd" + "\"}");

			}else
				out.print("0");
			
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
		doGet(request, response);
	}

}
