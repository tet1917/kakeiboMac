package com.example.demo.Repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.data.KakeiboUserDataEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Repository
public class KakeiboGetUserRepository {
	public KakeiboUserDataEntity getUsersData(int userId) throws JsonMappingException, JsonProcessingException {
		RestTemplate temp = new RestTemplate();
		String url = "https://1l9qmgyfm5.execute-api.ap-northeast-1.amazonaws.com/deafult/kakeibo/getacount?p1="
				+ userId;

		ResponseEntity<String> res = temp.getForEntity(url, String.class);
		String json = res.getBody();
		ObjectMapper mapper = new ObjectMapper();
		KakeiboUserDataEntity get = new KakeiboUserDataEntity();
		get = mapper.readValue(json, KakeiboUserDataEntity.class);
		return get;
	}
}
