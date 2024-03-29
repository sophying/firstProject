<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="net.member.db.*" %>
<%@ page import="net.board.db.*"%>
<%@ page import="net.movie.db.*"%>

<%
   String id=(String)session.getAttribute("id");
   request.setCharacterEncoding("UTF-8");
%>

<%
   response.setHeader("Cache-Control", "no-store");
   response.setHeader("Pragma", "no-cache");
   response.setDateHeader("Expires", 0);
   if (request.getProtocol().equals("HTTP/1.1"))
      response.setHeader("Cache-Control", "no-cache");
%>

<%
   List boardList = (List)request.getAttribute("boardlist");
   int listcount = ((Integer)request.getAttribute("listcount")).intValue();
   int nowpage = ((Integer)request.getAttribute("page")).intValue();
   int maxpage = ((Integer)request.getAttribute("maxpage")).intValue();
   int startpage = ((Integer)request.getAttribute("startpage")).intValue();
   int endpage = ((Integer)request.getAttribute("endpage")).intValue();
   
   //검색 기능용
   String srchKey = (String)request.getAttribute("srchKey");
   if(srchKey == null){
      srchKey = "";
   }
   
   String srchFlds = (String)request.getAttribute("srchFlds");
   if(srchFlds == null){
      srchFlds = "";
   }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<script type="text/javascript">
   function submitSrchForm(){
      document.srchForm.srchKey.value = document.srchForm.srchKey.value.trim();
      document.srchForm.submit();
   }
   function resetSrchForm(){
      document.srchForm.srchFlds[0].selected = true;
      document.srchForm.srchKey.value = "";
   }
</script>
</head>
<body>
<!-- 게시판 리스트 -->
<table width="70%" border="0" cellpadding="0" cellspacing="0">
<%
if(listcount > 0){
%>

<tr align="center" valign="middle">
   <td colspan="3">MVC 게시판</td>
   <td colspan="2" align="right">
      <font size="3">글 개수 : ${listcount }</font>
   </td>
</tr>

<!-- 검색 기능 추가 -->
<tr>
   <td colspan="4" align="center">
      <br>
      
      <form name="srchForm" action="BoardQNA.bo" method="post">
         <select name="srchFlds">
            <option value="all" <%= srchFlds.equals("all")? "selected='selected'": ""%>>로그인</option>
            <option value="sub" <%= srchFlds.equals("sub")? "selected='selected'": ""%>>예매</option>
            <option value="au" <%= srchFlds.equals("au")? "selected='selected'": ""%>>멤버십</option>
            <option value="con" <%= srchFlds.equals("con")? "selected='selected'": ""%>>포인트</option>
         </select>
         <input type="text" name="srchKey" size="20" maxlength="50" value="<%=srchKey%>"/>
         <input type="button" value="검색" onClick="submitSrchForm()"/>
         <input type="button" value="리셋" onClick="resetSrchForm()"/>
      </form>
      <br>
   </td>
</tr>

<!-- 검색 기능 추가 -->
<tr align="center" valign="middle" bordercolor="#333333">
   <td style="font-family:Tahoma;font-size:10pt;"width="8%" height="26">
      <div align="center">NUM</div>
   </td>
   <td style="font-family:Tahoma;font-size:10pt;" width="40%" height="26">
      <div align="center">CATEGORY</div>
   </td>
   <td style="font-family:Tahoma;font-size:10pt;" width="14%" height="26">
      <div align="center">SUBJECT</div>
   </td>
   <td style="font-family:Tahoma;font-size:10pt;" width="17%" height="26">
      <div align="center">ID</div>
   </td>
   <td style="font-family:Tahoma;font-size:10pt;" width="11%" height="26">
      <div align="center">DATE</div>
   </td>
   <td style="font-family:Tahoma;font-size:10pt;" width="11%" height="26">
      <div align="center">READCOUNT</div>
   </td>
</tr>
<%
   for(int i=0; i<boardList.size(); i++){
      BoardBean bl = (BoardBean)boardList.get(i);
%>
<tr align="center" valign="middle" bordercolor="#333333" onmouseover="this.style.backgroundColor='#F8F8F8'" onmouseout="this.style.backgroundColor=''">
   <td style="font-family:Tahoma;font-size:10pt;">
      <div align="center"><%=bl.getBOARD_NUM() %></div>
   </td>
   <td style="font-family:Tahoma;font-size:10pt;">
      <div align="center"><%=bl.getBOARD_CATEGORY() %></div>
   </td>
   <td style="font-family:Tahoma;font-size:10pt;">
      <div align="left">
      <% if(bl.getBOARD_RE_LEV() != 0){ 
         for(int a=0; a <= bl.getBOARD_RE_LEV()*2; a++){
      %>
         &nbsp;
         <!-- 답변을 달았을 때 공백 추가해서 표시 -->
      <% } %>         
         ▶
      <% }else{ %>
         ▶
      <% } %>
      
      <a href="./BoardDetailAction.bo?num=<%=bl.getBOARD_NUM() %>"><%=bl.getBOARD_SUBJECT() %></a>
      </div>
   </td>   
   <td style="font-family:Tahoma;font-size:10pt;">
      <div align="center"><%= bl.getBOARD_ID() %></div>
   </td>
   <td style="font-family:Tahoma;font-size:10pt;">
      <div align="center"><%= bl.getBOARD_DATE() %></div>
   </td>
   <td style="font-family:Tahoma;font-size:10pt;">
      <div align="center"><%= bl.getBOARD_READCOUNT() %></div>
   </td>
</tr>
<%
   }
%>
<tr align="center" height="20">
   <td colspan="7" style="font-family:Tahoma;font-size:10pt;">
      <%if(nowpage<=1){ %>
         [이전]&nbsp;
      <%}else{ %>
         <a href="./BoardQNA.bo?srchFlds=<%=srchFlds %>&srchKey=<%=srchKey %>&page=<%=nowpage-1%>">[이전]</a>&nbsp;
      <%} %>
      <%
         for(int a=startpage; a<=endpage; a++){
         if(a==nowpage){
      %>
         [<%=a %>]&nbsp;
      <%   }else{ %>
         <a href="./BoardQNA.bo?srchFlds=<%=srchFlds %>&srchKey=<%=srchKey %>&page=<%=a%>">[<%=a %>]</a>&nbsp;
      <%
         } 
      } 
         if(nowpage>=maxpage){
      %>
      [다음]
      <%}else{ %>
         <a href="./BoardQNA.bo?srchFlds=<%=srchFlds %>&srchKey=<%=srchKey %>&page=<%=nowpage+1 %>">[다음]</a>
      <%} %>
   </td>
</tr>
<%}else{ %>
<tr align="center" valign="middle">
   <td colspan="4">MVC 게시판</td>
   <td align="right">
      <font size="2">등록된 글이 없습니다.</font>
   </td>
</tr>
<%} %>

<tr align="right">
   <td colspan="5">
    <a href="./BoardWrite.bo">[글쓰기]</a>
	<a href="./MovieMain1.mo">HOME</a>
   </td>   
</tr>
</table>
</body>
</html>