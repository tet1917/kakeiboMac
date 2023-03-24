package com.example.kakeibo.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class KakeiboGetUser {
	
	@GetMapping("KakeiboGetUser")
	public String getuser() {
		return "KakeiboGetUser.html";
	}
}
