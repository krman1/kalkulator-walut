package com.aniol.currency_converter.NBP.client;

import com.aniol.currency_converter.domain.Currency;
import com.aniol.currency_converter.domain.CurrencyTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class NBPClient {
	
	@Autowired
	private RestTemplate restTemplate;
	private String PLN = "PLN";
	
	public double getCurrency(String currency) {
		if (!currency.equals(PLN)) {
			Currency actualCurrency = restTemplate.getForObject(
					"http://api.nbp.pl/api/exchangerates/rates/a/" + currency,
					Currency.class);
			return actualCurrency.getRates().get(0).getMid();
		} else {
			return 1.0;
		}
	}
	
	public List<CurrencyTable> getAllCurrency() {
		CurrencyTable[] actualALLCurrency = restTemplate.getForObject(
				"http://api.nbp.pl/api/exchangerates/tables/a",
				CurrencyTable[].class);
		
		return Arrays.asList(actualALLCurrency);
	}
}



