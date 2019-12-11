package net.movie.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.movie.db.MovieBean;
import net.movie.db.MovieDAO;

public class MovieAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MovieDAO moviedao = new MovieDAO();
		MovieBean moviebean = new MovieBean();
		ActionForward forward = new ActionForward();
		
		String realFolder="";
		String saveFolder="/movieupload";
		
		int fileSize=5*1024*1024;
		
		realFolder=request.getSession().getServletContext().getRealPath(saveFolder);
		
		boolean result = false;
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realFolder,fileSize,"UTF-8",new DefaultFileRenamePolicy());
			
			moviebean.setMOVIE_POSTER(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			moviebean.setMOVIE_SUBJECT(multi.getParameter("MOVIE_SUBJECT"));
			moviebean.setMOVIE_START(multi.getParameter("MOVIE_START"));
			moviebean.setMOVIE_END(multi.getParameter("MOVIE_END"));
			
			result = moviedao.movieInsert(moviebean);
			
			if(result==false) {
				System.out.println("영화 등록 실패");
				return null;
			}
			System.out.println("영화 등록 성공");
			
			forward.setRedirect(true);
			forward.setPath("./MovieList.mo");
			return forward;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
