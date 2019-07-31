package kr.co.booktopia.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.booktopia.dao.ShopDAO;
import kr.co.booktopia.service.ShopService;
import kr.co.booktopia.vo.ShopCartVO;
import kr.co.booktopia.vo.ShopGoodsImageVO;
import kr.co.booktopia.vo.ShopGoodsVO;
import kr.co.booktopia.vo.ShopOrderVO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Inject
	private ShopDAO dao;
	
	@Override
	public List<ShopGoodsVO> goodsList(String GOODS_SORT) {
		return dao.goodsList(GOODS_SORT);
	}
	
	@Override
	public ShopGoodsVO goodsView(String goods_id) {
		
		return dao.goodsView(goods_id);
	}
	
	@Override
	public ShopGoodsImageVO goodsDetailImage(String goods_id) {
		
		return dao.goodsDetailImage(goods_id);
	}
	
	public boolean findGoodsInCart(ShopCartVO vo) {
		
		return dao.findGoodsInCart(vo);
		
	}
	
	public void addGoodsInCart(ShopCartVO vo) {
		dao.addGoodsInCart(vo);
	}
	
	public Map<String, List<?>> myCartList(String member_id) {
		
		Map<String, List<?>> cartMap = new HashMap<String, List<?>>();
		
		List<ShopCartVO> myCartList = dao.selectCartList(member_id);
		
		if(myCartList.size() == 0) {
			return null;
		}
		
		List<ShopGoodsVO> myGoodsList = dao.selectGoodsListForCart(myCartList);
		cartMap.put("myCartList", myCartList);
		cartMap.put("myGoodsList", myGoodsList);
		
		return cartMap;
		
	}
	
	@Override
	public void orderAllCartGoods(Map<String, List<?>> cartMap, ShopOrderVO sov) {

		List<ShopGoodsVO> myGoodsList = (List<ShopGoodsVO>) cartMap.get("myGoodsList");
		List<ShopOrderVO> myOrderList = new ArrayList<ShopOrderVO>();

		int order_id = dao.selectMaxOrderSeq();

		for(ShopGoodsVO vo : myGoodsList) {

			ShopOrderVO orderVo = new ShopOrderVO();

			orderVo.setORDER_ID(order_id);
			orderVo.setMEMBER_ID(sov.getMEMBER_ID());
			orderVo.setGOODS_ID(vo.getGOODS_ID());
			orderVo.setGOODS_TITLE(vo.getGOODS_TITLE());
			orderVo.setGOODS_FILENAME(vo.getFILENAME());
			orderVo.setORDER_GOODS_QTY(1);
			orderVo.setGOODS_SALES_PRICE(vo.getGOODS_SALES_PRICE());
			orderVo.setORDERER_NAME(sov.getORDERER_NAME());
			orderVo.setRECEIVER_NAME(sov.getRECEIVER_NAME());
			orderVo.setRECEIVER_HP1(sov.getRECEIVER_HP1());
			orderVo.setRECEIVER_HP2(sov.getRECEIVER_HP2());
			orderVo.setRECEIVER_HP3(sov.getRECEIVER_HP3());
			orderVo.setRECEIVER_TEL1(sov.getRECEIVER_TEL1());
			orderVo.setRECEIVER_TEL2(sov.getRECEIVER_TEL2());
			orderVo.setRECEIVER_TEL3(sov.getRECEIVER_TEL3());
			orderVo.setDELIVERY_ADDRESS(sov.getDELIVERY_ADDRESS());
			orderVo.setDELIVERY_MESSAGE(sov.getDELIVERY_MESSAGE());
			orderVo.setDELIVERY_METHOD(sov.getDELIVERY_METHOD());
			orderVo.setGIFT_WRAPPING(sov.getGIFT_WRAPPING());
			orderVo.setPAY_METHOD(sov.getPAY_METHOD());
			orderVo.setCARD_COM_NAME(sov.getCARD_COM_NAME());
			orderVo.setCARD_PAY_MONTH(sov.getCARD_PAY_MONTH());
			orderVo.setORDERER_HP(sov.getORDERER_HP());
			orderVo.setPAY_ORDERER_HP_NUM(sov.getPAY_ORDERER_HP_NUM());

			myOrderList.add(orderVo);
		}
		
		dao.orderAllCartGoods(myOrderList);		
	}
	
	@Override
	public List<ShopGoodsVO> searchGoods(String searchWord) {
		return dao.searchGoods(searchWord);
	}
	
	@Override
	public List<String> searchAutoComplete(String keyword) {
		return dao.searchForAutoComplete(keyword);
	}
	
}
