package com.aniol.currency_converter.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {
	@JsonProperty("no")
	private String no;
	@JsonProperty("efectiveDate")
	private String effectiveDate;
	@JsonProperty("mid")
	private Double mid;
	@JsonProperty("ask")
	private Double ask;
	
	public Rates() {
	}
	
	public Rates(String no, String effectiveDate, Double mid, Double ask) {
		this.no = no;
		this.effectiveDate = effectiveDate;
		this.mid = mid;
		this.ask = ask;
	}
	
	public String getNo() {
		return no;
	}
	
	public void setNo(String no) {
		this.no = no;
	}
	
	public String getEffectiveDate() {
		return effectiveDate;
	}
	
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	public Double getMid() {
		return mid;
	}
	
	public void setBid(Double bid) {
		this.mid = mid;
	}
	
	public Double getAsk() {
		return ask;
	}
	
	public void setAsk(Double ask) {
		this.ask = ask;
	}
	
	@Override
	public String toString() {
		return "Rates{" +
				"no='" + no + '\'' +
				", effectiveDate='" + effectiveDate + '\'' +
				", mid=" + mid +
				", ask=" + ask +
				'}';
	}
}
