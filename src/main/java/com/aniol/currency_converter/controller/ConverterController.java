package com.aniol.currency_converter.controller;
import com.aniol.currency_converter.domain.CurrencyTable;
import com.aniol.currency_converter.repository.DataRepo;
import com.aniol.currency_converter.service.DbService;
import com.aniol.currency_converter.NBP.client.NBPClient;
import com.aniol.currency_converter.domain.StoredData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("v1/converter")
public class ConverterController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private NBPClient nbpClient;
	
	@Autowired
	DbService dbService;

	@Autowired
	DataRepo dataRepo;
	
	java.text.DecimalFormat df=new java.text.DecimalFormat("0.0000");
	java.text.DecimalFormat de=new java.text.DecimalFormat("0.00");
	
	@RequestMapping(method = RequestMethod.GET, value = "getone")
	public double getOneCurrency(String currency) {
		return nbpClient.getCurrency(currency);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "getall")
	public void getAllCurrency() {
		
		List<CurrencyTable> currencys = nbpClient.getAllCurrency();
		currencys.stream().flatMap(s -> s.getRatesTable().stream())
				.forEach(ratesTable -> System.out.println("Waluta: " + ratesTable.getCurrency() + "o symbolu: " + ratesTable.getCode() + " dzisiejszy kurs = " + df.format(ratesTable.getMid()) + " PLN"));
	}

	public void saveData(@RequestBody StoredData storedData){
		 dataRepo.save(storedData);
		 System.out.println("Zapisuje dane do bazy danych");
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void start() {
		System.out.println("Program przeliczający waluty");
		System.out.println("Program umożliwia przeliczanie następujących walut");
		getAllCurrency();

		System.out.println("Podaj symbol pierwszej waluty");
		String firstCurrency;
		Scanner a = new Scanner(System.in);
		firstCurrency = a.next();

		System.out.println("Podaj symbol drugiej waluty");
		String secondCurrency;
		Scanner b = new Scanner(System.in);
		secondCurrency = b.next();

		System.out.println("Podaj kwotę jaką chcesz wymienić");
		double valueToChange;
		Scanner c = new Scanner(System.in);
		valueToChange = c.nextDouble();

		double valueAfterChange =( (valueToChange * getOneCurrency(firstCurrency))/getOneCurrency(secondCurrency));
		System.out.println("Za " + valueToChange + " " + firstCurrency + " kupisz " + de.format(valueAfterChange) + " "+secondCurrency);

		StoredData storedData = new StoredData(firstCurrency,secondCurrency,valueToChange,valueAfterChange);
		saveData(storedData);
	}
}



