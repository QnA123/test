package com.org.koseaQnA.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.org.koseaQnA.home.service.HomeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final HomeService homeService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("test", homeService.homeTest());
		return "home";
	}
	
}
