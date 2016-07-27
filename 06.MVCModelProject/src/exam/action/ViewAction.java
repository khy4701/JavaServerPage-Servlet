package exam.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.dao.MemberDAO;
import exam.vo.MemberVO;

public class ViewAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("viewAction");
				
		String id = request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO member = null;
		
		try {
			member = dao.selectInfo(id);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MovePage movePage = new MovePage();
		if( member != null)
		{
			request.setAttribute("memberInfo", member);
			movePage.setRedirect(false);
			movePage.setPageName("View.jsp");
		}
		
		return movePage;
	}

}
