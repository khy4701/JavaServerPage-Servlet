package exam.action;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.dao.BoardDAO;
import exam.vo.BoardVO;

public class ListAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDAO dao = BoardDAO.getInstance();
		
		HttpSession session = request.getSession();		
		String id = (String)session.getAttribute("id");
		String word = request.getParameter("word");		
		
		ArrayList<BoardVO> arrayList = null;

		MovePage movePage = new MovePage();
		System.out.println("id : "+id);
			
		try {
			if( word == null)
				arrayList = dao.selectAll();
			else
				arrayList = dao.selectAll(word);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (arrayList != null) {
			System.out.println("출력 성공");
			request.setAttribute("BoardList", arrayList);
			movePage.setRedirect(false);
			movePage.setPageName("List.jsp");
		} else {
			request.setAttribute("errorMsg", "리스트 출력 실패 했습니다.");
			request.setAttribute("errorUrl", "List.jsp");
			movePage.setRedirect(false);
			movePage.setPageName("error/error.jsp");
		}
	
		return movePage;
		
	}

}
