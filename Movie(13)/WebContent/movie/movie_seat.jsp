<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="net.movie.db.*" %>
<%@ page import="net.movie.action.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<% 	
	int num = Integer.parseInt(request.getParameter("num")); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{
		text-align:center;
	}
</style>
</head>
<body>
	<h2>S E A T</h2><br>
<table border="1" align="center" width="500" height="100">
	<tr>
		<td style="background-color:#4B908E">
			<label><div id="div1" align="center" onclick="location='MovieSeatDiv1.mo?num=<%=num%>'">d1</div></label>
		</td>
	</tr>
	<tr>
		<td style="background-color:#B8D7D5">
			<label><div id="div2" align="center" onclick="location='MovieSeatDiv2.mo?num=<%=num%>'">d2</div></label>
		</td>
	</tr>
	<tr>
		<td style="background-color:#8eaed7 ">
			<label><div id="div3" align="center" onclick="location='MovieSeatDiv3.mo?num=<%=num%>'">d3</div></label>
		</td>
	</tr>
</table>
</body>
</html>