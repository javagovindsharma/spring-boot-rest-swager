package com.techprimers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.model.TempUser;
import com.techprimers.service.TempUserService;

@RestController
@CrossOrigin
@RequestMapping("/form")
public class FormRecords {

	@Autowired
	private TempUserService tempUserService;
	
	
	@PostMapping(value = "/add-form",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addTempUser(@RequestBody TempUser tempUser) {
		String msg="todo";
		try {
		     System.out.println("@@@"+tempUser.toString());
		     msg= tempUserService.saveUserDataService(tempUser);
		}catch (Exception e) {
			msg="technical Problem";
			e.printStackTrace();
		}
		return msg;
	}
	
	@PostMapping("/getTempUsers")
	public List<TempUser> getAllRecords(){
		return tempUserService.getAllUserDataService();
	}
	
	
	@PostMapping("/editTempUsers")
	public String editTempuserRecord(@RequestBody TempUser tempUser){
		  System.out.println("@@@"+tempUser.toString());
		return tempUserService.editTempUserRecordsService(tempUser);
		
	}
	
	@PostMapping("/deleteTempUsers")
	public String deleteTempuserRecord(@RequestBody TempUser tempUser){
		  System.out.println("@@@"+tempUser.toString());
		return tempUserService.deleteTempUserRecordsService(tempUser);
		
	}
	
	
}
