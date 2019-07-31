<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link href="/booktopia/css/style.css" rel="stylesheet" type="text/css" media="screen">
  <link href="/booktopia/css/basic-jquery-slider.css" rel="stylesheet" type="text/css" media="screen">
  <script src="/booktopia/js/jquery-1.6.2.min.js" type="text/javascript"></script>
  <script src="/booktopia/js/jquery.easing.1.3.js" type="text/javascript"></script>
  <script src="/booktopia/js/stickysidebar.jquery.js" type="text/javascript"></script>
  <script src="/booktopia/js/basic-jquery-slider.js" type="text/javascript"></script>
  <script src="/booktopia/js/tabs.js" type="text/javascript"></script>
  <script src="/booktopia/js/carousel.js" type="text/javascript"></script>
  <script>
    // 슬라이드
    $(document).ready(function() {
      $('#ad_main_banner').bjqs({
        'width': 775,
        'height': 145,
        'showMarkers': true,
        'showControls': false,
        'centerMarkers': false
      });
    });
    // 스티키
    $(function() {
      $("#sticky").stickySidebar({
        timer: 100,
        easing: "easeInBounce"
      });
    });
  </script>
  
   <script>
	  	$(function(){
	  		
	  		var input = $('input[name=searchWord]');
	  		
	  		input.keyup(function(){
	  			
	  		 	var value=input.val();
	  		 	
	  		 	if(value == ''){
	  		 		$('#suggest').hide();
	  		 		return false;  		 		
	  		 	}
	  		 	
	  			$.ajax({
	  				type : "get",
	  				async : true, //false인 경우 동기식으로 처리한다.
	  				url : "/booktopia/shop/searchAutoComplete",
	  				data : {keyword:value},
	  				success : function(data) {
	  					
	  					if(data.keyword.length > 0){
	  						
	  						$('#suggestList').children().remove();
	  						$('#suggest').show();
	  						
	  						html = '';
	  	  					
	  	  					for(var i in data.keyword){
	  	  						html += "<a href='/booktopia/shop/search?searchWord="+data.keyword[i]+"'>"+data.keyword[i]+"</a>";
	  	  					}
	  	  					
	  	  					$('#suggestList').append(html);
	  	  					
	  					}else{
	  						$('#suggest').hide();
	  						$('#suggestList').children().remove();
	  					}
	  					
	  				}
	  			}); //end ajax	
	  			
	  		});
	  		
	  	});
	  </script>
  
  <title>북토피아::메인</title>
</head>
<body>
  <div id="outer_wrap">
    <div id="wrap">
      <header>
        <div id="logo">
          <a href="/booktopia"><img width="176" height="80" alt="booktopia" src="/booktopia/img/Booktopia_Logo.jpg"></a>
        </div>
        <div id="head_link">
          <ul>
          <c:if test="${empty memberVO}">
          
            <li><a href="/booktopia/member/login">로그인</a></li>
            <li><a href="/booktopia/member/register">회원가입</a></li>
            
           </c:if>
           
           <c:if test="${not empty memberVO}">
          
            <li><a href="/booktopia/member/logout">로그아웃</a></li>
            <li><a href="/booktopia/shop/cart">장바구니</a></li>
            
           </c:if>
           
            <li><a href="#">고객센터</a></li>
          </ul>
        </div>
        <br>
        <div id="search">
          <form name="frmSearch" action="/booktopia/shop/search" autocomplete="off">
            <input name="searchWord" class="main_input" type="text"/>
            <input type="submit" name="search" class="btn1" value="검 색">
          </form>
          <div id="suggest">
            <div id="suggestList">
              <a href="#">자바1</a>
              <a href="#">자바2</a>
              <a href="#">자바3</a>
              <a href="#">자바4</a>
              <a href="#">자바5</a>
            </div>
          </div>
        </div>
      </header>
      <div class="clear"></div>
      <aside>
        <nav>
          <ul>
            <li>
              <h3>국내외 도서</h3>
              <ul>
                <li><a href="/booktopia/shop/list?GOODS_SORT=컴퓨터와 인터넷">IT/인터넷</a></li>
	            <li><a href="/booktopia/shop/list?GOODS_SORT=경제/경영">경제/경영</a></li>
	            <li><a href="/booktopia/shop/list?GOODS_SORT=대학교재">대학교재</a></li>
	            <li><a href="/booktopia/shop/list?GOODS_SORT=자기계발">자기계발</a></li>
	            <li><a href="/booktopia/shop/list?GOODS_SORT=자연과학/공학">자연과학/공학</a></li>
	            <li><a href="/booktopia/shop/list?GOODS_SORT=역사/인문학">역사/인문학</a></li>
              </ul>
            </li>
            <li>
              <h3>음반</h3>
              <ul>
                <li><a href="#">가요</a></li>
                <li><a href="#">록</a></li>
                <li><a href="#">클래식</a></li>
                <li><a href="#">뉴에이지</a></li>
                <li><a href="#">재즈</a></li>
                <li><a href="#">기타</a></li>
              </ul>
            </li>

          </ul>
        </nav>
        <div class="clear"></div>
        <div id="banner">
          <a href="#"><img width="190" height="163" src="/booktopia/img/n-pay.jpg"> </a>
        </div>
        <div id="notice">
          <h2>공지사항</h2>
          <ul>
            <li><a href="#">공지사항입니다.1</a></li>
            <li><a href="#">공지사항입니다.2</a></li>
            <li><a href="#">공지사항입니다.3</a></li>
            <li><a href="#">공지사항입니다.4</a></li>
            <li><a href="#">공지사항입니다.5</a></li>
          </ul>
        </div>
        <div id="banner">
          <a href="#"><img width="190" height="362" src="/booktopia/img/side_banner1.jpg"></a>
        </div>
        <div id="banner">
          <a href="#"><img width="190" height="104" src="/booktopia/img/call_center_logo.jpg"></a>
        </div>
        <div id="banner">
          <a href="#"><img width="190" height="69" src="/booktopia/img/QnA_logo.jpg"></a>
        </div>
      </aside>