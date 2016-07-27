package exam.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.dao.BoardDAO;

public class DownAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("DownAction");
		
		BoardDAO dao = new BoardDAO();
		String num = request.getParameter("num");
		String fileName = request.getParameter("filename");

		System.out.println(fileName);
		// 첨부파일로 하겠다.
		// Content-Type 타입 다운로드할 형식 을 때 이 헤더 어떻게 탐색기 이 파일 이름과 형식 말.
		try {			
			response.setHeader("Content-Disposition",
					"attachment; filename=" + new String(fileName.getBytes("UTF-8"), "8859_1")); // 다운로드를

			String path = request.getServletContext().getRealPath("upload");
			System.out.println(path);
			
			InputStream is = new FileInputStream(path+"\\"+fileName);
			ServletOutputStream sos = response.getOutputStream();
			
			byte []bytes = new byte[1000];
			int readByte = 0;
			while(( readByte = is.read(bytes)) != -1)
			{
				sos.write(bytes,0,readByte);
				System.out.println("down중..");
			}
			sos.flush();			
			sos.close();
			
		
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("뭔데 ? 넌 뭐야? 뭐냐고 ");
		
		
		int result = 0;
		try {
			result = dao.updateDownCountByNum(Integer.parseInt(num));
			
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		MovePage movePage = new MovePage();
		
		if(result == 1)
		{
			movePage.setPageName("list.kitri");
			movePage.setRedirect(true);
		}else
		{
			request.setAttribute("errorMsg", "다운로드 카운트 실패했습니다.");
			movePage.setRedirect(false);
			movePage.setPageName("error/error.jsp");
		}
		
		
		return movePage;
	}


}
