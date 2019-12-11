<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<form name="loginform" action="./MemberLoginAction.me" method="post">
<center>
<table border="0">
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
		<td colspan="2" align="center" bgcolor="#8eaed7">
			<b><font size="5">L O G I N</font></b>
		</td>
	</tr>
	<tr><td>ID : </td><td><input type="text" name="MEMBER_ID"/></td></tr>
	<tr><td>PASSWORD : </td><td><input type="password" name="MEMBER_PW"/></td></tr>
	<tr><td colspan="2"><hr></td></tr>
	<tr>
		<td colspan="2" align="center">
			<a href="javascript:loginform.submit()">LOGIN</a>&nbsp;&nbsp;
			<a href="MemberJoin.me">JOIN</a>
			<a href="./MovieMain.mo">HOME</a>
		</td>
	</tr>
</table>
</center>
</form>
</body>
</html>