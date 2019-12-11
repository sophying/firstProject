<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.board.db.*" %>
<%
	BoardBean board = (BoardBean)request.getAttribute("boardbean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC BOARD</title>
</head>
<body>
<!-- 게시판 수정 -->
<center>
<table cellpadding="0" cellspacing="0">
	<tr><td>&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5" bgcolor="#8eaed7"><b><font size="4">BOARD</font></b></td>
	</tr>
	<tr>
		<td style="font-family:돋음;font-size:12" height="16">
			<div align="center">CATEGORY</div>
		</td>
		<td style="font-family:돋음;font-size:12">
			<%=board.getBOARD_CATEGORY() %>
		</td>
	</tr>
	<tr bgcolor="#cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음;font-size:12">
			<div align="center">ID</div>
		</td>
		<td style="font-family:돋음;font-size:12">
			<%= board.getBOARD_ID() %>
		</td>
	</tr>	
	<tr bgcolor="#cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음;font-size:12">
			<div align="center">SUBJECT</div>
		</td>
		<td style="font-family:돋음;font-size:12">
			<%= board.getBOARD_SUBJECT() %>
		</td>
	</tr>
	<tr bgcolor="#cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음;font-size:12">
			<div align="center">CONTENT</div>
		</td>
		<td style="font-family:돋음;font-size:12">
			<table bolrder="0" width="490" height="250" style="table-layout:fixed">
				<tr>
					<td valign="top" style="font-family:돋음;font-size:12">
						<%= board.getBOARD_CONTENT() %>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr bgcolor="#cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size="2">
				<a href="./BoardReplyAction.bo?num=<%=board.getBOARD_NUM() %>">[REPLY]</a>
				&nbsp;&nbsp;
				<a href="./BoardModify.bo?num=<%=board.getBOARD_NUM() %>">[MODIFY]</a>
				&nbsp;&nbsp;
				<a href="./BoardDelete.bo?num=<%=board.getBOARD_NUM() %>">[DELETE]</a>
				&nbsp;&nbsp;
				<a href="./BoardQNA.bo">[LIST]</a>
				&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table>
</center>
</body>
</html>