package exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main.kitri")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MainServlet - Get");	
		// Charset: UTF-8로 설정 및, HTML을 추가해아함.
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();		
		String id =  (String)session.getAttribute("id");	
		
		String gid =  (String)session.getAttribute("gid");
		System.out.println(gid);
		
		PrintWriter out = response.getWriter();		
		out.println(id+"님 환영합니다."+ "<a href = \"LogoutServlet\" >로그아웃</a> ");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MainServlet - Post");	
	}

}
