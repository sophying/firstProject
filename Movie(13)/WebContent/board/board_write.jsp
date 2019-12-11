<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String id = (String)session.getAttribute("id");
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<script language="javascript">
   function addBoard(){
      boardform.submit();
   }
</script>
</head>
<body>
<!-- 게시판 등록 -->
<form action="./BoardAddAction.bo" method="post" name="boardform">
<!-- 
   파일 첨부를 위해서 input 태그의 type="file"을 사용하게 되며, file type을 사용하기 위해
    추가적으로, form 태그의 속성으로 enctype="multipart/data-form"을 지정해줘야함
 -->
   <table cellpadding="0" cellspacing="0">
      <tr align="center" valign="middle">
         <td colspan="2">MVC 게시판</td>
      </tr>
      <tr>
         <td style="font-family:돋움;font-size:12pt;" height="16">
            <div name="BOARD_ID" align="center">글쓴이</div>
         </td>
         <td>
            <%=id %>
            <input type="hidden" name="BOARD_ID" value="<%=id %>">         
         </td>
      </tr>
      <tr>
         <td style="font-family:돋움;font-size:12pt;" height="16">
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
         <td style="font-family:돋움;font-size:12pt;" height="16">
            <div align="center">제 목</div>
         </td>
         <td>
            <input name="BOARD_SUBJECT" type="text" size="50" maxlength="100" value=""/>
         </td>
      </tr>
      <tr>
         <td style="font-family:돋움;font-size:12pt;" height="16">
            <div align="center">내 용</div>
         </td>
         <td>
            <textarea name="BOARD_CONTENT"  cols="67" rows="15"></textarea>
         </td>
      </tr>
      <tr bgcolor="#8eaed7 ">
         <td colspan="2" style="height:1px">
         </td>
      </tr>
      <tr>
         <td colspan="2">
         &nbsp;
         </td>
      </tr>
      <tr align="center" valign="middle">
         <td colspan="2">
            <a href="javascript:addBoard()">[등록]</a>&nbsp;&nbsp;
            <a href="javascript:history.go(-1)">[뒤로]</a>
         </td>
      </tr>
   </table>
</form>
</body>
</html>