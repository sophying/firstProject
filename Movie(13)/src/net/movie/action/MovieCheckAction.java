package net.movie.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.movie.db.MovieBean;
import net.movie.db.MovieDAO;

public class MovieCheckAction implements Action {
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
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+id+"님! 예매완료되었습니다.\\n"+"\\n예매정보 : \\n"+moviebean.getMOVIE_SUBJECT()+"\\n"+moviebean.getMOVIE_START()+"\\n"+moviebean.getMOVIE_END()+"\\n"+
				 "');");
		out.println("location.href='./MovieMain1.mo'");
		out.println("</script>");
		out.close();
		
		
		forward.setRedirect(false);
		forward.setPath("./movie/movie_seat_check.jsp");
		return forward;
	}
}
