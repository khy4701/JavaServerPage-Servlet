package exam.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterMemberSevlet
 */
@WebServlet("/registerMember")
public class RegisterMemberSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterMemberSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		String phoneNum = request.getParameter("phoneNum");
		String address = request.getParameter("address");
					
		// 1. JDBC ����̹� �ε�
		// 2. JDBC ����
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO(id,pw, userName,Integer.parseInt(age),phoneNum,address);
		
		
		// 3. SQL�� ����
		int result = dao.insertMember(vo);
		
		// 4. ��� ó��
		PrintWriter out = response.getWriter();
		if( result == 1 )
			System.out.println("�Է� ����");
		
		ArrayList<MemberVO> arrayList = dao.selectAll();
		
		
		// 5. �ڿ� �ݳ�
		dao.close();
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}