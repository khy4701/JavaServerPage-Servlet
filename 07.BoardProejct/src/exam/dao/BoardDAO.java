package exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exam.util.DBManager;
import exam.vo.BoardVO;

public class BoardDAO {

	public static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance()
	{
		return dao;
	}
	
	public boolean login(String id, String pw) throws SQLException
	{
		System.out.println("BoardDAO - loginMember()");
		
		Connection con = DBManager.getConnetion();	
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		// ������ ��¥�� Default�� ������ ������ �־���
		String sql = "select * from member where id = ? and pwd = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1,id);
			psmt.setString(2,pw);			

			rs = psmt.executeQuery();
		
			if( rs.next())
				return true;			
			
		} finally{
			DBManager.close(con, psmt,rs);			
		}
			
		return false;
	}
	
	public ArrayList<BoardVO> selectAll(String word) throws SQLException
	{
		System.out.println("MemberDAO - selectAll()");
		
		Connection con = DBManager.getConnetion();	
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVO> arrayList = new ArrayList<BoardVO>();
		
		try {
		String sql = " select * from board b, member m where b.title like ? and m.id = b.id order by b.num asc" ;
		psmt = con.prepareStatement(sql);
		psmt.setString(1, "%"+word+"%");
		rs = psmt.executeQuery();
		
		while(rs.next())
		{
			BoardVO member = new BoardVO();
			member.setNum(rs.getInt("num"));
			member.setName(rs.getString("name"));
			member.setId(rs.getString("id"));
			member.setTitle(rs.getString("title"));
			member.setContent(rs.getString("content"));
			member.setWriteDate(rs.getDate("write_date"));
			member.setFileName(rs.getString("file_name"));
			member.setReadCount(rs.getInt("read_count"));
			member.setDownCount(rs.getInt("down_count"));
			arrayList.add(member);
		}
		}finally{
			DBManager.close(con, psmt,rs);	
		}
		
		return arrayList;
	}
	
	// �˻�� ���� ���
	public ArrayList<BoardVO> selectAll() throws SQLException
	{
		System.out.println("MemberDAO - selectAll()");
		
		Connection con = DBManager.getConnetion();	
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVO> arrayList = new ArrayList<BoardVO>();
		
		try {
		String sql = " select * from board b, member m where m.id = b.id order by b.num asc";
		psmt = con.prepareStatement(sql);
		
		rs = psmt.executeQuery();
		
		while(rs.next())
		{
			BoardVO member = new BoardVO();
			member.setNum(rs.getInt("num"));
			member.setName(rs.getString("name"));
			member.setId(rs.getString("id"));
			member.setTitle(rs.getString("title"));
			member.setContent(rs.getString("content"));
			member.setWriteDate(rs.getDate("write_date"));
			member.setFileName(rs.getString("file_name"));
			member.setReadCount(rs.getInt("read_count"));
			member.setDownCount(rs.getInt("down_count"));
			arrayList.add(member);
		}
		}finally{
			DBManager.close(con, psmt,rs);	
		}
		
		return arrayList;
	}
	
	public int insertBoard(BoardVO vo) throws SQLException
	{
		Connection con = DBManager.getConnetion();	
		PreparedStatement psmt = null;
		
		String sql = "insert into board values(board_id_seq.nextval,?,?,?,default,?,default,default)";
		int result = 0;
		
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getFileName());
			
			result = psmt.executeUpdate();
		}finally{
			DBManager.close(con, psmt);	
		}
		
		return result;
	}
	
	public BoardVO selectByNum(int number) throws SQLException
	{
		Connection con = DBManager.getConnetion();	
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BoardVO member =  null;
		
		String sql = "select * from board b, member m where num = ? and b.id = m.id";
		
		try {
			psmt = con.prepareStatement(sql);			
			psmt.setInt(1, number);
			
			rs = psmt.executeQuery();
						
			while(rs.next())
			{
				member = new BoardVO();
				member.setNum(rs.getInt("num"));
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setTitle(rs.getString("title"));
				member.setContent(rs.getString("content"));
				member.setWriteDate(rs.getDate("write_date"));
				member.setFileName(rs.getString("file_name"));
				member.setReadCount(rs.getInt("read_count"));
				member.setDownCount(rs.getInt("down_count"));
			}
			
		}finally{
			DBManager.close(con, psmt,rs);
		}		
		return member;		
	}
	
	public int updateByNum(int num) throws SQLException 
	{
		Connection con = DBManager.getConnetion();	
		PreparedStatement psmt = null;
		
		String sql = "update board set read_count = read_count+1 where num = ?";
		int result = 0;
		
		try {
			psmt = con.prepareStatement(sql);			
			psmt.setInt(1, num);
			
			result = psmt.executeUpdate();
		}finally{
			DBManager.close(con, psmt);	
		}		
		return result;
	}
	
	public int updateDownCountByNum(int num) throws SQLException 
	{
		Connection con = DBManager.getConnetion();	
		PreparedStatement psmt = null;
		
		String sql = "update board set down_count = down_count+1 where num = ?";
		int result = 0;
		
		try {
			psmt = con.prepareStatement(sql);			
			psmt.setInt(1, num);
			
			result = psmt.executeUpdate();
		}finally{
			DBManager.close(con, psmt);	
		}		
		return result;
	}
	
	
}