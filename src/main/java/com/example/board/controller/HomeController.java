package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/") // 현재경로로 접근 
	public String index() {
		return "index"; // ddddd
	}
	
	public String a() {
		return "";
	}
	
	public String b() {
		return "";
	}
	
	

}
