package exam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.action.Action;
import exam.action.ListAction;
import exam.action.LoginAction;
import exam.action.MovePage;
import exam.action.ViewAction;
import exam.action.WriteAction;

/**
 * Servlet implementation class controller
 */
@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// "/07.BoardProject/*.board"
		String url = request.getRequestURI();

		// "/07.BoardProject
		String path = request.getContextPath();
		
		// /*.board
		String cmd = url.substring(path.length());		

		MovePage movePage = null;
		Action action = null;
		
		switch(cmd)
		{
		case "/login.board":
			action = new LoginAction();
			movePage = action.execute(request, response);
			break;
			
		case "/write.board":
			action = new WriteAction();
			movePage = action.execute(request, response);
			break;
			
		case "/list.board":
			action = new ListAction();
			System.out.println("??");
			movePage = action.execute(request, response);
			break;
			
		case "/view.board":
			action = new ViewAction();
			movePage = action.execute(request, response);
			break;
		}
		
		// Redirect
		if (movePage.isRedirect()) {
			response.sendRedirect(movePage.getPageName());
		}
		// Forward
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(movePage.getPageName());
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}