package com.techprimers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techprimers.repository.LoginJpaRespository;



@Service
public class LoginService {

	@Autowired
	private LoginJpaRespository  loginJpaRespository; 
	
    public String userLoginAUthtication(String userid,String password) {
    	String msg="failed";
    	int counts=loginJpaRespository.loginValidate(Integer.parseInt(userid),password);
    	
    	
    	System.out.println("counts "+counts);
    	if(counts>0)
    		msg="success";
    	else
    		msg="failed";
    	
    	 return msg;
    }
}
