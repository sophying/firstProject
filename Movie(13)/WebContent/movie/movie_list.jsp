<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.movie.db.*" %>
<%
	List movieList=(List)request.getAttribute("movielist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie List</title>
</head>
<body>
<center>
<table border="1">
	<tr align="center" valign="middle">
	   <td colspan="5">MOVIE LIST</td>
	</tr>
	<tr align="center" valign="middle" bordercolor="#333333">
	   <td style="font-family:Tahoma;font-size:10pt;"width="8%" height="26">
	      <div align="center">NUM</div>
	   </td>
	   <td style="font-family:Tahoma;font-size:10pt;" width="40%" height="26">
	      <div align="center">POSTER</div>
	   </td>
	   <td style="font-family:Tahoma;font-size:10pt;" width="14%" height="26">
	      <div align="center">SUBJECT</div>
	   </td>
	   <td style="font-family:Tahoma;font-size:10pt;" width="17%" height="26">
	      <div align="center">START</div>
	   </td>
	   <td style="font-family:Tahoma;font-size:10pt;" width="11%" height="26">
	      <div align="center">END</div>
	   </td>
	</tr>
	<%
		for(int i=0; i<movieList.size(); i++){
			MovieBean ml = (MovieBean)movieList.get(i);
	%>
	<tr align="center" valign="middle" bordercolor="#333333" onmouseover="this.style.backgroundColor='#F8F8F8'" onmouseout="this.style.backgroundColor=''">
	<td height="23" style="font-family:Tahoma;font-size:10pt;">
		<%=ml.getMOVIE_NUM() %>
	</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><img src="./images/<%=ml.getMOVIE_POSTER() %>" width="150" height="100"/></div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=ml.getMOVIE_SUBJECT()%></div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=ml.getMOVIE_START().replaceAll("-", "")%></div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=ml.getMOVIE_END().replaceAll("-", "")%></div>
		</td>
	</tr>
	<%} %>
	<tr align="right">
	   <td colspan="5">
	    <a href="javascript:history.go(-1)">BACK</a>
		<a href="./MovieMain1.mo">HOME</a>
	    <a href="./MovieEnroll.mo">ADD</a>
	   </td>   
	</tr>	
</table>
</center>
</body>
</html>