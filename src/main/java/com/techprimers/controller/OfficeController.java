package com.techprimers.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techprimers.model.Office;
import com.techprimers.service.OfficeService;

@CrossOrigin
@RestController
@RequestMapping("/office")
public class OfficeController {

	
     private static final Logger logger = LoggerFactory.getLogger(OfficeController.class);
	
	@Autowired
	private OfficeService officeService;

	@PostMapping("/all")
	public List<Office> getAllOffice(HttpServletRequest request,HttpServletResponse response) {
		logger.info("get All Office");
		return officeService.getAllOfficeService();
	}

	@PostMapping(value = "/add-office")
	public void addOffice(@RequestBody Office empRecord) {
		officeService.addOfficeService(empRecord);
	}
	
	@PostMapping(value = "/get/{id}")
	public Office getOfficeById(@PathVariable String id) {
		return officeService.getOfficeByIdService(id);
	}
	
	@PostMapping(value = "/delete/{id}")
	public void deleteById(@PathVariable String id) {
		 officeService.deleteOfficeService(id);
	}
	
	@PostMapping(value = "/update-office")
	public void updateOffice(@RequestBody Office empRecord) {
		officeService.updateOfficeService(empRecord);
	}
	
}
