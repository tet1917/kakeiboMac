package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.GetUserRepository;
import com.example.demo.data.KakeiboUserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class KakeiboUserService {
	private final GetUserRepository getUserRepository;

	public KakeiboUserService(GetUserRepository getUserRepository) {
		this.getUserRepository = getUserRepository;
	}

	public KakeiboUserEntity getUsers(int userId) throws JsonMappingException, JsonProcessingException {
		KakeiboUserEntity kakeiboUserEntity = new KakeiboUserEntity();
		kakeiboUserEntity = getUserRepository.getUsers(userId);
		return kakeiboUserEntity;
	}
}
