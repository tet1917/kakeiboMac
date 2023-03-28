package com.example.kakeibo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kakeibo.Service.KakeiboUserService;
import com.example.kakeibo.data.KakeiboAccountEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class KakeiboUserController {
	private final KakeiboUserService kakeiboUserService;

	public KakeiboUserController(KakeiboUserService kakeiboUserService) {
		this.kakeiboUserService = kakeiboUserService;
	}

	@GetMapping("/kakeibouser")
	public String readKakeiboUser(Model model) throws JsonMappingException, JsonProcessingException {
		model.addAttribute("userlist", kakeiboUserService.getUsers(0).getuserList());
		return "kakeibo_user.html";
	}

	@PostMapping("/kakeibo_user_data")
	public String kakeibopostuser(@RequestParam("selecteduser") int p1, Model model)
			throws JsonMappingException, JsonProcessingException {
		model.addAttribute("selecteduser", kakeiboUserService.getUsers(p1).getuserList().get(0).getUserNm());
		KakeiboAccountEntity entity = kakeiboUserService.getAccount(p1,0);
		model.addAttribute("kakeiboList",entity.getkakeiboList());
		model.addAttribute("total", entity.getTotalAccount());
		
		//二回同じAPIコールをするのでNG。
		//一旦上のように呼び出すという行為を格納して、それを使い回すようなイメージ。
//		model.addAttribute("kakeiboList",kakeiboUserService.getAccount(p1).getkakeiboList());
//		model.addAttribute("total", kakeiboUserService.getAccount(p1).getTotalAccount());
		return "kakeibo_user_data.html";
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
