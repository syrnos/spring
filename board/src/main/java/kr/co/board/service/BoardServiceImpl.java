package kr.co.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.board.dao.BoardDAO;
import kr.co.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public void write(BoardVO vo) {
		dao.write(vo);
	}

	@Override
	public List<BoardVO> list() {
		return dao.list();
	}
	
	@Override
	public BoardVO view(int seq) {
		return dao.view(seq);
		
	}


	@Override
	public void modify() {
		
	}

	@Override
	public void delete() {
		
	}

	
	

}
