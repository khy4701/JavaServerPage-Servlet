package exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class MemberDAO {

	Connection con = null;
	ResultSet rs = null;
	PreparedStatement psmt = null;
	
	public MemberDAO()
	{		
		try {
			//1. JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. JDBC 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	// 회원가입
	public int insertMember(MemberVO vo){
		System.out.println("MemberDAO - insertMember()");
		
		// 마지막 날짜는 Default로 정의한 값으로 넣어줌
		String sql = "insert into member values(?,?,?,?,?,?,default)";
		int result = 0;
		PreparedStatement psmt;
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getUserName());
			psmt.setInt(4, vo.getAge());
			psmt.setString(5, vo.getAddress());
			psmt.setString(6, vo.getPhoneNum());

			result = psmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	// 중복확인
	
	// 리스트
	public ArrayList<MemberVO> selectAll()
	{
		String sql = "select * from member order by id";
		PreparedStatement psmt;
		
		ArrayList<MemberVO> arrayList = new ArrayList<MemberVO>();
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
						
			while(rs.next())
			{
				//String id, String pw, String userName, int age, String phoneNum, String address
				MemberVO member = new MemberVO();
				
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pwd"));
				member.setAge(rs.getInt("age"));
				member.setUserName(rs.getString("name"));
				member.setAddress(rs.getString("addr"));
				member.setPhoneNum(rs.getString("tel"));							
				member.setRegDate(rs.getDate("reg_date"));
				
				arrayList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayList;
	}

	// 로그인

	// 자원 반납
	public void close() {
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
	
	public MemberVO selectInfo(String id)
	{
		String sql = "select * from member where id = ?";
		PreparedStatement psmt;
		MemberVO member = new MemberVO();
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();						
			
			if( rs.next())
			{
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pwd"));
				member.setAge(rs.getInt("age"));
				member.setUserName(rs.getString("name"));
				member.setAddress(rs.getString("addr"));
				member.setPhoneNum(rs.getString("tel"));							
				member.setRegDate(rs.getDate("reg_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
	
	public boolean Login(String id, String pw)
	{

		String sql = "select * from member where id = ? and pwd = ? ";
		PreparedStatement psmt;
		
		try {
			System.out.println(id +" " + pw);
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
					
			if( rs.next() )
			{
				System.out.println("데이터 찾음");
				return true;
			}
			System.out.println("데이터 못찾음");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	// 회원 삭제
	public int deleteMember(String id){
		
		String sql= " delete from member where id = ?";
		PreparedStatement psmt;
		int result = 0;
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			
			result = psmt.executeUpdate();
			
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;		
		
	}

}
