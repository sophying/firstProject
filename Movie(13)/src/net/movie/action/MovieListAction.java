package net.movie.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.movie.db.MovieDAO;

public class MovieListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		MovieDAO moviedao = new MovieDAO();
		List movielist = new ArrayList();
		
		movielist = moviedao.getMovieList();
		
		request.setAttribute("movielist", movielist);
		
		forward.setRedirect(false);
		forward.setPath("./movie/movie_list.jsp");
		return forward;
	}

}
