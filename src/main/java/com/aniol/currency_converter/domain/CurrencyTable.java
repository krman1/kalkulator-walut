package com.aniol.currency_converter.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyTable {
	@JsonProperty("table")
	private String table;
	@JsonProperty("no")
	private String no;
	@JsonProperty("effectiveDate")
	private String effectiveDate;
	@JsonProperty("ratesTable")
	private List<RatesTable> ratesTable;
	
	public CurrencyTable() {
	}
	
	public CurrencyTable(String table, String no, String effectiveDate, List<RatesTable> ratesTable) {
		this.table = table;
		this.no = no;
		this.effectiveDate = effectiveDate;
		this.ratesTable = ratesTable;
	}
	
	public String getTable() {
		return table;
	}
	
	public void setTable(String table) {
		this.table = table;
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
	
	public List<RatesTable> getRatesTable() {
		return ratesTable;
	}
	
	public void setRates(List<RatesTable> rates) {
		this.ratesTable = rates;
	}
	
	@Override
	public String toString() {
		return "CurrencyTable{" +
				"table='" + table + '\'' +
				", no='" + no + '\'' +
				", effectiveDate='" + effectiveDate + '\'' +
				", ratesTable=" + ratesTable +
				'}';
	}
}
