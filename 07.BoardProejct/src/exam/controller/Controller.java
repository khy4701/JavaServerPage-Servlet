package exam.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.action.Action;
import exam.action.MovePage;

/**
 * Servlet implementation class Controller
 */
// 
@WebServlet(urlPatterns="*.kitri", initParams={@WebInitParam(name="url", value="url.properties")})


public class Controller extends HttpServlet {
	private Map<String,Action> maps ;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		maps = new HashMap<>();
		
		String url=config.getInitParameter("url");
		System.out.println(url);
		
		// 실제 경로를 가져옴
		String path = config.getServletContext().getRealPath(url);
		
		System.out.println(path);
		Properties prop = new Properties();
		
		try {
			InputStream is = new FileInputStream(path);
			
			prop.load(is);
			System.out.println(prop);
			
			Iterator it = prop.keySet().iterator();
			
			while(it.hasNext())
			{
				String key = (String)it.next();
				String value = prop.getProperty(key);
				
				System.out.println(key+", "+value);
				
				// 클래스 로드
				Class<?> clazz = Class.forName(value);
				
				// 클래스 객체화
				Action action = (Action)clazz.newInstance();
				
				maps.put(key, action);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

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

		String uri = request.getRequestURI();
		
		String path = request.getContextPath();
		
		String cmd = uri.substring(path.length()+1);
		
		/*System.out.println("cmd = " + cmd + maps.get(cmd));*/
		
		Action action = maps.get(cmd);
		MovePage movePage = null;
		
		if( action != null)
		{
			movePage = action.execute(request, response);
		}
		
		// Redirect
		if(movePage == null){
			System.out.println("이동할 페이지가 없습니다.");
		}
		else 
		{
			if (movePage.isRedirect()) {
				response.sendRedirect(movePage.getPageName());
			}
			// Forward
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(movePage.getPageName());
				dispatcher.forward(request, response);
			}
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
