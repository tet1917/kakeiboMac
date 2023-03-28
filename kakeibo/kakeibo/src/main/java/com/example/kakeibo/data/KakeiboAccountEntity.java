package com.example.kakeibo.data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KakeiboAccountEntity {

	@JsonProperty("kakeibolist")
	private List<KakeiboAccountData> kakeiboList;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("kakeibolist")
	public List<KakeiboAccountData> getkakeiboList() {
		return kakeiboList;
	}

	@JsonProperty("kakeibolist")
	public void setkakeiboList(List<KakeiboAccountData> kakeibolist) {
		this.kakeiboList = kakeibolist;
	}

	public int getTotalAccount() {
//		int size = getkakeiboList().size();
//
		int total = 0;
//		for (int i = 0; i < size; i++) {
//			// int data =
//			total += getkakeiboList().get(i).getAmount();
//		}
		
		for(KakeiboAccountData data:getkakeiboList()) {
			total += data.getAmount();
		}
		return total;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}