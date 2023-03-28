package com.example.kakeibo.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.kakeibo.Repository.GetAccountRepository;
import com.example.kakeibo.Repository.GetUserRepository;
import com.example.kakeibo.data.KakeiboAccountEntity;
import com.example.kakeibo.data.KakeiboUserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class KakeiboUserService {
	private final GetUserRepository getUserRepository;
	private final GetAccountRepository getAccountRepository;

	public KakeiboUserService(GetUserRepository getUserRepository, GetAccountRepository getAccountRepository) {
		this.getUserRepository = getUserRepository;
		this.getAccountRepository = getAccountRepository;
	}

	public KakeiboUserEntity getUsers(int userId) throws JsonMappingException, JsonProcessingException {
		KakeiboUserEntity kakeiboUserEntity = new KakeiboUserEntity();
		kakeiboUserEntity = getUserRepository.getUsers(userId);
		return kakeiboUserEntity;
	}
	
	public KakeiboAccountEntity getAccount(int userId,int id) throws JsonMappingException, JsonProcessingException {
		KakeiboAccountEntity kakeiboAccountEntity = new KakeiboAccountEntity();
		kakeiboAccountEntity = getAccountRepository.getUsersData(userId ,id);
		return kakeiboAccountEntity;
	}
	
	public Date dateChange(String accountDate) {
	  try{
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		    sdf.setLenient(false);
		    return sdf.parse(accountDate);
		  }catch(Exception ex){
		    return null;
		  }
	}
}