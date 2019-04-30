package com.techprimers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.techprimers.model.TempUser;
import com.techprimers.repository.TempUserRepository;

@Service
public class TempUserService {

	
	@Autowired
	private TempUserRepository tempUserRepository;
	
	  public String saveUserDataService(TempUser tempuser) {
		  String msg="";
		  TempUser tempObj=tempUserRepository.saveAndFlush(tempuser);
		  
		  if(tempObj.equals(tempuser))
			  msg="SucessFully Saved";
		  else
			  msg="Failure to Save";
		 
		  return msg;
	  }
	  
	  
	  public List<TempUser> getAllUserDataService(){
		  
		  return  tempUserRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
				
	  }
	  
	  public String editTempUserRecordsService(TempUser tempUser) {
		  String msg="";
		  try {
			    TempUser userObj=tempUserRepository.findOne(tempUser.getId());
			     userObj.setCity(tempUser.getCity());
			     userObj.setEmail(tempUser.getEmail());
			     userObj.setMob(tempUser.getMob());
			     userObj.setName(tempUser.getName());
			     userObj.setPin(tempUser.getPin());
			     tempUserRepository.saveAndFlush(userObj);
			      msg="sucessfully Updated"; 
				  
		  }catch (Exception e) {
			  msg="updation Failure";
		}
		  
		  System.out.println(msg);
		  return msg;
	  }
	  
	  
	  
	  public String deleteTempUserRecordsService(TempUser tempUser) {
		  String msg="";
		  try {
			    tempUserRepository.delete(tempUser.getId());
			    msg="sucessfully Deleted"; 
				  
		  }catch (Exception e) {
			  msg="Deletion Failure";
		}
	    return msg;
	  }
	  
	  
}
