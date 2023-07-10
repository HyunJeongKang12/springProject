package kr.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ezen.bbs2.domain.BoardDTO;
import kr.ezen.bbs2.domain.PageDTO;
import kr.ezen.bbs2.mapper.BoardMapper;


//Service Layer 구현 객체
@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	private BoardMapper mapper;

	@Override
	public void register(BoardDTO dto) {
		mapper.insert(dto);
	}

	@Override
	public List<BoardDTO> GetList(PageDTO pDto) {
		//paging
		int totalCnt = mapper.totalCnt();
		pDto.setValue(totalCnt, pDto.getCntPerPage());
		return mapper.getList(pDto);
	}

	@Override
	public BoardDTO view(int bid, String mode) {
		if(mode.equals("v")) {
			//조회수 증가
			mapper.hitAdd(bid);
		}
		return mapper.view(bid);
	}

	@Override
	public int modify(BoardDTO dto) {
		return mapper.update(dto);
	}

	@Override
	public int remove(int bid) {
		return mapper.delete(bid);
	}

	@Override
	public int totalCnt() {
		return mapper.totalCnt();
	}



}
