<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
<form name="joinform" action="./MemberJoinAction.me" method="post">
<center>
<table border="0">
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
	<td colspan="2" align="center" bgcolor="#8eaed7">
			<b><font size="5">J O I N</font></b>
		</td>
	</tr>
	<tr>
		<td>ID  </td>
		<td><input type="text" name="MEMBER_ID"/></td>
	</tr>
	<tr>
		<td>PASSWORD  </td>
		<td><input type="password" name="MEMBER_PW"/></td>
	</tr>
	<tr>
		<td>NAME  </td>
		<td><input type="text" name="MEMBER_NAME"/></td>
	</tr>
	<tr>
		<td>BIRTH </td>
		<td><input type="text" name="MEMBER_BIRTH" placeholder="1980-01-23"/></td>
	</tr>
	<tr>
		<td>GENDER </td>
		<td>
			<input type="radio" name="MEMBER_GENDER" value="남" checked/>Male
			<input type="radio" name="MEMBER_GENDER" value="여"/>Female
		</td>
	</tr>
	<tr>
		<td>E-MAIL </td>
		<td><input type="text" name="MEMBER_EMAIL" size="30"/></td>
	</tr>
	<tr>
		<td>ADDR</td>
		<td>
			<input type="text" name="MEMBER_ADDR" placeholder="○○시" />
		</td>
	</tr>
	<tr>
		<td>GENRE</td>
		<td>
			<input type="radio" name="MEMBER_GENRE" value="로맨스" checked/>로맨스
			<input type="radio" name="MEMBER_GENRE" value="공포" />공포
			<input type="radio" name="MEMBER_GENRE" value="액션" />액션
			<input type="radio" name="MEMBER_GENRE" value="기타" />기타
		</td>
	</tr>
	<tr><td colspan="2"><hr></td></tr>
	<tr>
		<td colspan="2" align="center">
			<a href="javascript:joinform.submit()">JOIN</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">HOME</a>&nbsp;&nbsp;
			<a href="javascript:joinform.reset()">RESET</a>
		</td>
	</tr>
</table>
</center>
</form>
</body>
</html>