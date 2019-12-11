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
<style>
    h2{
       text-align:center;
    }
    div{
        width:300px;
        text-align:center;
        display:inline-block;
        
    }
    .tableDiv{
        
        padding-left:200px;
        display:inline-block;
        
    }
    div.title {
    
        font-size:15pt;
        width:100px;
    
    }
    div.content{
    
        width:300px;
    }
    div.bigTable{

        display:inline;
        
    }
   
</style>
</head>
<body>
<h2>MOVIE DETAIL LIST</h2>
<!--  <center>-->
<div class="bigTable">
    <%
      for(int i=0; i<movieList.size(); i++){
         MovieBean ml = (MovieBean)movieList.get(i);
   %>
<div class="tableDiv" width="33%">
<p>
<table border="1">
   <tr align="center" valign="middle" bordercolor="#333333">
      <td style="font-family:Tahoma;font-size:10pt;"width="8%" height="26">
         <div class="title"align="center">NUM</div>
      </td>
      <td height="23" style="font-family:Tahoma;font-size:10pt;">
        <div class="content" align="center"><%=ml.getMOVIE_NUM() %></div>
      </td>
   </tr>
   <tr>   
      <td style="font-family:Tahoma;font-size:10pt;" width="40%" height="26">
         <div class="title" align="center">POSTER</div>
      </td>
      <td style="font-family:Tahoma;font-size:10pt;">
            <div class="content" align="center"><img src="./images/<%=ml.getMOVIE_POSTER() %>" width="200" height="120" /></div>      
      </td>
   </tr>
   <tr>  
      <td style="font-family:Tahoma;font-size:10pt;" width="14%" height="26">
         <div class="title" align="center">SUBJECT</div>
      </td>
      <td style="font-family:Tahoma;font-size:10pt;">
         <div class="content" align="center"><%=ml.getMOVIE_SUBJECT()%></div>
      </td>
    </tr>
    <tr>      
      <td style="font-family:Tahoma;font-size:10pt;" width="17%" height="26">
         <div class="title" align="center">START</div>
      </td>
      <td style="font-family:Tahoma;font-size:10pt;">
         <div class="content" align="center"><%=ml.getMOVIE_START().replaceAll("-","") %></div>
      </td>
   </tr>
   <tr>  
      <td style="font-family:Tahoma;font-size:10pt;" width="11%" height="26">
         <div class="title" align="center">END</div>
      </td>
      <td style="font-family:Tahoma;font-size:10pt;">
         <div class="content"align="center"><%=ml.getMOVIE_END().replaceAll("-","") %></div>
      </td>
   </tr>
   <tr> 
      <td colspan="2" style="font-family:Tahoma;font-size:10pt;">&nbsp;
         <div class="content"align="center"><button onclick="location='./MovieSeat.mo?num=<%=ml.getMOVIE_NUM()%>'">자리</button></div>
      </td>
   </tr>    
</table>
</div>
   <%} %>
   <p>
</div>
<p>

    <table>
      <tr align="right">
         <td colspan="5">
          <a href="javascript:history.go(-1)">BACK</a>
         <a href="./MovieMain1.mo">HOME</a>
         </td>
      </tr>
   </table> 
</p>      
<!-- </center>-->
</body>
</html>