<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.board.db.*" %>
<%
String id = (String)session.getAttribute("id");
BoardBean board = (BoardBean)request.getAttribute("boardbean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판_modify</title>
<script type="text/javascript">
function modifyboard(){
    
    modifyform.submit();
}


</script>

</head>
<body>
<!-- 게시판 수정 -->
<form action="BoardModifyAction.bo" method="post" name="modifyform">
<input type="hidden" name="BOARD_NUM" value="<%=board.getBOARD_NUM() %>"/>
<input type="hidden" name="BOARD_ID"value="<%=id %>"/>

<table cellpadding="0" cellspacing="0">
    <tr align="center" valign="middle">
        <td colspan="5" bgcolor="#ddddee">Q & A 게시글 수정</td>
    </tr>
    <tr>
        <td class="title" height="16" style="font-family:돋음; font-size:12">
            <div align="center">CATEGORY</div>
        </td>
                 <td>
            <select name="BOARD_CATEGORY">
               <option value="로그인">로그인</option>
               <option value="예매">예매</option>
               <option value="멤버십">멤버십</option>
               <option value="포인트">포인트</option>
            </select>
         </td>
    </tr>
    <tr>
        <td class="title" height="16" style="font-family:돋음; font-size:12">
            <div align="center">SUBJECT</div>
        </td>
        <td>
            <input name="BOARD_SUBJECT"size="50" maxlength="100" value="<%=board.getBOARD_SUBJECT() %>">
        </td>
    </tr>
    <tr>
        <td class="title" style="font-family:돋음; font-size:12">
            <div align="center">CONTENT</div>
        </td>
        <td>
            <textarea name="BOARD_CONTENT" cols="67" rows="15"><%=board.getBOARD_CONTENT() %></textarea>
        </td>
    </tr>
    <tr>
        <td colspan="5" bgcolor="#ddddee"></td>        
    </tr>
    <tr bgcolor="#cccccc">
        <td collspan="2" style="height:1px;">
        </td>
    </tr>
    <tr><td colspan="2">&nbsp;</td></tr>
    <tr align="center" valign="middle">
        <td colspan="5">
            <font size="2">
                <a href="javascript:modifyboard()">[MODIFY]</a>&nbsp;&nbsp;
                <a href="javascript:history.go(-1)">[BACK]</a>&nbsp;&nbsp;
            </font>
        </td>
    </tr>
</table>
</form>
</body>
</html>