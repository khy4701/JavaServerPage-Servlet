package exam.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import exam.dao.ReplyDAO;
import exam.vo.ReplyVO;

public class ReplyDeleteAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("ReplyDeleteAction");
		
		
		String replyNum = request.getParameter("replyNum");
		String boardNum = request.getParameter("boardNum");

		
		ReplyDAO dao = ReplyDAO.getInstance();
		
		int result = 0;
		
		try {
			result = dao.deleteReply(Integer.parseInt(replyNum));
			
			if( result == 1)
			{
				List<ReplyVO> arrayList = dao.selectAll(Integer.parseInt(boardNum));
				JSONArray array = new JSONArray();
				
				for(ReplyVO r : arrayList){
					JSONObject obj = new JSONObject();
					
					obj.put("write_date", String.valueOf(r.getWrite_date()));
					obj.put("content", r.getContent());				
					obj.put("id", r.getId());
					obj.put("num", r.getNum());
					
					array.add(obj);
				}
				
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();			
				out.print(array);				
			}
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
