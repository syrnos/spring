package kr.co.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.board.service.BoardService;
import kr.co.board.vo.BoardVO;
import kr.co.board.vo.UserVO;

@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		List<BoardVO> boardList = service.list();
		model.addAttribute("boardList",boardList);
		
		
		return "/list";
				
	}
	
	@RequestMapping("/view")
	public String view(int seq, Model model) {
		
		BoardVO vo = service.view(seq);
		model.addAttribute("vo",vo);
		
		return "/view";
				
	}
	
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public String write() {
		
		return "/write";
				
	}
	
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(BoardVO vo, HttpSession sess, HttpServletRequest req) {
		
		UserVO user = (UserVO) sess.getAttribute("user");
		
		vo.setUid(user.getUid());
		vo.setRegip(req.getRemoteAddr());
		
		service.write(vo);
		return "redirect:/list";
				
	}
	
	
	
}
