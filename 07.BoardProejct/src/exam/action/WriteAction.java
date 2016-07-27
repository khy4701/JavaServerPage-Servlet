package exam.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import exam.dao.BoardDAO;
import exam.vo.BoardVO;

public class WriteAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("WriteAction");
		
		String path = request.getServletContext().getRealPath("upload");
		System.out.println(path);
		
		String id = null;
		String title = null;
		String content = null;
		String fileName = null;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			id = multi.getParameter("id");
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			fileName = multi.getFilesystemName("fileName");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		
		/*// 파일은 인코딩을 시키면 안됨.. --> 인코딩 안시키면  getParameter() 사용할 수 없음.		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String fileName = request.getParameter("fileName");*/
		
		BoardVO vo = new BoardVO();
		
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setFileName(fileName);
				
		MovePage movePage = new MovePage();
		int result = 0;
		
		try {
			result = dao.insertBoard(vo);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( result == 1)
		{			
			System.out.println("글쓰기 성공");
			movePage.setRedirect(true);
			movePage.setPageName("list.board");
		}
		else
		{
			request.setAttribute("errorMsg", "글쓰기가 실패하였습니다");
			movePage.setRedirect(false);
			movePage.setPageName("error/error.jsp");	
		}
		return movePage;
	}

}
