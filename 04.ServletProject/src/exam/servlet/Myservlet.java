package exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Myservlet
 */
@WebServlet("/LoginServlet")
// Ŭ������ �����ϱ� ���� ��θ� �������� (URL ����)
// ������̼��� �ڵ�� ���� �ش� Ŭ������ �ڵ����� ������. 
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myservlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// response setContentType���� ������ html�� �ν����� ���Ͽ�,
		// <br> �±׿� ���� ���� �ν����� ���Ѵ�. 
		
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("doGet");
				
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		System.out.println("id : "+ id);
		System.out.println("pw : "+ pw);
		
		if(id.equals("test") && pw.equals("1234"))
		{
			// Servlet������ Session�� �ڵ����� ������� ���� �ʱ� ������
			// Session�� �����;���.			
			HttpSession session = request.getSession();
			
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			
			response.sendRedirect("main.kitri");
			
//			 RequestDispatcher dispatcher = request.getRequestDispatcher("MainServlet");
//				dispatcher.forward(request, response);
		}else
		{
			
		}
		// Servlet -> ȭ�鿡 ����ϴ� ���.
		PrintWriter out = response.getWriter();
		out.print( request.getParameter("id") + "<br>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		doGet(request, response);
	}

}