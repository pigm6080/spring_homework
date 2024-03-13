package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	@Autowired
	private final BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("list");
		model.addAttribute("list",service.getList());
		
	}
	@GetMapping("/register")
	public void register() {
		
	}
	@PostMapping("/register")
	public String register(BoardVO boardVO , RedirectAttributes rttr) {
		log.info(boardVO);
		
		service.register(boardVO);
		
		rttr.addFlashAttribute("result", boardVO.getBno());
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno , Model model) {
		
		log.info("/get 까지 왔음");
		
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/modify") //RedirectAttributes리다이렉트후에도 데이터를 유지랑수 있도록하는인터페이스다
	public String modify(BoardVO boardVO , RedirectAttributes rttr) {
		log.info("modify 당 !! ~~" + boardVO);
		
		if(service.modify(boardVO)) {
			rttr.addFlashAttribute("result" , "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno , RedirectAttributes rttr) {
	
		log.info("remove당 !!!!! " + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	
}
