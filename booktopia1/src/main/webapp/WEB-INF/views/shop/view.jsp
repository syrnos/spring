<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../_head.jsp" %>
<%-- 컨텍스트 루트 패스 전역설정 --%>
	<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
	
	<script>
		function addCart(goods_id){
			$.ajax({
				type : "get",			
				url : "${ctxPath}/shop/addGoodsInCart",
				data : {'goods_id':goods_id},
				success : function(data) {
					
					if(data.trim() == 'success'){
						alert('장바구니에 상품이 등록되었습니다.');
					}else{
						alert('이미 등록된 상품입니다.');
					}
				}
			}); 
			
		}// End addCart
	</script>
	
	<div id="dialog" title="Basic dialog">
		<h1>확인</h1>
	</div>
      <article>
        <hgroup>
          <h1>컴퓨터와 인터넷</h1>
          <h2>국내외 도서 &gt; 컴퓨터와 인터넷 &gt; 웹 개발</h2>
          <h3>${goodsVO.GOODS_TITLE}</h3>
	      <h4>${goodsVO.GOODS_WRITER} &nbsp; 저| ${goodsVO.GOODS_PUBLISHER}</h4>
        </hgroup>
        <div id="goods_image">
          <figure>
             <img alt="HTML5 &amp; CSS3" src="${ctxPath}/goods/thumbnail?goods_id=${goodsVO.GOODS_ID}&fname=${goodsVO.FILENAME}">
          </figure>
        </div>
        <div id="detail_table">
          <table>
            <tbody>
              <tr>
                <td class="fixed">정가</td>
                <td class="active">
                <span><fmt:formatNumber  value="${goodsVO.GOODS_PRICE}" type="number" var="goods_price" />${goods_price}원</span>
                </td>
              </tr>
              <tr class="dot_line">
                <td class="fixed">판매가</td>
                <td class="active">
                  <span><fmt:formatNumber  value="${goodsVO.GOODS_PRICE*0.9}" type="number" var="discounted_price" />
					         ${discounted_price}원(10%할인)</span>
                </td>
              </tr>
              <tr>
                <td class="fixed">포인트적립</td>
                <td class="active">${goodsVO.GOODS_POINT}P(10%적립)</td>
              </tr>
              <tr class="dot_line">
                <td class="fixed">포인트 추가적립</td>
                <td class="fixed">만원이상 구매시 1,000P, 5만원이상 구매시 2,000P추가적립 편의점 배송 이용시 300P 추가적립</td>
              </tr>
              <tr>
                <td class="fixed">발행일</td>
                <td class="fixed">
                	<c:set var="pub_date" value="${goodsVO.GOODS_PUBLISHED_DATE}" />
			   		<c:set var="arr" value="${fn:split(pub_date,' ')}" />
			   		<c:out value="${arr[0]}" />
			   </td>
              </tr>
              <tr>
                <td class="fixed">페이지 수</td>
                 <td class="fixed">${goodsVO.GOODS_TOTAL_PAGE}쪽</td>
              </tr>
              <tr class="dot_line">
                <td class="fixed">ISBN</td>
                <td class="fixed">${goodsVO.GOODS_ISBN}</td>
              </tr>
              <tr>
                <td class="fixed">배송료</td>
                <td class="fixed"><strong>무료</strong></td>
              </tr>
              <tr>
                <td class="fixed">배송안내</td>
                <td class="fixed"><strong>[당일배송]</strong> 당일배송 서비스 시작!<br> <strong>[휴일배송]</strong>
                  휴일에도 배송받는 Bookshop</td>
              </tr>
              <tr>
                <td class="fixed">도착예정일</td>
                <td class="fixed">지금 주문 시 내일 도착 예정</td>
              </tr>
              <tr>
                <td class="fixed">수량</td>
                <td class="fixed">
                  <select style="width: 60px;" id="order_goods_qty">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                  </select>
                </td>
              </tr>
            </tbody>
          </table>
          <ul>
            <li><a class="buy" href="#">구매하기 </a></li>
            <li><a class="cart" href="javascript:addCart(${goodsVO.GOODS_ID})">장바구니</a></li>
            <li><a class="wish" href="#">위시리스트</a></li>
          </ul>
        </div>
        <div class="clear"></div>
        <!-- 내용 들어 가는 곳 -->
        <div id="container">
          <ul class="tabs">
            <li class="active"><a href="#tab1">책소개</a></li>
            <li><a href="#tab2">저자소개</a></li>
            <li><a href="#tab3">책목차</a></li>
            <li><a href="#tab4">출판사서평</a></li>
            <li><a href="#tab5">추천사</a></li>
            <li><a href="#tab6">리뷰</a></li>
          </ul>
          <div class="tab_container">
            <div class="tab_content" id="tab1" style="display: block;">
              <p>${goodsVO.GOODS_INTRO}</p>
	        <%--
	        	도서 상세 이미지는 이미지 경로를 입력해도 되지만
	        	다운로드 주소방식으로 이미지 태그의 src경로에 지정해서 이미지를 출력함
	        --%>
	        <img src="${ctxPath}/goods/download.do?goods_id=${goodsVO.GOODS_ID}&fname=${goodsImageVO.FILENAME}">
	      </div>
	      <div class="tab_content" id="tab2" style="display: none;">
	        <h4>저자소개</h4>
	        <div class="writer">저자 : ${goodsVO.GOODS_WRITER}</div>
	        <p>${goodsVO.GOODS_WRITER_INTRO}</p>
            </div>
           </div>
	      <div class="tab_content" id="tab3" style="display: none;">
	        <h4>책목차</h4>
	        <p>${goodsVO.GOODS_CONTENTS_ORDER}</p>
	      </div>
	      <div class="tab_content" id="tab4" style="display: none;">
	        <h4>출판사서평</h4>
	        <p>${goodsVO.GOODS_PUBLISHER_COMMENT}</p>
	      </div>
	      <div class="tab_content" id="tab5" style="display: none;">
	        <h4>추천사</h4>
	        <p>{goodsVO.GOODS_RECOMMENDATION}</p>
	      </div>
	      <div class="tab_content" id="tab6" style="display: none;">
	        <h4>리뷰</h4>
	      </div>
	    </div>
	  </div>
	  <div class="clear"></div>
      </article>
      <div class="clear"></div>
      <%@ include file="../_tail.jsp" %> 
   