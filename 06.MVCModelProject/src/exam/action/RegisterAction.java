package exam.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.dao.MemberDAO;
import exam.vo.MemberVO;

public class RegisterAction implements Action{

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("RegisterAction");
		
		// 1. 요청 파라미터 처리		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		String phoneNum = request.getParameter("phoneNum");
		String address = request.getParameter("address");
		//String id, String pw, String userName, int age, String phoneNum, String address
		MemberVO member = new MemberVO(id,pw,userName,Integer.parseInt(age),phoneNum,address);
		
		// 2. DB 처리			
		int result = 0;
		try {
			MemberDAO dao = MemberDAO.getInstance();	
			result = dao.insertMember(member);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3. 다음 페이지 이동
		MovePage movePage = new MovePage();
		if( result == 1)
		{
			movePage.setRedirect(true);
			movePage.setPageName("LoginForm.jsp");
		}else
		{
			// NullpointerException을 발생시키는 코드
			//throw new NullPointerException();
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다");
			request.setAttribute("errorUrl", "RegisterForm.jsp");
			movePage.setRedirect(false);
			movePage.setPageName("error/error.jsp");			
		}
		
		return movePage;
	}

}
