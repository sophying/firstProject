<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Enroll</title>
</head>
<body>
<form name="enrollform" action="./MovieAddAction.mo" method="post" enctype="multipart/form-data" >
<center>
<table border="0">
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
	<td colspan="2" align="center" bgcolor="#8eaed7">
			<b><font size="5">E N R O L L </font></b>
		</td>
	</tr>
	<tr>
		<td>POSTER </td>
		<td><input type="file" name="MOVIE_POSTER"/></td>
	</tr>
	<tr>
		<td>SUBJECT  </td>
		<td><input type="text" name="MOVIE_SUBJECT"/></td>
	</tr>
	<tr>
		<td>START  </td>
		<td><input type="text" name="MOVIE_START"/></td>
	</tr>
	<tr>
		<td>END </td>
		<td><input type="text" name="MOVIE_END"/></td>
	</tr>
	<tr><td colspan="2"><hr></td></tr>
	<tr>
		<td colspan="2" align="center">		
			<a href="./MovieList.mo">LIST</a>&nbsp;&nbsp;
			<a href="javascript:enrollform.submit()">ENROLL</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">HOME</a>&nbsp;&nbsp;
			<a href="javascript:enrollform.reset()">RESET</a>
		</td>
	</tr>
</table>
</center>
</form>
</body>
</html>