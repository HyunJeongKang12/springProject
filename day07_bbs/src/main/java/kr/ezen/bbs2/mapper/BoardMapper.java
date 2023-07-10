package kr.ezen.bbs2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ezen.bbs2.domain.BoardDTO;
import kr.ezen.bbs2.domain.PageDTO;

@Mapper
public interface BoardMapper {

	//interface는 public이므로 생략 가능
	//게시글 등록
	void insert(BoardDTO dto);
	
	//게시글 조회
	List<BoardDTO> getList(PageDTO pDto);
	
	//게시글 상세보기
	public BoardDTO view(int bid);
	
	//게시글 수정
	int update(BoardDTO dto);
	
	//게시글 삭제
	int delete(int bid);
	
	//조회수 증가
	void hitAdd(int bid);
	
	//전체 게시글 수
	int totalCnt();
}
