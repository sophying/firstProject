package net.movie.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/MovieFrontController")
public class MovieFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("movie");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/MovieEnroll.mo")) {					//관리자 (MovieList.mo->MovieEnroll.mo)
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./movie/movie_enroll.jsp");
			
		}else if(command.equals("/MovieAddAction.mo")) {
			action = new MovieAddAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/MovieList.mo")) {				//관리자 
			action = new MovieListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/MovieMain.mo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./movie/movie_main.jsp");
			
		}else if(command.equals("/MovieMain1.mo")) {				
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./movie/movie_main1.jsp");
			
		}else if(command.equals("/MovieDetail.mo")) {			//모두(movie_main.jsp/movie_main1.jsp 영화정보-상세보기)
			action = new MovieDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MovieSeat.mo")) {
			action = new MovieSeatAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MovieSeatDiv1.mo")){
			action = new MovieSeatDiv1();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MovieSeatDiv2.mo")){
			action = new MovieSeatDiv2();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MovieSeatDiv3.mo")){
			action = new MovieSeatDiv3();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MovieCheck.mo")) {
			action = new MovieCheckAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MovieQNA.mo")) {
			action = new MovieQNAAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		

	if(forward != null) {
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}
}	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("movie doGET");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("movie doPOST");
		doProcess(request, response);
	}
}
