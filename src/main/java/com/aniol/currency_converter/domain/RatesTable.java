package com.aniol.currency_converter.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RatesTable {
	
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("code")
	private String code;
	@JsonProperty("mid")
	private Double mid;
	
	public RatesTable() {
	}
	
	public RatesTable(String currency, String code, Double mid) {
		this.currency = currency;
		this.code = code;
		this.mid = mid;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Double getMid() {
		return mid;
	}
	
	public void setMid(Double mid) {
		this.mid = mid;
	}
	
	@Override
	public String toString() {
		return "RatesTable{" +
				"currency='" + currency + '\'' +
				", code='" + code + '\'' +
				", mid=" + mid +
				'}';
	}
}
