package exam.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.dao.BoardDAO;
import exam.dao.ReplyDAO;
import exam.vo.BoardVO;
import exam.vo.ReplyVO;

public class ViewAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BoardDAO dao = BoardDAO.getInstance();		
		int board_id = Integer.parseInt(request.getParameter("id"));	
		BoardVO content =null;
		List<ReplyVO> arrayList  = null;
		
		System.out.println(board_id);
		try {			
			dao.updateByNum(board_id);
			content = dao.selectByNum(board_id);
			arrayList = ReplyDAO.getInstance().selectAll(board_id);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MovePage movePage = new MovePage();
		if( content != null)
		{
			request.setAttribute("ContentInfo", content);
			request.setAttribute("ReplyList", arrayList);
			movePage.setRedirect(false);
			movePage.setPageName("View.jsp");
		}
		else
		{
			request.setAttribute("errorMsg", "세부 보기 실패하였습니다");
			movePage.setRedirect(false);
			movePage.setPageName("error/error.jsp");
		}
		return movePage;
	}

}
