package exam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String CONN_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String CONN_ID = "hr";
	private static final String CONN_PWD = "hr";
			
	static {
		try {
			//1. JDBC 드라이버 로드
			Class.forName(JDBC_DRIVER);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}

	
	// 연결
	public static Connection getConnetion()
	{
		//2. JDBC 연결
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONN_URL, CONN_ID, CONN_PWD);
			System.out.println("connection 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;		
	}
	
	// 연결 종료 ( executeUpdate() 사용 시 )
	public static void close(Connection con, PreparedStatement psmt) {
		try {

			if (psmt != null)
				psmt.close();

			if (con != null)
				con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 연결 종료 ( executeQuery() 사용 시 )
	public static void close(Connection con, PreparedStatement psmt, ResultSet rs)
	{
		try {
			if (rs != null)
				rs.close();
			
			if( psmt != null )
				psmt.close();
			
			if( con != null )
				con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
