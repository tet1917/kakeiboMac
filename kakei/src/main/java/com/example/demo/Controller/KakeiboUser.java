package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.KakeiboUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class KakeiboUser {
	private final KakeiboUserService kakeiboUserService;

	public KakeiboUser(KakeiboUserService kakeiboUserService) {
		this.kakeiboUserService = kakeiboUserService;
	}
	
	@GetMapping("/kakeibouser")
	public String readKakeiboUser(Model model) throws JsonMappingException, JsonProcessingException {
		model.addAttribute("userlist" ,kakeiboUserService.getUsers(0).getuserList());
		return "kakeibo_user.html";
	}
	
	@PostMapping("/KakeiboGetUser")
	public String kakeibopostuser(@RequestParam("selecteduser") int p1, Model model) throws JsonMappingException, JsonProcessingException {
		model.addAttribute("selecteduser" , kakeiboUserService.getUsers(p1).getuserList().get(0).getUserNm());
		return "KakeiboGetUser.html";
	}
	
//	@GetMapping("/kakeibouser")
//	public String readKakeiboUser(Model model) throws JsonMappingException, JsonProcessingException {
//		model.addAttribute("userlist", kakeiboUserService.getUsers().getuserList().get(0).getUserNm());
//		return "kakeibo_user.html";
//	}

	//	@PostMapping("/KakeiboGetUser.html")
	//	public String postKakeiboUser(Model model) throws JsonMappingException, JsonProcessingException {
	//		model.addAttribute("userlist", kakeiboUserService.getUsers().getuserList())	;
	//		return"KakeiboGetUser.html";
	//	}
}
