package net.board.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardModifyAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.setCharacterEncoding("UTF-8");
      ActionForward forward = new ActionForward();
      boolean result = false;
      
      int num = Integer.parseInt(request.getParameter("BOARD_NUM"));
      
      BoardDAO boarddao = new BoardDAO();
      BoardBean boardbean = new BoardBean();
      
      // 변수 활용하여  String 으로 받아 BOARD_ID 를 받아 진행해도 되지만 바로 request. 활용하여 가능 
      boolean usercheck = boarddao.isBoardWriter(num, request.getParameter("BOARD_ID"));
      
      
      //만약 false 라면 다시 게시판 리스트로 돌아감 
      if (usercheck==false) {
         
         response.setContentType("text/html; charset=UTF-8"); 
         
         PrintWriter printWriter = response.getWriter();
         printWriter.println("<script>");
         printWriter.println("alert('수정할 권한이 없습니다.')");
         printWriter.println("location.href='./BoardList.bo';");
         printWriter.println("</script>");
         printWriter.close();
         
         return null;
      }
      
      try {
         boardbean.setBOARD_NUM(num);
         boardbean.setBOARD_CATEGORY(request.getParameter("BOARD_CATEGORY"));
         boardbean.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
         boardbean.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
         
         //BoardBean 값 이 넘어감 
         result = boarddao.boardModify(boardbean);
         
         if (result == false) {
            System.out.println("게시판 수정 실패");
            return null;
         }
         
         System.out.println("게시판 수정 완료");
         
         forward.setRedirect(true);
         forward.setPath("./BoardDetailAction.bo?num="+boardbean.getBOARD_NUM());
         
         //return forward;
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return forward;
   }
}