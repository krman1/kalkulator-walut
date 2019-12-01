package com.aniol.currency_converter.service;

import com.aniol.currency_converter.domain.StoredData;
import com.aniol.currency_converter.repository.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {
	
	private DataRepo repositore;
	
	@Autowired
	public DbService(DataRepo repositore) {
		this.repositore = repositore;
	}
	
	public StoredData saveData (StoredData storedData){
			return repositore.save(storedData);
	}
}
