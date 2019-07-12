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
	public String list(Model model,String pg) {
		
		//Limit start계산
		int start = service.getLimitStart(pg);
		
		//전체 게시물 갯수
		int total = service.getTotalCount();
		
		//페이지번호 계산
		int pageEnd = service.getPageEnd(total);
		
		//글 카운터번호
		int count = service.getPageCountStart(total, start);
		
		//페이지 그룹계산 
		int[] groupStartEnd = service.getPageGroupStartEnd(pg, pageEnd);
		
		
		
		List<BoardVO> boardList = service.list(start);
		model.addAttribute("boardList",boardList);
		model.addAttribute("count",count);
		model.addAttribute("pageEnd",pageEnd);
		model.addAttribute("groupStartEnd",groupStartEnd);
		
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
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public String modify(int seq, Model model) {
		
		BoardVO vo = service.view(seq);
		model.addAttribute("vo",vo);
		
		return "/modify";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modify(BoardVO vo) {
		
		service.modify(vo);
		
		return "redirect:/view?seq="+vo.getSeq();
		
	}
	
	
	
}
