<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ include file="./_head.jsp" %>
      <article>
        <div id="ad_main_banner">
          <ul class="bjqs">
            <li><img width="775" height="145" src="/booktopia/img/main_banner01.jpg"></li>
            <li><img width="775" height="145" src="/booktopia/img/main_banner02.jpg"></li>
            <li><img width="775" height="145" src="/booktopia/img/main_banner03.jpg"></li>
          </ul>
        </div>
        <!-- 베스트셀러 -->
        <div class="main_book">
          <h3>베스트셀러</h3>
          <c:forEach var="item" items="${goodsMap.bestseller }">
          	<div class="book">
          		<a href="/booktopia/shop/view?goods_id=${item.GOODS_ID}">
          			<img width="121" height="154" src="/booktopia/goods/thumbnail?fname=${item.FILENAME}&goods_id=${item.GOODS_ID}" >
          			<div class="title">${item.GOODS_TITLE }</div>
          			<div class="price"><fmt:formatNumber value	="${item.GOODS_PRICE}" type="number" var="goods_price" />${goods_price}원 </div>
          		</a>

          	</div>
          </c:forEach>
        </div>

        <div id="ad_sub_banner">
          <img width="770" height="117" src="/booktopia/img/sub_banner01.jpg">
        </div>

        <!-- 새로 출판된 책 -->
        <div class="main_book">
          <h3>새로 출판된 책</h3>
          
          <c:forEach var="item" items="${goodsMap.newbook }">
          	<div class="book">
          		<a href="/booktopia/shop/view?goods_id=${item.GOODS_ID}">
          			<img width="121" height="154" src="/booktopia/goods/thumbnail?fname=${item.FILENAME}&goods_id=${item.GOODS_ID}" >
          			<div class="title">${item.GOODS_TITLE }</div>
          			<div class="price"><fmt:formatNumber value	="${item.GOODS_PRICE}" type="number" var="goods_price" />${goods_price}원 </div>
          		</a>

          	</div>
          </c:forEach>
          
          
        </div>

        <div id="ad_sub_banner">
          <img width="770" height="117" src="/booktopia/img/sub_banner02.jpg">
        </div>

        <!-- 스테디셀러 -->
        <div class="main_book">
          <h3>스테디셀러</h3>
          
          <c:forEach var="item" items="${goodsMap.steadyseller }">
          	<div class="book">
          		<a href="/booktopia/shop/view?goods_id=${item.GOODS_ID}">
          			<img width="121" height="154" src="/booktopia/goods/thumbnail?fname=${item.FILENAME}&goods_id=${item.GOODS_ID}" >
          			<div class="title">${item.GOODS_TITLE }</div>
          			<div class="price"><fmt:formatNumber value="${item.GOODS_PRICE}" type="number" var="goods_price" />${goods_price}원 </div>
          		</a>

          	</div>
          </c:forEach>
          
        </div>
      </article>

      <div class="clear"></div>
     
     <%@ include file="./_tail.jsp" %>
  