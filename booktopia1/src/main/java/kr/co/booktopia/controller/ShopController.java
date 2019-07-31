package kr.co.booktopia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.booktopia.service.ShopService;
import kr.co.booktopia.vo.MemberVO;
import kr.co.booktopia.vo.ShopCartVO;
import kr.co.booktopia.vo.ShopGoodsImageVO;
import kr.co.booktopia.vo.ShopGoodsVO;
import kr.co.booktopia.vo.ShopOrderVO;

@Controller
public class ShopController {
	
	@Inject
	private ShopService service;
	
	@RequestMapping("/shop/list")
	public String list(Model model, String GOODS_SORT) {
		
		System.out.println(GOODS_SORT);
		
		List<ShopGoodsVO> goodsList = service.goodsList(GOODS_SORT);
		model.addAttribute("goodsList", goodsList);
		
		return "/shop/list";
	}

	@RequestMapping("/shop/view")
	public String view(Model model, String goods_id, HttpServletRequest req, HttpServletResponse resp) {
		
		ShopGoodsVO goodsVO = service.goodsView(goods_id);
		ShopGoodsImageVO goodsImageVO = service.goodsDetailImage(goods_id);
		
		model.addAttribute("goodsVO", goodsVO);
		model.addAttribute("goodsImageVO", goodsImageVO);
		
		return "/shop/view";
	}
	
	@ResponseBody
	@RequestMapping("/shop/addGoodsInCart")
	public String addGoodsInCart(int goods_id, HttpServletRequest req, HttpServletResponse resp) {

		HttpSession sess = req.getSession();
		MemberVO memberVO = (MemberVO) sess.getAttribute("memberVO");

		ShopCartVO scv = new ShopCartVO(); 
		scv.setMEMBER_ID(memberVO.getMember_id());
		scv.setGOODS_ID(goods_id);

		boolean isAreadyExisted = service.findGoodsInCart(scv);

		if(isAreadyExisted) {
			return "exist";
		}else {
			service.addGoodsInCart(scv);
			return "success";			
		}
	}
	
	@RequestMapping("/shop/cart")
	public String cart(HttpSession sess) {
		
		MemberVO memberVO = (MemberVO) sess.getAttribute("memberVO");
		String member_id = memberVO.getMember_id();

		Map<String, List<?>> cartMap = service.myCartList(member_id);

		sess.setAttribute("cartMap", cartMap);
		
		return "/shop/cart";
	}
	
	@RequestMapping(value="/shop/order", method=RequestMethod.GET)
	public String order(HttpSession sess) {
		
		MemberVO memberVO = (MemberVO) sess.getAttribute("memberVO");
		String member_id = memberVO.getMember_id();
		
		Map<String, List<?>> cartMap = service.myCartList(member_id);
		sess.setAttribute("cartMap", cartMap);
		
		return "/shop/order";
	}
	
	@RequestMapping(value="/shop/order", method=RequestMethod.POST)
	public String order(ShopOrderVO vo, HttpSession sess) {
		
		MemberVO memberVO = (MemberVO) sess.getAttribute("memberVO");
		String member_id = memberVO.getMember_id();
		vo.setMEMBER_ID(member_id);
		
		Map<String, List<?>> cartMap = service.myCartList(member_id);
		service.orderAllCartGoods(cartMap, vo);
		
		return "/shop/order";
	}
	
	@RequestMapping("/shop/search")
	public String search( Model model, String searchWord, 
											 HttpServletRequest req,
											 HttpServletResponse resp) {


		List<ShopGoodsVO> goodsList = service.searchGoods(searchWord);
		model.addAttribute("goodsList", goodsList);

		return "/shop/list";
	}
	
	@RequestMapping("/shop/searchAutoComplete")
	public @ResponseBody Map<String, List<String>> searchAutoComplete(String keyword, 
			HttpServletRequest req, HttpServletResponse resp) {
		
		List<String> keywordList = service.searchAutoComplete(keyword);
		
		// JSON 데이터 객체 생성(jackson 라이브러리 필요) 
		Map<String, List<String>> json = new HashMap<String, List<String>>();
		json.put("keyword", keywordList);
		
		return json;
	}
	
	
}
