package kr.co.booktopia.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.booktopia.service.MemberService;
import kr.co.booktopia.vo.MemberVO;

@Controller
public class MemberController {

	@Inject
	private MemberService service;
	
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String login(String result, Model model) {
		
		model.addAttribute("result", result);
		
		return "/member/login";
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String login(@RequestParam Map<String, String> loginMap, HttpSession session) {
		
		MemberVO memberVO = service.login(loginMap);
		
		if(memberVO != null) {
			session.setAttribute("islogin", true);
			session.setAttribute("memberVO", memberVO);
			return "redirect:/index";
		}else {
			return "redirect:/member/login?result=fail";
		}
		
	}
	
	@RequestMapping(value="/member/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/index";
	}
	
	@RequestMapping(value="/member/register", method=RequestMethod.GET)
	public String register() {	
		return "/member/register";
	}
	
	@RequestMapping(value="/member/register", method=RequestMethod.POST)
	public String register(MemberVO vo) {
		
		service.register(vo);
		
		return "redirect:/member/login";
	}
	
	@RequestMapping("/member/mypage")
	public String mypage() {
		return "/member/mypage";
	}
	
}