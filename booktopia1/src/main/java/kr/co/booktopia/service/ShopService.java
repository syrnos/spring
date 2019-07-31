package kr.co.booktopia.service;

import java.util.List;
import java.util.Map;

import kr.co.booktopia.vo.ShopCartVO;
import kr.co.booktopia.vo.ShopGoodsImageVO;
import kr.co.booktopia.vo.ShopGoodsVO;
import kr.co.booktopia.vo.ShopOrderVO;

public interface ShopService {
	
	public List<ShopGoodsVO> goodsList(String GOODS_SORT);
	public ShopGoodsVO goodsView(String goods_id);
	public ShopGoodsImageVO goodsDetailImage(String goods_id);
	
	public boolean findGoodsInCart(ShopCartVO vo);
	public void addGoodsInCart(ShopCartVO vo);
	public Map<String, List<?>> myCartList(String member_id);
	
	public void orderAllCartGoods(Map<String, List<?>> cartMap, ShopOrderVO sov);
	
	public List<ShopGoodsVO> searchGoods(String searchWord);
	public List<String> searchAutoComplete(String keyword);

}
