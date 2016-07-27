package exam.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.dao.MemberDAO;

public class LoginAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("LoginAction");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		
		MemberDAO dao = MemberDAO.getInstance();

		boolean IsSuccess = false;
		try {
			IsSuccess = dao.login(id, pw);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		MovePage movePage = new MovePage();
		if(IsSuccess)
		{
			System.out.println("�α��ο� �����Ͽ����ϴ�. ");
			HttpSession session = request.getSession();
			session.setAttribute("id", id);			
			
			movePage.setRedirect(true);
			movePage.setPageName("list.kitri");
		}
		else
		{
			request.setAttribute("errorMsg", "�α��ο� �����Ͽ����ϴ�. ���̵�� ��й�ȣ�� Ȯ���ϼ���.");
			request.setAttribute("errorUrl", "LoginForm.jsp");
			movePage.setRedirect(false);
			movePage.setPageName("error/error.jsp");
		}
		
		return movePage;
	}

}