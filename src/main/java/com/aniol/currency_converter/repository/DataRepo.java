package com.aniol.currency_converter.repository;

import com.aniol.currency_converter.domain.StoredData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Transactional
@Repository
public interface DataRepo extends CrudRepository<StoredData,Long> {

	@Override
	StoredData save (StoredData storedData);
}
