package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardReplyView implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      request.setCharacterEncoding("utf-8");
      
      ActionForward forward = new ActionForward();
      
      BoardDAO boarddao = new BoardDAO();
      BoardBean boardbean = new BoardBean();
      int result = 0;
      
      boardbean.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
      boardbean.setBOARD_ID(request.getParameter("BOARD_ID"));
      boardbean.setBOARD_CATEGORY(request.getParameter("BOARD_CATEGORY"));
      boardbean.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
      boardbean.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
      boardbean.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
      boardbean.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
      boardbean.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));
      
      result = boarddao.boardReply(boardbean);
      if (result == 0) {
         System.out.println("답장 실패");
         return null;
      }
      System.out.println("답장 완료");
      
      forward.setRedirect(true);
      forward.setPath("./BoardDetailAction.bo?num="+ result);
      return forward;
   }

}