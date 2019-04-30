package com.techprimers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.techprimers.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	
	    @Autowired
	    private LoginService loginService;

	    @PostMapping(value = "/uservalidate")
	    public String userAuthentication(@RequestParam(name = "userid") String userid, @RequestParam(name = "password") String password) {
	        
	    	System.out.println("userid"+userid+"   password "+password);
	    	return loginService.userLoginAUthtication(userid,password);
	    }
	
}
