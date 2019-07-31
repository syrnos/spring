package kr.co.booktopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping(value = {"/admin", "/admin/index"})
	public String index() {
		
		return "/admin/index";
	}
	
	@RequestMapping(value = {"/admin/goods", "/admin/goods/index"})
	public String goodsIndex() {
		
		return "/admin/goods/index";
	}
	
	@RequestMapping("/admin/goods/add")
	public String goodsAdd() {
		
		return "/admin/goods/add";
	}
	
	@RequestMapping(value = {"/admin/member/", "/admin/member/index"})
	public String memberIndex() {
		
		return "/admin/member/index";
	}
	
	@RequestMapping(value = {"/admin/order/", "/admin/order/index"})
	public String orderIndex() {
		
		return "/admin/order/index";
	}
	
}
