package com.example.kakeibo.Service;

import org.springframework.stereotype.Service;

import com.example.kakeibo.Repository.GetUserRepository;
import com.example.kakeibo.data.KakeiboUserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class KakeiboGetUserService {
	private final GetUserRepository getUserRepository;

	public KakeiboGetUserService(GetUserRepository getUserRepository) {
		this.getUserRepository = getUserRepository;
	}

	public KakeiboUserEntity getUsers(int userId) throws JsonMappingException, JsonProcessingException {
		KakeiboUserEntity kakeiboUserEntity = new KakeiboUserEntity();
		kakeiboUserEntity = getUserRepository.getUsers(userId);
		return kakeiboUserEntity;
	}
}