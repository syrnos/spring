<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../_head.jsp" %>
<%-- 컨텍스트 루트 패스 전역설정 --%>
	<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
	
	<c:set var="myCartList" value="${cartMap.myCartList}" />
	<c:set var="myGoodsList" value="${cartMap.myGoodsList}" />
	<c:set var="totalGoodsNum" value="0" />
	<c:set var="totalDeliveryPrice" value="0" />
	<c:set var="totalDiscountedPrice" value="0" />

      <article>
        <form name="frm_order_all_cart">
	  	<table class="list_view">
	
		    <tbody align="center">
		      <tr style="background:#33ff00">
		        <td class="fixed">구분</td>
		        <td colspan="2" class="fixed">상품명</td>
		        <td>정가</td>
		        <td>판매가</td>
		        <td>수량</td>
		        <td>합계</td>
		        <td>주문</td>
		      </tr>
		      <c:choose>
		      	<c:when test="${empty myCartList}">
		      		<tr>
		      			<td colspan="8" class="fixed"><strong>장바구니에 상품이 없습니다.</strong></td>
		      		</tr>
		      	</c:when>
		      	<c:otherwise>
		      		<c:forEach var="item" items="${myGoodsList}" varStatus="cnt">
		      			<c:set var="cart_goods_qty" value="${myCartList[cnt.count-1].CART_GOODS_QTY}" />
		      			<c:set var="cart_id" value="${myCartList[cnt.count-1].CART_GOODS_QTY}" />
		      			<tr>
					        <td><input type="checkbox" name="checked_goods" /></td>
					        <td class="goods_image">
					          <a href="#"><img width="75" alt="" src="${ctxPath}/goods/thumbnail?goods_id=${item.GOODS_ID}&fname=${item.FILENAME}"></a>
					        </td>
					        <td><h2><a href="#">${item.GOODS_TITLE}</a></h2></td>
					        <td class="price"><span>${item.GOODS_PRICE}원</span></td>
					        <td>
					          <strong>
					          	<fmt:formatNumber  value="${item.GOODS_SALES_PRICE*0.9}" type="number" var="discounted_price" />
					            ${discounted_price}원(10%할인)
					          </strong>
					        </td>
					        <td>
					          <input type="text" id="cart_goods_qty" name="cart_goods_qty" size="3" value="${cart_goods_qty}" /><br>
					          <a href="#"><img width="25" alt="" src="${ctxPath}/img/btn_modify_qty.jpg"></a>
					        </td>
					        <td>
					          <strong>
					          	<fmt:formatNumber  value="${item.GOODS_SALES_PRICE * 0.9 * cart_goods_qty}" type="number" var="total_sales_price" />
					         	${total_sales_price}원
					          </strong>
					        </td>
					        <td>
					          <a href="#"><img width="75" alt="" src="${ctxPath}/img/btn_order.jpg"></a><br>
					          <a href="#"><img width="75" alt="" src="${ctxPath}/img/btn_order_later.jpg"></a><br>
					          <a href="#"><img width="75" alt="" src="${ctxPath}/img/btn_add_list.jpg"></a><br>
					          <a href="#"><img width="75" alt="" src="${ctxPath}/img/btn_delete.jpg"></a>
					        </td>
					        <c:set  var="totalGoodsPrice" value="${totalGoodsPrice+item.GOODS_SALES_PRICE*0.9*cart_goods_qty }" />
							<c:set  var="totalGoodsNum" value="${totalGoodsNum+1 }" />
				      </tr>
			      </c:forEach>
		      	</c:otherwise>
		      </c:choose>
		    </tbody>
		  </table>
		  <div class="clear"></div>
		  <br>
		  <br>
		  <table width="80%" class="list_view" style="background:#cacaff">
		    <tbody>
		      <tr align="center" class="fixed">
		        <td class="fixed">총 상품수</td>
		        <td>총 상품금액</td>
		        <td></td>
		        <td>총 배송비</td>
		        <td></td>
		        <td>총 할인 금액 </td>
		        <td></td>
		        <td>최종 결제금액</td>
		      </tr>
		      <tr cellpadding="40" align="center">
		        <td id="">
		          <p id="p_totalGoodsNum">${totalGoodsNum}개 </p>
		        </td>
		        <td>
		          <p id="p_totalGoodsPrice">
		          <fmt:formatNumber  value="${totalGoodsPrice}" type="number" var="total_goods_price" />
					${total_goods_price}원</p>
		        </td>
		        <td>
		          <img width="25" alt="" src="${ctxPath}/img/plus.jpg">
		        </td>
		        <td>
		          <p id="p_totalDeliveryPrice">${totalDeliveryPrice }원  </p>
		        </td>
		        <td>
		          <img width="25" alt="" src="${ctxPath}/img/minus.jpg">
		        </td>
		        <td>
		          <p id="p_totalSalesPrice">${totalDiscountedPrice}원</p>
		        </td>
		        <td>
		          <img width="25" alt="" src="${ctxPath}/img/equal.jpg">
		        </td>
		        <td>
		          <p id="p_final_totalPrice">
		          <fmt:formatNumber  value="${totalGoodsPrice+totalDeliveryPrice-totalDiscountedPrice}" type="number" var="total_price" />
		            ${total_price}원
		          </p>
		        </td>
		      </tr>
		    </tbody>
	  </table>
	  <center>
	    <br><br>
	    <a href="#"><img width="75" alt="" src="${ctxPath}/img/btn_order_final.jpg"></a>
	    <a href="${ctxPath}/shop/order"><img width="75" alt="" src="${ctxPath}/img/btn_shoping_continue.jpg"></a>
	    <center></center>
	  </center>
	  </form>
	</article>
	
	<%@ include file="../_tail.jsp" %> 
