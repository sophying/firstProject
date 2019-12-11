<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="net.movie.db.*"%>
<%
	request.setCharacterEncoding("UTF-8");

	String id = null;
	if(session.getAttribute("id") != null){
		id=(String)session.getAttribute("id");
	}
	//List boardList=(List)request.getAttribute("boardlist");
    //int listcount=((Integer)request.getAttribute("listcount")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.menubar{
border:none;
border:0px;
margin:0px;
padding:0px;
font: 67.5% "Lucida Sans Unicode", "Bitstream Vera Sans", "Trebuchet Unicode MS", "Lucida Grande", Verdana, Helvetica, sans-serif;
font-size:25px;
font-weight:bold;
}

.menubar ul{
background: rgb(109,109,109);
height:50px;
list-style:none;
margin:0;
padding:0;
}

.menubar li{
align:center;
float:left;
padding:0px;
}

.menubar li a{
background: rgb(109,109,109);
color:#cccccc;
display:block;
font-weight:normal;
line-height:50px;
margin:0px;
padding:0px 25px;
text-align:center;
text-decoration:none;
}

.menubar li a:hover, .menubar ul li:hover a{
background: rgb(71,71,71);
color:#FFFFFF;
text-decoration:none;
}

.menubar li ul{
background: rgb(109,109,109);
display:none; /* 평상시에는 드랍메뉴가 안보이게 하기 */
height:auto;
padding:0px;
margin:0px;
border:0px;
position:absolute;
width:200px;
z-index:200;
/*top:1em;
/*left:0;*/
}

.menubar li:hover ul{
display:block; /* 마우스 커서 올리면 드랍메뉴 보이게 하기 */
}

.menubar li li {
background: rgb(109,109,109);
display:block;
float:none;
margin:0px;
padding:0px;
width:200px;
}

.menubar li:hover li a{
background:none;
}

.menubar li ul a{
display:block;
height:50px;
font-size:12px;
font-style:normal;
margin:0px;
padding:0px 10px 0px 15px;
text-align:left;
}

.menubar li ul a:hover, .menubar li ul li:hover a{
background: rgb(71,71,71);
border:0px;
color:#ffffff;
text-decoration:none;
}

.menubar p{
clear:left;
}


<!-- -->

* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-height:500px;
  max-width: 1000px;
  position: relative;
  padding-top:30px;;
  margin: auto;
}

/* Caption text */
.text {
  color: #000000;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}


<!-- -->


.grid {
        width: 100%;
        margin-top:30px;
        text-align: center; 
        font-size: 0; 
}
    
.grid_item {
        padding-top:50px;
        border: 1px solid dimgrey;
        width: 400px;
        height: 300px;
        display: inline-block; 
        vertical-align: top; 
}
.grid_item.first {

background-color: #717171;
font-size:30pt;
margin-left:10px;
}
.grid_item.two {
background-color: #717171;
font-size:30pt;
margin-left:10px;

}
.grid_item.third {
background-color: #717171;
font-size:30pt;
margin-left:10px;

}

a{
color:#cccccc;
display:block;
font-weight:normal;
line-height:50px;
margin:0px;
padding:0px 25px;
text-align:center;
text-decoration:none;
}


<!-- -->


</style>
</head>
<body>
<div class="menubar">
   <ul>
      <li><a href="./MovieDetailAction.mo" id="current">영화정보</a>
         <ul>
           <li><a href="./MovieDetail.mo">상세보기</a></li>
           <li><a href="#">평점리뷰</a></li>
         </ul>
      </li>
      <li><a href="./BoardQNA.bo">Q&A게시판</a></li>
	 <%if(id!=null && id.equals("admin")){ %>
     	 <li><a href="./MovieList.mo">영화관리</a></li>
	<%} %>      
      <li align="right" padding-left="750px">
	      <a href="#"><%=id %>님 로그인 되었습니다
	      <button onclick="location='MovieMain.mo'">로그아웃</button>
	      </a>
      </li>
   </ul>
</div>

<!--  -->

<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="./images/겨울왕국.jpg" style="width:100%; height:400px;">
  <div class="text">Caption One</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="./images/aboutTime1.png" style="width:100%; height:400px;">
  <div class="text">Caption Two</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img src="./images/lalaland1.jpg" style="width:100%; height:400px;">
  <div class="text">Caption Three</div>
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<div class="grid">
        <div class="grid_item first">
        
        <div><a href="./MovieDetailAction">Q&A</a></div>
        </div>
        <div class="grid_item two">
        <div><a href="#">멤버십등급바로가기</a></div>
        </div>
        <div class="grid_item third">
        <div><a href="#">예매하기</a></div>
        </div>
        <div class="grid_item third">
        
        <div><a href="./MovieDetailAction.mo">영화정보보기</a></div>
        </div>
</div>

<script type="text/javascript">
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>

</body>
</html>