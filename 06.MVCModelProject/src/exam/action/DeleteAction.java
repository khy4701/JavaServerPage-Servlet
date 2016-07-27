package exam.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.dao.MemberDAO;

public class DeleteAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("deleteAction");
		
		String id = request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = 0;
		try {
			result = dao.deleteMember(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MovePage movePage = new MovePage();
		
		if( result == 1)
		{
			movePage.setPageName("list.kitri");
			movePage.setRedirect(true);
		}
		else
		{
			request.setAttribute("errorPage", "회원 삭제가 실패하였습니다.");
			movePage.setPageName("error/error.jsp");
			movePage.setRedirect(false);
		}
		
		return movePage;
	}

}
