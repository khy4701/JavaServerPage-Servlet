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
// 클래스를 접근하기 위한 경로를 제공해줌 (URL 역할)
// 어노테이션의 코드로 인해 해당 클래스가 자동으로 생성됨. 
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
		
		// response setContentType하지 않으면 html로 인식하지 못하여,
		// <br> 태그와 같은 것이 인식하지 못한다. 
		
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("doGet");
				
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		System.out.println("id : "+ id);
		System.out.println("pw : "+ pw);
		
		if(id.equals("test") && pw.equals("1234"))
		{
			// Servlet에서는 Session이 자동으로 만들어져 있지 않기 때문에
			// Session을 가져와야함.			
			HttpSession session = request.getSession();
			
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			
			response.sendRedirect("main.kitri");
			
//			 RequestDispatcher dispatcher = request.getRequestDispatcher("MainServlet");
//				dispatcher.forward(request, response);
		}else
		{
			
		}
		// Servlet -> 화면에 출력하는 방법.
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
