package exam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/main.kitri")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Filter - destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("Filter - Before doFilter()");
		
		// HttpServletRequest�� ServletRequest�� �ڽ� Ŭ�����μ�, JSP���� ����ϴ� Request�̴�.
		// ����, JSP�� Session�� Filter���� ��� ���� ���ؼ��� ���� ����ȯ�� ���ؼ� session���� ��� �;��Ѵ�. 
		// Response�� �����ϴ�.
		HttpServletRequest req = (HttpServletRequest) request;		
		HttpSession session = req.getSession();
		session.setAttribute("gid", "test231231");
		
		if( session.getAttribute("id") == null)
		{
			HttpServletResponse rep = (HttpServletResponse) response;
			rep.sendRedirect("LoginForm");
		}else
		{
			// filter�� ������ �Է��ϸ� �ȴ�. 
			// filter�� �Ϸᰡ �Ǹ� ���� ������ MainServlet.java�� �����Ѵ�.
			chain.doFilter(request, response);
		}
		
		System.out.println("Filter - After doFilter()");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter - init()");
	}

}