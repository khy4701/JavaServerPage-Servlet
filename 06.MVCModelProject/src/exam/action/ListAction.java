package exam.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.dao.MemberDAO;
import exam.vo.MemberVO;

public class ListAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		MemberDAO dao = MemberDAO.getInstance();
		
		HttpSession session = request.getSession();		
		String id = (String)session.getAttribute("id");
		
		ArrayList<MemberVO> arrayList = null;

		MovePage movePage = new MovePage();
		System.out.println("id : "+id);
			
		if( id != null )
		{
			if(id.toUpperCase().equals("ADMIN"))
			{
				try {	
					arrayList = dao.selectAll();					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
				if( arrayList!= null)
				{
					System.out.println("��� ����");				
					request.setAttribute("MemberList", arrayList);			
					movePage.setRedirect(false);
					movePage.setPageName("List.jsp");
				}				
				else 
				{					
					request.setAttribute("errorMsg", "����Ʈ ��� ���� �߽��ϴ�.");
					request.setAttribute("errorUrl", "List.jsp");
					movePage.setRedirect(false);
					movePage.setPageName("error/error.jsp");
				}
			}
			else
			{
				request.setAttribute("errorMsg", "�����ڸ� ���� �����մϴ�.");
				request.setAttribute("errorUrl", "LoginForm.jsp");
				movePage.setRedirect(false);
				movePage.setPageName("error/error.jsp");
			}
		}				
		return movePage;
	}

}