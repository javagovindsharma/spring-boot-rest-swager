package com.techprimers.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techprimers.model.Office;
import com.techprimers.repository.OfficeRepository;

@Service
public class OfficeService {
	private static final Logger logger = LoggerFactory.getLogger(OfficeService.class);

	@Autowired
	private OfficeRepository officeRepository;

	public List<Office> getAllOfficeService() {
		logger.info(getClass().getName()+"  invked getAllOffice");
		List<Office> empRecords = new ArrayList<>();
		empRecords = officeRepository.findAll();
		return empRecords;
	}

	public Office getOfficeByIdService(String id) {
		return officeRepository.findOne(id);
	}
	
	
	public void addOfficeService(Office userRecord) {
		officeRepository.save(userRecord);
	}

	public void deleteOfficeService(String id) {
		officeRepository.delete(id);
	}
	
	public void updateOfficeService(Office office) {
		Office officeGetRecords=officeRepository.findOne(office.getOfficeCode());
		officeGetRecords.setAddressLine1(office.getAddressLine1());
		officeGetRecords.setAddressLine2(office.getAddressLine2());
		officeGetRecords.setCity(office.getCity());
		officeGetRecords.setCountry(office.getCountry());
		officeGetRecords.setPhone(office.getPhone());
		officeGetRecords.setPostalCode(office.getPostalCode());
		officeGetRecords.setState(office.getState());
		officeGetRecords.setTerritory(office.getTerritory());
		officeRepository.save(officeGetRecords);
	}
}
