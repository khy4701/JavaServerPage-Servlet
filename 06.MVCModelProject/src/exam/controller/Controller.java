package exam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.action.Action;
import exam.action.DeleteAction;
import exam.action.ListAction;
import exam.action.LoginAction;
import exam.action.MovePage;
import exam.action.RegisterAction;
import exam.action.ViewAction;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.kitri")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// "/06.MVCModelProject/*.kitri"
		String uri = request.getRequestURI();
		
		// "/06.MVCModelProject"
		String path = request.getContextPath();
		
		// "/*.kitri"
		String cmd = uri.substring(path.length());
		
		/*
		URL 목록
		회원가입 : register.kitri
		로그인 : login.kitri
		정보삭제 : delete.kitri
		리스트 : list.kitri
		상세내용 : view.kitri
		*/	
		
		MovePage movePage = null;
		Action action = null;
		
		switch(cmd)
		{
		case "/register.kitri" :
			System.out.println("회원 가입");
			action = new RegisterAction();
			movePage = action.execute(request, response);
			break;
			
		case "/login.kitri" :
			action = new LoginAction();
			movePage = action.execute(request, response);
			break;
			
		case "/delete.kitri" :
			action = new DeleteAction();
			movePage = action.execute(request, response);			
			break;
			
		case "/list.kitri" :
			action = new ListAction();
			movePage = action.execute(request, response);
			break;
			
		case "/view.kitri" :
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
