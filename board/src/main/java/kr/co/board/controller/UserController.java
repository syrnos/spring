package kr.co.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.board.service.UserService;
import kr.co.board.vo.TermsVO;
import kr.co.board.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String login() {
		return "/user/login";
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public String login(HttpSession sess,UserVO vo) {
		
		//데이터베이스 사용자확인
		
		UserVO user = service.login(vo);
		
		//세션처리 
		if(user != null) {
			//회원 일 결우 
			sess.setAttribute("user", user);
			return "redirect:/list";
		} else {
			//회원이 아닐 경우
			return "redirect:/user/login?result=fail";
		}
	}
	
	@RequestMapping("/user/logout")	
	public String logout(HttpSession sess) {
		
		
		sess.invalidate();
		
		return "redirect:/user/login";
	}
	
	@RequestMapping(value = "/user/register", method=RequestMethod.GET)
	public String register() {
		
		
		return "/user/register";
	}
	
	
	@RequestMapping(value = "/user/register", method=RequestMethod.POST)
	public String register(UserVO vo, HttpServletRequest req) {
		
		vo.setRegip(req.getRemoteAddr());
		
		service.register(vo);
		
		return "/user/register";			//뷰를 리턴 
	}
	
	
	@RequestMapping("/user/terms")
	public String terms(Model model) {
		
		TermsVO vo = service.terms();
		model.addAttribute("vo",vo);		//데이터 공유
		
		return "/user/terms";
	}
	
	@RequestMapping("/user/checkUid")
	@ResponseBody					//json을 리턴하게 해줌(원래는 사이트를 찾는데 json으로 리턴 )
	public Map<String, Integer> checkUid(String uid) {
		
		int result = service.checkUid(uid);
		
		//Map객체를 Json 데이터로 변환(jackson 라이브러리)
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", result);
		
		return map;
	}
	
	
}
