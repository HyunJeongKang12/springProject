package kr.ezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ezen.bbs2.domain.BoardDTO;
import kr.ezen.bbs2.domain.PageDTO;
import kr.ezen.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;  //최상위(추상화) 인터페이스 주입 : 다양한 구현 객체 받음, 코드 유연해 짐 
	
	@GetMapping("/list.do")
//	public String list(Model model) {
//		
//		List<BoardDTO> list = service.GetList();
//		model.addAttribute("list", list);
//		
//		return "board/boardList";
//	}
	public String list(PageDTO pDto, Model model) {

		//paging : PageDTO
		
		List<BoardDTO> list = service.GetList(pDto);
		model.addAttribute("list", list);
		model.addAttribute("pDto", pDto);
		
		return "board/boardList";
	}
	
	@GetMapping("/register.do")
	public String register() {
		return "board/register";
	}
	
	@PostMapping("/register.do")
	public String register(BoardDTO dto) {
		
		service.register(dto);
		
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/view.do")
	//==public String view(int bid, PageDTO pDto, Model m) {
	//==public String view(int bid, @ModelAttribute PageDTO pDto, Model m) {
		public String view(int bid, @ModelAttribute("pDto") PageDTO pDto, Model m) {
		
		BoardDTO dto = service.view(bid, "v");
		m.addAttribute("dto",dto);
		//참조형 매개변수 생략가능
		//m.addAttribute("pDto", pDto);
		
		return "board/view";
	}
	
	//수정 폼페이지
	//@RequestMapping 사용시-method 표기
	//@RequestMapping(value="/modify.do", method=RequestMethod.GET)
	@GetMapping("/modify.do")
	public String modifyForm(int bid, @ModelAttribute("pDto") PageDTO pDto, Model m) {
		BoardDTO dto = service.view(bid, "m");
		m.addAttribute("dto",dto);
		
		return "board/modify";
	}
	
	//수정
	@PostMapping("/modify.do")
	public String modify(BoardDTO dto) {
		service.modify(dto);
		
		return "redirect:/board/list.do";
	}
	
	//삭제
	@GetMapping("/remove.do")
	public String remove(int bid) {
		service.remove(bid);
		
		return "redirect:list.do";
	}
}
