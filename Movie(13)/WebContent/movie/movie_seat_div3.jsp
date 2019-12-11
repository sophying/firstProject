<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
    <script>
        // html 이 다 로딩된 후 실행
        $(document).ready(function() {
            // 체크박스들이 변경됬을때
            $(":checkbox").change(function() {
                var cnt = $("#person").val();
                 
                // 셀렉트박스의 값과 체크박스중 체크된 갯수가 같을때, 다른 체크박스들을 disable 처리
                if( cnt==$(":checkbox:checked").length ) {
                    $(":checkbox:not(:checked)").attr("disabled", "disabled");
                }
                // 체크된 갯수가 다르면 활성화 시킴
                else {
                    $(":checkbox").removeAttr("disabled");
                }
            });
             
            // 셀렉트박스에서 다른 인원수를 선택하면 초기화 시킴
            $("#person").change(function(){
                $(":checkbox").removeAttr("checked");
                $(":checkbox").removeAttr("disabled");
            });
        });
    </script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{
		text-align:center;
	}
</style>
</head>
<body>
<center>
       <h2>Selected SEAT</h2><br>
<table border="1" align="center" width="500px" height="100px">
	<tr>
		<td colspan="2" style="background-color:rgb(109,109,109)">
			<label><div id="div1" align="center" onclick="location='MovieMain.mo'">d1</div></label>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="background-color:rgb(109,109,109)">
			<label><div id="div2" align="center" onclick="location='MovieMain.mo'">d2</div></label>
		</td>
	</tr>
	<tr>
		<td  colspan="2" style="background-color:#4B908E">
			<label><div id="div3" align="center" onclick="location='MovieMain.mo'">d3</div></label>
		</td>
	</tr>
</table>
<br>
    <span>인원수 선택 : </span>
    <select id="person">
        <option value="1">1명</option>
        <option value="2">2명</option>
        <option value="3">3명</option>
        <option value="4">4명</option>
        <option value="5">5명</option>
    </select>
 	<br>
    <table border="1" align="center" width="500" height="100">
        <tr>
            <td><label><input type="checkbox"/>1</label></td>
            <td><label><input type="checkbox"/>2</label></td>
            <td><label><input type="checkbox"/>3</label></td>
            <td><label><input type="checkbox"/>4</label></td>
            <td><label><input type="checkbox"/>5</label></td>
            <td><label><input type="checkbox"/>6</label></td>
        </tr>
        <tr>
            <td><label><input type="checkbox"/>7</label></td>
            <td><label><input type="checkbox"/>8</label></td>
            <td><label><input type="checkbox"/>9</label></td>
            <td><label><input type="checkbox"/>10</label></td>
            <td><label><input type="checkbox"/>11</label></td>
            <td><label><input type="checkbox"/>12</label></td>
        </tr>
    </table>
    

<table border="0" align="center" width="500" height="100">
	<tr>
		<td style="text-align:center">
			<button onclick="location='MovieCheck.mo?num=<%=num%>'">완 료</button>
			<button onclick="javascript:history.go(-1)":>뒤로가기</button>
		</td>
	</tr>
</table>
</center>
</body>
</html>