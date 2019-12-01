package com.aniol.currency_converter.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
	@JsonProperty("table")
	private String table;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("code")
	private String code;
	@JsonProperty("rates")
	private List<Rates> rates;
	
	public Currency() {
	}
	
	public Currency(String table, String currency, String code, List<Rates> rates) {
		this.table = table;
		this.currency = currency;
		this.code = code;
		this.rates = rates;
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
	
	public String getTable() {
		return table;
	}
	
	public List<Rates> getRates() {
		return rates;
	}
	
	public void setTable(String table) {
		this.table = table;
	}
	
	public void setRates(List<Rates> rates) {
		this.rates = rates;
	}
	
	@Override
	public String toString() {
		return "Currency{" +
				"table='" + table + '\'' +
				", currency='" + currency + '\'' +
				", code='" + code + '\'' +
				", rates=" + rates +
				'}';
	}
}
