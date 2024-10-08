package com.org.koseaQnA.boards.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.koseaQnA.boards.dto.BoardsResponseDto;
import com.org.koseaQnA.boards.service.BoardsService;
import com.org.koseaQnA.boards.util.Paging;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardsController {
	
	final private BoardsService boardsService;

	@GetMapping("/boards")
	public String list(Model model, 
			@RequestParam(value = "pageGroup", required=false) String pageGroup, 
			@RequestParam(value="pageNum", required=false) String pageNum ) {
		
		int pGroup;
		int pNum;
		int amount = 10;
		
		if(pageGroup == null && pageNum == null) {
			pGroup = 1; pNum = 1;
			
		} else {
			pGroup = Integer.parseInt(pageGroup);
			pNum = Integer.parseInt(pageNum);
		}
		
		List<BoardsResponseDto> boardsResponseDto = boardsService.findAllBoards((pNum-1) * amount, amount);
		
		int totArticles = boardsService.findAllboardsCount();
		Paging paging = new Paging(totArticles, pNum, pGroup);
		
		
		model.addAttribute("items", boardsResponseDto);
		model.addAttribute("paging", paging);
		
		return "home";
	}
	
}
