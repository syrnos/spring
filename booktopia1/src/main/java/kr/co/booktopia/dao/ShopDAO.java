package kr.co.booktopia.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.booktopia.vo.ShopCartVO;
import kr.co.booktopia.vo.ShopGoodsImageVO;
import kr.co.booktopia.vo.ShopGoodsVO;
import kr.co.booktopia.vo.ShopOrderVO;

@Repository
public class ShopDAO {
	
	@Inject
	private SqlSession mybatis;
	
	
	
	public List<ShopGoodsVO> goodsList(String GOODS_SORT) {
		
		return mybatis.selectList("mapper.good.SELECT_GOODS_LIST", GOODS_SORT);
		
	}
	
	
	public ShopGoodsVO goodsView(String goods_id) {
		
		return mybatis.selectOne("mapper.good.SELECT_GOODS_DETAIL", goods_id);
		
	}
	
	public ShopGoodsImageVO goodsDetailImage(String goods_id) {
		
		return mybatis.selectOne("mapper.good.SELECT_GOODS_IMAGE", goods_id);
	}
	
	
	private int selectMaxCartId() {
		return mybatis.selectOne("mapper.good.SELECT_MAX_CART_ID");
	}

	public boolean findGoodsInCart(ShopCartVO vo) {
		String result = mybatis.selectOne("mapper.good.SELECT_COUNT_IN_CART", vo);
		return Boolean.parseBoolean(result); 
	}

	public void addGoodsInCart(ShopCartVO vo) {

		int cart_id = selectMaxCartId();
		vo.setCART_ID(cart_id);

		mybatis.insert("mapper.good.INSERT_GOODS_IN_CART", vo);
	}

	public List<ShopCartVO> selectCartList(String member_id) {
		return mybatis.selectList("mapper.good.SELECT_CART_LIST", member_id);
	}

	public List<ShopGoodsVO> selectGoodsListForCart(List<ShopCartVO> myCartList) {
		return mybatis.selectList("mapper.good.SELECT_GOODS_LIST_FOR_CART", myCartList);
	}
	
	public int selectMaxOrderSeq() {
		return mybatis.selectOne("mapper.good.SELECT_MAX_ORDER_SEQ");
	}
	
	public void orderAllCartGoods(List<ShopOrderVO> myOrderList) {
		
		for(ShopOrderVO vo : myOrderList) {
			mybatis.insert("mapper.good.INSERT_GOODS_IN_ORDER", vo);
			
		}
	}
	
	
	public List<ShopGoodsVO> searchGoods(String searchWord) {
		return mybatis.selectList("mapper.good.SELECT_GOODS_BY_SEARCH", searchWord);
	}
	
	public List<String> searchForAutoComplete(String keyword) {
		return mybatis.selectList("mapper.good.SELECT_SEARCH_AUTO_COMPLETE", keyword);
	}
	
}
