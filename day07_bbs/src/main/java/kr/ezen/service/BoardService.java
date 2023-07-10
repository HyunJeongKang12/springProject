package kr.ezen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ezen.bbs2.domain.BoardDTO;
import kr.ezen.bbs2.domain.PageDTO;

//service : root-context에서 동작

public interface BoardService {
	//게시글 등록
	void register(BoardDTO dto);
	
	//게시글 조회
	List<BoardDTO> GetList(PageDTO pDto);
	
	//게시글 상세보기
	BoardDTO view(int bid, String mode);
	
	//게시글 수정
	int modify(BoardDTO dto);
	
	//게시글 삭제
	int remove(int bid);
	
	//조회수 증가 :불필요, view에서 mapper바로 호출
	//void hitAdd(int bid);
	
	//전체 게시글 수
	int totalCnt();
}

