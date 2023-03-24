package com.example.kakeibo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.kakeibo.Service.KakeiboUserService;
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
		model.addAttribute("userlist", kakeiboUserService.getUsers().getuserList().get(0).getUserNm())	;
		return"kakeibo_user.html";
	}

	
//	@PostMapping("/KakeiboGetUser.html")
//	public String postKakeiboUser(Model model) throws JsonMappingException, JsonProcessingException {
//		model.addAttribute("userlist", kakeiboUserService.getUsers().getuserList())	;
//		return"KakeiboGetUser.html";
//	}
}
