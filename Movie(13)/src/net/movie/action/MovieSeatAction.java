package net.movie.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.movie.db.MovieBean;
import net.movie.db.MovieDAO;

public class MovieSeatAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		MovieBean moviebean = new MovieBean();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		String id = (String)session.getAttribute("id");
		
		MovieDAO moviedao = new MovieDAO();
		List movielist = new ArrayList();
		
		moviebean = moviedao.getCheckDetail(num);
		request.setAttribute("movielist", movielist);
		
		if (id==null) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('로그인이 필요합니다.');");
		out.println("location.href='./MemberLogin.me'");
		out.println("</script>");
		out.close();
		
		return null;
		
		}
		
		forward.setRedirect(false);
		forward.setPath("./movie/movie_seat.jsp");
		return forward;
	}

}
