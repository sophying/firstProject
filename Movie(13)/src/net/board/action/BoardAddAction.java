package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boarddao = new BoardDAO();
		BoardBean boardbean = new BoardBean();
		ActionForward forward = new ActionForward();

		boolean result = false;

		try {
			boardbean.setBOARD_ID(request.getParameter("BOARD_ID"));
			boardbean.setBOARD_CATEGORY(request.getParameter("BOARD_CATEGORY"));
			boardbean.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			boardbean.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));

			result = boarddao.boardInsert(boardbean);

			if (result == false) {
				System.out.println("BoardAddAction 실패");
				return null;
			}
			System.out.println("BoardAddAction 성공");

			forward.setRedirect(true);
			forward.setPath("./BoardQNA.bo");
			return forward;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
