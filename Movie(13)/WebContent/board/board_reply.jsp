<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "net.board.db.*" %>
<%
    String id = (String)session.getAttribute("id");
   request.setCharacterEncoding("UTF-8");
%>
<% BoardBean board = (BoardBean)request.getAttribute("boardbean"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>

<script type="text/javascript">
   function replyboard() {
      boardform.submit();
   }
</script>
</head>
<body>
<!-- 게시판 답변 -->

<form action="./BoardReplyView.bo" method="post" name="boardform">
   <input type="hidden" name="BOARD_NUM" value="<%= board.getBOARD_NUM() %>" />   
   <input type="hidden" name="BOARD_RE_REF" value="<%= board.getBOARD_RE_REF() %>" />   
   <input type="hidden" name="BOARD_RE_LEV" value="<%= board.getBOARD_RE_LEV() %>" />   
   <input type="hidden" name="BOARD_RE_SEQ" value="<%= board.getBOARD_RE_SEQ() %>" />   
   
   <table cellpadding="0" cellspacing="0">
      <tr align="center" valign="middle">
         <td colspan="2">MVC 게시판</td>
      </tr>
      <tr>
         <td style="font-family: 돋움; font-size: 12pt;" height="16">
            <div align="center">아이디</div>
         </td>
         <td>
            <%=id %>
            <input type="hidden" name="BOARD_ID" value="<%=id %>">    
         </td>
      </tr>
      <tr>
         <td style="font-family: 돋움; font-size: 12pt;" height="16">
            <div align="center">분 류</div>
         </td>
         <td>
            <select name="BOARD_CATEGORY">
               <option value="all">로그인</option>
               <option value="sub">예매</option>
               <option value="au">멤버십</option>
               <option value="con">포인트</option>
            </select>
         </td>
      </tr>
      <tr>
         <td style="font-family: 돋움; font-size: 12pt;" height="16">
            <div align="center">제 목</div>
         </td>
         <td>
            <input name="BOARD_SUBJECT" type="text" size="50" maxlength="100" value="Re; <%= board.getBOARD_SUBJECT() %>" />
         </td>
      </tr>
      <tr>
         <td style="font-falimy: 돋움; font-size: 12pt;" height="16">
            <div align="center">내 용</div>
         </td>
         <td>
            <textarea name="BOARD_CONTENT" cols="67" rows="15"></textarea>
         </td>
      </tr>
      <tr bgcolor="#cccccc">
         <td colspan="2" style="height: 1px"></td>
      </tr>
      <tr>
         <td colspan="2">&nbsp;</td>
      </tr>
      <tr align="center" valign="middle">
         <td colspan="2">
            <a href="javascript:replyboard()">[등록]</a>&nbsp;&nbsp;
            <a href="javascript:history.go(-1)">[뒤로]</a>
      </tr>
   </table>
</form>

<!-- 게시판 답변 -->
</body>
</html>