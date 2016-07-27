package exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exam.util.DBManager;
import exam.vo.ReplyVO;

public class ReplyDAO {

	public static ReplyDAO dao = new ReplyDAO();
	
	public static ReplyDAO getInstance()
	{
		return dao;
	}
	
	public int insertReply(ReplyVO reply) throws SQLException
	{
		int result = 0;
		
		Connection con = DBManager.getConnetion();
		String sql = " insert into reply values(reply_seq.nextval,?,?,default,?)";
		PreparedStatement psmt  = null;
		
		try {

			psmt = con.prepareStatement(sql);

			psmt.setString(1, reply.getId());
			psmt.setString(2, reply.getContent());
			psmt.setInt(3, reply.getBoard_num());

			result = psmt.executeUpdate();
		} finally {
			DBManager.close(con, psmt);
		}
		return result;
	}
	
	public List<ReplyVO> selectAll(int boardNum) throws SQLException
	{
		ArrayList<ReplyVO> arrayList = new ArrayList<ReplyVO>();
		
		Connection con = DBManager.getConnetion();
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from reply where board_num = ?";
			psmt = con.prepareStatement(sql);

			psmt.setInt(1, boardNum);
			rs = psmt.executeQuery();

			while (rs.next()) {
				ReplyVO vo = new ReplyVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setContent(rs.getString("content"));
				vo.setBoard_num(rs.getInt("board_num"));
				vo.setWrite_date(rs.getDate("write_date"));
				arrayList.add(vo);
			}
		} finally {
			DBManager.close(con, psmt, rs);
		}
		
		return arrayList;
	}
	
	public int deleteReply(int number) throws SQLException
	{
		int result = 0;
		
		Connection con = DBManager.getConnetion();
		
		String sql = "delete from reply where num = ?";
		
		PreparedStatement psmt = null;
		
		try{
			psmt= con.prepareStatement(sql);	
			
			psmt.setInt(1, number);
			result = psmt.executeUpdate();
			
		}finally{
			DBManager.close(con, psmt);
		}
		
		return result;
	}
}
