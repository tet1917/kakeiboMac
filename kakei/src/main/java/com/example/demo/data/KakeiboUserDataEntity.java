package com.example.demo.data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KakeiboUserDataEntity {

	@JsonProperty("kakeibolist")
	private List<KakeiboUserData> kakeiboList;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("kakeibolist")
	public List<KakeiboUserData> getkakeiboList() {
		return kakeiboList;
	}

	@JsonProperty("kakeibolist")
	public void setkakeiboList(List<KakeiboUserData> kakeibolist) {
		this.kakeiboList = kakeibolist;
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
