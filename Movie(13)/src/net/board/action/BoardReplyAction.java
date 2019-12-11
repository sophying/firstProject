package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardReplyAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      ActionForward forward = new ActionForward();

      BoardDAO boarddao = new BoardDAO();
      BoardBean boardbean = new BoardBean();

      int num = Integer.parseInt(request.getParameter("num"));

      boardbean = boarddao.getDetail(num);

      if (boardbean == null) {
         System.out.println("답장 페이지 이동 실패");
         return null;
      }
      System.out.println("답장 페이지 이동 완료");

      request.setAttribute("boardbean", boardbean);

      forward.setRedirect(false);
      forward.setPath("./board/board_reply.jsp");

      return forward;
   }

}