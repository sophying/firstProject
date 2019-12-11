package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		BoardDAO boarddao = new BoardDAO();
		BoardBean boardbean = new BoardBean();
		
		System.out.println("BoardDetailAction의 num : " + request.getParameter("num"));
		
		int num = Integer.parseInt(request.getParameter("num"));
		boarddao.setReadCountUpdate(num);
		boardbean = boarddao.getDetail(num);
		
		if(boardbean == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		
		request.setAttribute("boardbean", boardbean);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/board_view.jsp");
		return forward;
	}

}
